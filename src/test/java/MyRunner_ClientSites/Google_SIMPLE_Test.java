package MyRunner_ClientSites;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Google_SIMPLE_Test {
    WebDriver driver;

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        if ("true".equalsIgnoreCase(System.getenv("CI")) || "true".equalsIgnoreCase(System.getProperty("headless"))) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }
        return options;
    }

    private void acceptCookiesIfPresent(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"L2AGLb\"]")));
            acceptBtn.click();
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Cookie consent banner did not appear (or already dismissed).");
        }
    }


    // Add @BeforeAll (static) & @AfterAll (static) and static WebDriver driver;
    @Test
    public void title_test() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://google.co.uk");
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        assertEquals(title, "Google");
        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.quit();
    }

    /*@Test
    public void browserDetails_test() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        ChromeOptions chromeOptions = getChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        Capabilities caps = ((ChromeDriver) driver).getCapabilities();
        String version = caps.getBrowserVersion();
        System.out.println("Running ChromeDriver version: " + version);
        driver.quit();
    }

    @Test
    public void acceptCookies_test() {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://google.co.uk");
        acceptCookiesIfPresent(driver);
        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //assert search is displayed
        boolean searchDisplayed = driver.findElement(By.name("q")).isDisplayed();
        System.out.println("Search element is displayed: " + searchDisplayed);
        Assertions.assertTrue(searchDisplayed);

        //assert Index page URL
        //String indexURL = driver.getCurrentUrl();
        //System.out.print("Index URL: " +indexURL);
        //assertEquals("https://www.google.co.uk/", indexURL);

        //assert Index page title text
        String indexTitle = driver.getTitle();
        System.out.println("\nIndex Title: " + indexTitle);
        assertEquals("Google", indexTitle);

        driver.quit();
    }

    @Test
    public void SearchCheese_test() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://google.co.uk");
        acceptCookiesIfPresent(driver);
        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void screenshotCheeseSearchPage_test() throws IOException, InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        driver.get("https://google.co.uk");
        acceptCookiesIfPresent(driver);
        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        //Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./cheeseimagePage.png"));
        driver.quit();
        //Add cheeseimagePage.png to .gitIgnore
    }

    //  FirstResult_Test()... Actions open tab for first result and assert on cheeseType
    //  SecondResult_Test()... Navigate home Actions open Tab for second result and assert on cheeseType

    //123
    //ok
     *//
}