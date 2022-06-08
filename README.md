# prime-numbers
RESTful service which calculates and returns all the prime numbers up to and including a number provided

This is a Maven project, so run the command mvn clean install and the project will be compiled and the tests will run.

You require the following to build the project:

Oracle JDK 11
Apache Maven
JDK 11 is required to build and run this project.

## Running the Project
The project uses Spring boot. 
Spring boot is a tool that makes developing web application and microservices with Spring Framework faster and easier.

In order to run the project from the command line follow the steps provided by Spring Boot.

From the project base directory you can run mvn spring-boot:run which will start the application on `http://localhost:8080`

## Running the tests.
To run the unit tests navigate to PrimeNumberControllerTest Class and select Run.

To run the cucumber tests navigate to TestRunner Class, select run and that will run the entire suit of tests.
To run a specific test, navigate to primeNumbers.feature where you can select individual tests.

To see logs navigate to logging.txt. Here you can verify the request sent and response given.
