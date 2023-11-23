CREATE DATABASE  IF NOT EXISTS `empresa`;
USE `empresa`;

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `num_dep` int NOT NULL,
   `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`num_dep`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
);

INSERT INTO `departamento` VALUES (4,'DEC'),(1,'DEETC'),(2,'DEM'),(3,'DEQ');
