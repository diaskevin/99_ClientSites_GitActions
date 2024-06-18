package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SelectDropdown_b {
    WebDriver driver;

    @BeforeEach
    public void setUpaa() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions   .addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    // Similar to the first example, we are finding the dropdown list by it's ID. But instead of iterating over its option elements and clicking based on a conditional we are leveraging a built-in helper function of Selenium. With Select and it's selectBy methods
    // (e.g., selectByVisibleText) we're able to easily choose the item we want.
    // We then ask the selectList what option was selected by using getFirstSelectedOption and perform our assertion against it's text.
    // As an aside, in addition to selecting by text you can also select by value.
    // select.selectByValue("1");
        @Test
        public void dropdownTestRedux() {
            driver.get("http://the-internet.herokuapp.com/dropdown");
            Select selectList = new Select(driver.findElement(By.id("dropdown")));
            selectList.selectByVisibleText("Option 1");
            MatcherAssert.assertThat(selectList.getFirstSelectedOption().getText(), Matchers.is(CoreMatchers.equalTo("Option 1")));
        }
}