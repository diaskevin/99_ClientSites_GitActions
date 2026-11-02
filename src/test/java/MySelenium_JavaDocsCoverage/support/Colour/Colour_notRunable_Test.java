package MySelenium_JavaDocsCoverage.support.Colour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;

public class
Colour_notRunable_Test {

    // None of the following is runable at the moment
    private final Color HEX_COLOUR = Color.fromString("#2F7ED8");
    private final Color RGB_COLOUR = Color.fromString("rgb(255, 255, 255)");
    //private final Color RGB_COLOUR = Color.fromString("rgb(40%, 20%, 40%)");
    private final Color RGBA_COLOUR = Color.fromString("rgba(255, 255, 255, 0.5)");
    //private final Color RGBA_COLOUR = Color.fromString("rgba(40%, 20%, 40%, 0.5)");
    private final Color HSL_COLOUR = Color.fromString("hsl(100, 0%, 50%)");
    private final Color HSLA_COLOUR = Color.fromString("hsla(100, 0%, 50%, 0.5)");
    private final Color BLACK = Color.fromString("black");
    private final Color CHOCOLATE = Color.fromString("chocolate");
    //private final Color HOTPINK = Color.fromString("hotpink");
    private final Color TRANSPARENT = Color.fromString("transparent");
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        //System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @Test
    public void colour_Test_test() {
        driver.get("https://www.selenium.dev/selenium/web/login.html");

        Color loginButtonColour = Color.fromString(driver.findElement(By.id("login-form-submit")).getCssValue("color"));
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(By.id("login-form-submit")).getCssValue("background-color"));

        System.out.println("loginButtonColour: " + loginButtonColour);
        System.out.println("loginButtonBackgroundColour: " + loginButtonBackgroundColour);

        assert loginButtonColour.asRgba().equals("rgba(0, 0, 0, 1)");
        assert loginButtonBackgroundColour.asRgba().equals("rgba(240, 240, 240, 1)");

        driver.quit();
    }
}