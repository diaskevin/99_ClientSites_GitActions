package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class By_Id_Test {
    WebDriver driver;
    @Test
    public void by_Id_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kcl.ac.uk/index.aspx");
        driver.findElement(By.id("courseSearchInput")).sendKeys("123ok");
        driver.quit();
    }
}
