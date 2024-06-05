package ch01_selenium_general.Project_B_JavaMethods.b_DotMethod.e_Loop_WebElementS;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1_WebElementS_ForLoopList_div_Test {
	
	@Test
	public void WebElementsList() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		
		  try {
			  driver.get("http://www.google.com");
				// Get all the elements available with tag name of 'div'
	            List<WebElement> lotsOfelements = driver.findElements(By.tagName("div"));
	            for (WebElement element : lotsOfelements) {
	                System.out.println("Paragraph text:" + element.getText());
	           }
	                  
		  } 
		  
		  catch(Exception e) {System.out.println(e);
		  }
		  
		  finally {
	            driver.quit();            
	        	   }
	    }
	} 