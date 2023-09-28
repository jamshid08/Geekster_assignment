

## Framework and language used :

Framework and  technologies used : 
   
    SpringBoot (spring-boot-starter-web)
    Spring Boot Validation
    Swagger
    Lombok
    Spring Data JPA
    H2 Database


language used :      Java

## Data flow
Controller : StudentController  class with

    addStudents - HTTP POST
    updateStudentById - HTTP PUT
    deleteStudentById - HTTP DELETE
    getAllStudents - HTTP GET
    getStudentById - HTTP GET

 And  EventController with 

    addEvents - HTTP POST
    updateEventById - HTTP PUT
    deleteEventById - HTTP DELETE
    getAllEventsByDate - HTTP GET
    getAllEvents - HTTP GET   


Services :   StudentService class with methods

    addStudents - Return type: String
    updateStudentById - Return type: String
    deleteStudentById - Return type: String
    getAllStudents - Return type: List<Student>
    getStudentById - Return type: Object

 And EventService  class with methods

    addEvents - Return type: String
    updateEventById - Return type: String
    deleteEventById - Return type: String
    getAllEventsByDate - Return type: List<Event>
    getAllEvents - Return type: List<Event>   


           
Repository : 

    interface IStudentRepo which extends JpaRepository<Student,Integer> 
    interface IEventRepo which extends JpaRepository<Event,Integer>

    


DataBase Design :

1)

    Student (
    studentId - Type: Integer
    firstName - Type: String (Size: 3 to 50 characters, Pattern: /^[A-Z][a-z]*/)
    lastName - Type: String (Size: 2 to 50 characters, Pattern: /^[A-Z][a-z]*/)
    age - Type: int (Minimum value: 18, Maximum value: 25)
    department - Type: Department (EnumType.STRING)

    )

 2)

    Event (
    eventId - Type: Integer
    eventName - Type: String (Size: 2 to 100 characters)
    location - Type: String (Size: 2 to 100 characters)
    date - Type: LocalDate
    startTime - Type: LocalTime
    endTime - Type: LocalTime
    )   





## Data Structure
Data Structure used : List    

    List<Student>;
    List<Events>;
   

# Project summary


The University Management System project involves the modeling of two main entities: Student and Event. The application is designed to manage student information and university events. Here is a brief summary:

Student Entity:

    Fields:
    studentId (Integer): Unique identifier for each student.
    firstName (String): First name of the student, adhering to a specific pattern.
    lastName (String): Last name of the student, adhering to a specific pattern.
    age (int): Age of the student within the range of 18 to 25.
    department (Department Enum): Enumerated type representing the department (e.g., CSE, ECE, etc.).

Event Entity:

    Fields:
    eventId (Integer): Unique identifier for each event.
    eventName (String): Name of the event, with a length between 2 and 100 characters.
    location (String): Location of the event, with a length between 2 and 100 characters.
    date (LocalDate): Date of the event.
    startTime (LocalTime): Start time of the event.
    endTime (LocalTime): End time of the event.


Functionality:

    For students, the system supports operations such as adding, updating, and deleting student records. It also allows retrieving all students and fetching a specific student by ID.
    For events, the system supports operations such as adding, updating, and deleting event records. Additionally, it provides functionality to retrieve all events and fetch events based on a specified date.


Technology Stack:

    The project is implemented using Java and the Spring Boot framework.
    The application uses the Jakarta Persistence API (JPA) for data persistence.
    Validation is incorporated using Jakarta Bean Validation annotations.
    Lombok is used for code generation, reducing boilerplate code.


Database Integration:

    The entities are mapped to corresponding database tables (e.g., Student and Event).
    Data access is facilitated through Spring Data JPA repositories.


Validation:

    Input data is validated using Jakarta Bean Validation annotations to ensure adherence to specified constraints.

Endpoints:

    The project provides RESTful API endpoints for managing students and events, including CRUD operations.