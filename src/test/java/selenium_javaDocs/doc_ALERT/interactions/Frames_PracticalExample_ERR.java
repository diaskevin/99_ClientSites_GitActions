package selenium_javaDocs.doc_ALERT.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;

public class Frames_PracticalExample_Test_ERR {
    WebDriver driver;

    // With Selenium's .switchTo() method we can easily switch to the frame we want. When using it for frames
// (e.g., driver.switchTo().frame();) it accepts either an ID or name attribute. But in order to get the text of the middle frame (e.g., a frame nested within another frame), we need to switch to the parent frame (e.g., the top frame) first and then switch to the child frame (e.g., the middle frame).
// Once we've done that we're able to find the element we need, grab it's text, and assert that it's what we expect.
// While this example helps illustrate the point of frame switching, it's not very practical.
    @Test
    public void iFrames() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        editor.sendKeys("Hello World!");
        String afterText = editor.getText();
        MatcherAssert.assertThat(afterText, Matchers.not(Matchers.equalTo((beforeText))));
// switch back to top level

        driver.switchTo().defaultContent();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("u")).getText(),
                Matchers.is("An iFrame containing the TinyMCE WYSIWYG Editor"));


        MatcherAssert.assertThat(driver.findElement(By.id("content")).getText(), Matchers.is(Matchers.equalTo("MIDDLE")));

         driver.quit();
    }
}

