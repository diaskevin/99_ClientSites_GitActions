package selenium_examples.elements.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class By_TagName_Test {
    @Test
    public void tagName_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.GMAIL.COM");
        String pageHeader = driver.findElement(By.tagName("h1")).getText();
        System.out.println("Current Url: " + pageHeader);
        driver.quit();
    }
}
