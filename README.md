# Restaurant Management API

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F7?style=for-the-badge&logo=spring-boot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20Web%20Tokens&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)

## 📝 Descripción del Proyecto

Este es un proyecto de una API RESTful para la gestión completa de un restaurante. Desarrollado con **Java 21** y **Spring Boot**, el sistema permite la administración de mesas, platos y órdenes, con un enfoque en la seguridad a través de un sistema de autenticación basado en **JSON Web Tokens (JWT)**.

El objetivo de esta API es demostrar mi capacidad para construir aplicaciones backend seguras, escalables y con una arquitectura limpia, usando **Spring Data JPA** e **Hibernate** para la persistencia de datos.

## ✨ Funcionalidades Principales

* **Autenticación y Autorización:**
    * Registro y login de usuarios con roles específicos: `ADMIN` y `USER`.
    * Implementación de seguridad a nivel de endpoints para restringir el acceso a rutas según el rol del usuario.
* **Gestión de Platos:**
    * Operaciones **CRUD** (Crear, Leer, Actualizar, Borrar) para la administración de platos en el menú.
* **Gestión de Mesas:**
    * Operaciones **CRUD** para la administración de las mesas del restaurante.
* **Gestión de Órdenes:**
    * Creación de órdenes que vinculan **mesas** y **platos**.
    * Cada orden maneja su tiempo de creación y actualización con `LocalDateTime`.
    * La lógica del negocio asegura que la relación entre entidades sea correcta.

## 🛠️ Tecnologías y Herramientas

* **Backend:**
    * Java 21
    * Spring Boot
    * Spring Security
    * Spring Data JPA
    * Hibernate
    * JWT (JSON Web Tokens)
    * Maven
* **Base de Datos:**
    * PostgreSQL

