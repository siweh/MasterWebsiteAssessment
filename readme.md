Getting Started

To use this framework, you need to have the following software installed:

Java Development Kit (JDK) [version]
Maven [version]
WebDriver [version] (e.g., ChromeDriver, GeckoDriver)
Can use Intellij or Eclipse as your IDE

Clone the repository: git clone https://github.com/siweh/amplifyAppAutomation.git
Install the required dependencies: mvn install
Update project under project name through maven.
Update the pom.xml file for the appropriate WebDriver for your desired browser.

Project Structure
Under src folder/java/com.amplifyapp/Applications: It's where the functionalities of testcases are.
Under src folder/java/com.amplifyapp/Data: It's where the defects logs are.
Under src folder/java/com.amplifyapp/utilities: It's where setup of browser is.
Under src folder/java/com.amplifyapp/Test: It's where the tests are.

The testNG.xml file is the test suits for running my test cases.
The pom.xml file to for all the dependencies that I'm using.
Run the tests using TestNG.