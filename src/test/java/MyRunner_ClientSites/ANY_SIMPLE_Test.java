package MyRunner_ClientSites;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ANY_SIMPLE_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        //System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hovers_test() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement avatar = driver.findElement(By.className("figure"));

        Actions builder = new Actions(driver);
        builder.moveToElement(avatar).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));

        MatcherAssert.assertThat(driver.findElement(By.className("figcaption")).isDisplayed(), CoreMatchers.is(Boolean.TRUE));
    }
}



