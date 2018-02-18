/*SENTENCIA PARA ELIMINAR LA BASE DE DATOS*/
USE Master;
GO
DROP DATABASE SIAEN;
GO
/*****************************************/

--------------------------------------------------------------------------------------------------

CREATE DATABASE SIAEN;
GO
USE SIAEN;
GO

CREATE TABLE Tipo(
idTipo INT IDENTITY,
tipo VARCHAR(60) NOT NULL,
PRIMARY KEY(idTipo));
GO

CREATE TABLE Usuario(
idUsuario INT IDENTITY,
nombre VARCHAR(45) NOT NULL,
apellido1 VARCHAR(45) NOT NULL,
apellido2 VARCHAR(45),
correo VARCHAR(60) NOT NULL UNIQUE,
contrasena VARCHAR(22) NOT NULL,
estado BIT DEFAULT 1,
esAdmin BIT DEFAULT 0,
PRIMARY KEY(idUsuario));
GO

CREATE TABLE Encuesta(
idEncuesta INT IDENTITY,
nombre VARCHAR(45) NOT NULL,
descripcion VARCHAR(150),
fechaCreacion DATE DEFAULT GETDATE(),
codigo VARCHAR(6) NOT NULL UNIQUE,
estado BIT DEFAULT 1,
idUsuarioCreo INT NOT NULL,
PRIMARY KEY(idEncuesta),
CONSTRAINT fk_encuesta_usuario
FOREIGN KEY(idUsuarioCreo) REFERENCES Usuario(idUsuario));
GO

CREATE TABLE Pregunta(
idPregunta INT IDENTITY,
pregunta VARCHAR(150),
obligatoria BIT DEFAULT 1,
estado BIT DEFAULT 1,
idTipo INT NOT NULL,
idEncuesta INT NOT NULL,
PRIMARY KEY(idPregunta),
CONSTRAINT fk_pregunta_tipo 
FOREIGN KEY(idTipo) REFERENCES Tipo(idTipo),
CONSTRAINT fk_pregunta_encuesta 
FOREIGN KEY(idEncuesta) REFERENCES Encuesta(idEncuesta));
GO

CREATE TABLE Opcion(
idOpcion INT IDENTITY,
opcion VARCHAR(100) DEFAULT 'ES ABIERTA',
esAbierta BIT DEFAULT 1,
estado BIT DEFAULT 1,
idPregunta INT NOT NULL,
PRIMARY KEY(idOpcion),
CONSTRAINT fk_opcion_pregunta
FOREIGN KEY(idPregunta) REFERENCES Pregunta(idPregunta));
GO

CREATE TABLE Aplica(
idAplica INT IDENTITY,
fechaAplicacion DATETIME DEFAULT GETDATE(),
estado BIT DEFAULT 0,
idEncuesta INT NOT NULL,
idUsuario INT NOT NULL,
PRIMARY KEY(idAplica),
CONSTRAINT fk_aplica_encuesta
FOREIGN KEY(idEncuesta) REFERENCES Encuesta(idEncuesta),
CONSTRAINT fk_aplica_usuario 
FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario));
GO

CREATE TABLE Responde(
idResponde INT IDENTITY,
respuestaAbierta VARCHAR(100),
idAplica INT NOT NULL,
idPregunta INT NOT NULL,
idOpcion INT NOT NULL,
PRIMARY KEY(idResponde),
CONSTRAINT fk_responde_aplica 
FOREIGN KEY(idAplica) REFERENCES Aplica(idAplica),
CONSTRAINT fk_responde_pregunta 
FOREIGN KEY(idPregunta) REFERENCES Pregunta(idPregunta),
CONSTRAINT fk_responde_opcion 
FOREIGN KEY(idOpcion) REFERENCES Opcion(idOpcion));
GO


-----INSERCI�N DE DATOS
INSERT INTO Tipo(tipo) VALUES('Opci�n M�ltiple');
INSERT INTO Tipo(tipo) VALUES('Selecci�n M�ltiple');
INSERT INTO Tipo(tipo) VALUES('Abierta');
GO

INSERT INTO Usuario(nombre,apellido1,apellido2,correo,contrasena,esAdmin)
VALUES('Francisco Javier','Gardu�o','Estrada','franciscogarduno@utez.edu,mx','nikolas',1);
INSERT INTO Usuario(nombre,apellido1,apellido2,correo,contrasena,esAdmin)
VALUES('Sarahi Daniela','Medina','M�rtinez','20153ti059@utez.edu.mx','nikolas',1);
INSERT INTO Usuario(nombre,apellido1,apellido2,correo,contrasena,esAdmin)
VALUES('Sarah�','D�az','Ch�vez','20153ti140@utez.edu.mx','nikolas',0);
INSERT INTO Usuario(nombre,apellido1,apellido2,correo,contrasena,esAdmin)
VALUES('Evelyn','S�nchez','M�rquez','evelynsanchez@utez.edu.mx','nikolas',0);
INSERT INTO Usuario(nombre,apellido1,apellido2,correo,contrasena,esAdmin)
VALUES('Luis Uriel','Torres','Morales','i20143ti135@utez.edu.mx','nikolas',0);
GO

INSERT INTO Encuesta(nombre,descripcion,idUsuarioCreo,codigo)
VALUES('Gustos Personales','Encuesta realizada con la finalidad de conocer las gustos personales de los estudiantes',2,'ABC123');
INSERT INTO Encuesta(nombre,descripcion,idUsuarioCreo,codigo)
VALUES('Elecciones 2018','Encuesta realizada con la finalidad de conocer las gustos personales de los estudiantes',2,'123ABC');
GO

INSERT INTO Pregunta(pregunta,obligatoria,idTipo,idEncuesta)
VALUES('�Qu� fruta prefieres?',1,1,1);
INSERT INTO Pregunta(pregunta,obligatoria,idTipo,idEncuesta)
VALUES('�Cu�l es tu deporte favorito?',0,1,1);
INSERT INTO Pregunta(pregunta,obligatoria,idTipo,idEncuesta)
VALUES('�Qu� opinas de las redes sociales?',1,3,1);
INSERT INTO Pregunta(pregunta,obligatoria,idTipo,idEncuesta)
VALUES('�Cu�l es tu festividad favorita?',1,1,1);
GO

INSERT INTO Pregunta(pregunta,obligatoria,idTipo,idEncuesta)
VALUES('�Cu�l es su ideolog�a pol�tica?',1,1,2);
INSERT INTO Pregunta(pregunta,obligatoria,idTipo,idEncuesta)
VALUES('�Con qu� alianza se siente identificado?',1,1,2);
INSERT INTO Pregunta(pregunta,obligatoria,idTipo,idEncuesta)
VALUES('La frase "Ya sabes qui�n" �A qui�n le recuerda?',1,1,1);
GO

INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Mango',0,1);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Uva',0,1);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Fresa',0,1);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Pi�a',0,1);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Pl�tano',0,1);
GO

INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('F�tbol',0,2);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Voleibol',0,2);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Baloncesto',0,2);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Rugby',0,2);
GO

INSERT INTO Opcion(esAbierta,idPregunta)
VALUES(1,3);

INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('D�a del amor y la amistad',0,4);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Fiestas patrias',0,4);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('D�a de muertos',0,4);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Navidad',0,4);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('D�a de reyes',0,4);
GO

INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Izquierda',0,5);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Derecha',0,5);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Ninguna',0,5);
GO

INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('PRI-PV-PANAL',0,6);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('PAN-PRD-MC',0,6);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('MORENA-PT-PES',0,6);
GO

INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Carlos Salinas de Gortari',0,7);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Andr�s Manuel L�pez Obrador',0,7);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Voldemort',0,7);
INSERT INTO Opcion(opcion,esAbierta,idPregunta)
VALUES('Nadie en particular',0,7);
GO

INSERT INTO Aplica(idEncuesta,idUsuario,estado)VALUES(1,3,1);
INSERT INTO Aplica(idEncuesta,idUsuario,estado)VALUES(1,3,0);
INSERT INTO Aplica(idEncuesta,idUsuario,estado)VALUES(1,4,0);
INSERT INTO Aplica(idEncuesta,idUsuario,estado)VALUES(2,5,0);
GO

INSERT INTO Responde(idAplica,idPregunta,idOpcion)
VALUES(1,1,2);
INSERT INTO Responde(idAplica,idPregunta,idOpcion)
VALUES(1,2,1);
INSERT INTO Responde(idAplica,idPregunta,idOpcion,respuestaAbierta)
VALUES(1,3,10,'Una gran herramienta de informaci�n');
INSERT INTO Responde(idAplica,idPregunta,idOpcion)
VALUES(1,4,3);
GO



SELECT * FROM Responde;





