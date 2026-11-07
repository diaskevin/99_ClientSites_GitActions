package MySelenium_JavaDocsCoverage.chrome.proxy;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProxyType_Test {
    @Test
    public void proxy_test() throws InterruptedException {
        //This test demonstrates how to configure a proxy server in Selenium before launching Chrome
            // (if the test requires it at runtime in your environment)
            // Many government, defence and banking environments require traffic to go through a company proxy before internet access is permitted.

        //Proxies are used to:
            // capture network traffic (Very useful for API validation):
                //GET /login
                //POST /api/customer
                //GET /products
            // Mock responses (Useful for testing edge cases)
                //Instead of hitting a real server (Real API -> Proxy -> Fake Response)
            // Security testing
                //With tools like OWASP ZAP (Selenium -> Proxy -> Application)
                    //Allows inspection of requests and responses


        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("https://localhost:8090/");
        //Attaches the proxy settings to the Chrome session.
            ChromeOptions options = new ChromeOptions();
            options.setCapability("proxy", proxy);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.quit();
    }
}
