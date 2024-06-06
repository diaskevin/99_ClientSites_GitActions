
//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html#withTimeout(java.time.Duration)


package ch03_selenium_javaDocs.doc_ALERT;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait_WIPPPPP_Test_ChromeOptions_CO {
    WebDriver driver;

    @Test
    public void Search_Cheese() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

            driver.get("https://google.com");

            //WebDriverWait wait = new WebDriverWait(driver,30);
            //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = 'submit']")));

             // Waiting 30 seconds for an element to be present on the page, checking
               // for its presence once every 5 seconds.
               Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                   .withTimeout(Duration.ofSeconds(30))
                   .pollingEvery(Duration.ofSeconds(5))
                   .ignoring(NoSuchElementException.class);

               WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
                 public WebElement apply(WebDriver driver) {
                   return driver.findElement(By.id("foo"));
                 }
               });

            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);



                String url = driver.getTitle();
                System.out.println(url);
                Assert.assertEquals("Title ok" ,"cheese - Google Search", url);

    driver.quit();
       }
    }