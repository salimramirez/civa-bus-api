# CIVA Bus API

API REST para la gestión de buses y marcas desarrollada con Spring Boot 3.5.9 y Java 21. Este proyecto forma parte de un reto técnico e implementa operaciones de consulta sobre un catálogo de buses con paginación y documentación OpenAPI.

## Características

- API REST con arquitectura en capas (Controller, Service, Repository)
- Base de datos PostgreSQL con JPA/Hibernate
- Seguridad mediante Spring Security con autenticación básica
- Documentación interactiva con Swagger/OpenAPI
- Paginación de resultados
- Manejo global de excepciones
- Contenedorización con Docker
- Datos de prueba precargados

## Tecnologías

- Java 21
- Spring Boot 3.5.9
- Spring Data JPA
- Spring Security
- PostgreSQL 15
- Maven
- Docker y Docker Compose
- Lombok
- SpringDoc OpenAPI

## Requisitos Previos

### Opción 1: Ejecución con Docker
- Docker
- Docker Compose

### Opción 2: Ejecución Local
- Java 21
- Maven 3.9+
- PostgreSQL 15

## Configuración

### Variables de Entorno

El proyecto utiliza las siguientes credenciales por defecto:

**Base de datos:**
- Usuario: `salim_user`
- Contraseña: `salim_password`
- Base de datos: `civa_bus_db`

**Autenticación HTTP Basic:**
- Usuario: `civa_user`
- Contraseña: `civa_password`

## Instalación y Ejecución

### Opción 1: Con Docker Compose

Esta opción inicia automáticamente la base de datos PostgreSQL y la aplicación:

```bash
docker-compose up --build
```

La aplicación estará disponible en `http://localhost:8080`

Para detener los contenedores:
```bash
docker-compose down
```

Para eliminar también los volúmenes de datos:
```bash
docker-compose down -v
```

### Opción 2: Ejecución Local

#### 1. Iniciar PostgreSQL

Asegúrese de tener PostgreSQL ejecutándose en el puerto 5432 y cree la base de datos:

```sql
CREATE DATABASE civa_bus_db;
CREATE USER salim_user WITH PASSWORD 'salim_password';
GRANT ALL PRIVILEGES ON DATABASE civa_bus_db TO salim_user;
```

#### 2. Compilar y ejecutar

```bash
./mvnw clean package
./mvnw spring-boot:run
```

O ejecutar el JAR generado:
```bash
java -jar target/civa-bus-api-1.0.0.jar
```

## Uso de la API

### Autenticación

Todos los endpoints requieren autenticación HTTP Basic. Use las credenciales configuradas (por defecto: `civa_user`/`civa_password`).

### Endpoints Disponibles

#### 1. Obtener lista paginada de buses

**Endpoint:** `GET /api/v1/bus`

**Parámetros de consulta opcionales:**
- `page`: número de página (default: 0)
- `size`: tamaño de página (default: 5)
- `sort`: criterio de ordenamiento (ejemplo: `busNumber,asc`)

**Ejemplo con curl:**

```bash
# Solicitud básica
curl -u civa_user:civa_password http://localhost:8080/api/v1/bus

# Con paginación personalizada
curl -u civa_user:civa_password "http://localhost:8080/api/v1/bus?page=0&size=3"

# Con ordenamiento
curl -u civa_user:civa_password "http://localhost:8080/api/v1/bus?page=0&size=5&sort=busNumber,asc"

# Con ordenamiento descendente por placa
curl -u civa_user:civa_password "http://localhost:8080/api/v1/bus?sort=plate,desc"
```

**Ejemplo con Postman:**

1. Crear una nueva petición GET
2. URL: `http://localhost:8080/api/v1/bus`
3. Ir a la pestaña "Authorization"
4. Tipo: "Basic Auth"
5. Username: `civa_user`
6. Password: `civa_password`
7. (Opcional) Agregar parámetros en "Params":
   - Key: `page`, Value: `0`
   - Key: `size`, Value: `5`
   - Key: `sort`, Value: `busNumber,asc`
8. Clic en "Send"

#### 2. Obtener bus por ID

**Endpoint:** `GET /api/v1/bus/{id}`

**Parámetros de ruta:**
- `id`: Identificador único del bus (Long)

**Ejemplo con curl:**

```bash
# Obtener bus con ID 1
curl -u civa_user:civa_password http://localhost:8080/api/v1/bus/1

# Obtener bus con ID 5
curl -u civa_user:civa_password http://localhost:8080/api/v1/bus/5
```

**Ejemplo con Postman:**

1. Crear una nueva petición GET
2. URL: `http://localhost:8080/api/v1/bus/1`
3. Ir a la pestaña "Authorization"
4. Tipo: "Basic Auth"
5. Username: `civa_user`
6. Password: `civa_password`
7. Clic en "Send"

### Documentación Interactiva

La documentación Swagger UI está disponible en:

```
http://localhost:8080/swagger-ui/index.html
```

La especificación OpenAPI en formato JSON está en:

```
http://localhost:8080/v3/api-docs
```

Para acceder a Swagger UI, ingrese las credenciales de autenticación básica cuando se le solicite.

## Datos de Prueba

La aplicación incluye un inicializador de datos que carga automáticamente:
- 5 marcas de buses
- 7 buses de ejemplo con diferentes características y estados

Los datos se cargan solo si las tablas están vacías.

## Notas

- Se implementa paginación para optimizar consultas de listas grandes
- Los DTOs utilizan Java Records para inmutabilidad

## Autor

Salim Ramirez

## Licencia

Este proyecto fue desarrollado como parte de un reto técnico.
