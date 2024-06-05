package ch03_selenium_javaDocs.searchContent.takeScreenShot.other.api_Keys.api_Select;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMethods {

    @Test
    public void select_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://jsbin.com/osebed/2");
        Select fruit = new Select(driver.findElement(By.id("fruits")));
        fruit.selectByVisibleText("Banana");
        fruit.selectByIndex(1);
        driver.quit();
    }
}
