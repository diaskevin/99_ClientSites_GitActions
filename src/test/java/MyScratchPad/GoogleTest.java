package MyScratchPad;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class GoogleTest {
    WebDriver driver;
    @Test
    public void title_test(){
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.co.uk");
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals(title, "Google");
        driver.quit();
    }

    //  acceptCookies_test()... assert q element is displayed
    //  browserDetails_test()... assert Chrome version
    //  SearchCheese_test()... TakesScreenShot
    //  FirstResult_Test()... Actions open tab for first result and assert on cheeseType
    //  SecondResult_Test()... Navigate home Actions open Tab for second result and assert on cheeseType

}
