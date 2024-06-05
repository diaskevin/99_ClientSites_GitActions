package ch01_selenium_general.Project_B_JavaMethods.h_StopWatchReport_Latency;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class System_currentTime {
    WebDriver driver;
    @Test
    public void testGooglePage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        long start = System.currentTimeMillis();
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println("Browser title: " +title);
        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) + " ms");

        driver.quit();
    }
}
