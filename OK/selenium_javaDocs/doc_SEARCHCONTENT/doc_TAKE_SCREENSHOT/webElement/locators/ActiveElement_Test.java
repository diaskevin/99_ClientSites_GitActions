package selenium.doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.locators;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveElement_Test {
    @Disabled
    //ActiveElement_Test.activeElement_test(ActiveElement_Test.java:16)
    @Test
    public void activeElement_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
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
