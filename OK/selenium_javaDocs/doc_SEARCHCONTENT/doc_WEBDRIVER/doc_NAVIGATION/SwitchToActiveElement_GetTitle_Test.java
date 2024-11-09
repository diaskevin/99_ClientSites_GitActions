package selenium.doc_SEARCHCONTENT.doc_WEBDRIVER.doc_NAVIGATION;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SwitchToActiveElement_GetTitle_Test
{
	//ERR org.openqa.selenium.ElementNotInteractableException: element not interactable
	@Test
	public void SwitchTo_test() {
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
      
      	try {
        	driver.get("http://www.google.com");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();

        	driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");
        	// Get attribute of current active element
        	String attr = driver.switchTo().activeElement().getAttribute("title");
        	System.out.println(attr);
      		} catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
        driver.quit();
  		}      	
	}
}