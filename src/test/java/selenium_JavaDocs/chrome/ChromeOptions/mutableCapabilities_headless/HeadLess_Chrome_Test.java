package selenium_JavaDocs.chrome.ChromeOptions.mutableCapabilities_headless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class HeadLess_Chrome_Test {
	WebDriver driver;

	@Test
	public void HeadlessChrome_Test() {
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		driver = new ChromeDriver(options);

		driver.get("https://selenium.dev");
		String title = driver.getTitle();
		System.out.println(title);
		Assertions.assertEquals("Selenium", title);

		driver.quit();
	}
}