CREATE DATABASE IF NOT EXISTS agenda;
USE agenda;
CREATE TABLE IF NOT EXISTS contactos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(100) NOT NULL,
    tel VARCHAR(20),
    dir VARCHAR(200),
    mail VARCHAR(100) NOT NULL
);

INSERT INTO contactos (nom, tel, dir, mail) 
VALUES ('Juan Perez', '555-1234', 'Calle Principal 123', 'juan@email.com');

SELECT * FROM contactos;