**ICTAK-TECHBLOG**

**Project Overview**

This project is an end-to-end Automation Testing Framework developed using Selenium WebDriver, TestNG, and Maven. The framework follows the Page Object Model (POM) design pattern and automates functional test cases of a web-based blogging application.

**Tools and Technologies Used**

* Programming Language: Java  
* Automation Tool: Selenium WebDriver  
* Testing Framework: TestNG  
* Build Tool: Maven  
* Design Pattern: Page Object Model (POM)  
*  Database Connectivity: JDBC  
* Version Control: Git & GitHub


**Framework Workflow-ICTAK\_TECHBLOG**

├── src/test/java

│   ├── assertions

│   ├── base

│   ├── listeners

│   ├── pages

│   └── utility

├── src/test/resources

│   ├── config.properties

│   └── ICTAK-Login.xlsx

├── target

│   └── screenshots

├── test-output

├── pom.xml

├── testng.xml

└── README.md

**Prerequisites**

* Java JDK  
* Maven  
* Chrome & ChromeDriver  
* Git

**Setup Instructions**

1\. Clone the Repository

2\. Configure Browser & Environment

* Update application URL and browser details in config.properties

* ChromeDriver is managed automatically using WebDriverManager

3\. Install Dependencies

4\. Screenshot Handling

* Screenshots are captured automatically only on test failure

* Implemented using TestNG Listeners (ITestListener)

**Challenges Addressed**

* Dynamic element handling  
* Alert handling  
* Stale element issues  
* Click interception  
* Fast execution synchronization

**Conclusion**

This framework follows industry standards and is suitable for real-world automation testing.

