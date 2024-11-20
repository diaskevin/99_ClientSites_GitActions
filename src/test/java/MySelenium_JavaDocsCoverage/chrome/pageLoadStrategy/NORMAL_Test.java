package MySelenium_JavaDocsCoverage.chrome.pageLoadStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class NORMAL_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
    }

    @Test
    public void pageStrategyNormal_test() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);

        try {
            driver.get("https://google.com");
            Thread.sleep(1000);
        } finally {
            driver.quit();
        }
    }
}
