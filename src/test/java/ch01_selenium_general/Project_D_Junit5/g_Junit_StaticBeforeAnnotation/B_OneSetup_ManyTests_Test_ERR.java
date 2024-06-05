package ch01_selenium_general.Project_D_Junit5.g_Junit_StaticBeforeAnnotation;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class B_OneSetup_ManyTests_Test_ERR {
    WebDriver driver;
    // //ERR 'is' requires a library import, but not sure which to pick  (is)
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");	
    }
	@Test
    public void checkboxOption_Test1() {
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        MatcherAssert.assertThat(checkbox.isDisplayed(), CoreMatchers.is(true));
	}
	@Test
    public void checkboxOption_Test2() {
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        MatcherAssert.assertThat(checkbox.isSelected(), CoreMatchers.is(true));
	} 
	@Test
    public void checkboxOption_Test3() {
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        MatcherAssert.assertThat(checkbox.isEnabled(), CoreMatchers.is(true));
	} 
	 
	@After
        public void close() {
        driver.quit();
    }
}