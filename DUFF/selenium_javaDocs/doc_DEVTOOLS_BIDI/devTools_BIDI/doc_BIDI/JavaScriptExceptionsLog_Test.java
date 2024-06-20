package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.doc_BIDI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.LogInspector;
import org.openqa.selenium.bidi.log.JavascriptLogEntry;
import org.openqa.selenium.bidi.log.LogLevel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.*;

/**
 * Anything said
 */

public class JavaScriptExceptionsLog_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        //CHROMEOPTIONS ADDED AS IT IS REQUIRED TO GET THIS CLASS TO RUN
        //NOTE: WHEN THE WINDOW OPENS, CLICK ON THE LINKS TO GENERATE 'LOG TO CONSOLE'
        //NOTE: RAKESH ADDED 'STACK ERROR' FOR LOOP TO PRINT LOGS ON INTELLIJ CONSOLE
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }
    @Test
    public void jsErrorlog() throws InterruptedException {
        try (LogInspector logInspector = new LogInspector(driver)) {
        CompletableFuture<JavascriptLogEntry> future = new CompletableFuture<>();
        logInspector.onJavaScriptLog(future::complete);

        driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");
        driver.findElement(By.id("jsException")).click();

        JavascriptLogEntry logEntry = future.get(5, TimeUnit.SECONDS);
            System.out.println(logEntry.getText());
        Assertions.assertEquals("Error: Not working", logEntry.getText());
        Assertions.assertEquals("javascript", logEntry.getType());
        Assertions.assertEquals(LogLevel.ERROR, logEntry.getLevel());

    } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
