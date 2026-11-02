package MySelenium_JavaDocsCoverage.chrome.ChromeOptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Kev's way

public class RemoteAllowOrigins_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        // This fix was used to resolve the old Selenium3 problem caused by using the wrong selenium dependency on the POM
        // This passes a command-line parameter to Chrome.
        // Historically, this was used around Chrome 111 when many people received errors such as:
                //1. Plain Text
                //2. disconnected: not connected to DevTools
        // The argument tells Chrome to allow remote origins from anywhere (*).
        // In modern Selenium versions this is rarely needed.

        //System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void canLaunchChromeUsingRemoteAllowOrigins() {
        driver.get("http://Amazon.com");
    }
}