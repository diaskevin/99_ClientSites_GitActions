package Coverage_selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.xpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class AssertLogo_Test {
WebDriver driver;

	@Test
	public void testCheckboxDiscovery_test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(chromeOptions);
				driver.get("http://Amazon.com");
		Thread.sleep(2000);
		WebElement submit  = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		Assertions.assertTrue(submit.isDisplayed());
		driver.quit();
	}
	}