


CREATE DATABASE bd_ramirez;

CREATE TABLE bd_ramirez.person (
    id INT AUTO_INCREMENT PRIMARY KEY,       -- Campo id autoincremental
    nombre VARCHAR(100) NOT NULL,            -- Campo nombre
    apellido VARCHAR(100) NOT NULL,          -- Campo apellido
    fechaNacimiento DATE,                    -- Campo fecha de nacimiento
    puesto VARCHAR(100),                     -- Campo puesto
    sueldo DECIMAL(10, 2)                    -- Campo sueldo
);

CREATE USER 'conexion'@'%' IDENTIFIED BY 'root';

GRANT ALL PRIVILEGES ON bd_ramirez.* TO 'conexion'@'%';

FLUSH PRIVILEGES;