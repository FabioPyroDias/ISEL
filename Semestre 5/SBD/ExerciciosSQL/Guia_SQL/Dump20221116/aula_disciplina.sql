CREATE DATABASE  IF NOT EXISTS `aula` ;
USE `aula`;

--
-- Table structure for table `disciplina`
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE `disciplina` (
  `codigo` char(4) NOT NULL,
  `designacao` varchar(100) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `ak_designacao` (`designacao`)
);

--
-- Dumping data for table `disciplina`
--

LOCK TABLES `disciplina` WRITE;
INSERT INTO `disciplina` VALUES ('FSO','Fundamentos de Sistemas Operativos'),('SBD','Sistemas de Bases de Dados'),('SdI','Sistemas de Informação'),('SMI','Sistemas Multimédia para a Internet'),('TI','Tecnologias de Informação');
UNLOCK TABLES;
