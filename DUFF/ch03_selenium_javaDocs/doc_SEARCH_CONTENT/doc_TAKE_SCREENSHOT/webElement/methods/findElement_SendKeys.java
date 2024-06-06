package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.methods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElement_SendKeys {
    @Test
    public void sendKeys_Test() {
        System.setProperty("webdriver.chrome.driver", "D:\\02_Kevin\\qa\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.GMAIL.COM");
        driver.findElement(By.id("identifierId")).sendKeys("123ok");
        driver.quit();
    }
}
