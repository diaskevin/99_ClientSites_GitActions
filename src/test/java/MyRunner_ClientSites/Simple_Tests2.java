package MyRunner_ClientSites;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Simple_Tests2 {
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

    @Test
    public void hovers_test() {
        driver = new ChromeDriver(getChromeOptions());
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement avatar = driver.findElement(By.className("figure"));

        Actions builder = new Actions(driver);
        builder.moveToElement(avatar).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));

        MatcherAssert.assertThat(driver.findElement(By.className("figcaption")).isDisplayed(), CoreMatchers.is(Boolean.TRUE));

        driver.close();
    }

    @Test
    public void hovers_test2() {
        driver = new ChromeDriver(getChromeOptions());
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement avatar = driver.findElement(By.className("figure"));

        Actions builder = new Actions(driver);
        builder.moveToElement(avatar).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));

        MatcherAssert.assertThat(driver.findElement(By.className("figcaption")).isDisplayed(), CoreMatchers.is(Boolean.TRUE));

        driver.close();
    }

}



