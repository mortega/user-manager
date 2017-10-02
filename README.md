# user-manager
API for handling user data

# Run
 - mvn clean install
 - java -jar target/user-manager-{version}.jar

# Doc
 - http://localhost:8080/swagger-ui.html

 - User example:

 ```javascript
 {
   "name": "Marcela",
   "lastName": "Ortega",
   "cpf": "12345678901",
   "birthday": "1986-08-05",
   "address": {
     "street": "Street name",
     "number": 100,
     "cep": "01234567",
     "city": "São Paulo",
     "state": "SP"
   },
   "phoneNumbers": [
     {
       "ddd": 11,
       "phoneNumber": "912349876"
     }
   ]
 }
 ```

# Tech
 - Spring Boot: https://projects.spring.io/spring-boot/
 - Spring Framework: https://spring.io/
 - HSQLDB: http://hsqldb.org/
 - Swagger UI: https://swagger.io/swagger-ui/
