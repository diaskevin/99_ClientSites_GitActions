# 02_A_Selenium4_JavaDocCoverage

##Selenium4 Automation Test Coverage

The aim of this project is to provides Automation Testing of Selenium4, with specified coverage with respect to Java docs <<URL>>

### Convention & Configuration
Convention:
IntelliJ IDE
QA desktop folder with sub-folders for projectShare(/resource, /library, /applicationSoftware) & projectTools(/Git, /Java, /Maven)
WebDriver created as a global variable with no access modifiers (i.e. leave blank so that it is 'Protected', without stating Private or Public)
Junit5 annotations @BeforeEach @Test

Configuration:
Driver Location currently hard coded in repository <<>> (wip: Helper utility to store the location addreess of the driver)
Dependencies resolved by Maven (Selenium4, Junit 5 & Hamcrest)

#### REPOSITORY Problems:
CH003&9 Kev_Framework GitHub Remote Repository
CH01-10 Projects have Chrome baseline for System setProperties Ch 01-10 (each includes Read me notes)
CH01-10 Each Chapter has a Package 'Runner99' with NO SystemSet properities (i.e. Can clone running on any Selenium server)
Problem A1: Driver Resource
HP_Laptop Local machine 'Resource' QA folder with BrowserType Driver executables
HP_Laptop Local machine 'Environmental System Variables' for System setProperty locations of each BrowserType Driver
Problem A2: Driver Set
HP_Laptop_Local machine Project created with a pre-requisite Browser Utility for runner 99's classes (incl Chrome, Edge, Opera & Safari)
(Alt: JFrog artifactory)
Problem B: IDE Types & gitignore (Eclipse & Intellij & VSC)
Ch10- Understand the Git Ignore at Push to rerpository
Github 'Package' can be transfered across IDE Types (by CopyPaste or GitCloned or ZipExport)
Runner99 can be cloned and added to locally and pushed back to GitHub easily across IDE Types
Problem C: Dependency Resolution
Java_Project JAR for each IDE_type (Eclipse & Intellij & VCS)
Maven_Project POM for each IDE_type (Eclipse & Intellij & VCS)
Problem D: Version control (Selenium, Java, Windows)
Chrome Driver stopped running and needed a ChromeOption: Fixed by Selenium jar 'Selenium-java' replaced s'Selenium-standalone'
Grid requires Java version 11 (not version 8)
Grid requires Win11 not Win10

##### WebDriver Interface
// IntelliJ Observer (Point mouse on ChromeDrive, Ctrl + Click)
// IntelliJ Observe ChromeDriver class opens to display ChromeDriver extends ChromiumDriver
// Then... ChromiumDriver extends RemoreDriver, which in turn implements WebDriver (whic is an interface)


###### Selenium COVERAGE SUMMARY
Selenium4 functionality is defined by Java docs
https://www.javadoc.io/doc/org.seleniumhq.selenium/selenium-api/2.50.1/overview-summary.html

Automation Test coverage is to provide specified coverage of Selenium4 Java docs.
At present Repository coverage is defined below.

COVERAGE SUMMARY
02_A_Selenium3_general
-	a_browserTypes_InstantiationObjects
-	b_WebDriver_JavaLogic
+	c_Wait_ImplicitExplicitFluent_ThreadSleep
+	d_WebDriver_methods
-	e_utilities
02_B_Selenium4_framework
+	a_browserTypes_InstantiationObjects- OK
-	b_Garcia_WebDriverManager- move to obsolete
+	c_mutableCapabilities-ERR (see above)
-	d_wait- OK
+	e_pageLoadStrategy- OK
+	g_FileUpload- OK
+	h_Locators- OK, but see ERR above
+	i_Interactions- OK
+	j_Cookies- OK
+	k_WindowHandler- OK
-	l_ScreenShot
-	m_commandExecution
-	n_colour
-	o_Select
-	p_ThreadGuard
-	q_logging
+ 02_API_WebElement- ERR(Junit 'id')
+ 02_StopWatchReport_Latency
- 02_API_ScreenShot- ERR(Not Mavern but needs to be created as a separate Project, NOT as a package with a project)
+ 02_API_Select- OK
+ 02_API_By_findElement
+ API_driver_Navigation
+ 02_API_Keys
COVERAGE SUMMARY of obsolete functionality
09_X_BrowserType_Depreciated
09_X_BrowserType_PhatomJS


Java Docs Package: org.openqa.selenium
SEARCH_CONTENT 					
                WEBDRIVER
                            NAVIGATION
                                        back()
                                        forward()
                                        refresh()
                            WINDOW
                                        fullscreen()
                                        getPosition()
                                        getSize()
                                        mazamise()
                TAKE_SCREENSHOT
                            WEBELEMENT
                                        clear()
                                        click()
                                        findElement(By by)
                                        getText()
                                        isDisplayed()
                                        isEnabled()
                                        sendKeys

                ALERT
                                        getText()
                                        sendKeys()

                CAPABILITIES 			
                                        getBrowserName()
                                        getPlatform()
                                        getVersion()
OTHER PACKAGES:
org.openqa.selenium.html5
org.openqa.selenium.interactions
org.openqa.selenium.interactions.internal
org.openqa.selenium.interactions.touch
org.openqa.selenium.internal
org.openqa.selenium.logging
org.openqa.selenium.logging.profiler
org.openqa.selenium.remote
org.openqa.selenium.security
com.thoughtworks.selenium   (wip future as yet to be released features)