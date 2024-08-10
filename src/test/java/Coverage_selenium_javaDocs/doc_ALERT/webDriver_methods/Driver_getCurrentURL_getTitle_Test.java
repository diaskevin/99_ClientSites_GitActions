package Coverage_selenium_javaDocs.doc_ALERT.webDriver_methods;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_getCurrentURL_getTitle_Test {
	WebDriver driver;
	@Test
	public void currentURL_test() {

		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);

		//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\Rakesh\\Resource\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
			String browserURL = driver.getCurrentUrl();
			System.out.println("Browser Current url: " + browserURL);
				String browserTitle = driver.getTitle();
				System.out.println("Browser Title: " + browserTitle);
			driver.quit();
	}
}