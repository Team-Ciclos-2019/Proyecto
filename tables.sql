
CREATE TABLE if not exists Recurso (
  id int not null,
  nombre VARCHAR(100)  not null,
  tipo VARCHAR(100)  not null,
  ubicacion VARCHAR(100)  not null,
  estado  BOOLEAN not null,
  capacidad INT not null,
  disponibilidad INT not null);

