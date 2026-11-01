package My_zAi_Runner_ClientSites_ScheduledMonthly;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonCOM_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://amazon.com");
        Thread.sleep(3000);
     }
     @Test
     @Disabled("Amazon may present a CAPTCHA or anti-bot challenge; keep this as a manual test but Disable from scheduled execution")
    public void search_phone11_test() throws InterruptedException {
        //Step 03: Enter "IPhone 11" in Edit Box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 11");
        //Step 04: Click on Search Button
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("iPhone_11 Search url " + driver.getCurrentUrl());
        boolean firstSearch = driver.getCurrentUrl().contains("IPhone+11");
        Assertions.assertTrue(firstSearch);
    }
    @Test
    @Disabled("Amazon may present a CAPTCHA or anti-bot challenge; keep this as a manual test but Disable from scheduled execution")
    public void search_phone_12_test() throws InterruptedException {
        //Step 03: Enter "IPhone 12" in Edit Box
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("IPhone 12");
        //Step 04: Click on Search Button
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("iPhone_12 Search url " + driver.getCurrentUrl());
        boolean firstSearch = driver.getCurrentUrl().contains("IPhone+12");
        Assertions.assertTrue(firstSearch);
    }
    @AfterEach
    public void teardown() {
        driver.quit();
    }
}