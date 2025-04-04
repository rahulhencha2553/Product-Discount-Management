🛠️ Product Discount Management – Spring Boot Application
This is a simple Spring Boot project that manages product data and discounts. It includes RESTful APIs to fetch product information and inserts dummy data into the database at startup.

Configure the server and Database
# application.yml
# SERVER CONFIG
server:
  port: 8881

# APPLICATION CONFIG
spring:
  application:
           name: PRODUCT-DISCOUNT-MANAGEMENT
# DATABASE CONFIGURATION
  datasource:
            url: jdbc:mysql://localhost:3306/pdm?createDatabaseIfNotExist=true
            username: root //change username 
            password: 2553 //change password
            driver-class-name: com.mysql.cj.jdbc.Driver
# JPA CONFIGURATION
  jpa:
      hibernate:
         ddl-auto: update
      properties:
         hibernate:
             dialect: org.hibernate.dialect.MySQL8Dialect
      show-sql: true
