package MyScratchPad;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GoogleTest {
    WebDriver driver;
    // Add @BeforeAll (static) & @AfterAll (static) and static WebDriver driver;
     @Test
    public void title_test(){
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.co.uk");
        String title = driver.getTitle();
        System.out.println("Title: " + title);
        assertEquals(title, "Google");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.quit();
    }
    @Test
    public void browserDetails_test() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        Capabilities caps = ((ChromeDriver) driver).getCapabilities();
        String version = caps.getBrowserVersion();
        System.out.println("Running ChromeDriver version: " + version);
        driver.quit();
    }

    @Test
    public void acceptCookies_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.co.uk");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Add assert@ q is displayed
        boolean searchDisplayed = driver.findElement(By.name("q")).isDisplayed();
        System.out.println("Search element is displayed: " +searchDisplayed);
        Assertions.assertTrue(searchDisplayed);
        driver.quit();
    }

    @Test
    public void SearchCheese_test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.co.uk");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void screenshotCheeseSearchPage_test() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.co.uk");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
        //Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./cheeseimagePage.png"));
        driver.quit();
        //Add cheeseimagePage.png to .gitIgnore
    }

    //  FirstResult_Test()... Actions open tab for first result and assert on cheeseType
    //  SecondResult_Test()... Navigate home Actions open Tab for second result and assert on cheeseType
}