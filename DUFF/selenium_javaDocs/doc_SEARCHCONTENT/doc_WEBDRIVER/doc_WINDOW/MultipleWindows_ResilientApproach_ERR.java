package selenium_javaDocs.doc_SEARCHCONTENT.doc_WEBDRIVER.doc_WINDOW;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

public class MultipleWindows_ResilientApproach_ERR {
	WebDriver driver;

	// resilient approach for one that will work across all browsers
	// After loading the page we store the window handle in a variable (e.g., firstWindow) and then proceed with clicking the new window link.
	//Now that we have two windows open we grab all of the window handles and search through them to find the new window handle (e.g., the handle that doesn't match the one we've already stored). We store the new window result in another variable (e.g., newWindow) and then switch between the windows, checking page title each time to make sure the correct window is in focus.

	@Test
	public void browser_chrome() {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);

		driver.get("http://the-internet.herokuapp.com/windows");
		String firstWindow = driver.getWindowHandle();
		String newWindow = "";
		driver.findElement(By.cssSelector(".example a")).click();
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(firstWindow)) {
				newWindow = window;
			}
		}

		driver.switchTo().window(firstWindow);
		MatcherAssert.assertThat(driver.getTitle(), Matchers.is(Matchers.not(Matchers.equalTo("New Window"))));

		driver.switchTo().window(newWindow);
		MatcherAssert.assertThat(driver.getTitle(), Matchers.is(Matchers.equalTo("New Window")));


		driver.quit();
	}

}