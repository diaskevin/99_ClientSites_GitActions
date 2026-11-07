package MySelenium_featureExamples.elements.xpath;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonAssert_Test {
    @Disabled ("Accept Cookie is not necessary everytime- so this test is disabled for now and can be enabled when needed")
    @Test
    public void TestAlpha_test() throws InterruptedException {
        WebDriver driver;
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        driver.get("https://www.amazon.co.uk");
        Thread.sleep(10000);
        String title = driver.getTitle();

        String titleExpected = "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more";
        if (title.equals(titleExpected)) {
            System.out.println("Title is correct");
        } else {
            System.out.println("Title is incorrect");
            System.out.println("Expected: " + titleExpected);
            System.out.println("Actual: " + title);
        }

        //Accept cookie
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone11");
        driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();

        //assert

        driver.close();
    }
}