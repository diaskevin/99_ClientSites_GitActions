package OTHER.doc_TAKE_SCREENSHOT.screenShot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PrintScreen_Test {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void screenshotPage_test() throws IOException {

        driver.get("https://www.selenium.dev");
        PrintsPage printer = (PrintsPage) driver;

        PrintOptions printOptions = new PrintOptions();
        printOptions.setPageRanges("1-2");

        Pdf pdf = printer.print(printOptions);
        String content = pdf.getContent();

        System.out.println(content);
        BufferedWriter output = new BufferedWriter(new FileWriter("./selenium-dev.pdf"));
        output.write(Arrays.toString(pdf.getContent().getBytes(StandardCharsets.UTF_8)));
        output.close();

        driver.quit();
    }
}
