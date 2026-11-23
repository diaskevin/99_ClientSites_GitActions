# 00_ClientSites_GitActions

The aim of this project is to provide a GitHub Actions runner for running tests in the cloud on public facing urls (See GITHUB_ACTIONS_GUIDE.md):
    VALIDATE GitHub Actions to run Maven tests
                    VERIFY Maven dependency resolution via POM (Configure pom.xml to run Selenium JUnit 5 Tests)
                    VERIFY Maven headless runner (Chromeoptions helper in each Class for Headless Mode)
                    VERIFY No regional local functionality within tests
                    VERIFY acceptCookiesIfPresent() helper in each class
    Convention:
                GitHub Actions baseline for yaml (maven_Any.yml)
                    Scheduling: ON 
                        push:           branches: [ "main" ]
                        pull_request:   branches: [ "main" ]  
                Central results reporting (Results & logging & stack trace)
                                Disabled test require Manual intervention:
                        Captcha & cookie accept
                        page element * DOM changes (tree-like structure, content, style, etc)
        Extensibility across run types:
        Devices Types (Phtsical, Virtual, Remote using GitHub Actions)
        OS Types (Window & Mac & Linux)
        Browser Types (Local machine) 


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
