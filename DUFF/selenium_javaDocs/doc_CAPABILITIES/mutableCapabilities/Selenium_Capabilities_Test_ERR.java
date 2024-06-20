package selenium_javaDocs.doc_CAPABILITIES.mutableCapabilities;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Capabilities_Test_ERR {
    WebDriver driver;

    //ERR It runs but does not sysout anything
    @Test
    public void testGooglePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com");

        Capabilities cap = new MutableCapabilities();
        String browser = cap.getBrowserName();
        String version = cap.getBrowserVersion();
        String capName = cap.getCapabilityNames().toString();
        String platform = String.valueOf(cap.getPlatformName());

        System.out.println(browser);

        driver.quit();
    }
}
