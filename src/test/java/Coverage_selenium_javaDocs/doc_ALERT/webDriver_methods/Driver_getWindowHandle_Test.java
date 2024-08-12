package Coverage_selenium_javaDocs.doc_ALERT.webDriver_methods;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_getWindowHandle_Test {
	WebDriver driver;
	@Test
	public void windowHandle_test() {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
				String windowHandle = driver.getWindowHandle();
				System.out.println("Window Handle: " +windowHandle);
			driver.quit();
	}
}