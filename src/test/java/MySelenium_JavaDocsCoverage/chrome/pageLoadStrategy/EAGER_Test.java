package MySelenium_JavaDocsCoverage.chrome.pageLoadStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EAGER_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
    }

    @Test
    public void pageStrategyEager_test() throws InterruptedException {
        //EAGER, NORMAL, and NONE are Selenium Page Load Strategies.
        // They control how long WebDriver waits after driver.get()
                //NORMAL: Waits until the initial HTML document has been completely loaded and parsed,
                //EAGER:  Waits until the initial HTML document has been completely loaded and parsed,
                          //but does not wait for stylesheets, images, and subframes to finish loading.
                //NORMAL: Immediately continues without waiting for any resources to load.

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(chromeOptions);

        try {
            driver.get("https://google.com");
            Thread.sleep(1000);
        } finally {
            driver.quit();
        }
    }
}