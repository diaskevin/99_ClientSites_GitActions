package MySelenium_featureExamples.assertions.elements.by_class;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Create an object before using it (By)!

public class MouseHovers_2_AssertDisplayed_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() throws Exception {
        //System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void hovers_test() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        WebElement figure = driver.findElement(By.className("figure"));
        Actions builder = new Actions(driver);
        builder.moveToElement(figure).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        By figCaptionBy = By.className("figcaption");
        wait.until(ExpectedConditions.visibilityOfElementLocated(figCaptionBy));

        Boolean abc = driver.findElement(By.className("figcaption")).isDisplayed();
        System.out.println(abc);
        MatcherAssert.assertThat(abc, CoreMatchers.is(Boolean.TRUE));
    }
}