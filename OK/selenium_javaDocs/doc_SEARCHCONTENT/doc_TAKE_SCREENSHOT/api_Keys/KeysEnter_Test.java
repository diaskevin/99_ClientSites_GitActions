package selenium.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.actioni_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysEnter_Test {
    @Test
    public void verify_keysEnter_test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();

        //Enter "cheese" text and perform "ENTER" keyboard action
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        Thread.sleep(3000);

        driver.quit();
    }
}