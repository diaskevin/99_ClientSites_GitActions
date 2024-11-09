package selenium.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SelectDropdown_a_Test {
    WebDriver driver;

    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions   .addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }
// Selecting from a dropdown list seems like one of those simple things.
// Just grab the list by it's element and select an item within it based on the text you want.
// After visiting the example application we find the dropdown list by it's ID and store it in a variable.
// We then find each clickable element in the dropdown list (e.g., each option) with findElements (note the plural).
//Grabbing all of the options with findElements returns a collection that we iterate over.
// When the text matches what we want, we click on it.
//We finish the test by performing a check to see that our selection was made correctly.
// This is done by iterating over the dropdown options collection one more time.
// This time we're getting the text of the item that was selected, storing it in a variable, and making an assertion against it.
//
//While this works, the next class shows a simpler, built-in way to do this with Selenium
        @Test
        public void dropdown_test() {
            driver.get("http://the-internet.herokuapp.com/dropdown");
            WebElement dropdownList = driver.findElement(By.id("dropdown"));
            List<WebElement> options = dropdownList.findElements(By.tagName("option"));
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i).getText().equals("Option 1")) {
                    options.get(i).click();
                }
            }
            String selectedOption = "";
            for (int i = 0; i < options.size(); i++) {
                if (options.get(i).isSelected()) {
                    selectedOption = options.get(i).getText();
                }
            }
            MatcherAssert.assertThat(selectedOption, Is.is("Option 1"));
        }
}