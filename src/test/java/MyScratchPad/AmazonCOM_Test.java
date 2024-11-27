package MyScratchPad;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Kevin2023 Observe this is an Amazon Cookie accept, BUT it need to be place in the 'Before' annotation once, also it needs to be BeforeEach

public class AmazonCOM_Test {
	WebDriver driver;
	
	@Before
    public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.com");	
	}
	
	@Test
	public void SearchFirstitemTest() throws InterruptedException {
		Thread.sleep(1000);
	        	//Step 03: Enter "IPhone 11" in Edit Box 
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
				//Step 04: Click on Search Button
				driver.findElement(By.id("nav-search-submit-button")).click();
				//Step 05: Click the Fourth link in the result page
				//driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
				System.out.println("First Search");
	}
	
	@Test
	public void SearchSeconditemTest() throws InterruptedException {
		Thread.sleep(1000);
	        	//Step 03: Enter "IPhone 11" in Edit Box 
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 12");
				//Step 04: Click on Search Button
				driver.findElement(By.id("nav-search-submit-button")).click();
				//Step 05: Click the Fourth link in the result page
				//driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
				System.out.println("Second Search");
	}
	
	@After       	
     public void teardown() {
            	driver.quit();
        		}
	}
