package selenium_javaDocs.doc_SEARCHCONTEXT.doc_TAKE_SCREENSHOT.webElement.by_class;

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
import java.util.List;

// Kev's way, but assert name: user 1

public class MouseHovers_3_ancestors_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		this.driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void hovers_test() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");

        Thread.sleep(3000);
        WebElement user2Element = driver.findElement(By.xpath("//div[@class='figure']/following-sibling::div"));
        Actions point = new Actions(driver);
        point.moveToElement(user2Element).build().perform();
        System.out.println("Mouse Move successful "+user2Element.getText());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='figcaption']//h5[contains(text(), 'name: user2')]")));
        System.out.println("HTML dynamically related to mouse move is now displayed: " +driver.findElement(By.xpath("//div[@class='figcaption']//h5[contains(text(), 'name: user2')]")).getText());

        WebElement anchorElement = driver.findElement(By.xpath("//div[@class='figcaption']//a[@href='/users/2']"));
        System.out.println(anchorElement.getText());
        assert(anchorElement.getText().equalsIgnoreCase("View profile"));

        WebElement h5Element = driver.findElement(By.xpath("//div[@class='figcaption']//h5/following-sibling::a"));
        System.out.println("test"+h5Element.getText());

        WebElement figElement = driver.findElement(By.xpath("//div[@class='figcaption']//h5[contains(text(), 'name: user2')]"));
        assert(figElement.getText().equalsIgnoreCase("name: user2"));

        WebElement figElement2 = driver.findElement(By.xpath("//div[@class='figure'][2]//div"));
        System.out.println("class::::::"+figElement2.getAttribute("class"));
        System.out.println("div::::::"+figElement2.getText());

        WebElement figElement2href = driver.findElement(By.xpath("//a[@href='/users/2']"));
        System.out.println("href::::::"+figElement2href.getText());

        WebElement figElementImg = driver.findElement(By.xpath("//div[@class = 'figure']//img"));
        System.out.println("img::::::"+figElementImg.getAttribute("src"));
        System.out.println("img::::::"+figElementImg.getAttribute("alt"));

        WebElement aaa = driver.findElement(By.xpath("//div[@class = 'figure']//img"));
        System.out.println(aaa);

        /*other examples
        //div[@class = 'figure']
        //div[@class = 'example']//h3/following-sibling::p
        //div[@class = 'figcaption']//following-sibling::a//ancestor::div [@class = 'figure']
         */

        List<WebElement> figure =
                driver.findElements(By.xpath("//div [@class = 'figure']"));
        System.out.println("List elements::::::"+figure.size());
    }
}