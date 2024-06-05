package ch01_selenium_general.Project_A_BrowserTypes.a_browserTypes_InstantiationObjects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class 	A2_EdgeScriptTest {
	WebDriver driver;

	@BeforeEach
	public void checkDesireCap() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\edgeDriver\\msedgedriver.exe");
		driver = new EdgeDriver();
	}
	@Test
	public void browser_edge() throws InterruptedException {
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		driver.quit();
	}

}