package ch03_selenium_javaDocs.searchContent.takeScreenShot.other.api_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class B_Actions_Keydown_KeysControl_Test {
    WebDriver driver;
    @Test
    public void verify_keysControl() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();

        WebElement search_element =  driver.findElement(By.name("q"));
        search_element.sendKeys("bread" + Keys.ENTER);

        // Windows Keyboard shortcut 'Ctrl a' highlights all text
        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();
        keydown.perform();

        Thread.sleep(1000);
        driver.quit();
    }









}
