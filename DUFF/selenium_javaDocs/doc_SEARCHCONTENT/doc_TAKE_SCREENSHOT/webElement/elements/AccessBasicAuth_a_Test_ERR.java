package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;

public class AccessBasicAuth_a_Test_ERR {
    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions   .addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
    // Sometimes you'll work with applications that are secured behind Basic HTTP Authentication (a.k.a. Basic Auth).
    // In order to access them you'll need to pass credentials to the site when requesting a page.
    // Otherwise you'll get a system level pop-up prompting you for a username and password -- rendering Selenium helpless.
    // A Solution is to specify the username and password in the URL when visiting a page with Selenium,
    // we can a side-step the system level dialog box from Basic Auth
    // This approach will work for both HTTP or HTTPS pages

    // In this test we're loading the page by passing in the username and password in the front of the URL
    // (e.g., http://admin:admin@).
    // Once it loads we grab text from the page to make sure we ended up in the right place.
    //
    // In a separate test class we access this page as part of the test setup, so Basic Auth is cached
    // enabling us to visit the page again without having to specify credentials repeatedly.
        @Test
        public void workWithBasicAuthTest() {
            driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
            String pageMessage = driver.findElement(By.cssSelector("p")).getText();
            MatcherAssert.assertThat(pageMessage, CoreMatchers.containsString("Congratulations!"));
        }
}