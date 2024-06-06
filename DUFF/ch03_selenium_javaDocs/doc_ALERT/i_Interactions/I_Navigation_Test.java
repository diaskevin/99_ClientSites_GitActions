package ch03_selenium_javaDocs.doc_ALERT.i_Interactions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class I_Navigation_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void nav_Test() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(2000);
        driver.navigate().to("https://selenium.dev");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.quit();
    }

}
