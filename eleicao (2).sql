-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30-Set-2016 às 00:58
-- Versão do servidor: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eleicao`
--
CREATE DATABASE IF NOT EXISTS `eleicao` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `eleicao`;

DELIMITER $$
--
-- Functions
--
DROP FUNCTION IF EXISTS `quociente_eleitoral`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `quociente_eleitoral` (`vagas` INT) RETURNS INT(11) NO SQL
RETURN ROUND((SELECT SUM(votos) from partido) / vagas, 0)$$

DROP FUNCTION IF EXISTS `quociente_partidario`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `quociente_partidario` (`numero` INT, `quociente_eleitoral` INT) RETURNS INT(11) NO SQL
return FLOOR((SELECT votos from partido where partido.numero = numero) / quociente_eleitoral)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

DROP TABLE IF EXISTS `cidade`;
CREATE TABLE IF NOT EXISTS `cidade` (
  `id_cidade` int(11) NOT NULL AUTO_INCREMENT,
  `id_estado` int(11) NOT NULL,
  `nome` varchar(256) NOT NULL,
  PRIMARY KEY (`id_cidade`),
  KEY `id_estado` (`id_estado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `cidade`:
--   `id_estado`
--       `estado` -> `id_estado`
--   `id_estado`
--       `estado` -> `id_estado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `coligacao`
--

DROP TABLE IF EXISTS `coligacao`;
CREATE TABLE IF NOT EXISTS `coligacao` (
  `id_coligacao` int(11) NOT NULL AUTO_INCREMENT,
  `id_partido` int(11) NOT NULL,
  `nome_coligacao` varchar(256) NOT NULL,
  PRIMARY KEY (`id_coligacao`),
  UNIQUE KEY `nome_coligacao` (`nome_coligacao`),
  KEY `id_partido` (`id_partido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `coligacao`:
--   `id_partido`
--       `partido` -> `id_partido`
--   `id_partido`
--       `partido` -> `id_partido`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `eleitor`
--

DROP TABLE IF EXISTS `eleitor`;
CREATE TABLE IF NOT EXISTS `eleitor` (
  `id_eleitor` int(11) NOT NULL AUTO_INCREMENT,
  `id_cidade` int(11) NOT NULL,
  `nome` varchar(256) NOT NULL,
  `secao` int(11) NOT NULL,
  `zona` int(11) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  `data_cadastro` date NOT NULL,
  `votou` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_eleitor`),
  FOREIGN KEY `id_cidade` (`id_cidade`) REFERENCES `cidade`(`id_cidade`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `eleitor`:
--   `id_cidade`
--       `cidade` -> `id_cidade`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

DROP TABLE IF EXISTS `estado`;
CREATE TABLE IF NOT EXISTS `estado` (
  `id_estado` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(256) NOT NULL,
  `uf` varchar(2) NOT NULL,
  PRIMARY KEY (`id_estado`),
  UNIQUE KEY `uf` (`uf`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `estado`:
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `partido`
--

DROP TABLE IF EXISTS `partido`;
CREATE TABLE IF NOT EXISTS `partido` (
  `id_partido` int(11) NOT NULL AUTO_INCREMENT,
  `nome_partido` varchar(256) NOT NULL,
  `sigla` varchar(6) NOT NULL,
  `slogan` varchar(256) DEFAULT NULL,
  `numero` int(11) NOT NULL,
  `logo` longblob,
  `data_criacao` date DEFAULT NULL,
  `votos` int(11) DEFAULT '0',
  PRIMARY KEY (`id_partido`),
  UNIQUE KEY `numero` (`numero`),
  UNIQUE KEY `sigla` (`sigla`),
  UNIQUE KEY `nome_partido` (`nome_partido`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `partido`:
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `prefeito`
--

DROP TABLE IF EXISTS `prefeito`;
CREATE TABLE IF NOT EXISTS `prefeito` (
  `id_prefeito` int(11) NOT NULL AUTO_INCREMENT,
  `id_partido` int(11) NOT NULL,
  `nome` varchar(256) NOT NULL,
  `idade` int(11) NOT NULL DEFAULT '21',
  `numero` int(11) NOT NULL,
  `foto` longblob,
  `votos` int(11) DEFAULT '0',
  PRIMARY KEY (`id_prefeito`),
  UNIQUE KEY `UNIQUE` (`numero`),
  KEY `id_partido` (`id_partido`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `prefeito`:
--   `id_partido`
--       `partido` -> `id_partido`
--   `numero`
--       `partido` -> `numero`
--   `id_partido`
--       `partido` -> `id_partido`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nome` int(11) NOT NULL,
  `login` varchar(40) NOT NULL,
  `senha` varchar(40) NOT NULL,
  `perfil` varchar(40) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `usuario`:
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `vereador`
--

DROP TABLE IF EXISTS `vereador`;
CREATE TABLE IF NOT EXISTS `vereador` (
  `id_vereador` int(11) NOT NULL AUTO_INCREMENT,
  `id_partido` int(11) NOT NULL,
  `nome` varchar(256) NOT NULL,
  `numero` int(11) NOT NULL,
  `foto` longblob,
  `votos` int(11) DEFAULT '0',
  PRIMARY KEY (`id_vereador`),
  UNIQUE KEY `numero` (`numero`),
  KEY `id_partido` (`id_partido`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `vereador`:
--   `id_partido`
--       `partido` -> `id_partido`
--   `id_partido`
--       `partido` -> `id_partido`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `vice_prefeito`
--

DROP TABLE IF EXISTS `vice_prefeito`;
CREATE TABLE IF NOT EXISTS `vice_prefeito` (
  `id_vice` int(11) NOT NULL AUTO_INCREMENT,
  `id_partido` int(11) NOT NULL,
  `id_prefeito` int(11) NOT NULL,
  `nome` varchar(256) NOT NULL,
  `foto` longblob,
  PRIMARY KEY (`id_vice`),
  KEY `id_partido` (`id_partido`),
  KEY `id_prefeito` (`id_prefeito`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `vice_prefeito`:
--   `id_partido`
--       `partido` -> `id_partido`
--   `id_prefeito`
--       `prefeito` -> `id_prefeito`
--   `id_partido`
--       `partido` -> `id_partido`
--   `id_prefeito`
--       `prefeito` -> `id_prefeito`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `voto_branco`
--

DROP TABLE IF EXISTS `voto_branco`;
CREATE TABLE IF NOT EXISTS `voto_branco` (
  `voto_branco_prefeito` int(11) NOT NULL DEFAULT '0',
  `voto_branco_vereador` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `voto_branco`:
--

--
-- Extraindo dados da tabela `voto_branco`
--

INSERT INTO `voto_branco` (`voto_branco_prefeito`, `voto_branco_vereador`) VALUES
(0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `voto_nulo`
--

DROP TABLE IF EXISTS `voto_nulo`;
CREATE TABLE IF NOT EXISTS `voto_nulo` (
  `voto_nulo_prefeito` int(11) NOT NULL DEFAULT '0',
  `voto_nulo_vereador` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `voto_nulo`:
--

--
-- Extraindo dados da tabela `voto_nulo`
--

INSERT INTO `voto_nulo` (`voto_nulo_prefeito`, `voto_nulo_vereador`) VALUES
(0, 0);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `cidade`
--
ALTER TABLE `cidade`
  ADD CONSTRAINT `cidade_ibfk_1` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id_estado`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `coligacao`
--
ALTER TABLE `coligacao`
  ADD CONSTRAINT `coligacao_ibfk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id_partido`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `prefeito`
--
ALTER TABLE `prefeito`
  ADD CONSTRAINT `prefeito_ibfk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id_partido`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `vereador`
--
ALTER TABLE `vereador`
  ADD CONSTRAINT `vereador_ibfk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id_partido`) ON DELETE CASCADE;

--
-- Limitadores para a tabela `vice_prefeito`
--
ALTER TABLE `vice_prefeito`
  ADD CONSTRAINT `vice_prefeito_ibfk_1` FOREIGN KEY (`id_partido`) REFERENCES `partido` (`id_partido`) ON DELETE CASCADE,
  ADD CONSTRAINT `vice_prefeito_ibfk_2` FOREIGN KEY (`id_prefeito`) REFERENCES `prefeito` (`id_prefeito`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
