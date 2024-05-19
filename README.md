# Leads Module Application

### Built on Java SpringBoot Web MVC 3.2.5
For further reference, please consider the following sections:

* The Web Application is built with Java 17, Springboot MVC
* The Application endpoints are protected with SpringSecurity context - InMemoryuserDetails manager
* The Application is shipped with the InMemoryUserDetailsManager to make login easy for you to test.
* WebSecurityConfig configures our security and URL parttens that are permitted 
* Please take note of the LeadsController Java class.
* It containts all CRUD endpoints for the application(GET,POST,DELETE,PUT).
* PUT Method 
* GET Leads endpoint can show report of Leads in the system or for a specific user
* Shown leads can be filtered and shown for specific date using javascript
* Unique dates are sent to the front-end using HashSet collection to have unique elements
* Application uses JPA ORM repository and Postgres as database
* Modify application.properties file to match your postgres database details
* After login, dashboard screen is displayed - user can choose different endpoint routes
* The application can use Auth2 provider and can be changed and use Database.
* The Application can be scalled further depending on requirements,allow registration etc. 
* For the interest of time only the basic requirements are implemented.
### RUNNING THE APPLICATION
To run the application, follow below instructions:

* You can run the application using any IDE, Intelij is used here.
* The Application is Shipped with a WAR file. 
* You can deploy the war file into any web container
* You can build the application using any IDE, Intelij is used here.
* To package the project run: ./mvnw clean package
* Run the project with: ./mvnw clean spring-boot:run
* Navigate to: http://localhost:8080

### TESTING THE APPLICATION
The Application has been Unit tested using JUNIT Jupiter:

* Not part of the requirements but the endpoints are unit tested
* Test the methods by running the LeadsRepositoryTest class
* The Application is Shipped with a WAR file, you can deploy in any web container
* You can run all the Tests to see if they work