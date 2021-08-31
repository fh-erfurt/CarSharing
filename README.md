# CarSharing
Web app for car sharing purposes. Customers are able to search the cars in offering, and make reservations as well as pay and manage their rentals.
The app is currently under development, using the Spring Boot Framework

## Prerequisites
Java 11
Apache Maven 3.x

## Installation and running
```
mvn clean package
mvn spring-boot:run
```
Application can be accessed via http://localhost:8080

## Introduction
Sign in as one of three user types:
* administrator
* customer
* employee

Admin's role is to manage branches and employees. Admin has access to statistics pertaining to rentals. Admin account is access through the following credentials:
```
username: admin
password: admin
```
***
Customer is able to search for available cars in the branch desired and reserve them for a period of time.
***
Employee manages and assists customers with rentals

### Technologies used
* Spring Boot Framework
* Postgresql
* Thymeleaf
* Maven