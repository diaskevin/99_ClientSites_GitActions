package MySelenium_examples.elements.methods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement_SendKeys_Test {
    @Test
    public void sendKeys_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.GMAIL.COM");
        driver.findElement(By.id("identifierId")).sendKeys("123ok");
        driver.quit();
    }
}
