# Chapter02 Selenium JavaDocs
The aim of this project is to provide Automation Testing of the packages provided by the Selenium 4 api
as defined by Java docs: 
https://www.javadoc.io/doc/org.seleniumhq.selenium/selenium-api/2.50.1/overview-summary.html

## Convention & Configuration
See Chapter01 Readme
Verify what class uses POM commons-io 2.15.1

Selenium inheritance note::
ChromiumDriver extends RemoteDriver, which in turn implements WebDriver (which is an interface)

General note:
1) Observe the Base Utility with extended child classes (See doc_SEARCHCONTENT.doc_TAKE_SCREENSHOT.webElement.actions)
2) Review affected child classes of Base Utility.


WIP:
Verify element with type By for xpath Id.
Verify element with type By for xpath Name.
Verify element with type By for xpath Id and getTyxt (Type cast?).
Verify Frame with WebElement getText.
Verify Window with WebElement and getText.
Verify WindowHandle WebElement and getText.
Validate log SPLF.
Validate log 4kj?.
Verify charted progress with JavDocs.

Validate Local Run of Repo ch02 across 4 browsers (Safari, Firefox, Chrome & Edge) on one machine.  
Validate Run Repo_ch02 Maven project (one POM) across two machine (Windows & Windows).
Validate Run Repo_ch02 Maven project (one POM) across two machine (Windows & Mac).
Validate run durations on multiple devices (HP_Laptop, Hp_Family, MAC).

As a prelude to Ch03:
Validate run of BrowserTypes on several machines.

Validate skill to run the official Selenium Dev Repo:
https://github.com/SeleniumHQ/seleniumhq.github.io/blob/trunk/README.md