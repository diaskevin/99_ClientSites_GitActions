package selenium_examples.elements.elements;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class OptOut_A_B_Test {
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

        @Test
    public void WithCookieAfterVisitingPage_test() throws Exception {
            driver.get("http://the-internet.herokuapp.com/abtest");
            String headingText = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
            MatcherAssert.assertThat(headingText, CoreMatchers.startsWith("A/B Test"));
            driver.manage().addCookie(new Cookie("optimizelyOptOut", "true"));
            driver.navigate().refresh();
            headingText = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText();
            MatcherAssert.assertThat(headingText, CoreMatchers.is("No A/B Test"));
    }
}