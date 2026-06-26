# Tienda Online

API REST básica para administrar clientes y productos.

## Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Funciones

### Clientes

- Crear cliente
- Listar clientes
- Buscar cliente por ID

### Productos

- Crear producto
- Listar productos
- Buscar producto por ID
- Eliminar producto

## Preparar la base de datos

Crear una base de datos en PostgreSQL:

```sql
CREATE DATABASE tienda_online;
```

Copiar el archivo `.env.example`, cambiar el nombre de la copia a `.env` y completar los datos:

```properties
DB_URL=jdbc:postgresql://localhost:5432/tienda_online
DB_USERNAME=postgres
DB_PASSWORD=tu_contrasena
```

## Ejecutar

Abrir el proyecto en IntelliJ y ejecutar la clase:

```text
TiendaOnlineApplication.java
```

También se puede ejecutar desde una terminal:

```bash
mvn spring-boot:run
```

La aplicación utiliza el puerto 8080.

## Endpoints

### Clientes

```text
POST   /clientes
GET    /clientes
GET    /clientes/{id}
```

### Productos

```text
POST   /productos
GET    /productos
GET    /productos/{id}
DELETE /productos/{id}
```

Las solicitudes de ejemplo están en el archivo `pruebas.http`.

## Organización

```text
Controller
DTO
Mapper
Service
Repository
Base de datos
```

El controller recibe las solicitudes. Los DTO transportan los datos. El mapper convierte entre DTO y entidad. El service contiene las operaciones. El repository se comunica con la base de datos.
