package MySelenium_featureExamples.assertions.elements.elements;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AccessBasicAuth_b_URLinSetup_Test {
    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
    // In this test we access the page as part of the test setup, so Basic Auth is cached in browser session, for visiting numerous pages

    // --remote-allow-origins=*: This ChromeOptions argument addresses a breaking change in ChromeDriver where security handshake issues often caused "Socket Exception" HTTP 401 Unauthorized errors.

    // Note: Some versions of Chrome have attempted to block sub-resource requests containing embedded credentials.
    // If the page doesn't load, you might need an alternative such as the Selenium 4 HasAuthentication interface
    // Use the alternative HasAuthentication interface if the "URL method" fails or feels too "hacky
    // It intercepts the 401 challenge and injects the credentials via the CDP (Chrome DevTools Protocol)

    @Test
    public void workWithBasicAuth_test() {
        driver.get("http://the-internet.herokuapp.com/basic_auth");
        String pageMessage = driver.findElement(By.cssSelector("p")).getText();
        MatcherAssert.assertThat(pageMessage, CoreMatchers.containsString("Congratulations!"));
    }
}