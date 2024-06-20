package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PressKeyboardKeys_Test {
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
    public void KeySpace_test() throws Exception {
                driver.get("http://the-internet.herokuapp.com/key_presses");
                driver.findElement(By.id("target")).sendKeys(Keys.SPACE);
                String txt = driver.findElement(By.id("result")).getText();
                System.out.println(txt);
                MatcherAssert.assertThat(txt, Is.is("You entered: SPACE"));
    }
}