CREATE DATABASE  IF NOT EXISTS `empresa`;
USE `empresa`;

DROP TABLE IF EXISTS `empregado`;

CREATE TABLE `empregado` (
  `num_emp` int NOT NULL,
  `nome` varchar(150) NOT NULL,
  `morada` varchar(200) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `num_dep` int DEFAULT NULL,
  `cod_tc` int DEFAULT NULL,
  PRIMARY KEY (`num_emp`),
  KEY `fk_departamento` (`num_dep`),
  KEY `fk_tc` (`cod_tc`),
  CONSTRAINT `fk_departamento` FOREIGN KEY (`num_dep`) REFERENCES `departamento` (`num_dep`),
  CONSTRAINT `fk_tc` FOREIGN KEY (`cod_tc`) REFERENCES `tipo_contrato` (`cod`)
);


INSERT INTO `empregado` VALUES (1,'Manuel Joaquim','Rua de cima n3 28 Dto, 2222-876 Lisboa',20,1,1),(2,'Maria Manuela','Rua de cima n3 28 Dto, 2222-876 Lisboa',20,1,2),(3,'Joaquim Moreira','Rua de cima n3 28 Dto, 2222-876 Lisboa',25,2,3),(4,'Jorge Manuel','Rua de cima n3 28 Dto, 2222-876 Lisboa',26,2,3),(5,'Ti manel','rua de baixo',20,NULL,NULL),(6,'Avó Xica','Alvalade',20,3,2);
