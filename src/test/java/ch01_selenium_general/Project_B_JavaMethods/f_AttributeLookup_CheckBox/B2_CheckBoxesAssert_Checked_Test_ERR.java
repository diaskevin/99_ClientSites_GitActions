package ch01_selenium_general.Project_B_JavaMethods.f_AttributeLookup_CheckBox;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class B2_CheckBoxesAssert_Checked_Test_ERR {
	// //ERR 'is' requires a library import, but not sure which to pick (Observe: original import was JUNIT4)
	@Test
	public void checkboxOption1_Test() {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
		assertThat(checkbox.getAttribute("checked"), is(not("null")));
		MatcherAssert.assertThat(checkbox.getAttribute("checked"), CoreMatchers.is("true"));
		driver.quit();
	}
	} 