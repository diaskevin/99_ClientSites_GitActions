package selenium_javaDocs.doc_CAPABILITIES.versionOutput;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CapabilitiesChromeOptions_getVersion_Test {
    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        Capabilities caps = ((ChromeDriver) driver).getCapabilities();
        String version = caps.getBrowserVersion();
        System.out.println("Running ChromeDriver version: " + version);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
        @Test
        public void workWithBasicAuth_test() {
            driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
            String pageMessage = driver.findElement(By.cssSelector("p")).getText();
            MatcherAssert.assertThat(pageMessage, CoreMatchers.containsString("Congratulations!"));
        }
}