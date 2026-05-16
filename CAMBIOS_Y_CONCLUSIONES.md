# CAMBIOS REALIZADOS Y CONCLUSIONES

## Problemas identificados

| Problema | Explicación |
|----------|-------------|
| Driver obsoleto | org.gjt.mm.mysql.Driver fue reemplazado |
| URL incorrecta | Espacios en blanco y sintaxis inválida |
| Método sin retorno | getconnection() no retornaba la conexión |
| Violación de MVC | Lógica de BD dentro del modelo Contacto |
| HTML vs JSP | HTML no ejecuta Java, imposible conectar a BD |
| Tabla incorrecta | Usaba "users" en lugar de "contactos" |

## Cambios realizados

### 1. Corrección de DbConnection.java

Driver actualizado, URL corregida, método con retorno.

### 2. Separación de responsabilidades - MVC

- Contacto.java: SOLO datos (getters/setters)
- ContactoDAO.java: SOLO acceso a datos (CRUD)

### 3. Migración de HTML a JSP

HTML no ejecuta Java. JSP permite:
- Conectar a MySQL mediante DAO
- Generar tablas dinámicamente
- Mostrar mensajes de éxito/error

### 4. Creación del Servlet Controlador

AddContacto.java maneja las peticiones HTTP:
- doPost(): Guardar y Actualizar
- doGet(): Listar, Editar y Eliminar

### 5. Uso de PreparedStatement

Previene ataques de SQL Injection y maneja caracteres especiales.

## ¿Por qué JSP en lugar de HTML?

| Necesidad | HTML | JSP |
|-----------|------|-----|
| Mostrar datos de MySQL |  No puede |  Sí puede |
| Conectar a base de datos |  No puede |  Sí puede |
| Ejecutar lógica condicional |  Solo con JS |  En servidor |
| Mostrar mensajes dinámicos |  Solo con JS |  Directo |

Conclusión: Un archivo HTML es estático. Para interactuar con una base de datos.

## Estructura final del proyecto
```text
ndex.html (estático) → index.jsp + editar.jsp
Contacto.java (con lógica BD) → Contacto.java (solo datos)

ContactoDAO.java
DbConnection.java (errores) → DbConnection.java (corregido)
No había Servlet → AddContacto.java
No había librería propia → DBConnect.jar
```


## Conclusiones del proyecto

### Aprendizajes técnicos

1. Patrón MVC
   - Comprendí cómo separar las capas de una aplicación web
   - Modelo gestiona datos, Vista presenta interfaz, Controlador maneja peticiones

2. JDBC y MySQL
   - Aprendí a conectar Java con MySQL
   - Comprendí la importancia de PreparedStatement para seguridad

3. Servlets y JSP
   - Servlets reciben y procesan peticiones HTTP
   - JSP generan HTML dinámico en el servidor

4. Despliegue en Tomcat
   - Configuré Apache Tomcat desde NetBeans
   - Comprendí la estructura de una aplicación web

5. Librerías reutilizables
   - Creé una librería propia (DBConnect.jar)
   - La reutilicé en el proyecto principal

### Dificultades superadas

| Dificultad | Solución |
|------------|----------|
| Error "Access denied" | Configurar contraseña correcta |
| Driver no encontrado | Agregar mysql-connector.jar |
| HTML no ejecutaba Java | Migrar a JSP |
| La tabla no aparecía | Implementar ContactoDAO.listar() |
| Editar no funcionaba | Agregar método obtenerPorId() |

### Reflexión final

Esta práctica me permitió comprender cómo funciona una aplicación web Java completa, desde la interfaz de usuario hasta la base de datos.

La diferencia entre la versión inicial del profesor (con errores) y la versión final (organizada, segura y funcional) muestra la importancia de:
- Separar responsabilidades (cada clase hace una cosa)
- Usar las herramientas correctas (JSP para vistas dinámicas)
- Asegurar las conexiones (PreparedStatement)

El proyecto cumple con todos los requisitos del CRUD y está listo para ser desplegado en cualquier servidor Tomcat con MySQL.

---
# Universidad Autonoma de Nuevo Leon
## Facultad de Ciencias Fisico Matematicas
### Estdiante: Eduardo Osorio Castillo  2094956
### Fecha: 15 Mayo 2026


