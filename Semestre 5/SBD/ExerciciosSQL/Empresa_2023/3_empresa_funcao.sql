CREATE DATABASE  IF NOT EXISTS `empresa` ;
USE `empresa`;


DROP TABLE IF EXISTS `funcao`;

CREATE TABLE `funcao` (
  `cod` int NOT NULL,
  `cod_tc` int NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`cod`),
  KEY `fk_tipo_contrato` (`cod_tc`),
  CONSTRAINT `fk_tipo_contrato` FOREIGN KEY (`cod_tc`) REFERENCES `tipo_contrato` (`cod`)
);


INSERT INTO `funcao` VALUES (1,1,'Chefe disto tudo'),(2,2,'Money man'),(3,3,'worker bee'),(4,3,'Worker bee assistent');
