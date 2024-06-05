package ch03_selenium_javaDocs.searchContent.webDriver.navigation;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ab_Navigation_Reference_ToBackForwardRefresh_Test {
    WebDriver driver;
    @Test
    public void navigationImport_dotmethod_test() {
        System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
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
