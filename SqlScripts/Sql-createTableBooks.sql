CREATE DATABASE  IF NOT EXISTS `CRUD-Hib-ConsoleApp`;
USE `CRUD-Hib-ConsoleApp`;

--
-- Table structure for table `Books`
--

DROP TABLE IF EXISTS `Books`;

CREATE TABLE `Books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `release_date` int(11) NOT NULL,
  `pages` int(11) NOT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `isbn` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

