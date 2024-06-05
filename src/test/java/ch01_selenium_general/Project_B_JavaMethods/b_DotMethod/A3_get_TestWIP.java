//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html#findElements(org.openqa.selenium.By)

package ch01_selenium_general.Project_B_JavaMethods.b_DotMethod;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class A3_get_TestWIP {
	
	@Test
	public void getDetails_test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();   //accept cookies
		
		WebElement search_box =  driver.findElement(By.name("q"));
		
		//Coverage of Selenium Class RemoteWebElement methods
		System.out.println("Attribute 'Title' value is: " +search_box.getAttribute("title"));
		System.out.println("Class value is: " +search_box.getClass());
		System.out.println("CSSValue of 'background-colour' value is: " +search_box.getCssValue("background-color"));
		System.out.println("Location value is: " +search_box.getLocation());
		System.out.println("Rectangle value is: " +search_box.getRect());
		//search_box.getScreenshotAs(null)
				System.out.println("Size value is: " +search_box.getSize());
				System.out.println("TagName value is: " +search_box.getTagName());
				System.out.println("'Text' value is: " +search_box.getText());
		/*
		assertEquals("", search_box.getCssValue("title"));
		search_box.getLocation();
		search_box.getRect();
		search_box.getSize();		
				
		//DOM coverage
		System.out.println("Attribute 'Title' value is: " +search_box.getAttribute("title"));
		System.out.println("Attribute 'Type' value is: " +search_box.getAttribute("type"));
	    assertEquals("Search", search_box.getAttribute("title"));
		assertEquals("text", search_box.getAttribute("type"));
		search_box.sendKeys("abcdefg");
		*/		
		driver.quit();
	}
}