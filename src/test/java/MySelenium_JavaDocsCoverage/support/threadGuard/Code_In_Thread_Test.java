package MySelenium_JavaDocsCoverage.support.threadGuard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;

public class Code_In_Thread_Test {
    WebDriver driver;
    // This example shows how to run code in a thread
    //Observe 'main method' is calling methods

    Runnable r1 = () -> {
       WebDriver protectedDriver1 = ThreadGuard.protect(driver);
        protectedDriver1.get("https://selenium.dev");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };
    Thread thr1 = new Thread(r1);

    void runThread(){
        System.out.println("invoke Thread start");
        driver = getChromeDriver();
        thr1.start();
        driver.quit();
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        // 'Main' is generally static, so we have to create an object for this class

        Code_In_Thread_Test test  = new Code_In_Thread_Test();
        test.runThread();
    }

    public ChromeDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
