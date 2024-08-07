package selenium_javaDocs.doc_SEARCHCONTEXT.doc_SUPPORT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;

public class
Colour_notRunable_Test {

    // Non of the following is runable at the moment

    WebDriver driver;

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

    @BeforeEach
    public void checkDesireCap() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

        @Test
        public void colour_Test_test() {
            //driver.get("http://www.w3.org/TR/css3-color/#html4");
            //driver.get("https://www.selenium.dev");
            //driver.get("https://www.selenium.dev/selenium/web/formPage.html");
            //driver.get("https://www.selenium.dev/selenium/web/colorPage.html");
            driver.get("https://www.selenium.dev/selenium/web/login.html");

            Color loginButtonColour = Color.fromString(driver.findElement(By.id("login")).getCssValue("color"));
            Color loginButtonBackgroundColour = Color.fromString(driver.findElement(By.id("login")).getCssValue("background-color"));

            //assert loginButtonBackgroundColour.equals(HOTPINK);

            //assert loginButtonBackgroundColour.asHex().equals("#ff69b4");
            //assert loginButtonBackgroundColour.asRgba().equals("rgba(255, 105, 180, 1)");
            //assert loginButtonBackgroundColour.asRgb().equals("rgb(255, 105, 180)");

            //driver.quit();
        }
    }