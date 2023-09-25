

## Framework and language used :

Framework and  technologies used : 
   
    SpringBoot (spring-boot-starter-web)
    Spring Boot Validation
    Swagger
    Lombok


language used :      Java

## Data flow
Controller : UserController class with


    addUsers method:----- HTTP Method: POST

    getAllUsers method:----- HTTP Method: GET

    getUserById method:----- HTTP Method: GET

    deleteUserById method:----- HTTP Method: DELETE

    updateUserById method:----- HTTP Method: PUT


Services :   UserService  class with methods


    addUsers method:---- Return Type: String

    getAllUsers method:---- Return Type: List<User>

    getUserById method:---- Return Type: Object

    deleteUserById method:---- Return Type: String

    updateUserById method:---- Return Type: String


           
Repository : 

    two classes DataSource and UserRepo
    which provides List<User>.

    


DataBase Design :


    User (
    userId    Type: Long
    username   Type: String
    dateOfBirth  Type: LocalDate
    email   Type: String
    phoneNumber   Type: String


    )

## Data Structure
Data Structure used : List    

    List<User>;
   

# Project summary

This Spring Boot project establishes a User Management System with CRUD functionalities and using Validations. It includes a User entity with attributes like UserId, username, dateOfBirth, email and PhoneNumber. The project features RESTful endpoints for adding users, retrieving users by ID, fetching all users, updating user information, and deleting users.