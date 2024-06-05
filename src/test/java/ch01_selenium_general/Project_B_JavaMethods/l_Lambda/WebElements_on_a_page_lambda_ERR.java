//https://www.w3schools.com/java/java_lambda.asp
// A lambda expression is a short block of code which takes in parameters and returns a value. 
//Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

package ch01_selenium_general.Project_B_JavaMethods.l_Lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.function.Consumer;

public class WebElements_on_a_page_lambda_ERR {
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
            Consumer<WebElement> LambdaExpression_WebElements =  (n) -> {System.out.println(n.getText());};
            lotsOfelements.forEach(LambdaExpression_WebElements);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            driver.quit();
        }
    }

}
