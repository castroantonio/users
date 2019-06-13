# users
REST application using SpringBoot.

Available at: https://users-springboot.herokuapp.com/users

This simple project was made in Java using SpringBoot, Eclipse IDE and Spring Tools 4 (aka Spring Tools Suite). The main purpose is to test the advantages of using SpringBoot.

It is consists on a REST service that can be used to create, retrive, delete and list all users (Usuarios.java), this way:

 - create:
 
 URL: https://users-springboot.herokuapp.com/users
 
 method: POST
 
 request body: JSON containing user name, for example: {"nome" : "Antonio Castro"}
 
 returns: JSON containing user id and name, for example: {"id" : 1, "nome" : "Antonio Castro"} with status CREATED.
 
 
 
 - retrive:
 
 URL: https://users-springboot.herokuapp.com/users/{id}
 
 method: GET
 
 request body: N/A
 
 returns: JSON containing user id and name, for example: {"id" : 1, "nome" : "Antonio Castro"} with status OK; or NOT FOUND.
 
 
 
 - update:
 
 URL: https://users-springboot.herokuapp.com/users
 
 method: PUT
 
 request body: JSON containing user id and new name, for example: {"id" : 1, "nome" : "Antonio"}
 
 returns: JSON containing user id and name, for example: {"id" : 1, "nome" : "Antonio"} with status OK; or NOT FOUND.
 
 

 - delete:
 
 URL: https://users-springboot.herokuapp.com/users/delete/{id}
 
 method: DELETE
 
 request body: N/A
 
 returns: OK or NOT FOUND.
 
 
  
 - list all:
 
 URL: https://users-springboot.herokuapp.com/users/list
 
 method: GET
 
 request body: N/A
 
 returns: JSON containing user array, for example: [
    {"id": 1, "nome": "Antonio Castro"}, {"id": 2, "nome": "Marisol"}, {"id": 3, "nome": "Mr. Second"}] with status OK.
