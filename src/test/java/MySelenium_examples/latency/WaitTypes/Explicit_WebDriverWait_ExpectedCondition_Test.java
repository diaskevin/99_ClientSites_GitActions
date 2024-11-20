package MySelenium_examples.latency.WaitTypes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Explicit_WebDriverWait_ExpectedCondition_Test {
		WebDriver driver;

//   https://www.selenium.dev/documentation/webdriver/waits/
		@Test
	    public void explicitWait1_test() {
			System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

			driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
			WebElement revealed = driver.findElement(By.id("revealed"));
			driver.findElement(By.id("reveal")).click();

			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(d -> revealed.isDisplayed());

			revealed.sendKeys("Displayed");
			Assertions.assertEquals("Displayed", revealed.getDomProperty("value"));
			driver.quit();
			}
	    }