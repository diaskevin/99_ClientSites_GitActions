package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.xpath;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Select_Hotels_Test {

    @Test
    public void TestAlpha_test() throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://uk.hotels.com/");
        String title = driver.getTitle();
        String titleExpected = "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations";

        Assertions.assertEquals(titleExpected, title);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@role='dialog']//button[2]")).click();
        System.out.println("Accept All");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@aria-label='Going to']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='destination_form_field']")).click();
        driver.findElement(By.xpath("//input[@id='destination_form_field']")).sendKeys("London");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='destination_form_field']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='search_button']")).click();
        Thread.sleep(2000);
        //driver.quit();
       //WebElement ele = driver.findElement(By.xpath("//div[@class='uitk-spacing uitk-spacing-margin-blockstart-three']//a"));
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"app-layer-base\"]/div[1]/main/div/div/div/div/div[2]/section[2]/div/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div/a"));
        System.out.println(ele.getSize());
        System.out.println("The First displayed hotel is: "+ele.getText());
        WebElement match = driver.findElement(By.xpath("//header//div[@data-stid=\"results-header-message\"]"));
        System.out.println("The Number of hotel is Listed: "+match.getText());
        String[] str = match.getText().split(" ");
        int numberOfHotels = Integer.parseInt(str[0].replace(",", ""));
        System.out.println(numberOfHotels);
        Assertions.assertTrue(numberOfHotels > 1500);
        System.out.println(str[1]);
        Assertions.assertEquals("properties", str[1].trim());
        char[] ch = str[1].toCharArray();
        System.out.println(ch[2]);
        driver.quit();
    }
}