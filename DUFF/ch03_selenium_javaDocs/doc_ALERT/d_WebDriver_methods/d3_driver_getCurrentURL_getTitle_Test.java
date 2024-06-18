package ch03_selenium_javaDocs.doc_ALERT.d_WebDriver_methods;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GU_driver_getCurrentURL_getTitle_Test_CO {
	WebDriver driver;
	@Test
	public void currentURL() {

		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
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