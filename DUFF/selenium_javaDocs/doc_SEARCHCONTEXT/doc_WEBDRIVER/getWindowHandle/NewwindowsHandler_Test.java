package selenium_javaDocs.doc_SEARCHCONTEXT.doc_WEBDRIVER.getWindowHandle;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class NewwindowsHandler_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void cookies_test() throws InterruptedException, IOException {
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/windows/");

        Thread.sleep(1000);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
        System.out.println(driver.getTitle());

        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;
        System.out.println(driver.getWindowHandle());
        Thread.sleep(2000);
        //Click the link which opens in a new window
        driver.findElement(By.linkText("new window")).click();

        //Wait for the new window or tab
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        for(String s: driver.getWindowHandles()){
            System.out.println("Out the elements in the for loop " +s);
        }

        Thread.sleep(2000);
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(originalWindow);
                break;
            }
        }
        Thread.sleep(2000);
        System.out.println(driver.getWindowHandle());
        //Wait for the new tab to finish loading content
        wait.until(ExpectedConditions.titleIs("Working with windows and tabs | Selenium"));

        // Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(3000);

        //Close the tab or window
        driver.close();
        Thread.sleep(3000);

        //Switch back to the old tab or window
        driver.switchTo().window(originalWindow);

        Thread.sleep(3000);


        //Window management- size
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        System.out.println("Window Width: " +width);
        System.out.println("Window Height: " +height);
        //Or store the dimensions and query them later
        Dimension size = driver.manage().window().getSize();
        int width1 = size.getWidth();
        int height1 = size.getHeight();

        //Set window size
        //Restores the window and sets the window size.
        driver.manage().window().setSize(new Dimension(1024, 768));
        width = driver.manage().window().getSize().getWidth();
        height = driver.manage().window().getSize().getHeight();
        System.out.println("New Window Width: " +width);
        System.out.println("New Window Height: " +height);


        // Access each dimension individually
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();
        System.out.println("Window X position: " +width);
        System.out.println("Window Y position: " +height);
        // Or store the dimensions and query them later
        Point position = driver.manage().window().getPosition();
        int x1 = position.getX();
        int y1 = position.getY();

        //Set window position
        driver.manage().window().setPosition(new Point(5, 5));
        System.out.println("New Window X position: " +width);
        System.out.println("New Window Y position: " +height);

        //Maximize window
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().window().minimize();
        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        //Take Screenshot
        WebElement element = driver.findElement(By.cssSelector("h1"));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));

        //Quit will:
        //Close all the windows and tabs associated with that WebDriver session
        //Close the browser process
        //Close the background driver process
        //Notify Selenium Grid that the browser is no longer in use so it can be used by another session (if you are using Selenium Grid)
        driver.quit();
    }
}
