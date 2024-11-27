package MyScratchPad;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonUK_Test {
    @Test
    public void acceptCookies_test() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.amazon.co.uk/");

        //(To accept cookies)
        driver.findElement(By.xpath("//*[@id='sp-cc-accept']")).click();

        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();
    }
}