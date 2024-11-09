package selenium.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.actioni_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Clear_Test {
    WebDriver driver;
    @Test
    public void clear_test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
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
