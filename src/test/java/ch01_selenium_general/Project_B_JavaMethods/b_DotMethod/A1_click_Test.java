package ch01_selenium_general.Project_B_JavaMethods.b_DotMethod;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A1_click_Test {
	@Test
	public void about() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();   //accept cookies
		
		WebElement about =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]"));
		
		about.click();
		driver.quit();
	}
}