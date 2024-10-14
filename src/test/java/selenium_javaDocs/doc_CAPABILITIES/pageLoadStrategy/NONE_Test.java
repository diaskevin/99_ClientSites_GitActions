package selenium_javaDocs.doc_CAPABILITIES.pageLoadStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NONE_Test {
    WebDriver driver;
@BeforeEach
public void setup() {
    System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
}

    @Test
    public void pageStrategyNone_test() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(chromeOptions);
        try {
            // Navigate to Url
            driver.get("https://google.com");
            Thread.sleep(1000);
        } finally {
            driver.quit();
        }
    }
}
