package ch03_selenium_javaDocs.doc_SEARCH_CONTENT.doc_TAKE_SCREENSHOT.webElement.elements;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HTTP_RequestResponse_Test_ERR {
	WebDriver driver;

	// In a previous tip we stepped through how to download files with Selenium by configuring the browser to download them locally and performing some checks.
	// While this works it requires a custom configuration that is not available in all browsers, and is inconsistent between the browsers that have it.
	// Ultimately we shouldn't care if a file was downloaded or not. Instead, we should care that a file can be downloaded. And we can do that by using an HTTP request alongside Selenium.
	// With an HTTP library we can perform a header (HEAD) request for the file. Instead of downloading the file we'll receive the header information for the file which contains things like the content type and length.
	// With this information we can easily confirm the file is what we expect without onerous configuration, local disk usage, or lengthy download times.



	/*This class needs two addition dependencies:
	        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.14</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpcore</artifactId>
            <version>4.4.16</version>
        </dependency>
	 */

	@Test
	public void downloadFileRevisitedTest() throws Exception {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);

		driver.get("http://the-internet.herokuapp.com/download");
		String link = driver.findElement(By.cssSelector(".example a:nth-of-type(1)")).getAttribute("href");

		HttpClient httpClient =  HttpClientBuilder.create().build();
		HttpHead request = new HttpHead(link);
		HttpResponse response = httpClient.execute(request);
		String contentType = response.getFirstHeader("Content-Type").getValue();
		int contentLength = Integer.parseInt(response.getFirstHeader("Content-Length").getValue());

		MatcherAssert.assertThat(contentType, Matchers.is("application/octet-stream"));
		MatcherAssert.assertThat(contentLength, Matchers.is(Matchers.not(0)));

		driver.quit();
	}

}