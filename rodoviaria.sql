CREATE DATABASE rodoviaria;	
USE rodoviaria;

CREATE TABLE passageiro(
idpassageiro int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome varchar(50),
genero varchar(9),
RG varchar (10),
CPF varchar(11),
endereo varchar(150),
email varchar(100),
telefone BIGINT(14)
);


