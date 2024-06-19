package ch03_selenium_javaDocs.doc_ALERT;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

	public class Implicit_driver_manage_timeouts2_Test {
		WebDriver driver;
		
		@Test
		public void ImplicitWait2() {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\Rakesh\\Resource\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);

			driver.get("https://google.com");
			driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
			//Implicit Wait 
	            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);    
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        String url = driver.getTitle();
	        System.out.println(url);
	        driver.quit();
	        }
	    }