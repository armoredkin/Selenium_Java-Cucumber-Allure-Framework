
# Selenium + Java + Cucumber + Allure Framework

# Automation base

Automation Testing Using Selenium Java, BDD and Allure reports

Automation base is a behavior driven development (BDD) approach to write automation test script to test Web.    
The framework supports reporting with Allure reports.  
Target Web is [demoblaze](https://www.demoblaze.com/index.html) web

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
Git
Java
Maven

## Installing

Clone the repo to get a working project

## Running the tests - command line mode
open terminal, cd to project path then run:
mvn clean test -DbrowserName=chrome  
Supported browser:  
chrome, firefox, safari, ie, edge, headless chrome, headless firefox

## Running the tests - from IDE

Right click  testng.xml then run  
Change the browserName value to any supported browser above  
to run parallel increase the thread-count and add more runner inside classes

## Result - Reports
Report from cucumber will be auto generated in target\reports\cucumber-reports  
Generate allure report by open terminal, go to project dir then run: allure serve

## Built With

- [Selenium](http://www.seleniumhq.org/)  - The web framework to automate browsers
- [Maven](https://maven.apache.org/)  - Dependency Management
- [Cucumber](https://cucumber.io/)  - Behavior Driven Development (BDD) library
- [Allure reports](http://allure.qatools.ru/)  - Reporting

## Authors

**Eko Kristianto** -Email:  [eko_04771@yahoo.com](mailto:eko_04771@yahoo.com)