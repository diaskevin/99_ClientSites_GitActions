package selenium_JavaDocs.Capabilities.proxy;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProxyType_Test {
    @Test
    public void proxy_test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");

        //This is an example of how to access a proxy server if the test requires it at runtime in your environment
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("https://localhost:8090/");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("proxy", proxy);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.quit();
    }
}
