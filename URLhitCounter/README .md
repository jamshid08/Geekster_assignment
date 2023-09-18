

## Framework and language used :

Framework  used : SpringBoot (spring-boot-starter-web)

language used : Java

## Data flow
Controller : UrlHitController with


    getHitCount()(http method Get),getUserHitCount(http method Get)


Services : UrlHitService  class with

    public int getHitCount() ,public Map<String, Integer>  getUserHitCount(String username) 
           


Repository :   

    DataSource class(which creates bean of Map),UrlRepo class(through which we can manipulate the Map)  


## Data Structure
Data Structure used : Map
    Map<String, Integer>     

    List<Restaurant>;

# Project summary

This Spring Boot project implements a URL hit counter feature with two main tasks. Task 1 involves creating a Spring Boot application with endpoints to count global hits and individual user hits. Task 2, an additional feature, extends the project to count hits by specific usernames. The project includes a UrlHitController for endpoint handling, a UrlHitService for hit count management, and utilizes Spring Web for RESTful functionality. 

