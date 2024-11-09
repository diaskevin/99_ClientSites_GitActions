package selenium.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class Frames_PracticalExample_Test {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }
    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Disabled
    //Frames_PracticalExample_Test.iFrames_test:42 » InvalidElementState invalid ele...
    @Test
    public void iFrames_test() throws Exception {
        driver.get("http://the-internet.herokuapp.com/tinymce");
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.id("tinymce"));
        String beforeText = editor.getText();
        editor.clear();
        editor.sendKeys("Hello World!");
        String afterText = editor.getText();
        MatcherAssert.assertThat(afterText, IsNot.not(CoreMatchers.equalTo((beforeText))));
        // switch back to top level
        driver.switchTo().defaultContent();
        ///html/body/div[2]/div/div/h3
        //assertThat(driver.findElement(By.cssSelector("u")).getText(),
        MatcherAssert.assertThat(driver.findElement(By.xpath("/html/body/div[2]/div/div/h3")).getText(),
        Is.is("An iFrame containing the TinyMCE WYSIWYG Editor"));
        MatcherAssert.assertThat(driver.findElement(By.id("content")).getText(), Is.is(CoreMatchers.equalTo("An iFrame containing the TinyMCE WYSIWYG Editor\nFile\nEdit\nView\nFormat\nParagraph\nP\nPOWERED BY TINY")));
    }
}

