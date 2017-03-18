## Multiple Datasources with Spring Boot and JavaConfig

![alt text](https://cloud.githubusercontent.com/assets/1865566/24074352/a79fe09e-0be5-11e7-97d8-b2dadfb2ac78.png "Transactional Context")

This little POC implements a multiple Datasources sample using AbstractRoutingDataSource.

This sample uses Tomcat JDBC as connection pool and works with Spring transactions using @Transactional.

Feel free to improve this project.

Javadoc for AbstractRoutingDataSource: http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/datasource/lookup/AbstractRoutingDataSource.html
