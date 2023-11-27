CREATE DATABASE  IF NOT EXISTS `aula` ;
USE `aula`;

--
-- Table structure for table `aluno_veiculo`
--

DROP TABLE IF EXISTS `aluno_veiculo`;
CREATE TABLE `aluno_veiculo` (
  `aluno` decimal(5,0) NOT NULL,
  `veiculo` varchar(10) NOT NULL,
  PRIMARY KEY (`aluno`,`veiculo`),
  KEY `fk_aluno_veiculo_veiculo_idx` (`veiculo`),
  CONSTRAINT `fk_aluno_veiculo_aluno` FOREIGN KEY (`aluno`) REFERENCES `aluno` (`numero`),
  CONSTRAINT `fk_aluno_veiculo_veiculo` FOREIGN KEY (`veiculo`) REFERENCES `veiculo` (`matricula`)
);

--
-- Dumping data for table `aluno_veiculo`
--

LOCK TABLES `aluno_veiculo` WRITE;
INSERT INTO `aluno_veiculo` VALUES (27,'11AA11'),(26,'CC3333'),(25,'DD4444');
UNLOCK TABLES;
