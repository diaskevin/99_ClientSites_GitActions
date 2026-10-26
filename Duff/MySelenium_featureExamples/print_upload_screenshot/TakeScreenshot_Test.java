package MySelenium_featureExamples.print_upload_screenshot;


import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void screenshotPage_test() throws IOException {
        driver.get("http://www.example.com");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./imagePage.png"));
        driver.quit();
    }

    @Test
    public void screenshotWebelement_test() throws IOException {
        //Take Screenshot of element
        driver.get("http://www.example.com");
        WebElement element = driver.findElement(By.cssSelector("h1"));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./image.png"));
        driver.quit();
    }
}
