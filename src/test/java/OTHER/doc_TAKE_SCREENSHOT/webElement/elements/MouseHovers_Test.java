package OTHER.doc_TAKE_SCREENSHOT.webElement.elements;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MouseHovers_Test {
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
        public void hovers_test() throws Exception  {
            driver.get("http://the-internet.herokuapp.com/hovers");
            Thread.sleep(2000);
            WebElement avatar = driver.findElement(By.className("figure"));
            Actions builder = new Actions(driver);
            Thread.sleep(2000);
            builder.moveToElement(avatar).build().perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));
            MatcherAssert.assertThat(driver.findElement(By.className("figcaption")).isDisplayed(), Is.is(Boolean.TRUE));
        }
}