package MySelenium_featureExamples.assertions.elements.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Elements_Test {
    @Test
    public void elements_test() {
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://example.com");
            //driver.get("https://www.bbc.co.uk/");
            System.out.println("URL = " + driver.getCurrentUrl());
            System.out.println("Title = " + driver.getTitle());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
            System.out.println("element = " + element.getText());
                    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("div")));

            // Get element with tag name 'div'
            //WebElement element = driver.findElement(By.tagName("p"));

            // Get all the elements available with tag name "p"
            List<WebElement> elements = element.findElements(By.tagName("p"));
            System.out.println("elements count: " + elements.size());
            for (WebElement e : elements) {
                System.out.println(e.getText() + "\n");
            }
        } finally {
            driver.quit();
        }
    }
}