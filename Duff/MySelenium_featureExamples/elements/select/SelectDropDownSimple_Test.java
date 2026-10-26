package MySelenium_featureExamples.elements.select;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownSimple_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        //System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void SelectDropDown_test() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");

        WebElement selectElement = driver.findElement(By.name("single_disabled"));
        Select select = new Select(selectElement);
        select.selectByValue("enabled");
        //select.selectByValue("disabled");
        driver.quit();
    }
}