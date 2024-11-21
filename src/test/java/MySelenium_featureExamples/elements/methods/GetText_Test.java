package MySelenium_featureExamples.elements.methods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetText_Test {
    WebDriver driver;
    @Test
    public void geText_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.GMAIL.COM");
        String pageHeader = driver.findElement(By.tagName("h1")).getText();
        System.out.println("tagName 'h1': " + pageHeader);
        driver.quit();
    }
}
