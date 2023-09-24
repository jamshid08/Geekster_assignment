

## Framework and language used :

Framework  technologies used : 
   
    SpringBoot (spring-boot-starter-web)
    Spring Data JPA
    H2 Database
    Spring Boot Validation
    Swagger
    Lombok


language used :      Java

## Data flow
Controller : JobController class with


    addJobs - HTTP POST
    getAllJobs - HTTP GET
    updateJobById - HTTP PUT
    deleteJobsBYIds - HTTP DELETE
    getAllJobsOfType - HTTP GET
    getAllJobsOfTypeAndSalaryGreaterEqual - HTTP GET
    getAllJobsByLocationAndSalaryGreaterEqual - HTTP GET
    getAllJobsOfTypeByLocationAndDate - HTTP GET
    updateSalaryByEmployerName - HTTP PUT
    updateSalaryByJobType - HTTP PUT
    deleteByEmployerName - HTTP DELETE
    deleteByLocation - HTTP DELETE


Services : JobService  class with methods

    addJobs - Returns String
    getAllJobs - Returns List<Job>
    updateJobById - Returns String
    deleteJobsBYIds - Returns String
    getAllJobsOfType - Returns List<Job>
    getAllJobsOfTypeAndSalaryGreaterEqual - Returns List<Job>
    getAllJobsByLocationAndSalaryGreaterEqual - Returns List<Job>
    getAllJobsOfTypeByLocationAndDate - Returns List<Job>
    updateSalaryByEmployerName - Returns String
    updateSalaryByJobType - Returns String
    deleteByEmployerName - Returns String
    deleteByLocation - Returns String
           


Repository :   

    interface IJobRepo which extends CrudRepository<Job,Long> 


DataBase Design :  H2 DataBase used


    TABLE Job (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    location VARCHAR(255),
    salary DECIMAL(10, 2) CHECK (salary >= 20000), -- Ensure salary is above 20,000
    companyEmail VARCHAR(255) NOT NULL,
    companyName VARCHAR(255),
    employerName VARCHAR(255),
    jobType VARCHAR(255), -- Store the enum as a string
    appliedDate DATE
    )

## Data Structure
Data Structure used : List    

    List<Job>;
    List<ids>;

# Project summary

This Spring Boot project implements CRUD (Create, Read, Update, Delete) operations on a Job entity while incorporating Spring Boot Validation using annotations. The project uses an H2 database for data storage. Key components of the project include:

Job Entity:

The Job entity class is defined with fields such as title,  description, location, salary, company email, company name, employer name, job type (represented as an enum), and applied date. Spring Boot Validation annotations ensure data integrity, including a @Min constraint for salary validation and @Enumerated for job type handling.

Repository Interface:

 A repository interface extends the CrudRepository interface, providing basic CRUD functionality. Custom query methods can be defined for complex searches using Spring Data JPA query method naming conventions.

Controller: 

A controller class handles HTTP requests, interacting with the JobRepository with the help of Jobservice. It implements endpoints for creating, reading, updating, and deleting Job entities. Validation errors are managed using Spring Boot's exception handling.

H2 Database:

 The application is configured to use an H2 in-memory database, simplifying development and testing.

Custom Queries:

 When necessary, custom queries can be defined in the repository interface using @Query annotations to address complex data retrieval requirements.

By combining Spring Boot, Spring Boot Validation, Spring Data JPA, and an H2 database, this project enables efficient management of job-related data, enforces data integrity, and provides flexibility for custom queries when needed.

