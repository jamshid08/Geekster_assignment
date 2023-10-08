

## Framework and language used :

Framework and  technologies used : 
   
    SpringBoot (spring-boot-starter-web)
    Swagger
    Lombok
    Spring Validations
    Spring Data JPA
    MySQL JDBC driver.


language used :      Java

## Data flow
Controller : 

 AddressController

    POST: addAddress
    PUT: updateAddressById
    DELETE: deleteById
    GET: getAllAddresses, getAddressById

BookController

    POST: addBook
    PUT: updateBookById
    DELETE: deleteById
    GET: getAllBooks, getBookById

CourseController

    POST: addCourse
    PUT: updateCourseById
    DELETE: deleteById
    GET: getAllCourses, getCourseById

LaptopController

    POST: addLaptop
    PUT: updateLaptopById
    DELETE: deleteById
    GET: getAllLaptops, getLaptopById

StudentController

    POST: addStudent
    PUT: updateStudentById
    DELETE: deleteById
    GET: getAllStudents, getStudentById


Services : 
 AddressService:

    addAddress - String
    updateAddressById - String
    deleteById - String
    getAllAddresses - List<Address>
    getAddressById - Address

BookService:

    addBook - String
    updateBookById - String
    deleteById - String
    getAllBooks - List<Book>
    getBookById - Book

CourseService:

    addCourse - String
    updateCourseById - String
    deleteById - String
    getAllCourses - List<Course>
    getCourseById - Course

LaptopService:

    addLaptop - String
    updateLaptopById - String
    deleteById - String
    getAllLaptops - List<Laptop>
    getLaptopById - Laptop

StudentService:

    addStudent - String
    updateStudentById - String
    deleteById - String
    getAllStudents - List<Student>
    getStudentById - Student


           
Repository : 

    interface IAddress extends JpaRepository<Address,Long>
    interface IBook extends JpaRepository<Book,String>
    interface ICourse extends JpaRepository<Course,String>
    interface ILaptop extends JpaRepository<Laptop,String>
    interface IStudent extends JpaRepository<Student,String>

    


DataBase Design :

Address:

    addressId (Long)
    landmark (String)
    zipcode (String)
    district (String)
    state (String)
    country (String)
    student (Student)

Book:

    bookId (String)
    title (String)
    author (String)
    description (String)
    price (Double)
    student (Student)


Course:

    courseId (String)
    title (String)
    description (String)
    duration (String)
    student (Set<Student>)


Laptop:

    laptopId (String)
    name (String)
    brand (String)
    price (Integer)
    student (Student)

Student:

    studentId (String)
    name (String)
    age (Integer)
    phoneNumber (String)
    branch (String)
    department (String)
    address (Address)
    bookSet (Set<Book>)
    laptop (Laptop)
    courseSet (Set<Course>)




## Data Structure
Data Structure used : List    

    List;
    Set;
   

# Project summary

    The project includes several model classes: Address, Book, Course, Laptop, and Student, representing entities related to student information.
    Entities are annotated with JPA annotations for persistence and Jackson annotations for JSON serialization.
    There are corresponding service classes (e.g., AddressService, BookService) that handle business logic related to each entity.
    Controllers (e.g., AddressController, BookController) define RESTful endpoints for CRUD operations on these entities.
    The application likely uses Spring Data JPA for database access, MySQL as the relational database, and supports OpenAPI documentation through springdoc-openapi(Swagger).

Functionality:

    Manages student-related entities such as addresses, books, courses, laptops, and students.
    Supports creating, updating, and deleting entities via RESTful endpoints.
    Utilizes validation to ensure data integrity.
    Potentially provides API documentation using OpenAPI.


    In summary, the project is a comprehensive Spring Boot application designed for handling student-related data with a clear separation of concerns using MVC architecture and integrating various Spring and third-party libraries for enhanced functionality.