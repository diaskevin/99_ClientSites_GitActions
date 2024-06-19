package ch03_selenium_javaDocs.doc_CAPABILITIES.c_mutableCapabilities;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C3_Capabilities_HeadLess_Platforn_Firefox_Test_ERR {
	FirefoxDriver driver;

	@Test
	public void eightComponents() {

		//MutableCapabilities capabilities = new MutableCapabilities();
		//Pre requisite optional checks:
			//capabilities.setCapability("platformName", "windows");
		    //capabilities.setCapability("browserName", Browser.FIREFOX.browserName());
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		//options = options.merge(capabilities);
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\geckodriver\\geckodriver.exe");

		driver = new FirefoxDriver(options);
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