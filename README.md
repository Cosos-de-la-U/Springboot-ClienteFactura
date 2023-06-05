# HTTP Requests

## Cliente

**GET (ALL)**: http://localhost:8080/cliente

**GET (ID)**: http://localhost:8080/cliente/1

**POST**: http://localhost:8080/cliente
```json
{
    "nombre": "John Doe"
}
```
**POST (Actualizar)**: http://localhost:8080/cliente
```json
{   
    "cliente_id": 1, // Solo se pasa el ID, con un post request
    "nombre": "John Doe"
}
```
**DELETE (ID)**: http://localhost:8080/cliente/1

## Factura 

**GET (ALL)**: http://localhost:8080/factura

**GET (ID)**: http://localhost:8080/factura/1

**POST**: http://localhost:8080/factura
```json
{
  "cliente_id": 1,
  "fechaEmision": "2023-06-01",
  "total": 100.50
}
```
**POST (Actualizar)**: http://localhost:8080/factura
```json
{
  "cliente_id": 1, // Solo se pasa el ID, con un post request
  "fechaEmision": "2023-06-01",
  "total": 100.50
}
```
**DELETE (ID)**: http://localhost:8080/factura/1

# applications.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/laboratorio
spring.datasource.username=postgres
spring.datasource.password=password
# Code first approach
spring.jpa.hibernate.ddl-auto=update
# Show or not log for each sql query
spring.jpa.show-sql = true
```


