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
('Juan Perez', '555-1234', 'Calle Principal 123', 'juan@email.com');```

## Paso 3: Configurar Apache Tomcat en NetBeans
1.Abrir NetBeans
2.Ir a Tools → Servers → Add Server
3.Seleccionar "Apache Tomcat"
4.Indicar la ruta de instalación de Tomcat
5.Clic en "Finish"

## Paso 4: Compilar la librería DBConnect
1.Abrir el proyecto DBConnect en NetBeans
2.Verificar/Corregir el archivo DbConnection.java:

java
```package DB;
import java.sql.*;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/agenda?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}```

3.Clic derecho en DBConnect → Clean and Build
4.El archivo DBConnect.jar se genera en la carpeta dist/


## Paso 5: Configurar el proyecto PracticaWEB
1.Abrir el proyecto PracticaWEB en NetBeans
2.Agregar DBConnect.jar a Libraries:
    2.1 Clic derecho en Libraries → Add JAR/Folder...
    2.2 Seleccionar DBConnect/dist/DBConnect.jar
3.Agregar el driver de MySQL:
    3.1 Descargar mysql-connector-j-9.5.0.jar
    3.2 Clic derecho en Libraries → Add JAR/Folder...
    3.3 Seleccionar el archivo descargado

## Paso 6: Ejecutar la aplicación
1. Clic derecho en PracticaWEB → Clean and Build
2. Clic derecho → Run
3. Abrir navegador en: http://localhost:8080/PracticaWEB/

## Posibles errores y soluciones
Error	                        Solución
Access denied for user 'root'|    Verificar contraseña en DbConnection.java
ClassNotFoundException	|         Falta driver MySQL en Libraries
Unknown database 'agenda'	|    Ejecutar script SQL en MySQL Workbench
Tomcat no inicia	|            Verificar que el puerto 8080 esté libre
