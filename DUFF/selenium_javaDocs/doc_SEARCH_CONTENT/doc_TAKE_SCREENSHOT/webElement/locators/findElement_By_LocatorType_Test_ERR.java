package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class findElement_By_LocatorType_Test_ERR {
    WebDriver driver;
    //ERR org.openqa.selenium.NoSuchElementException: no such element
    @Test
    public void LocatorTypes_Test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //Open Account Management Page >> Click on Create Account
        driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
        driver.findElement(By.xpath("//a[contains(@href, 'NewAccount.aspx')]")).click();
        //Fill Out form >> On the Create an Account Page
        driver.findElement(By.id("MainContent_txtFirstName")).sendKeys("name");
        driver.findElement(By.name("ctl00$MainContent$txtEmail")).sendKeys("email");
        driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]")).sendKeys("phoneNumber");
        driver.findElement(By.cssSelector("Input[type = 'Password'][id = 'MainContent_txtPassword']")).sendKeys("password");
        driver.findElement(By.cssSelector("Input[type = 'Password'][id = 'MainContent_txtVerifyPassword']")).sendKeys("password");
        driver.findElement(By.cssSelector("Input[name ='ctl00$MainContent$Gender'][Value = 'Female']")).click();
        new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue("Italy");
        driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
        driver.findElement(By.id("MainContent_btnSubmit")).click();
    }
}
