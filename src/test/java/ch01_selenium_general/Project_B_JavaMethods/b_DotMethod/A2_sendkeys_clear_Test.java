//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html

package ch01_selenium_general.Project_B_JavaMethods.b_DotMethod;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A2_sendkeys_clear_Test {
	@Test
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();   //accept cookies
		
		WebElement search_Box =  driver.findElement(By.name("q"));
		
		search_Box.sendKeys("bread");
		Thread.sleep(1000);
		search_Box.clear();
		search_Box.sendKeys("pumkin");
		Thread.sleep(1000);
		driver.quit();
	}
}