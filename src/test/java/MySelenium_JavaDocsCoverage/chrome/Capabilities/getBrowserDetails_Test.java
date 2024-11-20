package MySelenium_JavaDocsCoverage.chrome.Capabilities;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class getBrowserDetails_Test {
//Note Global declared 'ChromiumDriver'
//  This is used instead of WebDriver
//  WebDriver  is 'too super' for Capabilities method
//  Capabilities method is in ChromiumDriver class
//  WebDriver interface has remoteWebDriver child class and this has ChromiumDriver child class
//  For Inheritance, Intellisense 'work upwards' from a child class and can display methods inherited up the chain from super classes above
//  For Constructor, the Capabilities class has a constructor (with a return type of Capabilities)
//  For dot.method, 'Capabilities' methods need the ChromiumDriver object created as this is where the Capabilities constructor exists
//  For Inheritance, Intellisense 'work upwards' but can not 'work downwards' for dot.method use of Capabilities from WebDriver super class
//  For Capabilities object creation of Chromium class is required before capabilities methods can be used- see below cap.getBrowserName()
    ChromiumDriver driver;

    @Test
    public void testGooglePage_test() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://google.com");

        Capabilities cap = driver.getCapabilities();

        String browser = cap.getBrowserName();
        String version = cap.getBrowserVersion();
        String capName = cap.getCapabilityNames().toString();
        String platform = String.valueOf(cap.getPlatformName());

        System.out.println("browser " +browser);
        System.out.println("version " +version);
        System.out.println("Capability " +capName);
        System.out.println("Platform " +platform);

        driver.quit();
    }
}
