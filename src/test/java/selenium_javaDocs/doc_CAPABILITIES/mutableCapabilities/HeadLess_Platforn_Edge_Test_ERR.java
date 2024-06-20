package selenium_javaDocs.doc_CAPABILITIES.mutableCapabilities;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Browser;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

//ERROR org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: session not created: No matching capabilities found

public class C2_Capabilities_HeadLess_Platforn_Edge_Test_ERR {
	EdgeDriver driver;
	@Test
	public void eightComponents() {
		MutableCapabilities capabilities = new MutableCapabilities();
		//Pre requisite optional checks:
			capabilities.setCapability("platformName", "windows");
			capabilities.setCapability("browserName", Browser.EDGE.browserName());
		EdgeOptions options = new EdgeOptions();
		options.setHeadless(true);
		options = options.merge(capabilities);
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new EdgeDriver(options);
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