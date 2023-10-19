
## Framework and language used :

 Framework and Technology  used :

    SpringBoot (spring-boot-starter-web)
    Swagger

language used : Java

## Data flow
Controller : 

    addTodo: POST method for adding a single todo.
    getAllTodos: GET method for retrieving all todos.
    setTodoStatusById: PUT method for updating the status of a todo by its ID.
    removeTodoById: DELETE method for removing a todo by its ID.
    addTodos: POST method for adding a list of todos.
    getAllUndoneTodos: GET method for retrieving all todos that are not done.
    removeTodos: DELETE method for removing todos by a list of their IDs.


DataBase Design :   

    Todo
    (
    Integer todoId;
    String todoName;
    boolean todoStatus;
    )

## Data Structure

    List<Todo>

# Project summary
this Spring Boot application serves as a backend for a todo management system, with API endpoints supporting common CRUD operations on todo items. The project is configured using Maven and includes dependencies for web development, testing, and OpenAPI documentation.


