package selenium_javaDocs.doc_CAPABILITIES.pageLoadStrategy;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Default_Test {
    WebDriver driver;

    @Before
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void pageStrategyDefault_Test() {
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver = new ChromeDriver(chromeOptions);

        try {
            // Navigate to Url
            driver.get("https://google.com");
        } finally {
            driver.quit();
        }
    }
}
