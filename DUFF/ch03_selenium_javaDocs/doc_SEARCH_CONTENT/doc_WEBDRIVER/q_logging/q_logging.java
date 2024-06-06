package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_WEBDRIVER.q_logging;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class q_logging {

    Logger logger = Logger.getLogger("q_logging");
    @Test
    public void googlesearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(4000);
        driver.quit();


    }
    @Test
    public void logging() throws IOException {

        logger.setLevel(Level.FINE);
        Arrays.stream(logger.getHandlers()).forEach(handler -> {
            handler.setLevel(Level.FINE);
        });

        Handler handler = new FileHandler("selenium.xml");
        logger.addHandler(handler);

        Logger.getLogger(RemoteWebDriver.class.getName()).setLevel(Level.FINEST);
        Logger.getLogger(SeleniumManager.class.getName()).setLevel(Level.SEVERE);

        Logger localLogger = Logger.getLogger(this.getClass().getName());
        localLogger.warning("this is a warning");
        localLogger.info("this is useful information");
        localLogger.fine("this is detailed debug information");

        byte[] bytes = Files.readAllBytes(Paths.get("selenium.xml"));
        String fileContent = new String(bytes);

        Assertions.assertTrue(fileContent.contains("this is a warning"));
        Assertions.assertTrue(fileContent.contains("this is useful information"));
        Assertions.assertTrue(fileContent.contains("this is detailed debug information"));
    }
}
