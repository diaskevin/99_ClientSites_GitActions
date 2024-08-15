# Chapter02 Selenium JavaDocs
The aim of this project is to provide Automation Testing of the packages provided by the Selenium 4 api
as defined by Java docs: 
https://www.javadoc.io/doc/org.seleniumhq.selenium/selenium-api/2.50.1/overview-summary.html

## Convention & Configuration
See Chapter01 Readme

ChromiumDriver extends RemoteDriver, which in turn implements WebDriver (which is an interface)

Validate run of BrowserTypes on several machines.

Tips:
1) When repo name is changed, check the POM artifect is same as the new project name.
2) Observe the Base Utility with extended child classes (See doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.actions)
3) Review affected child classes of Base Utility.

WIP:
Verify element with type By for xpath Id.
Verify element with type By for xpath Name.
Verify element with type By for xpath Id and getTyxt (Type cast?).
Verify Frame with WebElement getText.
Verify Window with WebElement and getText.
Verify WindowHandle WebElement and getText.
Validate log SPLF.
Validate log 4kj?.
Chart progress with JavDocs