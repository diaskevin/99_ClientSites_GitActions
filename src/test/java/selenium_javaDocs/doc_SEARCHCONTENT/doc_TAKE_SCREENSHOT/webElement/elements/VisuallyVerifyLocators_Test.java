package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class VisuallyVerifyLocators_Test {
    WebDriver driver;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions   .addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    // Now let's create a highlightElement helper method that will accept a Selenium WebDriver element and a time to wait (e.g., duration) as arguments.
    // By setting a duration, we can control how long to highlight an element on the page before reverting the styling back. And we can make this an optional argument by setting a sensible default (e.g., 3 seconds).
    //There are three things going on here.
    //We store the style of the element so we can revert it back when we're done
    //We change the style of the element so it visually stands out (e.g., a red dashed border)
    //We revert the style of the element back after 3 seconds (or longer if specified)
    private void highlightElement(WebElement element, int duration) throws InterruptedException {
        String original_style = element.getAttribute("style");

        js.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 2px solid red; border-style: dashed;");

        if (duration > 0) {
            Thread.sleep(duration * 1000);
            js.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    element,
                    "style",
                    original_style);
        }
    }

        @Test
            public void highlightElement_test() throws InterruptedException {
                driver.get("http://the-internet.herokuapp.com/large");
                WebElement element = driver.findElement(By.id("sibling-2.3"));
            highlightElement(element, 3);
    }
}