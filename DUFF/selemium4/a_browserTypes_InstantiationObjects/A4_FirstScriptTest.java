package ch01_selenium_general.Project_A_BrowserTypes.a_browserTypes_InstantiationObjects;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class A4_FirstScriptTest {
	WebDriver driver;

	@BeforeEach
	public void checkDesireCap() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();

	}
	@Test
	public void browser_chrome() throws InterruptedException {
		driver.get("https://www.facebook.com");
		Thread.sleep(2000);
		driver.quit();
	}


	@Test
	public void eightComponents() {
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