package selenium.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.elements;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class multipleWindows_Test {
	WebDriver driver;

	//After loading the page we click the link which spawns a new window.
	// We then grab the window handles (a.k.a. unique identifier strings which represent each open browser window)
	// and switch between them based on their order (assuming that the first one is the originating window, and that the second one is the new window)
	// We round this test out by performing a simple check against the title of the page to make sure Selenium is focused on the correct window

	// While this may seem like a good approach, it can present problems later. That's because the order of the window handles is not consistent across all browsers
	// Some return it in the order opened, others alphabetically
	// See resilient approach in next class for one that will work across all browsers

	@Test
	public void browser_chrome_test() {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		//driver.get("https://www.facebook.com");
		driver.get("http://the-internet.herokuapp.com/windows");
		driver.findElement(By.cssSelector(".example a")).click();
		Object[] allWindows = driver.getWindowHandles().toArray();
		driver.switchTo().window(allWindows[0].toString());
		MatcherAssert.assertThat(driver.getTitle(), Is.is(CoreMatchers.not("New Window")));
		driver.switchTo().window(allWindows[1].toString());
		MatcherAssert.assertThat(driver.getTitle(), CoreMatchers.is("New Window"));
		driver.quit();
	}

}