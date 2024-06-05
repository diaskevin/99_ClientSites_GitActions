package ch03_selenium_javaDocs.searchContent.takeScreenShot.webElement.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElement_By_RelativeLocators_Test_WIP {

    @Test
    public void relativeLocators_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kcl.ac.uk/index.aspx");
        driver.findElement(By.id("courseSearchInput")).sendKeys("123ok");

        //above()
        //import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
        //WebElement passwordField= driver.findElement(By.id("password"));
        //WebElement emailAddressField = driver.findElement(withTagName("input")
        //                                                  .above(passwordField));

        //below()
        //import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
        //WebElement emailAddressField= driver.findElement(By.id("email"));
        //WebElement passwordField = driver.findElement(withTagName("input")
        //	                                          .below(emailAddressField));

        //toLeftOf()
        //import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
        //WebElement submitButton= driver.findElement(By.id("submit"));
        //WebElement cancelButton= driver.findElement(withTagName("button")
        //                                            .toLeftOf(submitButton));

        //toRightOf()
        //import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
        //WebElement cancelButton= driver.findElement(By.id("cancel"));
        //WebElement submitButton= driver.findElement(withTagName("button")
        //                                            .toRightOf(cancelButton));

        //near()
        //import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
        //WebElement emailAddressLabel= driver.findElement(By.id("lbl-email"));
        //WebElement emailAddressField = driver.findElement(withTagName("input")
        //                                                  .near(emailAddressLabel));

        driver.quit();
    }
}
