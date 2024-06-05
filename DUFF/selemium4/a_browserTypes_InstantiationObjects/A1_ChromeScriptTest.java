package ch01_selenium_general.Project_A_BrowserTypes.a_browserTypes_InstantiationObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_ChromeScriptTest {
	WebDriver driver;

	@BeforeEach
	public void checkDesireCap() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void browser_chrome() throws InterruptedException {
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		driver.quit();
	}

}