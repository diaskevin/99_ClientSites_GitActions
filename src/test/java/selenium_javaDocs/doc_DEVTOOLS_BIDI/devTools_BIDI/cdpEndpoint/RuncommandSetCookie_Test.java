package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpEndpoint;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.HasCdp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RuncommandSetCookie_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void set_cookie() throws InterruptedException {
        driver.get("https://www.google.com");

        //Create a map with one cookie and its details
        Map<String, Object> cookie = new HashMap<>();
        cookie.put("name", "cheese");
        cookie.put("value", "gouda");
        cookie.put("domain", "www.google.com");
        cookie.put("secure", true);

        //Create the cookie and set it with hash values
        ((HasCdp) driver).executeCdpCommand("Network.setCookie", cookie);
        Thread.sleep(3000);

        //Print cookie
       Set<Cookie> cookieSet = driver.manage().getCookies();
       for(Cookie c: cookieSet){
           System.out.println(c.getName()+"::::"+ c.getValue());
       }

       //assert cookie value
        Cookie cheese = driver.manage().getCookieNamed("cheese");
        Assertions.assertEquals("gouda", cheese.getValue());
        driver.quit();
    }
}
