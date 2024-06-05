package ch01_selenium_general.Project_B_JavaMethods.b_DotMethod;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D2_DropDownSelectTypeGetFirstSelected_Test_ERR {

	//ERR org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"#month"}
	@Test
	public void DD_First() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		WebElement month_dropdown = driver.findElement(By.id("month"));

		Select month_dd = new Select(month_dropdown);	
		Thread.sleep(1000);
		
		//Radio button selection output: before & after selection is made
		WebElement selected_value = month_dd.getFirstSelectedOption();
		System.out.println("Before selection selected value is: " +selected_value.getText());
		
		month_dd.selectByIndex(3);
		
		WebElement selected_value1 = month_dd.getFirstSelectedOption();
		System.out.println("After selection selected value is: " +selected_value1.getText());
		
		
		Thread.sleep(1000);
		month_dd.selectByValue("10");
		Thread.sleep(1000);
		month_dd.selectByVisibleText("Aug");
		Thread.sleep(1000);
		
		driver.quit();
	}
}