import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeOptions_Sel3_historicProblem {
    WebDriver driver;
    
    @Test
    public void iFrames_test() throws Exception {

        //This fix was used to resolve the old Selenium3 problem caused by using the wrong selenium dependency on the POM
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        org.openqa.selenium.chrome.ChromeOptions chromeOptions = new org.openqa.selenium.chrome.ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://google.com");
        driver.quit();
    }
}