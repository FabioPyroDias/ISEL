CREATE DATABASE  IF NOT EXISTS `aula` ;
USE `aula`;
--
-- Table structure for table `inscricao`
--

DROP TABLE IF EXISTS `inscricao`;
CREATE TABLE `inscricao` (
  `numero` decimal(5,0) NOT NULL,
  `codigo` char(4) NOT NULL,
  `ano` int NOT NULL,
  `nota` decimal(3,1) DEFAULT NULL,
  PRIMARY KEY (`numero`,`codigo`,`ano`),
  KEY `fk_disciplina` (`codigo`),
  CONSTRAINT `fk_aluno` FOREIGN KEY (`numero`) REFERENCES `aluno` (`numero`) ON UPDATE CASCADE,
  CONSTRAINT `fk_disciplina` FOREIGN KEY (`codigo`) REFERENCES `disciplina` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `inscricao_chk_1` CHECK (((`ano` > 2000) and (`ano` < 2100))),
  CONSTRAINT `inscricao_chk_2` CHECK (((`nota` >= 10) and (`nota` <= 20)))
);

--
-- Dumping data for table `inscricao`
--

LOCK TABLES `inscricao` WRITE;
INSERT INTO `inscricao` VALUES (1,'SBD',2017,NULL),(2,'SBD',2017,10.0),(3,'SBD',2018,15.0),(4,'SBD',2018,11.0),(6,'SBD',2018,NULL),(7,'SBD',2018,18.0),(8,'SBD',2018,15.0),(9,'SBD',2018,13.0),(10,'SBD',2019,NULL),(10,'SdI',2019,NULL),(10,'SMI',2019,NULL),(10,'TI',2019,NULL),(11,'SBD',2018,14.2),(12,'SBD',2018,18.0),(13,'SBD',2019,16.0),(13,'SBD',2021,15.0),(14,'SdI',2018,14.0),(15,'SBD',2022,NULL),(15,'SdI',2017,15.0),(16,'SdI',2018,11.0),(18,'SdI',2018,11.0),(19,'SdI',2018,13.1),(20,'SdI',2017,16.0),(21,'SdI',2018,17.0),(22,'SdI',2017,13.0),(25,'TI',2021,12.0),(26,'SdI',2017,NULL),(26,'SMI',2021,15.0),(26,'TI',2021,NULL),(27,'SBD',2022,NULL),(27,'SdI',2022,NULL),(27,'SMI',2021,11.0),(27,'TI',2021,14.0);
UNLOCK TABLES;


