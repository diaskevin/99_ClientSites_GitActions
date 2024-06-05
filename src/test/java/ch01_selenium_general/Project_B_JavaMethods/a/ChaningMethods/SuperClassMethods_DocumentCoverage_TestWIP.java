package ch01_selenium_general.Project_B_JavaMethods.a.ChaningMethods;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class SuperClassMethods_DocumentCoverage_TestWIP {
	@Test
	public void chainingMethods() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();   //accept cookies
		WebElement searchForm = driver.findElement(By.tagName("form"));
		RemoteWebElement searchBox = (RemoteWebElement) searchForm.findElement(By.name("q"));
		searchBox.sendKeys("webdriver");
		driver.quit();
		
		//Chaining methods@
		//1) AVAILABLITY OF METHODS Super class has 5 methods, sub class has 4 methods. 
		//		If you extend super class into sub class & created an instance for sub class, will show 9 methods	
		//2) findBy method, Get TagName, connecting multiple operations in sequence
		
		//3) Java Collections (list & sets), Lambda, streams concept, multiple methods in a connected (filter. map)   
        
		//4) Reactive programming for rest api	
		//5) Asynchronious		
	}
}