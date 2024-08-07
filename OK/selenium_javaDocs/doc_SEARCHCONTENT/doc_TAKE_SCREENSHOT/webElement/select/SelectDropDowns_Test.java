package selenium_javaDocs.doc_SEARCHCONTEXT.doc_TAKE_SCREENSHOT.webElement.select;//import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDowns_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @Disabled
    //Line SelectDropDowns_Test.select_test(SelectDropDowns_Test.java:37)
    @Test
    public void select_test() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");

        WebElement selectElement = driver.findElement(By.name("selectomatic"));
        Select select = new Select(selectElement);

        WebElement twoElement = driver.findElement(By.cssSelector("option[value=two]"));
        WebElement fourElement = driver.findElement(By.cssSelector("option[value=four]"));
        WebElement countElement = driver.findElement(By.cssSelector("option[value='still learning how to count, apparently']"));

        Thread.sleep(5000);

        select.selectByVisibleText("Four");
        Assertions.assertTrue(fourElement.isSelected());

        Thread.sleep(3000);
        select.selectByValue("two");
        Assertions.assertTrue(twoElement.isSelected());

        Thread.sleep(3000);
        select.selectByIndex(3);
        Assertions.assertTrue(countElement.isSelected());


        driver.quit();
    }
}