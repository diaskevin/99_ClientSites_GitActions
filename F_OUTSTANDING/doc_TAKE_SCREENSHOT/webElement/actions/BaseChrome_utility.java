package selenium_javaDocs.doc_SEARCHCONTEXT.doc_TAKE_SCREENSHOT.webElement.actions;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseChrome_utility extends Base_utility {

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
