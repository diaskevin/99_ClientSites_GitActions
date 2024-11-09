package selenium.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v126.network.Network;

import java.util.Optional;
import java.util.Set;

public class ApiSet_Cookie_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void set_cookie_test() throws InterruptedException {

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();

        devTools.send(
                Network.setCookie(
                        "cheese",
                        "gouda",
                        Optional.empty(),
                        Optional.of("www.selenium.dev"),
                        Optional.empty(),
                        Optional.of(true),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty(),
                        Optional.empty()));

        driver.get("https://www.selenium.dev");
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
