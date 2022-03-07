
# ProgressSoft
ClusteredData Warehouse Service Spring-Boot Rest API

## Steps to run and build the service.

1. *Create PostgreSQL database (warehouse) with two schema {public, revision} and role {userName:progress_user, password:progress} and grant both schemas permisions to progress_user*

using pgadmin to create graphically or psql with bellow commands 
 
 ```
CREATE DATABASE warehouse;
CREATE ROLE progress_user LOGIN PASSWORD 'progress';
GRANT CONNECT ON DATABASE warehouse TO progress_user;
grant all privileges on database warehouse to progress_user; 
  
connect to database: \c warehouse;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO progress_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO progress_user;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO progress_user;
GRANT ALL PRIVILEGES ON SCHEMA public TO progress_user;
ALTER SCHEMA public OWNER TO progress_user;

CREATE SCHEMA revision;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA revision TO progress_user;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA revision TO progress_user;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA revision TO progress_user;
GRANT ALL PRIVILEGES ON SCHEMA revision TO progress_user;
ALTER SCHEMA revision OWNER TO progress_user;
```

2. Clone and run the project
```
git clone https://github.com/Akbari300/ClusteredData_Warehouse.git
cd path/ClusteredData_Warehouse
mvn install
mvn spring-boot:run
```

3. API Documentation. it's used OpenAPI Docs swagger-ui
http://localhost:8090/warehouse.html


<!-- ## To run the service in multiple instances 
in case of to scale up the application to be able to run in multiple instances, one of the solution is implementing Messaging Queue Architecture 
Particularly using RabbitMQ 
the concept of producing/consuming message from broker(message queue), that load balance between workers. 
each client send requets to message queue and consumers process the message.  to ensure data consistency one of the way is that spring-boot has notation like @transactional implmented in makeTransaction() method. it ensure Atomicity in transaction.   -->
