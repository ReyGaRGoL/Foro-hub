### 📚 Foro Hub API  
**Aplicación Backend para la Gestión de Tópicos en un Foro**  

¡Hola! Este proyecto es parte del desafío "Foro Hub" propuesto por Alura Latam y Oracle. La idea principal es practicar conceptos clave de backend mientras desarrollamos una API REST que simula el funcionamiento básico de un foro. 🚀  

---

### 🎯 **Propósito del Proyecto**  
El objetivo de esta aplicación es:  
- Practicar el desarrollo de APIs RESTful utilizando **Spring Boot**.  
- Gestionar bases de datos relacionales con **MySQL**.  
- Implementar autenticación y autorización con **Spring Security**.  
- Controlar versiones de la base de datos mediante **Flyway**.  
- Documentar la API con **Swagger**, facilitando su comprensión y uso por parte de otros desarrolladores.  
- Seguir las mejores prácticas del diseño API REST para CRUD (Crear, Leer, Actualizar y Eliminar).  

---

### 🛠️ **Funciones Principales**  

1️⃣ **Crear un nuevo tópico:** Los usuarios pueden publicar preguntas o temas de discusión.  

2️⃣ **Mostrar todos los tópicos creados:** Recupera la lista completa de tópicos almacenados.  

3️⃣ **Mostrar un tópico específico:** Consulta los detalles de un tópico mediante su identificador único.  

4️⃣ **Actualizar un tópico:** Modifica los datos de un tópico existente.  

5️⃣ **Eliminar un tópico:** Borra un tópico específico de la base de datos.  

---

### 🧩 **Tecnologías Utilizadas**  

- **Java:** Lenguaje principal del desarrollo.  
- **Spring Boot:** Framework para agilizar el desarrollo backend.  
- **JPA/Hibernate:** Para gestionar la persistencia y consultas a la base de datos.  
- **MySQL:** Base de datos relacional utilizada para almacenar los datos del foro.  
- **Flyway:** Para el control de versiones y migraciones de la base de datos.  
- **Spring Security:** Implementación de autenticación y autorización.  
- **Swagger:** Para documentar y visualizar la API de manera interactiva.  

---

### 📦 **Requisitos Previos**  

Antes de ejecutar el proyecto, asegúrate de tener:  

- **Java 17** o superior.  
- **Maven** para la gestión de dependencias.  
- **MySQL** instalado y configurado.  
- Un IDE como IntelliJ IDEA o Eclipse.  

---

### 🚀 **Cómo Usarlo**  

1️⃣ **Clonar el repositorio:**  
```bash  
git clone https://github.com/ReyGaRGoL/Foro-hub.git  
```  

2️⃣ **Configurar la base de datos:**  
- Crea una base de datos en MySQL llamada `foro_hub`.  
- Configura el archivo `application.properties` con tus credenciales de MySQL.  

3️⃣ **Ejecutar las migraciones:**  
- Flyway aplicará automáticamente las migraciones necesarias para crear y actualizar la estructura de la base de datos.  

4️⃣ **Compilar y correr el proyecto:**  
```bash  
mvn clean install  
mvn spring-boot:run  
```  

5️⃣ **Consultar la documentación de la API:**  
- Antes de interactuar con la API, te recomiendo revisar la documentación generada con **Swagger**.  
- Puedes acceder a ella desde `http://localhost:8080/swagger-ui.html`. Esta interfaz te permitirá explorar las rutas disponibles, comprender sus parámetros y probarlas directamente.  

6️⃣ **Probar las rutas de la API:**  
- Usa herramientas como Postman o cURL para probar las rutas documentadas.  
- Para acceder a las rutas protegidas, utiliza las credenciales del administrador generadas automáticamente después de las migraciones:  
  - **Correo:** `admin@forohub.com`  
  - **Contraseña:** `12345`  

---

### 📝 **Rutas de la API**  

- `POST /login` → Ruta principal para iniciar sesión. Este método genera y retorna un **token de autorización** que se debe incluir en los encabezados (`Authorization: Bearer <token>`) para acceder a los demás endpoints.  

#### Rutas para Tópicos:  
- `POST /topico` → Crear un nuevo tópico.  
- `GET /topico` → Listar todos los tópicos.  
- `GET /topico/{id}` → Obtener un tópico específico.  
- `PUT /topico` → Actualizar un tópico existente.  
- `DELETE /topico/{id}` → Eliminar un tópico.  

#### Otras rutas:  
- `POST /usuario` → Crear un nuevo usuario.  
- `GET /usuario` → Listar todos los usuarios registrados.  

---

### 🔒 **Seguridad con Spring Security**  

La API implementa autenticación y autorización utilizando **Spring Security**. Esto asegura que solo usuarios autenticados puedan acceder a rutas protegidas, añadiendo una capa de seguridad al manejo de datos sensibles.  

---

### 📋 **Migraciones con Flyway**  

El control de versiones de la base de datos se realiza mediante **Flyway**, lo que permite aplicar cambios estructurados de forma segura y automatizada. Las migraciones están configuradas para ejecutarse automáticamente al iniciar la aplicación.  

---

### 📖 **Documentación con Swagger**  

La API está documentada utilizando **Swagger**, lo que permite visualizar y probar los endpoints de manera interactiva. Puedes acceder a la documentación en `http://localhost:8080/swagger-ui.html`. Esto es útil tanto para desarrolladores como para otros usuarios que necesiten entender y consumir la API.  

---

### 🎉 **Notas Finales**  

Este proyecto es parte de mi aprendizaje en desarrollo backend. Si estás desarrollando algo similar, ¡te animo a personalizar esta idea y experimentar con nuevas funcionalidades! 🚀  

**¡Gracias por leer y feliz codificación!** 💻  
