package selenium.Alert.interactions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interaction_Test {
    WebDriver driver;
    @BeforeEach
    public void checkDesireCap() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //This Test Assertion fails and it continues to conduct the next test
    @Test
    public void interact_test() throws InterruptedException {
    driver.get("https://www.selenium.dev/selenium/web/inputs.html");
    // Click on the element
    Thread.sleep(2000);
    driver.findElement(By.name("color_input")).click();
    Thread.sleep(2000);
    // assert field is displayed
    boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
    Assertions.assertTrue(isEmailVisible);
    // Clear field to empty it from any previous data
    driver.findElement(By.name("email_input")).clear();
    Thread.sleep(2000);
    //Enter Text
    driver.findElement(By.name("email_input")).click();
    driver.findElement(By.name("email_input")).sendKeys("admin11@localhost.dev");
    Thread.sleep(3000);
    driver.quit();
}

    //This Test Assertion passes
    @Test
    public void interact2_test() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/inputs.html");
        // Click on the element
        Thread.sleep(2000);

        driver.findElement(By.name("color_input")).click();
        Thread.sleep(2000);

        // assert field is displayed
        boolean isEmailVisible = driver.findElement(By.name("email_input")).isDisplayed();
        Assertions.assertTrue(isEmailVisible);
        //returns true if element is enabled else returns false
        boolean value = driver.findElement(By.name("button_input")).isEnabled();
        Assertions.assertTrue(value);
        //returns TagName of the element
        String email_value = driver.findElement(By.name("email_input")).getTagName();
        System.out.println("email tag name is: "+email_value);

        // Clear field to empty it from any previous data
        driver.findElement(By.name("email_input")).clear();
        Thread.sleep(2000);
        //Enter Text
        driver.findElement(By.name("email_input")).click();
        driver.findElement(By.name("email_input")).sendKeys("admin11@localhost.dev");
        Thread.sleep(3000);

        // Returns height, width, x and y coordinates referenced element
         Rectangle res =  driver.findElement(By.name("range_input")).getRect();
        // Rectangle class provides getX,getY, getWidth, getHeight methods
         System.out.println("x co-ordinates "+res.getX());
        System.out.println("y co-ordinates "+res.getY());
        System.out.println("WIDTH is  "+res.getWidth());
        System.out.println("HEIGHT is "+res.getHeight());
        String cssValue = driver.findElement(By.name("color_input")).getCssValue("background-color");
        System.out.println(cssValue);
        //identify the email text bx
        WebElement emailTxt = driver.findElement(By.name(("email_input")));
        System.out.println(emailTxt.getText());
        //fetch the value property associated with the textbox
        String valueInfo = emailTxt.getAttribute("value");
        System.out.println(valueInfo);
        driver.quit();
    }
}

