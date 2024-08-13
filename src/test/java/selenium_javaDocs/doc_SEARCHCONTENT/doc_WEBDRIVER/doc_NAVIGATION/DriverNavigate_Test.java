package selenium_javaDocs.doc_SEARCHCONTENT.doc_WEBDRIVER.doc_NAVIGATION;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigate_Test {
    WebDriver driver;
    @Test
    public void driverNavigate_test() {
        System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.kcl.ac.uk/index.aspx");
        driver.navigate().to("https://www.screwfix.com");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }
}