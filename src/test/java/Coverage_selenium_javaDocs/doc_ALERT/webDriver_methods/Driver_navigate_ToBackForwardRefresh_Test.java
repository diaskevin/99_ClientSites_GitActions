package Coverage_selenium_javaDocs.doc_ALERT.webDriver_methods;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_navigate_ToBackForwardRefresh_Test {
	WebDriver driver;
	@Test
	public void navigate_BackForward_test() {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			driver.get("https://www.kcl.ac.uk/index.aspx");
			driver.navigate().to("https://www.screwfix.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.quit();
	}
}
