package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SelectListDropDowns_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void selectMultipleOptions_test() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");

        WebElement selectElement = driver.findElement(By.name("multi"));
        Select select = new Select(selectElement);

        WebElement hamElement = driver.findElement(By.cssSelector("option[value=ham]"));
        WebElement gravyElement = driver.findElement(By.cssSelector("option[value='onion gravy']"));
        WebElement eggElement = driver.findElement(By.cssSelector("option[value=eggs]"));
        WebElement sausageElement = driver.findElement(By.cssSelector("option[value='sausages']"));

        List<WebElement> optionElements = selectElement.findElements(By.tagName("option"));
        List<WebElement> optionList = select.getOptions();
        Assertions.assertEquals(optionElements, optionList);

        Thread.sleep(3000);

        List<WebElement> selectedOptionList = select.getAllSelectedOptions();
        List<WebElement> expectedSelection = new ArrayList<WebElement>() {{
            add(eggElement);
            add(sausageElement);
        }};
        Assertions.assertEquals(expectedSelection, selectedOptionList);

        Thread.sleep(3000);

        select.selectByValue("ham");
        select.selectByValue("onion gravy");
        Assertions.assertTrue(hamElement.isSelected());
        Assertions.assertTrue(gravyElement.isSelected());

        Thread.sleep(3000);

        select.deselectByValue("eggs");
        select.deselectByValue("sausages");
        Assertions.assertFalse(eggElement.isSelected());
        Assertions.assertFalse(sausageElement.isSelected());

        driver.quit();
    }
}