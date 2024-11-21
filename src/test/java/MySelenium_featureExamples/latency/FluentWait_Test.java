package MySelenium_featureExamples.latency;//https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/FluentWait.html#withTimeout(java.time.Duration)


import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

	public class FluentWait_Test {
		private WebDriver driver;
		
		@BeforeEach
	    public void fluentWait1() {
			System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		@Test
		public void FluentWaitWithLamba() {
			driver.get("https://google.com");
	    		 // Fluent Wit (30 sec with 5 sec polling)
	    		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	    		       .withTimeout(Duration.ofSeconds(30))
	    		       .pollingEvery(Duration.ofSeconds(5))
	    		       .ignoring(NoSuchElementException.class);
				//Lambda expression to wait for the return of the element
	    		   WebElement cockieAccept = wait.until(new Function<WebDriver, WebElement>() {
	    		     public WebElement apply(WebDriver driver) {
	    		       return driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]"));
	    		     }
	    		   });
				//Click the element
				   cockieAccept.click();

	            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
	            	String url = driver.getTitle();
	            	System.out.println(url);
	            	Assert.assertEquals("Title ok" ,"cheese - Google Search", url);
				}
		
		
		@AfterEach
	     public void quit() {
	            	driver.quit();
	        		}
	    }