package dave.actions;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseChromeTest extends BaseTest {

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
