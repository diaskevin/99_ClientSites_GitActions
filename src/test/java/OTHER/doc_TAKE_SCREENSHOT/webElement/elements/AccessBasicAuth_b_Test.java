package OTHER.doc_TAKE_SCREENSHOT.webElement.elements;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;

public class AccessBasicAuth_b_Test {
    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions   .addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
    // In this test we access the page as part of the test setup
    // This would have cached the Basic Auth session in the browser,
    // enabling us to visit the page again without having to specify credentials.
    // This is particularly useful if you have numerous pages behind Basic Auth.
    @Test
    public void workWithBasicAuth_test() {
        driver.get("http://the-internet.herokuapp.com/basic_auth");
        String pageMessage = driver.findElement(By.cssSelector("p")).getText();
        MatcherAssert.assertThat(pageMessage, CoreMatchers.containsString("Congratulations!"));
        }
}