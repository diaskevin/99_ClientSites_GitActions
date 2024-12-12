package MyScratchPad;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonCOM_Test {
	WebDriver driver;

	@BeforeEach
    public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		Thread.sleep(10000);
		//     !!!!!     OBSERVE: MANUAL INPUT CAPTCHA     !!!!!
		//     !!!!!     DISABLED TESTS                    !!!!!
		}

	//@Disabled
	@Test
	public void search_phone11_test() throws InterruptedException {
		       	//Step 03: Enter "IPhone 11" in Edit Box
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
				//Step 04: Click on Search Button
				driver.findElement(By.id("nav-search-submit-button")).click();
				System.out.println("First Search url " +driver.getCurrentUrl());
				boolean firstSearch = driver.getCurrentUrl().contains("IPhone+11");
				Assertions.assertTrue(firstSearch);
	}

	//@Disabled
	@Test
	public void search_phone_12_test() throws InterruptedException {
		       	//Step 03: Enter "IPhone 11" in Edit Box
				driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 12");
				//Step 04: Click on Search Button
				driver.findElement(By.id("nav-search-submit-button")).click();
				System.out.println("Second Search url " +driver.getCurrentUrl());
				boolean firstSearch = driver.getCurrentUrl().contains("IPhone+12");
				Assertions.assertTrue(firstSearch);
	}
	
	@AfterEach
     public void teardown() {
            	//driver.quit();
        		}
	}