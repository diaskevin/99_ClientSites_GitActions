package selenium.Alert.webDriver_methods;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_manage_window_max_Test {
	WebDriver driver;
	@Test
	public void window_max_test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);

		//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\Rakesh\\Resource\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
			driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.quit();
	}
}
