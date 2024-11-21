package MySelenium_featureExamples.latency;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Explicit_WebDriverWait_ExpectedCondition_Test {
		WebDriver driver;
		@Test
		public void explicitwait_test() {
			System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

			//System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
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