package selenium_javaDocs.doc_DEVTOOLS_BIDI.fileUpload;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FileUpload_Test {
    @Test
    public void fileUploadTest(){
       WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/upload");
        //we want to import the file held in the project location.
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\family\\Desktop\\cheese.JPG");
        driver.findElement(By.id("file-submit")).submit();
        if(driver.getPageSource().contains("File Uploaded!")) {
            System.out.println("file uploaded");
        }
        else{
            System.out.println("file not uploaded");
        }
        driver.quit();


    }



}
