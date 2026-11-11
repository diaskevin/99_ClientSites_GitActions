# 00_ClientSites_GitActions

The aim of this project is to provide a runner on LIVE Client Sites that are changing all the time. 
Modification effected by change include: 
    Captcha & cookie accept
    Browser versions  
    page element * DOM changes (tree-like structure, content, style, etc)
Extensibility across :
    Devices (Physical, Virtual, GitHub Actions)
    OS Types (Window & Mac & Linux)
Runtime variables:
    Waits
    Scheduling 
Reporting:
    Central Results & logging & stack trace (monitoring pipeline output- ephemeral VMs)
Scheduling:
    Jenkins
    GitLab CI/CD

CLIENT SITES
------------
AmazonCOM_Test
A smoke test.
Opens the site, waits a few seconds,
has disabled search tests for “IPhone 11” and “IPhone 12”.
Good example of a basic page-load + manual CAPTCHA / disabled flow.

AmazonUK_Test.java
Cookie handling
Search, then explores selecting product results by XPath.
Most of the search/selection methods are disabled.

DIY_CookiesAccept_defaultContent_Test.java
Visits DIY.com & verifies the title,
waits for the consent banner, clicks “Accept Cookies,”
then switches back to default content.
The actual search test (test_SearchDrill) is disabled.
This is a cleaner example of handling a consent banner and browser switching.

Google_Test.java
A collection of scratch-pad Selenium experiments:
title test
browser details test
cookie acceptance flow
search for “cheese”
screenshot of the results page


REVIEW (See GITHUB_ACTIONS_GUIDE.md):
------------
VALIDATE GitHub Actions to run Maven tests
    VERIFY Maven dependency resolution
    VERIFY Maven headless runner
    VERIFY No regional local functionality within tests
    VERIFY Central results reporting

Setup 1:  Configure pom.xml So Maven Can Run JUnit 5 Tests
Setup 2:  Update Your Selenium Test Class for Headless Mode & Optional Popups
Setup 3: Add a getChromeOptions() Helper method for Headless Mode
Setup 4: Add a acceptCookiesIfPresent() Helper method for gracefully popup handling

Confirm Setup 5: Create the GitHub Actions Workflow File (With a Live Results Summary Table!)

Confirm run: Github Actions
Confirm run: Local machine
