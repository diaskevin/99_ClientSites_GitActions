package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_WEBDRIVER.l_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.print.PrintOptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class l_PrintScreen {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void screenshotPage() throws IOException {

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
