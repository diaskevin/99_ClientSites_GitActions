package selenium_javaDocs.doc_ALERT.wait;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Explicit_WebDriverWait_ExpectedCondition_Test {
		WebDriver driver;

//   https://www.selenium.dev/documentation/webdriver/waits/
//   How to import REVEALED
		@Test
	    public void explicitWait1_test() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\Rakesh\\Resource\\chromedriver.exe");
			driver = new ChromeDriver();

			//System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("--remote-allow-origins=*");
			//driver = new ChromeDriver(chromeOptions);

			driver.get("https://google.com");



			//WebDriverWait wait = new WebDriverWait(driver,3);
			//wait.until(ExpectedConditions.urlContains("google"));//    String url = driver.getTitle();
	        //System.out.println("url :" +url);

			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(d -> revealed.isDisplayed());

			driver.quit();
	    	}
	    }