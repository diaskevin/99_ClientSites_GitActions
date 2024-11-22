# Chapter02 Selenium JavaDocs
The aim of this project is to provide Automation Testing of the packages provided by the Selenium 4 api as defined by Java docs: 
https://www.javadoc.io/doc/org.seleniumhq.selenium/selenium-api/2.50.1/overview-summary.html

Three Projects:
MySelenium_featureExamples
MySelenium_JavaDocsCoverage
MyScratchPad GoogleTest

## Convention
See Chapter01 Readme (Globally declare WebDriver with @Before constructor for Driver Type). 

### Configuration
See Chapter01 Readme (By default Chrome browser type and dirty repo BrowserDriver.exe location in c:/qa with dependency resolution by Baelined POM).
VALIDATE Run Repo_ch02 Maven project (one baslined POM) across two Windows machines.
VALIDATE run duration times on multiple devices (HP_Laptop, Hp_Family, MAC).

As a prelude to Ch03:
VALIDATE run of BrowserTypes on several machines.


Selenium inheritance note:
   WebDrive is an interface
   ChromiumDriver extends RemoteDriver, which in turn implements WebDriver interface
   ChromeDriver and EdgeDriver are child classes of ChromiumDriver
   GeckoDriver is NOT within ChromiumDriver
   Capabilities is a method WITHIN ChromiumDriver with a return type of 'Capabilities'
      VERIFY WebDrive has own 'this' constructor with a return type of WebDriver
      VERIFY ChromiumOptions has own 'this' constructor with a return type of ChromiumOptions
      VERIFY Capabilities has own 'this' constructor with a return type of Capabilities    
   Observer: WebDriver Constructor- WebDriver declared (as driver), new constructor for Driver Type, only then use the driver.get
   Observer: Capabilities Constructor- Capabilities declared (as cap), new constructor for Capabilities, then cap.getBrowserNName
   Observer: ChromiumOptions Constructor- ChromiumOptions declared (as options), new constructor for ChromeOptions, then options.setMaximizeWindow
      Example of Java CONSTRUCTORS:
						1) WedDriver CONSTRUCTOR
						WebDriver driver;
						driver = new ChromeDriver();
						driver.get(bbc.co.uk);
						2) ChromiumOptions CONSTRUCTOR
						WebDriver driver;
						ChromeOptions options = new ChromeOptions();
						options.setMaxmizeWindow();
						3) ChromeDriver CONSTRUCTOR (See doc_CAPABILITIES/mutableCapabilities/SeleniumCapabilities_Test)
						Capabilities cap;
						cap = driver.getCapabilities();
						String browser= cap.getBrowserName();
						BUT WE NEED TO GO DOWN TO CHORMIUM
									ChromiumDriver driver;
									driver = new ChromeDriver();
									driver.get("bbc.co.uk")'
									Capabilities cap;
									cap = driver.getCapabilities();
									String browser= cap.getBrowserName();
      
   Class Hierarchy tip (see the flow driagram created for this project (using https://app.diagrams.net): 
						WedDriver, RemoteWebDriver, ChromiumDiver  [with method Captbilities()]
						WedDriver, RemoteWebDriver, ChromiumDiver, [children: @ChromeDriver @EdgeDriver]
		To view Class documentation: Click Ctrl, click blue hyperlink <Class_Name>
		Click blue '@' in Documentation to see children classes of the current class
		   VERIFY ChromiumDriver has a method within it called Capabilities() and that  
		   VERIFY WedDriver with child RemoteWebDriver
         	   VERIFY RemoteWebDriver with child ChromiumDiver
        	   VERIFY ChromiumDiver with method Captbilities()
		   VERIFY IntelliSense on a child class displays methods inherited up the chain from super classes above  
	
WIP:
VERIFY what are the affected child classes of 'Base Utility'
VERIFY what class uses POM commons-io 2.15.1
VERIFY element with type By for xpath Id.
VERIFY element with type By for xpath Name.
VERIFY element with type By for xpath Id and getTyxt (Type cast?).
VERIFY Frame with WebElement getText.
VERIFY Window with WebElement and getText.
VERIFY WindowHandle WebElement and getText.
VALIDATE log SPLF.
VALIDATE log 4kj?.
VALIDATE charted progress with JavDocs.
VALIDATE Local Run of Repo ch02 across browsers (Safari & Edge) on one machine.
VALIDATE Run Repo_ch02 Maven project (one POM) across two machine (Windows & Mac).
VALIDATE skill to run the official Selenium Dev Repo on GitHub: 
https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/README.md
