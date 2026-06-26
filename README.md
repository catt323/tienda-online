# Tienda Online

Proyecto básico realizado con Spring Boot para administrar clientes y productos.

## Tecnologías

* Java 17
* Spring Boot
* PostgreSQL
* Maven

## Base de datos

Crear la base de datos en PostgreSQL:

```sql
CREATE DATABASE tienda_online;
```

Copiar el archivo `.env.example`, cambiarle el nombre a `.env` y colocar los datos de PostgreSQL:

```properties
DB_URL=jdbc:postgresql://localhost:5432/tienda_online
DB_USERNAME=postgres
DB_PASSWORD=tu_contrasena
```

## Ejecutar el proyecto

Abrir el proyecto en IntelliJ y ejecutar:

```text
TiendaOnlineApplication.java
```

## Endpoints

### Clientes

```text
POST /clientes
GET /clientes
GET /clientes/{id}
```

### Productos

```text
POST /productos
GET /productos
GET /productos/{id}
DELETE /productos/{id}
```

Las pruebas se encuentran en el archivo `pruebas.http`.
