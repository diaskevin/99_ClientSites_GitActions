package Coverage_selenium_javaDocs.doc_ALERT.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
public class WaitThreadSleep_Test {
	WebDriver driver;
	@Test
	public void testManageWindow_test() {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);

		driver.get("http://www.facebook.com");
		  //Thread.sleep (10 seconds)     
    			try {
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    						e.printStackTrace();
    				}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.quit();
	}
}