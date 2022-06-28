# Project Title

**undostres Website Automation:**
This automation framework is designed to do mobile recharge. In this project we have one scenario, i.e buying recharge with valid card details. Also noticed there are particular number of recharge we can do using one card details hence I have enhanced the script to do transaction is card details are already present. website is having lot of issues like rendering, different response time each time & website will behave different on different browsers.

Using below commands we can run our test suites on different browsers. Depending upon the execution result screenshots will be present in the screenshot folder. Extent report & logger is enabled.

# Prerequisites

* Java8
* Maven
* Chrome Browser
* Firefox Browser


## Running the tests

Got to the directory where we have kept the pom.xml and execute below command on cmd or terminal

    mvn clean package exec:java -Dbrowser=FF
    
    mvn clean package exec:java -Dbrowser=Chrome

## Findings

Same script will behave different on different browser. Response time of a website is also vary on both browsers.
