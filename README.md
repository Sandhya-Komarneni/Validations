# Validations
Validations using Custom Annotations

# UserInfo Project

## Overview

The UserInfo project is a Spring Boot application that manages user information, providing RESTful API endpoints for creating user entities. It includes validation for user input using Jakarta Bean Validation annotations.

## Technologies Used

- Spring Boot
- Jakarta Persistence (JPA)
- Jakarta Bean Validation
- Lombok
- Spring Data JPA
- Spring MVC
- MySQL

## Project Structure

- `src/main/java/com/example/UserInfo/controller`: Contains the controller class responsible for handling HTTP requests.
- `src/main/java/com/example/UserInfo/model`: Defines the data model for the application.
- `src/main/java/com/example/UserInfo/repository`: Contains the repository interface for database operations.
- `src/main/java/com/example/UserInfo/repository` : Contains the custom annotations and validator classes.

## Endpoints
POST/users: Create a new user. Example request body:
{
  "name": "Jeff",
  "age": 20,
  "phn_no": "9876543210",
  "email": "jeff@gmail.com"
}
