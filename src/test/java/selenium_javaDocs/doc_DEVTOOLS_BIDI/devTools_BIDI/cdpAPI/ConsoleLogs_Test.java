package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.cdpAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v126.runtime.Runtime;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConsoleLogs_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void consoleLogs_test() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");

    DevTools devTools = ((HasDevTools) driver).getDevTools();
    devTools.createSession();
    devTools.send(Runtime.enable());

    //Listener for console events
    CopyOnWriteArrayList<String> logs = new CopyOnWriteArrayList<>();
    devTools.addListener(
            Runtime.consoleAPICalled(),
    event -> logs.add((String) event.getArgs().get(0).getValue().orElse("")));

    //Do an action that will generates event log
    Thread.sleep(1000);
        driver.findElement(By.id("consoleLog")).click();
        Thread.sleep(1000);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(_d -> !logs.isEmpty());
        System.out.println(logs.get(0));
        Assertions.assertEquals("Hello, world!", logs.get(0));
        driver.quit();
    }
}