package My_zAi_Runner_Daily_on_liveSites;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DIY_CookiesAccept_defaultContent_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");

        //This code disables notifications popup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--remote-allow-origins=*");
        //driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.diy.com/");
        String title = driver.getTitle();
        String titleExpected = "DIY Products at Everyday Low Prices at B&Q";
        assertEquals(titleExpected, title);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the consent banner to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("truste-consent-track")));
        // Click the Accept Cookies button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("truste-consent-button"))).click();

        // This code switches back to default content
        driver.switchTo().defaultContent();
    }

    @Disabled
    public void test_SearchDrill() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"headlessui-control-_R_1d6535_\"]")).sendKeys("drill");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchPage = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/div/h1"));
        String result = searchPage.getText();
        System.out.println("Search Page displays text: " + result);
        //assertEquals("Search results for", result);
        assertEquals("Drills", result);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}