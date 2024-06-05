package ch03_selenium_javaDocs.searchContent.takeScreenShot.webElement.methods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElement_isSelected {
    WebDriver driver;
    @Test
    public void isSelected_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.GMAIL.COM");
        boolean a = driver.findElement(By.id("identifierId")).isSelected();
        System.out.println(a);
        driver.quit();
    }





}
