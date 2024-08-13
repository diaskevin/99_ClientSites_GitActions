package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpAPI;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v126.network.Network;
import org.openqa.selenium.devtools.v126.network.model.Headers;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

public class Api_BasicAuthentication_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void set_Header_token_test() throws InterruptedException {

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        //devTools.createSession();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(100000), Optional.of(100000), Optional.of(100000)));

        String encodedAuth = Base64.getEncoder().encodeToString("admin:admin".getBytes());
        Map<String, Object> headers = ImmutableMap.of("Authorization", "Basic " + encodedAuth);

        //devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));


        driver.get("https://www.selenium.dev");

        System.out.println(headers.entrySet());

        driver.quit();
    }
}
