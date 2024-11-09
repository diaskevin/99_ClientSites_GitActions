package OTHER.doc_TAKE_SCREENSHOT.action_Keys;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Actions_Keydown_KeysControl_Test {
    WebDriver driver;

    @Disabled
    //line23: ElementNotInteractable
    @Test
    public void verify_keysControl_test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
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
