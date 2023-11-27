CREATE DATABASE  IF NOT EXISTS `aula` ;
USE `aula`;

--
-- Table structure for table `aluno`
--

DROP TABLE IF EXISTS `aluno`;
CREATE TABLE `aluno` (
  `numero` decimal(5,0) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `genero` char(1) NOT NULL,
  `nascido` date NOT NULL,
  `telemovel` varchar(15) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE KEY `telemovel_UNIQUE` (`telemovel`),
  CONSTRAINT `chk_genero` CHECK ((`genero` in (_utf8mb4'F',_utf8mb4'M'))),
  CONSTRAINT `chk_nome` CHECK ((not(regexp_like(`nome`,_utf8mb4'[^a-z \'àáãâéêíóõôúçñ-]'))))
);

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
INSERT INTO `aluno` VALUES (1,'ABEL ALVES BOTELHO','M','1980-10-20',NULL,NULL),(2,'Abel Alves da Costa Pina','M','1971-05-04',NULL,NULL),(3,'ABILIO DOS SANTOS PINTO','M','1964-01-14',NULL,NULL),(4,'Abílio Pires dos Santos','M','1975-01-06',NULL,NULL),(5,'ACACIO CARDOSO DA ROCHA','M','1977-12-16',NULL,NULL),(6,'Acácio Cardoso do Nascimento','M','1967-02-01',NULL,NULL),(7,'Adalberto Luís Marques Rabaça','M','1966-12-27',NULL,NULL),(8,'ADALBERTO LUIS MARTINHO DE MELO','M','1966-12-15',NULL,NULL),(9,'ADAO DE ALMEIDA SILVARES','M','1974-02-28',NULL,NULL),(10,'Adao de Almeida Vasconcelos','M','1968-06-08',NULL,NULL),(11,'ADAO FINO DA COSTA','M','1965-09-30',NULL,NULL),(12,'Adélia Oliveira Pereira','F','1965-07-30',NULL,NULL),(13,'ADELIA MARIA VAZ PESTANA SETE DIAS','F','1973-10-30',NULL,NULL),(14,'ADERITO AUGUSTO FERREIRINHA','M','1963-03-18',NULL,NULL),(15,'Adérito Augusto Figueira','M','1972-07-07',NULL,NULL),(16,'ZACARIAS MACHADO FERREIRA','M','1972-04-07',NULL,NULL),(17,'ZACARIAS MAGALHAES FERNANDES','M','1972-04-16',NULL,NULL),(18,'Zélia Maria Lima da Costa','F','1971-07-02',NULL,NULL),(19,'Zélia Maria Lopes Dias Moreira','F','1957-08-07',NULL,NULL),(20,'Álvaro Silva d\'Almeida','M','1958-09-07',NULL,NULL),(21,'António Fagundes Fraga','M','1959-11-07',NULL,NULL),(22,'Abreu Oliveira Antunes','M','1960-01-07',NULL,NULL),(23,'ABEL JORGE DE ALPOIM E OSORIO DE VALDOLEIROS','M','2000-01-01',NULL,NULL),(24,'ADILSON SALVE-RAINHA VICENTE','M','2000-04-01',NULL,NULL),(25,'AFONSO MARIA PERESTRELLO CORTE-REAL PERDIGÃO','M','2000-03-01',NULL,NULL),(26,'PORFIRIO DE VASCONCELOS DIAS DOS SANTOS CARNEIRO','M','2000-05-01',NULL,NULL),(27,'Manel Jaquim','M','1998-01-01','919191911',NULL);
UNLOCK TABLES;
