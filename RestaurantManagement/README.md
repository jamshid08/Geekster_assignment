

## Framework and language used :

Framework and  technologies used : 
   
    SpringBoot (spring-boot-starter-web)
    Swagger
    Lombok
    Spring Validations
    Spring Data JPA
    MySQL JDBC driver.
    Sun.Email


language used :      Java

## Data flow
Controller : 

AdminController:

    addFoodItem - POST
    getAllFoodItems - GET
    deleteFoodItemById - DELETE
    
UserController:

    userSignUp - POST
    userSignIn - POST
    userSignOut - DELETE
    getAllFoodItems - GET
    CreateOrder - POST
    cancelOrder - PUT


Services : 

 FoodIteamService:

    getAllFoodItems - List<FoodItem>
    addFoodItem - String
    deleteFoodItemById - String

OrderService:

    CreateOrder - String
    cancelOrder - String

UserAuthTokenService:

    createToken - void
    isAuthenticated - boolean
    deleteToken - 
    
UserService:

    userSignUp - String
    userSignIn - String
    userSignOut - String
    getAllFoodItems - List<FoodItem>

EmailService,PasswordEncryptor.    

           
Repository : 

    interface IAdminRepo extends JpaRepository<Admin,Integer>
    interface IFoodIteamRepo extends JpaRepository<FoodItem,Integer>
    interface IOrderRepo extends JpaRepository<Order,Integer>
    interface IUserAuthTokenRepo extends JpaRepository<UserAuthToken,Integer> 
    interface IUserRepo extends JpaRepository<User,Integer>

    


DataBase Design :

Admin:

    adminId (Integer)
    adminName (String)
    adminEmail (String)
    adminPassword (String)

FoodItem:

    foodItemId (Integer)
    foodItemName (String)
    foodItemDescription (String)
    foodItemPrice (String)
    order (Order)

Order:

    orderId (Integer)
    quantity (Integer)
    status (Status - Enum)
    user (User)
    foodItemList (List<FoodItem>)


User:

    userId (Integer)
    userName (String)
    password (String)
    email (String)

UserAuthToken:

    tokenId (Integer)
    tokenValue (String)
    tokenCreationTime (LocalDateTime)
    user (User)

## Data Structure
Data Structure used : List    

    List;
    
   

# Project summary

Controllers:

    There are two controllers, AdminController and UserController, managing different aspects of the system.
    AdminController deals with food items, allowing the addition, retrieval, and deletion of food items.
    UserController handles user-related operations like sign-up, sign-in, sign-out, and ordering/canceling orders.

Services:

    FoodIteamService manages operations related to food items, such as retrieving all items, adding a new item, and deleting an item by ID.
    OrderService is responsible for handling order-related functionalities, including creating and canceling orders. It also ensures authentication before processing orders.

Entities (Models):

    There are several model classes representing entities in the system:
    Admin for administrative users.
    FoodItem representing items available in the restaurant.
    Order for managing customer orders.
    User representing end-users of the system.
    UserAuthToken for managing user authentication tokens.

Entity Relationships:

    The entities have relationships defined between them:
    FoodItem has a Many-to-One relationship with Order.
    Order has a Many-to-One relationship with User and a One-to-Many relationship with FoodItem.
    UserAuthToken has a One-to-One relationship with User.

Validation:

    The code uses Java validation annotations (@Valid, @Email, @Pattern) for input validation in various places, ensuring data integrity.

Security:

    The project uses some basic security features, with token-based authentication and authorization checks before processing orders.

Other Components:

    There's a UserAuthTokenService responsible for managing user authentication tokens.
    Password encryption seems to be implemented in the UserService during user sign-up and sign-in.
    and EmailService to send the Token value to user's registered email.
