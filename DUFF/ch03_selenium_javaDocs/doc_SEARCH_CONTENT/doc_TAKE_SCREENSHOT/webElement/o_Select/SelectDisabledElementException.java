package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.o_Select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDisabledElementException {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @Test
    public void DisabledElement_Test() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/formPage.html");

        WebElement selectElement = driver.findElement(By.name("single_disabled"));
        Select select = new Select(selectElement);
        select.selectByValue("disabled");

        //The above throws an exception

        driver.quit();
    }
}