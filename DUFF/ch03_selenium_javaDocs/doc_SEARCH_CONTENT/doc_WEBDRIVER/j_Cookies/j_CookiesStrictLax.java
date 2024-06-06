package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_WEBDRIVER.j_Cookies;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class j_CookiesStrictLax {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void cookies() throws InterruptedException {
        driver.get("http://www.example.com");

        Thread.sleep(1000);
        // Adds the cookie for webservice Request / Response within same Site for (Strict/Lax)

        Cookie cookie = new Cookie.Builder("key", "value").sameSite("Strict").build();
        Cookie cookie1 = new Cookie.Builder("key1", "value1").sameSite("Lax").build();
        driver.manage().addCookie(cookie);
        driver.manage().addCookie(cookie1);
        System.out.println(cookie.getSameSite());
        System.out.println(cookie1.getSameSite());

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);
        System.out.println(cookies.size());

        driver.quit();
    }
}
