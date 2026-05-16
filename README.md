# practica-web-crud
Practica Web Facultad de Ciencias Fisico Matematicas
# 📒 Práctica WEB - CRUD de Contactos

## Descripción
Aplicación web Java que permite gestionar una agenda de contactos con operaciones CRUD (Crear, Leer, Actualizar, Eliminar) usando MySQL y Tomcat.

## Tecnologías utilizadas
- Java (Servlets, JSP)
- MySQL
- Apache Tomcat 10+
- JDBC
- HTML/CSS

## Requisitos previos
- JDK 17 o superior
- MySQL Server 8.0+
- Apache Tomcat 10+
- NetBeans IDE (recomendado)

## Configuración de la base de datos

1. Iniciar MySQL Server
2. Ejecutar el script `script.sql` en MySQL Workbench:
```sql
CREATE DATABASE agenda;
USE agenda;
CREATE TABLE contactos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    tel VARCHAR(20),
    dir VARCHAR(200),
    mail VARCHAR(100) NOT NULL
);
