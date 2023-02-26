# apiuser
Nisum Api REST


## Instalación 📋
* Descargue los archivos fuentes
* La crea la base de datos y las tablas al iniciarse
* Despues de correr la aplicación puede ver la base de datos local en http://localhost:8080/h2-console/
* Ingrese a la base de datos con los siguientes parametros 
```
Driver Class:org.h2.Driver
JDBC URL:jdbc:h2:mem:testdb
User Name:api
Password:api
```

El respositorio gestiona las dependencias con Maven
## Tecnologias 🛠️
***
A list of technologies used within the project:
* Spring Boot: Version 3.0.3
* Java: Version 11 o supererior
* Base de Datos: h2database
* Maven: 4.0

## Probando la aplicación ⚙️
Con una herramienta para probar Apis como Postman podra realizar la prueba de la aplicación.
* Metodo: Post
* EndPoint: http://localhost:8080/user
* En el body ingrese el siguiente json para realizar la prueba
```
{
  "name": "cristian botian",
  "email": "cristian_botina3@hotmail.com",
  "password": "Crist@123",
  "phones": [
              {
                  "number": "4444",
                  "citycode": "4",
                  "contrycode": "44"
              },
              {
                  "number": "33333",
                  "citycode": "3",
                  "contrycode": "32"
              }
          ]
 }
```


