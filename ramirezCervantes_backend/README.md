
ramirezCervantes_backend 

===============================

Este servicio permite realizar las operaciones CRUD  sobre el objeto y tabla de Person

Información general
--------------------

1- Tener instalado Java version 17 o superior

2- Descargar proyecto del repositorio

3- En la seccion de MAVEN   -->   seleccionar Lifecycle  -->  ejecutar install 


4- Ejecutar comando ./mvnw spring-boot:run

5- Esto levantará el servidor en el puerto 8080 (por defecto).

## Endpoint

GET		localhost:8080/personas
POST	localhost:8080/personas
{
    "nombre": "Alan",
    "apellido": "Cervantes",
    "fechaNacimiento": "1985-06-12T07:16:10.328+00:00",
    "puesto": "FullStack",
    "sueldo": 45000.00
}
PUT		localhost:8080/personas/2
{
    "nombre": "Alan",
    "apellido": "Cervantes",
    "fechaNacimiento": "1985-06-12T07:16:10.328+00:00",
    "puesto": "Scrum Master",
    "sueldo": 45000.00
}
DELETE	localhost:8080/personas/3

