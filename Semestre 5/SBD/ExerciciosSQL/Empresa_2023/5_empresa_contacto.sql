CREATE DATABASE  IF NOT EXISTS `empresa`;
USE `empresa`;

DROP TABLE IF EXISTS `contacto`;

CREATE TABLE `contacto` (
  `numero_empregado` int NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `valor` varchar(100) NOT NULL,
  PRIMARY KEY (`numero_empregado`,`tipo`,`valor`),
  CONSTRAINT `fk_numero_empregado` FOREIGN KEY (`numero_empregado`) REFERENCES `empregado` (`num_emp`)
);


INSERT INTO `contacto` VALUES (1,'email','mj@isel.pt'),(1,'tlmv','919999999'),(2,'tlmv','922222222');
