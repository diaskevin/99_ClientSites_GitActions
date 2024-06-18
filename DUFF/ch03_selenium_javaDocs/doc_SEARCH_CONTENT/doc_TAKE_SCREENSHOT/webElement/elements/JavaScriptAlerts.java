package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class JavaScriptAlerts {
    WebDriver driver;

    @BeforeEach
    public void setUpaa() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions   .addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

        @Test
    public void JavaScriptAlertTest() throws Exception {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".example li:nth-child(2) button")).click();
        Thread.sleep(2000);
        Alert popup = driver.switchTo().alert();
        Thread.sleep(2000);
        popup.accept();
        String result = driver.findElement(By.id("result")).getText();
        MatcherAssert.assertThat(result, Matchers.is(CoreMatchers.equalTo("You clicked: Ok")));
    }

}