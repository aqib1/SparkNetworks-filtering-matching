## Spark-networks Filter Handling application
Spring cloud microservice for filter handling

### How to Run
- To run application its necessary to run EurekaServer application first, so other both application register first with server
- mvn exec:java

### Technologies
* Spring boot 2
* Spring Cloud (Netflix eureka, Netflix feign (embedded ribbon LB), Netflix Hystrix)
* Spring MVC
* Spring Rest
* Spring data JPA
* Spring AOP
* bootstrap and JSTL
* Junit 4 (for unit testing)
* Mockito (for mocking database calls and methods in unit testing)
* MockMVC (for Integration testing)
* Swagger (openapi 3.0)
* H2 Database
* Openpojo

### Design Pattren
* Double check locking singleton pattren
* Builder pattren

### Thread safety
For thread safety, i am using java 1.8 StampedLock, in which we have optimistic read lock. Which make synchronization overhead is very   low.

### Application details
- All application is build using spring cloud, microservice architecture
- Client application is build using Spring MVC, Client Appliction register it self as erueka client in server.
- Client application communicating with backend api using Netflix feign
- Simple design is madeup using bootstrap and JSTL (for data manipulation)
- Backend application is a euraka client, which is build using spring rest
- H2 database is used save data and given data is loaded during the start-up of application
- Spring specifications are used to create complex quries
- Erueka Server configure on 8085
- Client application is configure on 8080
- Backend application is configure on 8082

### Testing
- TDD (unit testing done using JUNIT 4)
- Mockito (for mocking in unit testing)
- openpojo (for testing required getter/setter existence)
- MockMVC (for integeration testing of API end points)



### API Usage

HTTP METHOD | PATH | USAGE
--- | --- | ---
GET| spark-networks-client/home | Client home page
POST| spark-networks-client/filter | Client filter api
GET| spark-networks-client/ | Client login page
POST| spark-networks-client/login | Client login operation api
POST| spark-networks-backend/filter/login | Backend login rest api
POST| spark-networks-backend/filter | Backend filter rest api
GET| spark-networks-backend/filter | Backend geting all rest api


### Https Status
- 200 OK: The request has succeeded
- 400 Bad Request: The request could not be understood by the server
- 404 Not Found: The requested resource cannot be found
- 417 Bad Exception: Internal server exception
- 500 Internal Server Error: The server encountered an unexpected condition
