# Project Details

## Tools Used

1. Eclipse
2. JAVA
3. TestNG
4. Maven
5. Extent Report

Install these tools in order to run the tests

## Framework Architecture Details
This project is designed using Maven+TestNG. Scripts are written in JAVA. Log4j2 is used for generating logs and extentReport is used to generate HTML reports for each test execution.

Load the project into Eclipse.

--src/main/java
1. package: baseSetup -- Driver and Browser setup
2. package: customListeners -- user for reporting
3. package: utils -- all utilities files for reports, property file reader, driver manager, screenshots etc

--src/test/java
1. package: pages -- page class consists of all the webelements/locators page wise. It is designed as Page Factory model.
2. package: tests -- test class and the test is defined class wise. Single test in a single class.

--src/test/resources
1. folder: executables - chromedriver.exe used to initiate chrome browser.
2. folder: extentConfig - It is used to generate html report for each test execution
3. folder: propertFiles - It consist of application URL and it can have all important data like login credentials etc.
4. folder: runner - It consist of a testNG file and it is used to run the tests. Right click on file("testng.xml") and run the file as TestNG Suite.

--log4j2.xml - it is designed to create log files for test execution


# How to run with Docker on Mac and Linux

1. Clone this repo.
2. Open a shell in the folder of this repo, run,

   ```sh
   mvn clean test
   ```
