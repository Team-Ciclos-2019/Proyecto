
CREATE TABLE if not exists Recurso (
  id int not null,
  nombre VARCHAR(100)  not null,
  tipo VARCHAR(100)  not null,
  ubicacion VARCHAR(100)  not null,
  estado  BOOLEAN not null,
  capacidad INT not null,
  disponibilidad INT not null);

CREATE TABLE if not exists Usuario (
	id int not null,
	nombre VARCHAR(100)  not null,
	carrera VARCHAR(100)  not null,
	penalizado BOOLEAN not null);
	
CREATE TABLE if not exists Recurso_Reservado (
	id SERIAL PRIMARY KEY,
	recurso int  not null,
	estudiante int  not null,
	inicio TIMESTAMP  not null,
	fin TIMESTAMP  not null,
	activo BOOLEAN not null);
	
CREATE TABLE if not exists Reserva_Simple (
	id SERIAL PRIMARY KEY,
	reserva int  not null,
	inicio TIMESTAMP  not null,
	fin TIMESTAMP  not null,
	activo BOOLEAN not null);
	
insert into Usuario(id,nombre,carrera,penalizado) values (1,'Mauricio Gonzalez','Ing Mecanica',false);