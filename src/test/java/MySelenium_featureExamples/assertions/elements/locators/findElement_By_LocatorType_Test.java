package MySelenium_featureExamples.assertions.elements.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElement_By_LocatorType_Test {
    WebDriver driver;

    //ERR org.openqa.selenium.NoSuchElementException: no such element
    @Test
    public void LocatorTypes_test() {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://studio.teams.hvnt.com/auth/signup");
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonAccept\"]")).click();

        driver.findElement(By.id("displayName")).sendKeys("kevin");
        driver.findElement(By.name("email")).sendKeys("aaa@aaa.com");
        driver.findElement(By.cssSelector("Input[type = 'password'][id = 'password']")).sendKeys("password");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        //driver.findElement(By.xpath("//*[@type=\"button\"]")).click(); --- observe two buuton look at specific text for 'back to logon'
        driver.quit();
    }
}