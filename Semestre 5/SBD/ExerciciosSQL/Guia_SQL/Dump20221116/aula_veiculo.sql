CREATE DATABASE  IF NOT EXISTS `aula` ;
USE `aula`;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
CREATE TABLE `veiculo` (
  `matricula` varchar(10) NOT NULL,
  `Marca` varchar(80) DEFAULT NULL,
  `Modelo` varchar(80) DEFAULT NULL,
  `Cor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
);

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
INSERT INTO `veiculo` VALUES ('11AA11','Renault','Clio','vermelho'),('66FF66','BMW','S2','azul'),('77GG77','BMW','S2','branco'),('BB2222','Kia','Ceed','branco'),('CC3333','Mercedes','A','branco'),('DD4444','BMW','S1','preto'),('EE5555','BMW','S2','vermelho');
UNLOCK TABLES;
