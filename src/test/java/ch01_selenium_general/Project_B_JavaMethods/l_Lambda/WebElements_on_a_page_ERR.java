package ch01_selenium_general.Project_B_JavaMethods.l_Lambda;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements_on_a_page_ERR {
    WebDriver driver;
    // //ERR 'is' requires a library import, but not sure which to pick (is)
    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void webElementCollection() {

        try {
            driver.get("http://www.google.com");
            // Get all the elements available with tag name of 'div'
            List<WebElement> lotsOfelements = driver.findElements(By.tagName("div"));
            for (WebElement element : lotsOfelements) {
                System.out.println("Paragraph text:" + element.getText());
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            driver.quit();
        }
    }

}