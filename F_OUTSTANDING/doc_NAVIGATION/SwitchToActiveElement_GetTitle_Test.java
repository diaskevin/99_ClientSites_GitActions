import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


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
			//driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();

			//Question1- Why does this not work?
			//driver.switchTo().alert().accept();

			//Question2 How to use this?
			By cookies_accept = By.xpath(""//*[@id=\"L2AGLb\"]"");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));

        	driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");
        	// Get attribute of current active element
        	String attr = driver.switchTo().activeElement().getAttribute("title");
        	System.out.println(attr);
      		} catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
        //driver.quit();
  		}      	
	}
}