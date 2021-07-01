# Summary

- Sandbox repo for Interview work cloned from https://spring.io/guides/gs/actuator-service/#initial
- interview-app1 contains a basic Spring Boot Application to serve as a starting point for a basic RESTful API.

# Setup

- `cd interview-app1`
- Build the project - e.g. via `mvn clean install`
- Run the Spring Boot Application - `PlastiqApplication`
- Invoke the API - e.g.

```
curl --request POST http://localhost:9000/login?username=plastiq&password=bigsecret
```

# Interview Exercise

- Build and run the aplication
- Identify and fix any bugs found with the initial implementation
- Once the initial issues are fixed, start refactoring the code to try achieve the following:
    - Improve any issues or gaps identified with the current implementation of the login API
    - Create a second API for fetching Foreign Exchange Rate Data