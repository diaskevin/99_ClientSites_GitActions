package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_WEBDRIVER.m_commandExecution.webdriver_biDiAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.LogInspector;
import org.openqa.selenium.bidi.log.ConsoleLogEntry;
import org.openqa.selenium.bidi.log.JavascriptLogEntry;
import org.openqa.selenium.bidi.log.LogLevel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Anything said
 */

public class listenJSlogs {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        //CHROMEOPTIONS ADDED AS IT IS REQUIRED TO GET THIS CLASS TO RUN
        //NOTE: WHEN THE WINDOW OPENS, CLICK ON THE LINKS TO GENERATE 'LOG TO CONSOLE'
        //NOTE: RAKESH ADDED 'STACK ERROR' FOR LOOP TO PRINT LOGS ON INTELLIJ CONSOLE
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }
    @Test
    public void listenJSlog() throws ExecutionException, InterruptedException, TimeoutException {
        try (LogInspector logInspector = new LogInspector(driver)) {
            CompletableFuture<ConsoleLogEntry> future = new CompletableFuture<>();
            logInspector.onConsoleEntry(future::complete);

            driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");
            driver.findElement(By.id("consoleLog")).click();

            ConsoleLogEntry logEntry = future.get(5, TimeUnit.SECONDS);
            System.out.println(logEntry.getText());
            System.out.println(logEntry.getStackTrace().toString());
            Assertions.assertEquals("Hello, world!", logEntry.getText());
            Assertions.assertNull(logEntry.getRealm());
            Assertions.assertEquals(1, logEntry.getArgs().size());
            Assertions.assertEquals("console", logEntry.getType());
            Assertions.assertEquals("log", logEntry.getMethod());
            //Assertions.assertNull(logEntry.getStackTrace());
        }

        driver.quit();
    }
}
