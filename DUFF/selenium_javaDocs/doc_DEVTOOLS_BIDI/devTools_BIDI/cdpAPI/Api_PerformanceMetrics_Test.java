package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v121.performance.Performance;
import java.util.Optional;
public class Api_PerformanceMetrics_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void set_performance_test() throws InterruptedException {

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        java.util.List
                <org.openqa.selenium.devtools.v121.performance.model.Metric> metricList =
                devTools.send(Performance.getMetrics());

        Thread.sleep(3000);
        driver.get("https://www.selenium.dev");

        //Print
           System.out.println(metricList);

        driver.quit();
    }
}
