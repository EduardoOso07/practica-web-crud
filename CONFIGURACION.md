# CONFIGURACIÓN DE LA APLICACIÓN - AGENDA DE CONTACTOS

## Requisitos previos

| Software | Versión | Dónde descargar |
| JDK | 17 o superior | https://www.oracle.com/java/technologies/downloads/ |
| MySQL Server | 8.0+ | https://dev.mysql.com/downloads/mysql/ |
| Apache Tomcat | 10+ | https://tomcat.apache.org/download-10.cgi |
| NetBeans IDE | 12+ | https://netbeans.apache.org/ |
| MySQL Workbench | 8.0+ | https://dev.mysql.com/downloads/workbench/ |

## Paso 1: Instalar MySQL Server

1. Descargar MySQL Installer desde el sitio oficial
2. Ejecutar el instalador
3. Seleccionar "Developer Default"
4. Configurar contraseña para usuario `root` (ejemplo: `123456`)
5. Anotar la contraseña - será necesaria más adelante
6. Asegurarse que el servicio MySQL inicie automáticamente

## Paso 2: Crear la base de datos

1. Abrir MySQL Workbench
2. Conectarse a "Local instance MySQL" con la contraseña de root
3. Ejecutar el siguiente script:

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
INSERT INTO contactos (nom, tel, dir, mail) VALUES 
('Juan Perez', '555-1234', 'Calle Principal 123', 'juan@email.com');
