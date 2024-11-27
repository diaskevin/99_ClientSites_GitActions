package MyScratchPad;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AmazonUK_Test {
    @Test
    public void acceptCookies_test() throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.co.uk/");

        //(To accept cookies)
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }

    @Test
    public void searchSelectFirstPhone() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.co.uk/");

        //Search IPhone 11
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //Select first search link in the result page
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        List<WebElement> phones = driver.findElements(By.xpath("(.//span[starts-with(text(),'Apple iPhone 11') and @class = 'a-size-medium a-color-base a-text-normal'])/.."));
        phones.get(0).click();
        driver.quit();
    }

    @Test
    public void searchSelectSecondPhone() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.co.uk/");

        //Search IPhone 11
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //Select first search link in the result page
        driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        List<WebElement> phones = driver.findElements(By.xpath("(.//span[starts-with(text(),'Apple iPhone 11') and @class = 'a-size-medium a-color-base a-text-normal'])/.."));
        phones.get(1).click();
        driver.quit();
    }
}