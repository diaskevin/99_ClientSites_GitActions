package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_WEBDRIVER.m_commandExecution.cdpAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v121.network.Network;

import java.util.Optional;
import java.util.Set;

public class ApiSet_Cookie_Test_ERR {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void set_cookie() throws InterruptedException {

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
