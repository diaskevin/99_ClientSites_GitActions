package MySelenium_examples.elements.methods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayed_Test {
    WebDriver driver;
    @Test
    public void isDisplayed_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.GMAIL.COM");
        boolean a = driver.findElement(By.id("identifierId")).isDisplayed();
        System.out.println(a);
        driver.quit();
    }
}