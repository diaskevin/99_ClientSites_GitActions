package selenium_javaDocs.doc_SEARCHCONTEXT;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeOptions_Sel3_historicProblem {
    WebDriver driver;

    // Montly allowance (Aug24) has run out, so can not edit field. Try in Sept

    // With Selenium's .switchTo() method we can easily switch to the frame we want. When using it for frames
// (e.g., driver.switchTo().frame();) it accepts either an ID or name attribute. But in order to get the text of the middle frame (e.g., a frame nested within another frame), we need to switch to the parent frame (e.g., the top frame) first and then switch to the child frame (e.g., the middle frame).
// Once we've done that we're able to find the element we need, grab it's text, and assert that it's what we expect.
// While this example helps illustrate the point of frame switching, it's not very practical.
    @Test
    public void iFrames_test() throws Exception {

        //This fix was used to resolve the old Selenium3 problem caused by using the wrong selenium dependency on the POM
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        org.openqa.selenium.chrome.ChromeOptions chromeOptions = new org.openqa.selenium.chrome.ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://google.com");
        driver.quit();
    }
}