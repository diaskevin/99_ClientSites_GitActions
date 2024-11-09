package selenium.doc_SEARCHCONTENT.doc_WEBDRIVER.doc_OPTIONS_cookie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class CookiesAddDelete_Test {
    WebDriver driver;
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void cookies_test() throws InterruptedException {
        driver.get("http://www.example.com");

        Thread.sleep(1000);
        // Adds the cookie into current browser context

        driver.manage().addCookie(new Cookie("Kevin_pword", "pword123"));
        // Get cookie details with named cookie 'foo'
        Cookie cookie1 = driver.manage().getCookieNamed("Kevin_pword");
        System.out.println(cookie1.getValue());

        driver.manage().addCookie(new Cookie("David_pword", "pwordDave"));
        // Get All available cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
        System.out.println(cookies.size());

        driver.manage().deleteCookieNamed("David_pword");
        cookies = driver.manage().getCookies();
        System.out.println(cookies);
        System.out.println(cookies.size());

        driver.manage().deleteCookie(cookie1);
        cookies = driver.manage().getCookies();
        System.out.println(cookies);
        System.out.println(cookies.size());

        driver.quit();
    }
}
