package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.H_Locators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//ERR: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"css selector","selector":"*[name='newsletter']"}
public class H1_LocalIndex_elements_Test_ERR {
	WebDriver driver;

	@BeforeEach
	public void checkDesireCap() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void browser_chrome() throws InterruptedException {
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