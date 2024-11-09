package selenium.doc_SEARCHCONTEXT.doc_SUPPORT;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

//Perhaps look at https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/examples/java/src/test/java/dev/selenium/troubleshooting/LoggingTest.java

//@Slf4j
public class SLF4J_Colour_Test {
    WebDriver driver;

    @BeforeEach
    public void checkDesireCap() {
        //ChromeOptions options = new ChromeOptions();
        //options.setCapability("webSocketUrl", true);
        //options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
    }

    @Test
    public void log_test() throws InterruptedException {
        driver.get("https://www.google.co.uk/");


        Thread.sleep(3000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        Thread.sleep(1000);

        //driver.switchTo().window("70D3478554C7AFD5211BE1E15F35FF21");
        //driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        //Thread.sleep(3000);
        //driver.switchTo().parentFrame();

        Color loginButtonColour = Color.fromString(driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[1]/div/div[1]/a")).getCssValue("color"));
        Color abc = Color.fromString("white");

        log.info("the white color rgb value:{}", abc);
        System.out.println("the white value is " + abc);
        //  Color loginButtonColour = Color.fromString(driver.findElement(By.id("login")).getCssValue("color"));
        //  Color loginButtonBackgroundColour = Color.fromString(driver.findElement(By.id("login")).getCssValue("background-color"));

        log.info("the loginButtonColour color rgb value:{}", loginButtonColour);
        Thread.sleep(3000);
        System.out.println(loginButtonColour);

        //assert loginButtonBackgroundColour.equals(HOTPINK);

        //assert loginButtonBackgroundColour.asHex().equals("#ff69b4");
        //assert loginButtonBackgroundColour.asRgba().equals("rgba(255, 105, 180, 1)");
        //assert loginButtonBackgroundColour.asRgb().equals("rgb(255, 105, 180)");

        driver.quit();
    }
}