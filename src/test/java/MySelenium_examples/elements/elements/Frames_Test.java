package MySelenium_examples.elements.elements;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Frames_Test {
    WebDriver driver;
// With Selenium's .switchTo() method we can easily switch to the frame we want. When using it for frames
// (e.g., driver.switchTo().frame();) it accepts either an ID or name attribute. But in order to get the text of the middle frame (e.g., a frame nested within another frame), we need to switch to the parent frame (e.g., the top frame) first and then switch to the child frame (e.g., the middle frame).
// Once we've done that we're able to find the element we need, grab it's text, and assert that it's what we expect.
// While this example helps illustrate the point of frame switching, it's not very practical.
    @Test
    public void nestedFrames_test() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
            driver.get("http://the-internet.herokuapp.com/nested_frames");
            driver.switchTo().frame("frame-top");
            driver.switchTo().frame("frame-middle");
            MatcherAssert.assertThat(driver.findElement(By.id("content")).getText(), Is.is(CoreMatchers.equalTo("MIDDLE")));
        driver.quit();
    }
}
