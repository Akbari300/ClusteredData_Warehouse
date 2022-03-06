Carpool Implementation using JPA and Postgres 
Server port:8092

--- Setup to run and build the Service
Create PostgreSQL database (carpool_db) with two schema {public, revision} and 
role {userName:carpool_user, password:carpool} and 
grant both schemas permisions to carpool_user


--- API Documentation. it's used OpenAPI Docs swagger-ui 
(http://localhost:8092/carpool.html)

-- Java-11 configured in pom.xml, because  my local machine java version.

-- to setup the project.
# get clone carpoolJPA.bundle 
# cd carpoolJPA
# mvn install
# mvn spring-boot:run