package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_WEBDRIVER.p_ThreadGuard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;

public class DriverClash {
    // This example shows how to split something into two threads
    //Observe 'main method' is calling methods which use 'runnable' and threads

    //Thread-1 (id 24) is calling the same driver causing the clash to happen
    private WebDriver protectedDriver = ThreadGuard.protect(getChromeDriver());

    Runnable r1 = () -> {
        WebDriver protectedDriver1 = ThreadGuard.protect(getChromeDriver());
        protectedDriver1.get("https://selenium.dev");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    };
    Thread thr1 = new Thread(r1);

    void runThreads(){
        System.out.println("invoke Thread start");
        thr1.start();
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        new DriverClash().runThreads();
    }

    public ChromeDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        options.addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }
}
