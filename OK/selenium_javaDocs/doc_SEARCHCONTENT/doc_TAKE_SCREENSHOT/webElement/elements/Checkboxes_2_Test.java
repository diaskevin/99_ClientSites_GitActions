package selenium.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Checkboxes_2_Test {
WebDriver driver;
	
	@BeforeEach
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(chromeOptions);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void checkboxDiscovery_test() {
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		
		List<WebElement> checkboxes =
				driver.findElements(By.cssSelector("input[type='checkbox']"));
		
		System.out.println("With .attribute('checked')" );
		int i =1;
		for (WebElement checkbox : checkboxes) {		
	System.out.println("Checkbox "+i+" "+String.valueOf(checkbox.getAttribute("checked")));
	System.out.println("Checkbox "+i+" "+checkbox.isSelected());	
	 	i = i+1;
		}
			
	}
}