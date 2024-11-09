package OTHER.doc_CHROME;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

//Kev's way

public class RemoteAllowOrigins_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        //This fix was used to resolve the old Selenium3 problem caused by using the wrong selenium dependency on the POM
        System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void hovers_test() {
        driver.get("http://Amazon.com");
    }
}