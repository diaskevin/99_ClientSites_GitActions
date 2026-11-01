package My_zAi_Runner_ClientSites_ScheduledMonthly;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DIY_Captcha_CookiesAccept_Search_Test {
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

        ///HUMAN VERIFICATION: CAPTCHA
        //String title = driver.getTitle();
        //String titleExpected = "DIY Products at Everyday Low Prices at B&Q";
        //assertEquals(titleExpected, title);

        ///HUMAN VERIFICATION: COOKIES ACCEPTANCE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for the consent banner to be visible
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("truste-consent-track")));
        // Click the Accept Cookies button
            //wait.until(ExpectedConditions.elementToBeClickable(By.id("truste-consent-button"))).click();

        // This code switches back to default content
        driver.switchTo().defaultContent();
    }

    @Test
    @Disabled("HUMAN INTERVENTION REQUIRED")
    public void test_SearchDrill() throws InterruptedException {

        String title = driver.getTitle();
        System.out.println("Title text: " + title);
        Thread.sleep(20000);

        driver.findElement(By.xpath("//*[@id=\"headlessui-control-_R_1d9l35_\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"headlessui-control-_R_1d9l35_\"]")).sendKeys("drill");
        System.out.println("Entered Drill");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Click Submit");
        Thread.sleep(3000);

        //ASSERT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement drillsHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("h1[data-slot='page-title-heading']")));
        assertEquals(drillsHeading.getText().trim(), "Drills");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}