package selenium_javaDocs.doc_DEVTOOLS_BIDI.devTools_BIDI.doc_BIDI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.LogInspector;
import org.openqa.selenium.bidi.log.ConsoleLogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Anything said
 */

public class consoleLog_Test {
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
    public void consolelog() throws InterruptedException {
            CopyOnWriteArrayList<ConsoleLogEntry> logs = new CopyOnWriteArrayList<>();

            try (LogInspector logInspector = new LogInspector(driver)) {
                logInspector.onConsoleEntry(logs::add);
            }
            driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");

            // During te threadsleep, click to generate error events
        Thread.sleep(20000);
        for (ConsoleLogEntry e: logs){
            System.out.println(e.getText());
           // System.out.println(e.getStackTrace().);
        }
            driver.quit();
    }
}
