package selenium.Alert.webDriver_methods;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver_manage_window_GetSet_PositionDimension_Test {
	WebDriver driver;
	@Test
	public void window_position_test() {
		System.setProperty("webdriver.chrome.driver",  "C:\\qa\\projectShare\\resource\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);

	//System.setProperty("webdriver.chrome.driver",  "C:\\Users\\Family\\Desktop\\Rakesh\\Resource\\chromedriver.exe");
	//WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		//Access each dimension individually
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		System.out.println("width :" +width);
		System.out.println("height :" +height);
			//Or store the dimensions and query them later
				Dimension size = driver.manage().window().getSize();
				int width1 = size.getWidth();
				int height1 = size.getHeight();
					System.out.println("width1 :" +width1);
					System.out.println("height1 :" +height1);

		// Access each dimension position individually
		int x = driver.manage().window().getPosition().getX();
		int y = driver.manage().window().getPosition().getY();
		System.out.println("Position X :" +x);
		System.out.println("Position Y :" +y);
			//Or store the dimensions and query them later
				Point position = driver.manage().window().getPosition();
				int x1 = position.getX();
				int y1 = position.getY();
		
		// Move the window to the top left of the primary monitor
		driver.manage().window().setPosition(new Point(12, 12));
	
		Point positionB = driver.manage().window().getPosition();
		int x2 = positionB.getX();
		int y2 = positionB.getY();
		System.out.println("moved PositionB X :" +x2);
		System.out.println("moved PositionB Y :" +y2);
	
		// Resize to full screen
		driver.manage().window().fullscreen();
		Point positionC = driver.manage().window().getPosition();
		int x3 = positionC.getX();
		int y3 = positionC.getY();
		System.out.println("fullscreen PositionC X :" +x3);
		System.out.println("fullscreen PositionC Y :" +y3);
	
		// Resize to max size
		driver.manage().window().maximize();
		driver.quit();
	}
}