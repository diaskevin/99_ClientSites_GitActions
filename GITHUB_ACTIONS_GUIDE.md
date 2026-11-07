# Beginner's Guide: Running Selenium (Java + Maven) Tests on GitHub Actions

This guide explains step-by-step how we took a local Selenium test (`Google_Test.java`) that opens Chrome on your computer and configured it to run automatically in the cloud using **GitHub Actions**—including a visual **Test Results Summary** right at the bottom of the GitHub Actions run page.

By following these steps, you can take any other Selenium test in this repository (or any other Java/Maven project) and make it ready for GitHub Actions.

---

## Why Can't Local Selenium Tests Just Work on GitHub Actions Out of the Box?

When you click the green **Run** button in IntelliJ IDEA on your computer, three things are true:
1. **IntelliJ uses its own internal test runner** to execute your `@Test` methods.
2. **Your computer has a screen (monitor)**, so Chrome can open a visible browser window.
3. **Your computer is located in your home country (e.g., the UK)**, so websites show regional popups like UK/EU GDPR cookie consent banners.

When **GitHub Actions** runs your tests in the cloud, it uses a virtual Linux server (typically located in the United States) that:
1. Runs tests from the command line using **Maven** (`mvn test`), not IntelliJ.
2. **Has no monitor attached**—if Chrome tries to open a normal visible window, it will immediately crash with a `SessionNotCreatedException`.
3. **Connects from a US data center**, meaning regional UK/EU cookie banners often don't appear at all. If your test blindly tries to click an "Accept Cookies" button that isn't there, it will fail with a `NoSuchElementException`.

To solve this, we made **3 changes** across the project.

---

## Step 1: Configure `pom.xml` So Maven Can Run JUnit 5 Tests

GitHub Actions uses **Maven** (`mvn test`) to run tests. Specifically, Maven uses a plugin called `maven-surefire-plugin` to find and execute `@Test` methods and output XML test reports into `target/surefire-reports/`.

### What Was Wrong?
1. Older versions of `maven-surefire-plugin` (like `2.19.1`) only understood **JUnit 4** (`org.junit.Test`) and completely ignored **JUnit 5** (`org.junit.jupiter.api.Test`), resulting in `Tests run: 0`.
2. Our dependencies only had `junit-jupiter-api` (which lets you *write* `@Test` annotations), but not `junit-jupiter` (which includes the `junit-jupiter-engine` needed to actually *run* them via Maven).

### What We Changed in `pom.xml`
1. **Upgraded `maven-surefire-plugin` to `3.2.5`** inside `<build><plugins>`:
   ```xml
   <plugin>
       <artifactId>maven-surefire-plugin</artifactId>
       <version>3.2.5</version>
       <configuration>
           <includes>
               <include>**/*Test.java</include>
           </includes>
           <excludes>
               <exclude>**/MouseHovers_3_Test.java</exclude>
           </excludes>
           <excludedGroups>slow</excludedGroups>
       </configuration>
   </plugin>
   ```
2. **Added the full `junit-jupiter` aggregator dependency** inside `<dependencies>`:
   ```xml
   <dependency>
       <groupId>org.junit.jupiter</groupId>
       <artifactId>junit-jupiter</artifactId>
       <version>${junit.jupiter.version}</version>
       <scope>test</scope>
   </dependency>
   ```

> **Tip:** You only need to do Step 1 **once per project** (`pom.xml`). Every test in this repository now benefits from it!

---

## Step 2: Update Your Selenium Test Class for Headless Mode & Optional Popups

To make a test class work both **locally in IntelliJ (with a visible browser)** and **on GitHub Actions (without a screen)**, we updated `Google_Test.java` with two helper methods.

### 2A. Add a `getChromeOptions()` Helper Method for Headless Mode

**Headless mode** tells Chrome to run in the background without drawing a visible window on a physical screen.

Add this helper method inside your test class:

```java
private ChromeOptions getChromeOptions() {
    ChromeOptions options = new ChromeOptions();
    // GitHub Actions automatically sets the environment variable CI=true.
    // We also check for -Dheadless=true in case you want to test headless mode locally.
    if ("true".equalsIgnoreCase(System.getenv("CI")) || "true".equalsIgnoreCase(System.getProperty("headless"))) {
        options.addArguments("--headless=new");          // Run Chrome without a visible UI window
        options.addArguments("--no-sandbox");            // Required for running Chrome inside Linux CI containers
        options.addArguments("--disable-dev-shm-usage"); // Prevents Chrome from crashing due to small shared memory in CI
        options.addArguments("--window-size=1920,1080"); // Sets a standard 1080p screen size so elements aren't hidden in mobile view
    }
    return options;
}
```

Then, whenever you create a `new ChromeDriver()` in your `@Test` or `@BeforeEach` methods, pass `getChromeOptions()` into it:

```java
// BEFORE:
driver = new ChromeDriver();

// AFTER:
driver = new ChromeDriver(getChromeOptions());
```

**Why is this great?**
- When you run the test on your laptop in IntelliJ, `CI` is not set, so Chrome still opens a normal window you can watch!
- When GitHub Actions runs the test, `CI=true` is detected automatically, and Chrome switches to headless mode.

---

### 2B. Handle Cookie Banners Gracefully (Don't Assume They Always Appear)

Locally in the UK, visiting `https://google.co.uk` shows a cookie popup (`id="L2AGLb"`). On a US-based GitHub Actions server, Google often skips this popup and goes straight to the search page.

Instead of doing a hard click that crashes when the banner isn't there:

```java
// FRAGILE — Crashes with NoSuchElementException if the cookie banner doesn't appear!
driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
```

Wrap it in a helper method using a short `WebDriverWait` and a `try / catch` block:

```java
private void acceptCookiesIfPresent(WebDriver driver) {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement acceptBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"L2AGLb\"]"))
        );
        acceptBtn.click();
    } catch (TimeoutException | NoSuchElementException e) {
        System.out.println("Cookie consent banner did not appear (or already dismissed).");
    }
}
```

Then call `acceptCookiesIfPresent(driver);` right after `driver.get(...)`.
- If the cookie banner appears (like on your UK machine), it waits up to 5 seconds and clicks it.
- If the cookie banner does not appear (like on a US GitHub Actions runner), it prints a message after 5 seconds and continues the test without failing.

---

## Step 3: Create the GitHub Actions Workflow File (With a Live Results Summary Table!)

GitHub Actions looks for YAML files inside the `.github/workflows/` folder at the root of your repository. We created `.github/workflows/selenium-tests.yml`.

### How the Bottom-of-Page Test Summary Works (`$GITHUB_STEP_SUMMARY`)
GitHub Actions provides a special built-in environment variable called `$GITHUB_STEP_SUMMARY`. Any Markdown text written to `$GITHUB_STEP_SUMMARY` during a workflow step is automatically rendered as a clean table at the bottom of the Actions run page!

When Maven finishes running your tests, `maven-surefire-plugin` creates an XML file in `target/surefire-reports/TEST-<ClassName>.xml` containing:
- Every `@Test` method name and how long it took (`time`).
- Any `System.out.println(...)` output (`<system-out>`).
- Whether it passed, was skipped (`<skipped>`), failed an assertion (`<failure>`), or threw an unexpected exception (`<error>`), along with the exact failure reason and stack trace.

We added a `Generate Test Summary on Actions Page` step (`if: always()`, so it runs even when tests fail!) that parses those Surefire XML files using Python and writes a Markdown summary table to `$GITHUB_STEP_SUMMARY`.

Here is what gets displayed right at the bottom of your GitHub Actions run page:

> ### ✅ Selenium Test Results Summary
>
> | Total Tests | ✅ Passed | ❌ Failed | 💥 Errors | ⏭️ Skipped | ⏱️ Total Duration |
> | :---: | :---: | :---: | :---: | :---: | :---: |
> | **5** | **5** | **0** | **0** | **0** | **11.75s** |
>
> #### 📦 `My_zAi_Runner_ClientSites_ScheduledMonthly.Google_Test` (11.75s)
>
> | Status | Test Method | Duration | Details / Console Output |
> | :--- | :--- | :--- | :--- |
> | ✅ **PASSED** | `title_test` | 2.25s | `Title: Google` |
> | ✅ **PASSED** | `acceptCookies_test` | 2.04s | `Search element is displayed: true / Index Title: Google` |
> | ✅ **PASSED** | `browserDetails_test` | 0.39s | `Running ChromeDriver version: 156.0.8078.74` |
> | ✅ **PASSED** | `screenshotCheeseSearchPage_test` | 3.14s | — |
> | ✅ **PASSED** | `SearchCheese_test` | 3.92s | — |

And if any test **fails** or throws an **error**, it automatically adds an expandable **🔍 Failure & Error Details** section right underneath the table showing:
- **Which test failed** (`❌ title_test`)
- **Why it failed** (e.g., `org.opentest4j.AssertionFailedError: expected: <Google> but was: <...>`, or `NoSuchElementException: Unable to locate element...`)
- **The full stack trace** showing the exact line number in your `.java` file.

---

### Full `.github/workflows/selenium-tests.yml` Explained

```yaml
name: Run Selenium Tests

# 1. TRIGGER: How and when this workflow runs
on:
  workflow_dispatch: # Allows you to click a "Run workflow" button manually in GitHub
    inputs:
      test_class:
        description: 'Test class (or pattern) to run'
        required: true
        default: 'My_zAi_Runner_ClientSites_ScheduledMonthly.Google_Test'
        type: string

# 2. JOBS: The virtual machine and steps to run
jobs:
  selenium-test:
    runs-on: ubuntu-latest # Spins up a fresh Ubuntu Linux virtual machine

    steps:
      # Step A: Download your repository code onto the virtual machine
      - name: Checkout repository
        uses: actions/checkout@v4

      # Step B: Install Java 11 (matching <java.version>11</java.version> in pom.xml)
      # Also caches your Maven dependencies (.m2) so future runs are much faster
      - name: Set up JDK 11
        uses: actions/setup-java@v4
        with:
          java-version: '11'
          distribution: 'temurin'
          cache: 'maven'

      # Step C: Install the latest stable version of Google Chrome on the Linux machine
      # (Note: Selenium 4.23+ includes "Selenium Manager", which automatically downloads
      # the matching ChromeDriver for whatever Chrome version is installed!)
      - name: Set up Google Chrome
        uses: browser-actions/setup-chrome@v1
        with:
          chrome-version: stable

      # Step D: Run the specific test class you selected using Maven
      - name: Run Selenium Test (${{ inputs.test_class }})
        env:
          CI: 'true'
        run: mvn test -Dtest="${{ inputs.test_class }}" -Dheadless=true

      # Step E: Read target/surefire-reports/TEST-*.xml and render a visual table
      # at the bottom of the GitHub Actions run page ($GITHUB_STEP_SUMMARY)
      - name: Generate Test Summary on Actions Page
        if: always()
        run: |
          python3 - << 'EOF' >> "$GITHUB_STEP_SUMMARY"
          # (Parses target/surefire-reports/TEST-*.xml and prints Markdown tables
          # showing Passed, Failed, Errors, Skipped, console output, and failure reasons)
          EOF

      # Step F: Save any screenshots (*.png) and test reports so you can download them
      # "if: always()" ensures screenshots are uploaded even if a test fails!
      - name: Upload Screenshots & Surefire Reports
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: test-results-and-screenshots
          path: |
            *.png
            target/surefire-reports/
          if-no-files-found: ignore
```

---

## Checklist: How to Prepare Any Other Test in This Repository for GitHub Actions

Whenever you want to make another test class (for example, `AmazonUK_Test` or a test in `MySelenium_featureExamples`) ready for GitHub Actions, follow this 4-step checklist:

### 1. Check Driver Initialization
Make sure the test does **not** have a hardcoded Windows path to `chromedriver.exe`:
- Comment out or delete any `System.setProperty("webdriver.chrome.driver", "C:\\...");` lines. Selenium 4.33.0's built-in **Selenium Manager** automatically downloads the right driver on Windows, Mac, and Linux.
- Pass headless options into `ChromeDriver` (or `EdgeDriver` / `FirefoxDriver`) when `CI=true`:
  ```java
  ChromeOptions options = new ChromeOptions();
  if ("true".equalsIgnoreCase(System.getenv("CI")) || "true".equalsIgnoreCase(System.getProperty("headless"))) {
      options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080");
  }
  driver = new ChromeDriver(options);
  ```
  *(Pro Tip: Later on, you could move `getChromeOptions()` into a shared `BaseTest` class so you don't have to copy-paste it into every test file!)*

### 2. Always Quit the Driver
Make sure every `@Test` (or an `@AfterEach` method) calls `driver.quit();`. If a browser stays open, the GitHub Actions job might hang.

### 3. Avoid Hardcoded Windows File Paths
If your test saves a screenshot or reads a file, use **relative paths** with forward slashes:
- Good: `new File("./cheeseimagePage.png")` (works on both Windows and Linux)
- Bad: `new File("C:\\Users\\diasj\\Desktop\\screenshot.png")` (crashes on Linux)

### 4. Test It Locally in Headless Mode First
Before pushing to GitHub, you can simulate what GitHub Actions will do by running Maven with `-Dheadless=true`:
```bash
mvn test -Dtest="PackageName.YourTestClassName" -Dheadless=true
```
If it passes locally in headless mode without opening a Chrome window, it is ready for GitHub Actions!

---

## How to Run Any Test on GitHub and View the Results

1. Push your changes to GitHub (`git add .`, `git commit -m "..."`, `git push`).
2. Open your repository on **github.com** and click the **Actions** tab at the top.
3. In the left sidebar, click **Run Selenium Tests**.
4. Click the **Run workflow** dropdown button on the right.
5. In the **Test class (or pattern) to run** box, enter:
   - Default (`Google_Test`): `My_zAi_Runner_ClientSites_ScheduledMonthly.Google_Test`
   - Just the class name: `Google_Test`
   - A single test method inside a class: `Google_Test#title_test`
   - All tests in a package: `My_zAi_Runner_ClientSites_ScheduledMonthly.*Test`
6. Click the green **Run workflow** button, then click on the newly started workflow run.
7. Once it finishes, **scroll to the bottom of the workflow run summary page**:
   - You will see the **Selenium Test Results Summary** table showing every test method, whether it **Passed / Failed / Skipped**, its duration, its `System.out.println` output, and an expandable **Failure & Error Details** box explaining why any failed test failed.
   - Right below that, under **Artifacts** (`test-results-and-screenshots`), you can click to download any screenshots (`.png`) taken during the run!
