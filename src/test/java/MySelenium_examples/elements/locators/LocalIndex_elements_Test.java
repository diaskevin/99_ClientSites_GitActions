package MySelenium_examples.elements.locators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//ERR: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"*[name='newsletter']"}
public class LocalIndex_elements_Test {
	WebDriver driver;

	@BeforeEach
	public void checkDesireCap() {
		System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Disabled
	//Line 31 element not found
	@Test
	public void browser_chrome_test() throws InterruptedException {
		driver.get("C:\\Users\\Family\\Desktop\\Intellij\\02_B_Selenium4_framework\\src\\main\\java\\org\\example\\index.html");
		Thread.sleep(2000);
		//driver.findElement(By.name("newsletter"));
		//driver.findElement(By.linkText("Selenium Official Page"));
		//driver.findElement(By.tagName("a"));
		//driver.findElement(By.partialLinkText("Official Page"));
		//driver.findElement(By.xpath("//input[@value='f']"));

		WebElement vegetable = driver.findElement(By.className("tomatoes"));
		System.out.println("Tomatoes within the vegetable set: "+vegetable.getText());

		WebElement fruits = driver.findElement(By.id("fruits"));
		WebElement fruit = fruits.findElement(By.className("tomatoes"));
		System.out.println("Tomatoes within the fruit set: "+fruit.getText());

		By fruitT=By.cssSelector("#fruits .tomatoes");
		WebElement fruitt = driver.findElement(fruitT);
		System.out.println("Tomatoes within the fruit1 set: "+fruitt.getText());

		List<WebElement> plants = driver.findElements(By.tagName("li"));
		System.out.println("plant has list of items: "+plants.size());
		for (WebElement plant : plants) {
			System.out.println("Paragraph text:" + plant.getText());
		}
		driver.quit();
	}
}