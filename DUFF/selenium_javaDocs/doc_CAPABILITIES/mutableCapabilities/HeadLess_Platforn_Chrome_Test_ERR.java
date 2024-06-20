package selenium_javaDocs.doc_CAPABILITIES.mutableCapabilities;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class C1_Capabilities_HeadLess_Platforn_Chrome_Test_ERR {
	ChromeDriver driver;
	@Test
	public void eightComponents() {
		//MutableCapabilities capabilities = new MutableCapabilities();
		//Pre requisite optional checks:
			//capabilities.setCapability("platformName", "windows");
			//capabilities.setCapability("browserName", Browser.CHROME.browserName());
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		//options = options.merge(capabilities);
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		System.out.println(driver.getCapabilities().asMap());
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		String title = driver.getTitle();
		Assertions.assertEquals("Web form", title);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		textBox.sendKeys("Selenium");
		submitButton.click();
		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		System.out.println("value: "+value);
		Assertions.assertEquals("Received!", value);
		driver.quit();
	}

}