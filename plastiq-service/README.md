# Summary

- Basic Spring Boot Application to serve as a starting point for a basic RESTful API.
- Cloned from https://spring.io/guides/gs/actuator-service/#initial

# Setup

- Build the project - e.g. `mvn clean install`
- Run the Spring Boot Application e.g. `mvn spring-boot:run`
- Invoke the API - e.g. `curl --request POST 'http://localhost:9000/login'`

# Interview Exercise

- Build and run the aplication
- Identify and fix any bugs found with the initial implementation
- Once the initial issues are fixed, start refactoring the code to try achieve the following:
  - Improve any issues or gaps identified with the current implementation of the login API
  - Update the login endpoint to send a verification code to the user's phone (hardcoded to 4159979691). We will use Twillio's REST service to accomplish this The details for the service are included below.
  - Create a second Endpoint that can take that Code and verify it with Twilio's API
