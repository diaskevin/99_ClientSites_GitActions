package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v126.browser.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadComplete_Test {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void consoleLogs_test() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/downloads/download.html");

        DevTools tools = ((HasDevTools) driver).getDevTools();
        tools.createSession();
        tools.send(
                Browser.setDownloadBehavior(
                        Browser.SetDownloadBehaviorBehavior.ALLOW,
                        Optional.empty(),
                        Optional.of(""),
                        Optional.of(true)));

        AtomicBoolean completed = new AtomicBoolean(false);
        tools.addListener(
                Browser.downloadProgress(),
                e -> {
                    //completed.set(Objects.equals(e.getState().toString(), "completed"));
                    completed.set(true);
                    System.out.println(e.getState().toString());
                    return;
                });

        Thread.sleep(5000);
        driver.findElement(By.id("file-2")).click();

        Assertions.assertTimeout(Duration.ofMillis(1000), () -> wait.until(e -> completed));
        Thread.sleep(5000);
        Assertions.assertTrue(completed.get());
       driver.quit();
    }
}
