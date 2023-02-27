# apiuser
Nisum Api REST.
Se expone una Api REST con un endpoint lo cual crea un usuario en la base de datos H2


## Instalación 📋
* Descargue los archivos fuentes
* Cuando se corre la aplicación, la base de datos y las tablas se crean automaticamente gracias al ORM de Hibernate
* Después de correr la aplicación puede ver la base de datos local en http://localhost:8080/h2-console/
* Ingrese a la base de datos con los siguientes parametros 
```
Driver Class:org.h2.Driver
JDBC URL:jdbc:h2:mem:testdb
User Name:api
Password:api
```
* Puede ejecutar la aplicación desde el IDE o si tiene Maven instalado, ejecute el comando
```
    mvn clean install
```

## Tecnologias 🛠️
***
Lista de las tecnologías usadas en el proyecto:
* Spring Boot: Version 3.0.3
* Java: Version 17
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


* Ejecute las pruebas unitarias con el comando o con el IDE de desarrollo
```
mvn test
```

## Documentación 📖
Para ver ka documentación de Swagger, revise los enlaces

* http:localhost:8080/v3/api-docs
* http:localhost:8080/swagger-ui/index.html

Descargue la documentación de la API llamado api-documentation.pdf 