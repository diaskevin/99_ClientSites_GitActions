package ch01_selenium_general.Project_D_Junit5.g_Junit_StaticBeforeAnnotation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class C_OneStaticBeforeAllSetup_ManyTests_Test {
    WebDriver driver;
    //ERR 'is' requires a library import, but not sure which to pick  (is)
	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");	
    }
	@Test
    public void checkboxOption_Test1() {
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        System.out.println("test1");
        MatcherAssert.assertThat(checkbox.isDisplayed(), CoreMatchers.is(true));
	}
	@Test
    public void checkboxOption_Test2() {
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        System.out.println("test2");
        MatcherAssert.assertThat(checkbox.isSelected(), CoreMatchers.is(true));
	} 
	@Test
    public void checkboxOption_Test3() {
        WebElement checkbox = driver.findElement(By.cssSelector("form input:nth-of-type(2)"));
        System.out.println("test3");
        MatcherAssert.assertThat(checkbox.isEnabled(), CoreMatchers.is(true));
	} 
	 
	@AfterClass
        public static void close() {
        driver.quit();
    }
}