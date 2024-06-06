package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.methods;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class findElement_Click_TestWIP {
	WebDriver driver;

	//ERR org.openqa.selenium.NoSuchElementException: no such element:
	@Test
	public void click_test(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.GMAIL.COM");
		driver.findElement(By.id("next")).click();
		driver.quit();
	}
}