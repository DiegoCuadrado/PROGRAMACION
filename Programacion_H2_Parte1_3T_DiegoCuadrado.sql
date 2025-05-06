CREATE DATABASE Cine;
USE Cine;

CREATE TABLE salas (
    id_sala VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    capacidad INT
);

CREATE TABLE peliculas (
    codigo VARCHAR(10) PRIMARY KEY,
    titulo VARCHAR(100),
    director VARCHAR(100),
    genero VARCHAR(50),
    duracion INT,
    id_sala VARCHAR(10),
    FOREIGN KEY (id_sala) REFERENCES salas(id_sala)
);

INSERT INTO salas VALUES 
('S01', 'Sala 1', 120),
('S02', 'Sala 2', 80);

INSERT INTO peliculas VALUES 
('P001', 'Inception', 'Christopher Nolan', 'Sci-Fi', 148, 'S01'),
('P002', 'Titanic', 'James Cameron', 'Romance', 195, 'S02');

select* from salas;
select* from peliculas;