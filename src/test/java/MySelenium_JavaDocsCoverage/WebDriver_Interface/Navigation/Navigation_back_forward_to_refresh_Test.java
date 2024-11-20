package MySelenium_JavaDocsCoverage.WebDriver_Interface.Navigation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation_back_forward_to_refresh_Test {
    WebDriver driver;
    @Test
    public void navigationImport_dotmethod_test() {
        System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriver.Navigation nickyNackyDo = driver.navigate();
        nickyNackyDo.to("https://www.kcl.ac.uk/index.aspx");
        nickyNackyDo.to("https://www.screwfix.com");
        nickyNackyDo.back();
        nickyNackyDo.forward();
        nickyNackyDo.refresh();
        driver.quit();
    }











}
