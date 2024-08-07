package selenium_javaDocs.doc_SEARCHCONTEXT.doc_TAKE_SCREENSHOT.api_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_Test {

    @Test
    public void select_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://jsbin.com/osebed/2");
        Select fruit = new Select(driver.findElement(By.id("fruits")));
        fruit.selectByVisibleText("Banana");
        fruit.selectByIndex(1);
        driver.quit();
    }
}
