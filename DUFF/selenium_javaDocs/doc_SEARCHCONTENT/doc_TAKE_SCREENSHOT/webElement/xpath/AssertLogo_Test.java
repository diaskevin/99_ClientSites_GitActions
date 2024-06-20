package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.xpath;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AssertLogo_Test {
WebDriver driver;
	
	@BeforeEach
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = getChromeDriver();
	}

	public WebDriver getChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testCheckboxDiscovery() throws InterruptedException {
		driver.get("http://Amazon.com");
		Thread.sleep(2000);
		WebElement submit  = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
		Assertions.assertTrue(submit.isDisplayed());
		}
	}