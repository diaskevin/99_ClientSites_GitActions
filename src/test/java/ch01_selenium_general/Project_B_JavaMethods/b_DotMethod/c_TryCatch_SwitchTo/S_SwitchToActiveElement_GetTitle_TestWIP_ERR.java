package ch01_selenium_general.Project_B_JavaMethods.b_DotMethod.c_TryCatch_SwitchTo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class S_SwitchToActiveElement_GetTitle_TestWIP_ERR {
	//ERR org.openqa.selenium.ElementNotInteractableException: element not interactable
	@Test
	public void SwitchTo() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
      
      	try {
        	driver.get("http://www.google.com");
        	driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

        	// Get attribute of current active element
        	String attr = driver.switchTo().activeElement().getAttribute("title");
        	System.out.println(attr);
      		} 
      	finally {
        driver.quit(); 
  		}      	
	}
}