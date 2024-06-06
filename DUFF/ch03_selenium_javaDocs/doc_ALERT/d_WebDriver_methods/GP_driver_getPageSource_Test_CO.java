package ch03_selenium_javaDocs.doc_ALERT.d_WebDriver_methods;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GP_driver_getPageSource_Test_CO {
	WebDriver driver;
	@Test
	public void pageSource() {

		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);

		//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();

		driver.get("https://kcl.ac.uk");
				String PageSource = driver.getPageSource();
				System.out.println("Page Source: " + PageSource);	
		driver.quit();
	}
}