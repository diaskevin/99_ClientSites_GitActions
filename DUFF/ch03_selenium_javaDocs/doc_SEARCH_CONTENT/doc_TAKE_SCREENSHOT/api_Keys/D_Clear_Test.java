package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.api_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class D_Clear_Test {
    WebDriver driver;
    @Test
    public void verify_clear() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();

        WebElement search_element =  driver.findElement(By.name("q"));

        // Enters text "qwerty" with keyDown SHIFT key and after keyUp SHIFT key (QWERTYqwerty)
        Actions actionProvider = new Actions(driver);
        actionProvider.keyDown(Keys.SHIFT).sendKeys("qwerty").keyUp(Keys.SHIFT).sendKeys("qwerty").perform();

        // Clears entered text
        search_element.clear();
        Thread.sleep(1000);
        driver.quit();
    }









}
