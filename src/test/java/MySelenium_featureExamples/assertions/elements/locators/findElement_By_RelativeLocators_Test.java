package MySelenium_featureExamples.assertions.elements.locators;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class findElement_By_RelativeLocators_Test {
    WebDriver driver;

    @Disabled
    @Test
    public void relativeLocators_test() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://studio.teams.hvnt.com/auth/signup");
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonAccept\"]")).click();

        //above()
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement companyName = driver.findElement(RelativeLocator.with(By.tagName("input")).above(passwordField));
        System.out.println(companyName.getAccessibleName());
        //below()
        WebElement emailAddressField1 = driver.findElement(By.name("email"));
        WebElement companyName1 = driver.findElement(RelativeLocator.with(By.tagName("input")).below(emailAddressField1));
        System.out.println(companyName1.getAccessibleName());

        driver.quit();
    }
}
