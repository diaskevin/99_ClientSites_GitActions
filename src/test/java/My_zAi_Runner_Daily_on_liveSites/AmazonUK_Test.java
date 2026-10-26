package My_zAi_Runner_Daily_on_liveSites;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonUK_Test {
    @Test
    public void acceptCookies_test() throws InterruptedException {
        WebDriver driver;
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.co.uk/");

        //(To accept cookies)
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sp-cc-accept']")));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie banner did not appear");
        }

        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }

    @Disabled
    public void searchSelectFirstPhone() {
        WebDriver driver;
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.co.uk/");
        //(To accept cookies)
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sp-cc-accept']")));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie banner did not appear");
        }

        //Search IPhone 11
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //Select first search link in the result page
        //Option A — contains instead of starts-with
        //List<WebElement> phones = driver.findElements(By.xpath("(.//span[contains(text(),'Apple iPhone 11')]/parent::*)/.."));
        //System.out.println("Found phones: " + phones.size());

        //Option B — match the full Amazon product title class (most reliable)
        //List<WebElement> phones = driver.findElements(By.xpath("(.//span[contains(@class,'a-link-normal') and contains(text(),'Apple iPhone 11')])/.."));
        //List<WebElement> phones = driver.findElements(By.xpath("(.//span[contains(@class,'black') and contains(text(),'Apple iPhone 11')])/.."));
        List<WebElement> phones = driver.findElements(By.xpath("(.//span[contains(text(),'Apple iPhone 11')])/.."));
        System.out.println("Found phones: " + phones.size());

        //Option C — get the whole clickable product container
        // //h2//span[contains(text(),'Apple iPhone 11')]/ancestor::div[@data-component-type='s-search-result']
        //List<WebElement> phones = driver.findElements(By.xpath("(//h2//span[contains(text(),'Apple iPhone 11')]/ancestor::div[@data-component-type='s-search-result'])/.."));
        //System.out.println("Found phones: " + phones.size());


        phones.get(0).click();
        driver.quit();
    }

    @Disabled
    public void searchSelectSecondPhone() {
        WebDriver driver;
       // System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.co.uk/");

        //(To accept cookies)
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='sp-cc-accept']")));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie banner did not appear");
        }

        //Search IPhone 11
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
        driver.findElement(By.id("nav-search-submit-button")).click();
        //Select first search link in the result page
       // driver.findElement(By.xpath("//*[@id=\"sp-cc-accept\"]")).click();
        List<WebElement> phones = driver.findElements(By.xpath("(.//span[starts-with(text(),'Apple iPhone 11') and @class = 'a-size-medium a-color-base a-text-normal'])/.."));
        phones.get(1).click();
        driver.quit();
    }
}