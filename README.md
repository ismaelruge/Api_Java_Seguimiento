# API RESTful en Java con Spring Boot y WebFlux

## Descripción
Este proyecto es una API RESTful desarrollada en **Java 21** con **Spring Boot 3.4.3**, utilizando **Maven** como gestor de dependencias. La API implementa **Spring Security** para autenticación básica, **internacionalización (i18n)** y **programación reactiva** con WebFlux.

## Tecnologías Utilizadas
- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Security**
- **Spring WebFlux**
- **Lombok**
- **JUnit**

## Funcionalidades
### 1. Seguridad en la Aplicación
La API está protegida con **Spring Security**, requiriendo autenticación básica para acceder a los endpoints. Las credenciales predeterminadas son:

```
Usuario: usuario
Contraseña: contraseña
```

### 2. CRUD de Pedidos
Se han desarrollado endpoints para gestionar pedidos, permitiendo:
- **Crear** un pedido (`POST /api/pedidos`)
- **Listar** todos los pedidos (`GET /api/pedidos`)
- **Obtener** un pedido por ID (`GET /api/pedidos/{id}`)
- **Actualizar** un pedido (`PUT /api/pedidos/{id}`)
- **Eliminar** un pedido (`DELETE /api/pedidos/{id}`)

### 3. Internacionalización (i18n)
Se ha implementado soporte multilingüe en el controlador `SaludoController`, permitiendo cambiar el idioma usando:
- **Encabezado HTTP:** `Accept-Language: es/en/fr`
- **Parámetro en la URL:** `GET /api/saludo?lang=es`

### 4. Programación Reactiva
Toda la API utiliza **Spring WebFlux**, permitiendo el manejo de flujos de datos de manera reactiva con `Mono` y `Flux`.

## Instalación y Ejecución
### 1. Clonar el Repositorio
```sh
git clone https://github.com/ismaelruge/Api_Java_Seguimiento.git
cd Api_Java_Seguimiento
```

### 2. Construir el Proyecto
```sh
mvn clean install
```

### 3. Ejecutar la Aplicación
```sh
mvn spring-boot:run
```
La API se ejecutará localmente en `http://localhost:8080`.

## Pruebas Automatizadas
El proyecto incluye pruebas con **JUnit**, las cuales pueden ejecutarse con:
```sh
mvn test
```

## Contribuciones
Si deseas contribuir a este proyecto, puedes hacer un **fork**, crear una rama con tus cambios y enviar un **pull request**.

## Autor
Desarrollado por **Ismael Ruge Gonzalez** para la materia "Lenguaje de Programación Avanzado 1" en la **Corporación Universitaria Remington**.

## Repositorio
[GitHub - Api_Java_Seguimiento](https://github.com/ismaelruge/Api_Java_Seguimiento.git)

