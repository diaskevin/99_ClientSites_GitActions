package ch01_selenium_general.Project_A_BrowserTypes.a_browserTypes_InstantiationObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

//ERROR: org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Possible causes are invalid address of the remote server or browser start-up failure.
public class A2_FireFoxScriptTest_ERR {
	WebDriver driver;

	@BeforeEach
	public void checkDesireCap() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void browser_firefox() throws InterruptedException {
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		driver.quit();
	}

}