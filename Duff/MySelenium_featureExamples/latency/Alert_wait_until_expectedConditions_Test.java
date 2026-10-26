package MySelenium_featureExamples.latency;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert_wait_until_expectedConditions_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void alert_test() throws InterruptedException {
        //Click the link to activate the alert

        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.linkText("See an example alert"));
        Thread.sleep(2000);
        System.out.println(element.getText());
        element.click();
        //Wait for the alert to be displayed and store it in a variable
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //Store the alert text in a variable
        String text = alert.getText();
        //Press the OK button
        alert.accept();
        driver.quit();
    }

    @Test
    public void alertConfirm_test() throws InterruptedException {
        //Click the link to activate the alert

        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.linkText("See an example alert")).click();
        //Wait for the alert to be displayed and store it in a variable
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //Wait for the alert to be displayed
        wait.until(ExpectedConditions.alertIsPresent());
        //Store the alert in a variable
        Alert alert = driver.switchTo().alert();
        //Store the alert in a variable for reuse
        String text = alert.getText();
        System.out.println(text);
        //Press the Cancel button
        alert.dismiss();
        driver.quit();
    }

    @Disabled
    @Test
    public void prompt_test() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        Thread.sleep(1000);
        //driver.findElement(By.linkText("See a sample prompt")).click();


        //driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        //Thread.sleep(5000);
        //driver.findElement(By.linkText("See a sample prompt")).click();

        WebElement element1 = driver.findElement(By.xpath("/html/body/div/div[1]/div/main/div/p[8]/a"));
        WebElement element = driver.findElement(By.linkText("See a sample prompt"));
        System.out.println(element.isEnabled());
        Thread.sleep(4000);
        element.click();

        //Click the link to activate the alert
        Thread.sleep(2000);
        driver.findElement(By.linkText("See a sample prompt")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        //Type your message
        alert.sendKeys("Selenium");
        //Press the OK button
        alert.accept();
        driver.quit();
    }
}
