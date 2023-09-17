
## Framework and language used :

Framework  used : SpringBoot (spring-boot-starter-web)

language used : Java

## Data flow
Controller :  RestaurantController class with


    getrestaurantById(http method Get),getAllRestaurants(http method Get),addRestaurant(http methos Post),setRestaurantInfoById(http method Put),removeRestaurantById(http method Delete)


Services : ResService  class

    getrestaurantById(Integer id),getAllRestaurants(),addRestaurant(Restaurant newRestaurant),setRestaurantInfoById(Integer id, Restaurant updateRestaurant),removeRestaurantById(Integer id)
           


Repository :   

    DataSource class(which creates bean of List),ResRepo class(through which we can manipulate the list iteams)  


DataBase Design :    contains

    enum Category, Restaurant class (contains all member variables), Getters and setters (using Lombok dependency)

## Data Structure
Data Structure used : List of Restaurant

    List<Restaurant>;

# Project summary
This Spring Boot project, created using the Spring Initializr, aims to manage restaurant information through a RESTful API. The project includes the following key components and features:

Restaurant Model:

A Restaurant model class with attributes such as restaurant name, restaurant address, contact number, specialty, total staff, and additional relevant variables to describe a restaurant comprehensively.


##Operations Performed:

1.Get Restaurant by ID (GetMapping):

    Retrieve restaurant details by specifying the restaurant ID in the URL.

2.Get All Restaurants (GetMapping):

    Retrieve a list of all restaurants.

3.Add Restaurant to the List (PostMapping):

    Create a new restaurant entry by providing the restaurant details through a POST request.

4.Update Restaurant Information (PutMapping):

    Update restaurant information, such as changing the specialty, by specifying the restaurant ID and providing the updated data via a PUT request.

5.Delete Restaurant from the List (DeleteMapping):

    Remove a restaurant from the list by specifying the restaurant ID in a DELETE request.


The project utilizes Spring Boot, Lombok to provide a RESTful API for managing restaurant data. It allows users to perform basic CRUD operations on restaurant entries.



