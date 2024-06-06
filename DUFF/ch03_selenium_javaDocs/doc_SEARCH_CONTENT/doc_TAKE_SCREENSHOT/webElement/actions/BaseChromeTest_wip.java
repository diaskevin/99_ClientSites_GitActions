package dave.actions;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseChromeTest_wip extends BaseTest {

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        driver = new ChromeDriver();
    }

}
