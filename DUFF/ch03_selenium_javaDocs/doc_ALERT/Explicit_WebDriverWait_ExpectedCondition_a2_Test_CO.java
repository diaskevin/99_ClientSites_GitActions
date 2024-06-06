package ch03_selenium_javaDocs.doc_ALERT;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Explicit_WebDriverWait_ExpectedCondition_a2_Test_CO {
		WebDriver driver;
		@Test
		public void explicitwait2() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\Rakesh\\Resource\\chromedriver.exe");
			driver = new ChromeDriver();



			//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("--remote-allow-origins=*");
			//driver = new ChromeDriver(chromeOptions);

			driver.get("https://google.com");
	        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
	        String url = driver.getTitle();
	        System.out.println("url :" +url);

	        	//Without wait 
		      	// WebElement firstResult = driver.findElement(By.xpath("//a/h3"));
		      	// System.out.println("without wait " +firstResult.getText()); 
	       
		    //Explicit wait
	        //WebElement firstResult1 = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
	        //System.out.println("Explicit wait " +firstResult1.getText());
	        
	        driver.quit();
	        		}
		}