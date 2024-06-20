package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.xpath;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonAssert_Test {

    @Test
    public void TestAlpha_test() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.amazon.co.uk");
        String title = driver.getTitle();

        String titleExpected = "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more";
        if (title.equals(titleExpected)) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is incorrect");
        }
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone11");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        //Accept cookie
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();

        //assert

driver.close();
    }
}