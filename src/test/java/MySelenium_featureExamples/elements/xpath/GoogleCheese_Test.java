package MySelenium_featureExamples.elements.xpath;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleCheese_Test {
    WebDriver driver;

    @Test
    public void IndexPageAssert_test() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.get("https://www.google.co.uk/");
        this.driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        Thread.sleep(1000L);
        String indexURL = this.driver.getCurrentUrl();
        System.out.print("Current URL: " + indexURL);
        String indexTitle = this.driver.getTitle();
        System.out.println("\nCurrent Title: " + indexTitle);
        this.driver.findElement(By.name("q")).sendKeys(new CharSequence[]{"cheese" + Keys.ENTER});
        Thread.sleep(3000L);
        String searchURL = this.driver.getTitle();
        System.out.println("Search URL: " + searchURL);
        this.driver.quit();
    }
}