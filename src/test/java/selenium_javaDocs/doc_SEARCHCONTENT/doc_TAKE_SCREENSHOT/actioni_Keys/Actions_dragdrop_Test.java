package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.actioni_Keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Actions_dragdrop_Test {
    WebDriver driver;
   
@Test
    public void dragDrop_Test() throws InterruptedException {

        //Note: Following statement is required since Selenium 3.0,
        //optional till Selenium 2.0
        //Set system properties for geckodriver
    System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
    driver = new ChromeDriver();

        String URL = "https://demoqa.com/droppable/";

        driver.get(URL);

        // It is always advisable to Maximize the window before performing DragNDrop action
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        //Actions class method to perform drag and drop
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));
        new Actions(driver).dragAndDrop(from, to).perform();

        //verify text changed in to 'Drop here' box
        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }

        driver.close();

    }
}

