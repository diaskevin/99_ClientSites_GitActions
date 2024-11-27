package MyScratchPad;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DIY_CookiesAccept_defaultContent_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");

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
        String titleExpected = "B&Q | DIY Products at Everyday Low Prices | DIY at B&Q";
        assertEquals(titleExpected, title);
        Thread.sleep(3000);

        // This code accepts cookies by switching the frame
        driver.switchTo().frame(0);
                Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='truste-consent-button']")).click();
        //driver.findElement(By.id("truste-consent-button")).click();
        //driver.findElement(By.id("//*[@id=/"truste-consent-button/"]")).click();

        // This code switches back to default content
        driver.switchTo().defaultContent();
    }

    @Test
    public void test_SearchDrill() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"app-header\"]/nav/div/div/div/div/form/input")).sendKeys("drill");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        String searchResult = driver.findElement(By.xpath("//h2")).getText();
        System.out.println(searchResult);
        assertEquals("\"drill\"", searchResult);
    }

    @AfterEach
    public void tearDown() {
        //driver.quit();
    }
}