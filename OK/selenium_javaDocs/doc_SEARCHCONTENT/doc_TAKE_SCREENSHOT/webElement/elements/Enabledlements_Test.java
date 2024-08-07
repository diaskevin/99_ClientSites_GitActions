package selenium_javaDocs.doc_SEARCHCONTEXT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Enabledlements_Test {
    WebDriver driver;

    @BeforeEach
    public void setUpaa() throws Exception {
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
    public void enabled_test() throws Exception {
            driver.get("http://the-internet.herokuapp.com/dropdown");
            Select dropdown = new Select(driver.findElement(By.id("dropdown")));
            //MatcherAssert.assertThat(dropdown.getOptions().get(0).isEnabled(), Matchers.is(false));
            MatcherAssert.assertThat(dropdown.getOptions().get(0).isEnabled(), Matchers.is(false));
    }
}