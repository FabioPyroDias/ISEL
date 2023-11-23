CREATE DATABASE  IF NOT EXISTS `empresa`;
USE `empresa`;

DROP TABLE IF EXISTS `tipo_contrato`;

CREATE TABLE `tipo_contrato` (
  `cod` int NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `remuneracao` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`cod`)
);


INSERT INTO `tipo_contrato` VALUES (1,'CEO',4000.00),(2,'CFO',3500.00),(3,'funcionario',1000.00);
