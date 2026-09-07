# 🚀 Task Manager API

> Una API REST sencilla para la gestión de tareas, construida con Spring Boot y respaldada por un pipeline automatizado de Integración Continua (CI/CD).

---

## 📌 Sobre el Proyecto

Este proyecto forma parte de mi portafolio de desarrollo backend, enfocado en la aplicación de buenas prácticas de ingeniería de software, arquitectura limpia con Spring Data JPA y automatización de flujos de trabajo mediante GitHub Actions.

## 🛠️ Tecnologías y Stack

* **Lenguaje:** Java 17 (Temurin)
* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Spring Validation)
* **Base de Datos:** H2 Database (En memoria para desarrollo y pruebas)
* **Gestor de Dependencias:** Maven
* **CI/CD:** GitHub Actions (Integración Continua automatizada)
* **Control de Versiones:** Git & GitHub

---

## ⚙️ Arquitectura y Estructura

El proyecto sigue el patrón arquitectónico estándar de capas para aplicaciones Spring Boot:

```text
src/
└── main/
    ├── java/com/task_manager_api/demo/
    │   ├── controller/   # Controladores REST (Endpoints HTTP)
    │   ├── model/        # Entidades JPA y reglas de validación
    │   └── repository/   # Interfaces de persistencia de datos
    └── resources/
        └── application.properties # Configuración de la aplicación
