package selenium_examples.elements.methods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FindElement_Click_Test {
	WebDriver driver;

	//ERR org.openqa.selenium.NoSuchElementException: no such element:
	@Test
	public void click_test(){
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.GMAIL.COM");
		driver.findElement(By.id("identifierId")).sendKeys("123ok");
		driver.findElement(By.id("identifierId")).click();
		driver.quit();
	}
}