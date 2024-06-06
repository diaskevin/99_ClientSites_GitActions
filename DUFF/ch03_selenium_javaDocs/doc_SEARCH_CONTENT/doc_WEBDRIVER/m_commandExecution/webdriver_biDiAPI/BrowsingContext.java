package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_WEBDRIVER.m_commandExecution.webdriver_biDiAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContextInfo;
import org.openqa.selenium.bidi.browsingcontext.NavigationResult;
import org.openqa.selenium.bidi.browsingcontext.ReadinessState;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

/**
 * Anything said
 */

public class BrowsingContext {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }
    @Test
    public void set_Header_token() throws InterruptedException {
        String id = driver.getWindowHandle();
        System.out.println("Window handler value : "+id);

        org.openqa.selenium.bidi.browsingcontext.BrowsingContext browsingContextWindow = new org.openqa.selenium.bidi.browsingcontext.BrowsingContext(driver, WindowType.WINDOW);
        //or
        //BrowsingContext browsingContextTab = new BrowsingContext(driver, WindowType.TAB);

       // Navigate to a URL
        // browsingContextWindow.navigate("https://www.selenium.dev");

        NavigationResult info = browsingContextWindow.navigate("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html",
        ReadinessState.COMPLETE); System.out.println("readiness state : " +info.getNavigationId() +" "+info.getUrl());
        Thread.sleep(3000);

        //Get browsing context tree of the parent window
        String referenceContextId = driver.getWindowHandle();
        org.openqa.selenium.bidi.browsingcontext.BrowsingContext parentWindow = new org.openqa.selenium.bidi.browsingcontext.BrowsingContext(driver, referenceContextId);
        parentWindow.navigate("https://www.selenium.dev/selenium/web/iframes.html", ReadinessState.COMPLETE);
        List<BrowsingContextInfo> contextInfoList = parentWindow.getTree(0);

        //Get All Top level browsing contexts
        org.openqa.selenium.bidi.browsingcontext.BrowsingContext window1 = new org.openqa.selenium.bidi.browsingcontext.BrowsingContext(driver, driver.getWindowHandle());
        org.openqa.selenium.bidi.browsingcontext.BrowsingContext window2 = new org.openqa.selenium.bidi.browsingcontext.BrowsingContext(driver, WindowType.WINDOW);
        List<BrowsingContextInfo> contextInfoList1 = window1.getTopLevelContexts();

        //Close a tab/window
        org.openqa.selenium.bidi.browsingcontext.BrowsingContext window3 = new org.openqa.selenium.bidi.browsingcontext.BrowsingContext(driver, WindowType.WINDOW);
        org.openqa.selenium.bidi.browsingcontext.BrowsingContext window4 = new org.openqa.selenium.bidi.browsingcontext.BrowsingContext(driver, WindowType.WINDOW);
        window4.close();

        driver.quit();
    }
}
