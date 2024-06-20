package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpEndpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.HasCdp;

import java.util.HashMap;
import java.util.Map;

public class PerformanceMetrics_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void set_performance_test() throws InterruptedException {
        driver.get("https://www.google.com");
        //driver.get("https://www.bbc.co.uk");

        //Create a map of the 'Performance matrix' for the Response
        ((HasCdp) driver).executeCdpCommand("Performance.enable", new HashMap<>());
        Map<String, Object> response = ((HasCdp) driver).executeCdpCommand("Performance.getMetrics", new HashMap<>());

        //Print to console
        System.out.println(response);

        driver.quit();
    }
}
