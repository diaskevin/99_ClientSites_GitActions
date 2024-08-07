package selenium_javaDocs.doc_SEARCHCONTEXT.doc_TAKE_SCREENSHOT.api_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_dragdrop_Test {
    WebDriver driver;
    //ERR org.openqa.selenium.NoSuchElementException: no such element
    @Test
    public void dragNdrop_test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        //ERR System.out.println("L2AGLb clicked, but NoSuchElementException for 'Source' ");
        Thread.sleep(3000);
        WebElement source = driver.findElement(By.id("source"));
        WebElement target = driver.findElement(By.id("target"));
        new Actions(driver).dragAndDrop(source, target).build().perform();

        driver.quit();
    }
}
