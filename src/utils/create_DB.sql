CREATE TABLE carreras (
	id_carrera int AUTO_INCREMENT PRIMARY key,
	nombre_carrera VARCHAR(30) not null,
        capacidad_asistentes int UNSIGNED not null,
        nivel_dificultad decimal(2,1) UNSIGNED not null,
	techo_disponible BOOLEAN DEFAULT false not null
);

INSERT INTO carreras (nombre_carrera, capacidad_asistentes, nivel_dificultad, techo_disponible)
VALUES ("Zipatocan", 8473, 8.9, true);
INSERT INTO carreras (nombre_carrera, capacidad_asistentes, nivel_dificultad, techo_disponible)
VALUES ("Quirachiquin", 12332, 7.3, true);

INSERT INTO carreras (nombre_carrera, capacidad_asistentes, nivel_dificultad, techo_disponible)
VALUES ("Vitaguata", 0, 1.9, false);

CREATE TABLE pilotos(
	cod_piloto int PRIMARY KEY,
    nombre varchar(30) not null,
    millas_recorridas decimal(10,2) not null,
    combustible_usado int not null,
    cod_escuderia_fk int not null,
    foreign key (cod_escuderia_fk) REFERENCES escuderia(cod_escuderia)
);

INSERT INTO pilotos(cod_piloto, nombre, millas_recorridas, combustible_usado, cod_escuderia_fk) 
VALUES (12, "JuanPis", 27833.8, 9876456,232);
INSERT INTO pilotos(cod_piloto, nombre, millas_recorridas, combustible_usado, cod_escuderia_fk) 
VALUES (872, "Chumajer", 0.0, 0,345);

CREATE TABLE escuderia(
	cod_escuderia int primary key,
    nombre varchar(40) not null,
    patrocinador varchar(40) not null,
    carreras_ganadas int not null,
    fecha_ingreso_formula DATE not null
);

INSERT INTO escuderia(cod_escuderia, nombre, patrocinador, carreras_ganadas, fecha_ingreso_formula) 
VALUES(232,"Viejo Willy", "Doña Cecilia", 38, '2001-12-12');
INSERT INTO escuderia(cod_escuderia, nombre, patrocinador, carreras_ganadas, fecha_ingreso_formula) 
VALUES(345,"Severo Fierrari", "Guión Burger", 45, '1998-3-07');
INSERT INTO escuderia(cod_escuderia, nombre, patrocinador, carreras_ganadas, fecha_ingreso_formula) 
VALUES(876,"Mechas Plateadas", "Corredor Gourmet", 42, '1999-8-30');

CREATE TABLE participacion (
	id_participacion int AUTO_INCREMENT PRIMARY KEY,
    cod_piloto_fk int not null,
    fecha TIMESTAMP not null,
    posicion int not null,
    id_carrera_fk int not null,
    FOREIGN KEY (cod_piloto_fk) REFERENCES pilotos(cod_piloto),
    FOREIGN KEY (id_carrera_fk) REFERENCES carreras(id_carrera)
);
INSERT INTO participacion (cod_piloto_fk, fecha, posicion, id_carrera_fk) 
VALUES(12,'2019-02-12 18:56:45',1,1);
INSERT INTO participacion (cod_piloto_fk, fecha, posicion, id_carrera_fk) 
VALUES(872,'2019-02-12 18:56:45',2,1);

INSERT INTO participacion (cod_piloto_fk, fecha, posicion, id_carrera_fk) 
VALUES(12,current_timestamp(),2,2);
INSERT INTO participacion (cod_piloto_fk, fecha, posicion, id_carrera_fk) 
VALUES(872,current_timestamp(),1,2);


