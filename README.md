# product-service
**Service for viewing products info**

Integration:
- in `bootstrap.yml` url, user and password for access to review-service API (`integration.review-service`). User/password must be the same as in review-service.

For easier access to API there was added Swagger dependency. It's accessible through http://localhost:8081/swagger-ui.html (change to your own host/port if needed).

Run standalone:
1. `mvn clean package`
2. `cd target`
3. `java -jar product-service-0.0.1-SNAPSHOT.jar`

Run in Docker:
1. `mvn clean package`
2. `cp target/product-service-0.0.1-SNAPSHOT.jar src/main/docker`
3. `cd src/main/docker`
4. `docker-compose -p "product" up`

When running in Docker default external port for application is 8081. Change to your own in `scr/main/docker/docker-compose.yml` if needed.
