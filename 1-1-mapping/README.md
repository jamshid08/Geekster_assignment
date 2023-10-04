

## Framework and language used :

Framework and  technologies used : 
   
    SpringBoot (spring-boot-starter-web)
    Swagger
    Lombok
    Spring Data JPA
    MySQL JDBC driver.


language used :      Java

## Data flow
Controller : AddressController  class with

    POST: addAddress(@RequestBody Address newAddress)
    PUT: addAddress(@PathVariable Integer id, @RequestBody Address updateAdd)
    DELETE: deleteAddressById(@PathVariable Integer id)
    GET: getAllAddress()
    GET: getAddressById(@PathVariable Integer id)

 And  EmpController with 

    GET: getEmployees()
    GET: getEmployeeById(@PathVariable Long id)
    POST: addEmp(@RequestBody Emp newEmp)
    DELETE: deleteEmpById(@PathVariable Long id)
    PUT: updateEmp(@PathVariable Long id, @RequestBody Emp updateEmp)   


Services :   AddressService class with methods

    saveAddress(Address newAddress)  --- Returns String
    updateAddress(Integer id, Address updateAdd) --- Returns String
    deleteAddressById(Integer id) --- Returns String
    getAllAddress() --- Returns List<Address>
    getAddressById(Integer id) --- Returns Address

 And EmpService  class with methods

    getEmployees() --- Returns List<Emp>
    saveEmp(Emp newEmp) --- Returns String
    getEmployeeById(long id) --- Returns Emp
    deleteEmpById(Long id) --- Returns String
    updateEmp(Long id, Emp updateEmp) --- Returns String  


           
Repository : 

    interface IAddressRepo which extends JpaRepository<Address,Integer>
    interface IEmpRepo  which extends JpaRepository<Emp,Long>

    


DataBase Design :

1)

    Address (
    Primary Key:

    Variable Name: addressId
    Type: Integer
    Annotations: @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)


    Other Fields:

    street - Type: String
    city - Type: String
    state - Type: String
    zipCode - Type: String

    )

 2)

    Emp (
    Primary Key:

    Variable Name: empId
    Type: Long
    Annotations: @Id, @GeneratedValue(strategy = GenerationType.IDENTITY)


    Other Fields:

    firstName - Type: String
    lastName - Type: String


    Association(Foreign Key):

    address - Type: Address
    Annotation: @OneToOne
    Join Column: fk_addressId

    )   





## Data Structure
Data Structure used : List    

    List<Address>;
    List<Emp>;
   

# Project summary

This Java project using the Spring Framework for building a web application with RESTful services. The project involves the mapping of entities, specifically Address and Emp, and includes functionalities related to these entities.


#### Entities:

    Address:
    Attributes: addressId (primary key), street, city, state, zipCode.
    Emp:
    Attributes: empId (primary key), firstName, lastName.
    Association: One-to-One relationship with Address.
#### Controllers:

    AddressController:
    Provides REST endpoints for CRUD operations on Address entities.
    Endpoints include adding, updating, deleting, and retrieving addresses.


    EmpController:
    Provides REST endpoints for CRUD operations on Emp entities.
    Endpoints include adding, updating, deleting, and retrieving employees.

#### Services:

    AddressService:
    Implements business logic for operations on Address entities.

    EmpService:
    Implements business logic for operations on Emp entities.

#### Repositories:

    IAddressRepo:
    Interface for CRUD operations on Address entities.

    IEmpRepo:
    Interface for CRUD operations on Emp entities.
#### Technologies:
    Java with Spring Framework (including Spring Boot).
    Persistence is likely handled by a database, given the usage of Spring Data JPA repositories.
    Lombok is used for generating boilerplate code (getters, setters, constructors).
    ORM (Object-Relational Mapping):

    The entities (Address and Emp) are annotated with JPA annotations for ORM.