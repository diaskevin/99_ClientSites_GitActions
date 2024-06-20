package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.api_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_dragdrop_Test_ERR {
    WebDriver driver;
    //ERR org.openqa.selenium.NoSuchElementException: no such element
    @Test
    public void verify_dragNdrop() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();

        WebElement source = driver.findElement(By.id("source"));
        WebElement target = driver.findElement(By.id("target"));
        new Actions(driver).dragAndDrop(source, target).build().perform();

        driver.quit();
    }
}
