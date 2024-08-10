package Coverage_selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpEndpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.HasCdp;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class BasicAuthentication_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void set_Header_token_test() throws InterruptedException {
        driver.get("https://www.google.com");

        //Create a map with
        ((HasCdp) driver).executeCdpCommand("Network.enable", new HashMap<>());
        String encodedAuth = Base64.getEncoder().encodeToString("admin:admin".getBytes());
        Map<String, Object> headers = Map.of("headers", Map.of("authorization", "Basic " + encodedAuth));

        ((HasCdp) driver).executeCdpCommand("Network.setExtraHTTPHeaders", headers);

        System.out.println(headers.entrySet());

        driver.quit();
    }
}
