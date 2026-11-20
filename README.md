# 00_ClientSites_GitActions

The aim of this project is to provide a GitHub Actions runner.
    Convention:
        Browser versions handled by ChromeOptions
        Runtime variables: Implicit Waits
        Yaml runs tests using GitHub Actions  
            Reporting: Central Results & logging & stack trace (monitoring pipeline output- ephemeral VMs)
            Scheduling: ON 
                    push:           branches: [ "main" ]
                    pull_request:   branches: [ "main" ]  
            Disabled test require Manual intervention:
                        Captcha & cookie accept
                        page element * DOM changes (tree-like structure, content, style, etc)

Extensibility across:
    Devices (Physical, Virtual, GitHub Actions)
    OS Types (Window & Mac & Linux)

AUTOMATED TESTS
---------------
AmazonUK_Test.java
    Cookie handling
    Search
    Explores selecting product results by XPath
    Asserts title for acceptCookies_test
    Mostly disabled tests (search/selection methods)

Google_Test.java
    Ignores cookie handling
    Asserts title
    browser details test
    Mostly disabled tests (search/selection methods)



MANUAL TESTS (Disabled: requires human intervention)
------------
AmazonUK_Test.java & Google_Test.java
    Mostly disabled tests (search/selection methods)
    Cookie handling
    Search
    Explores selecting product results by XPath
    Asserts title for acceptCookies_test
        
AmazonCOM_Test
    Opens the site and waits
    disabled search tests for “IPhone 11” and “IPhone 12”
    Good example of a basic page-load + manual CAPTCHA to disabled flow

DIY_CookiesAccept_defaultContent_Test.java
    Opens the site 
    verifies the title
    waits for the consent banner, clicks “Accept Cookies,”
    then switches back to default content
    The actual search test (test_SearchDrill) is disabled.
    This is a cleaner example of handling a consent banner and browser switching.
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
