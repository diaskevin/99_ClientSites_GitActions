package selenium_javaDocs.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveElement_Test {
@Test
    public void activeElement_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://www.google.com");
            driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
            driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");
            // Get attribute of current active element
            String attr = driver.switchTo().activeElement().getAttribute("title");
            System.out.println(attr);
        } finally {
            driver.quit();
        }
    }
}
