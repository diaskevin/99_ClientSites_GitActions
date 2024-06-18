package ch03_selenium_javaDocs.doc_CAPABILITIES.chromeOption;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupReturnDriver {
WebDriver driver;
	
	@BeforeEach
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver",  "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
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
		//driver.quit();
	}
	
	@Test
	public void testCheckboxDiscovery() throws InterruptedException {

		driver.get("http://Amazon.com");
		}
	}