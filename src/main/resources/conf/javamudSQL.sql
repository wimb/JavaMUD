-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------

-- Server version	5.6.13



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema javamud
--
DROP DATABASE IF EXISTS javamud;
CREATE DATABASE IF NOT EXISTS javamud;
USE javamud;

--
-- Definition of table `boek`
--

DROP TABLE IF EXISTS `boek`;
CREATE TABLE `boek` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `boekitemidfk` FOREIGN KEY (`id`) REFERENCES `item` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `boek`
--

/*!40000 ALTER TABLE `boek` DISABLE KEYS */;

INSERT INTO `boek` (`id`) VALUES 
 (2);
/*!40000 ALTER TABLE `boek` ENABLE KEYS */;


--
-- Definition of table `gebruiker`
--

DROP TABLE IF EXISTS `gebruiker`;
CREATE TABLE `gebruiker` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emailadres` varchar(50) NOT NULL,
  `voornaam` varchar(50) NOT NULL,
  `familienaam` varchar(50) NOT NULL,
  `paswoord` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `gebruiker`
--

/*!40000 ALTER TABLE `gebruiker` DISABLE KEYS */;
INSERT INTO `gebruiker` (`Id`,`emailadres`,`voornaam`,`familienaam`,`paswoord`) VALUES 
 (1,'johnny.test@nick.com','Jonathan','Test','3b2fddbf99578c473ad43f0e8059bf066084638a'),
 (2,'test@test.test','test','test','b3872a330a7b142f3fda8697673a123d4bb2f514');
/*!40000 ALTER TABLE `gebruiker` ENABLE KEYS */;


--
-- Definition of table `heeftitems`
--

DROP TABLE IF EXISTS `heeftitems`;
CREATE TABLE `heeftitems` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `heeftitems`
--

/*!40000 ALTER TABLE `heeftitems` DISABLE KEYS */;
INSERT INTO `heeftitems` (`Id`) VALUES 
 (1),
 (2),
 (3),
 (4),
 (5),
 (6),
 (7),
 (10),
 (11),
 (12),
 (13),
 (14),
 (16);
/*!40000 ALTER TABLE `heeftitems` ENABLE KEYS */;


--
-- Definition of table `iseigenaarvan`
--

DROP TABLE IF EXISTS `iseigenaarvan`;
CREATE TABLE `iseigenaarvan` (
  `eigenaarID` int(10) unsigned NOT NULL,
  `itemID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`eigenaarID`,`itemID`),
  CONSTRAINT `EigenaarHeeftItemFK` FOREIGN KEY (`eigenaarID`) REFERENCES `heeftitems` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `EigenaarItemFK` FOREIGN KEY (`itemID`) REFERENCES `item` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `iseigenaarvan`
--

/*!40000 ALTER TABLE `iseigenaarvan` DISABLE KEYS */;
INSERT INTO `iseigenaarvan` (`eigenaarID`,`itemID`) VALUES 
 (1,1),
 (1,2),
 (1,100);
/*!40000 ALTER TABLE `iseigenaarvan` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Omschrijving` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)

) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`Id`,`Omschrijving`) VALUES 
 (1,'Knuppel'),
 (2,'Ladder'),
 (100,'Boek');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `karakter`
--

DROP TABLE IF EXISTS `karakter`;
CREATE TABLE `karakter` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `gebruikerId` int(10) unsigned NOT NULL,
  `lokatieId` int(10) unsigned DEFAULT NULL,
  `naam` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `KarakterGebruiker` (`gebruikerId`),
  KEY `KarakterLokatie` (`lokatieId`),
  CONSTRAINT `KarakterGebruikerFK` FOREIGN KEY (`gebruikerId`) REFERENCES `gebruiker` (`Id`),
  CONSTRAINT `KarakterItemFK` FOREIGN KEY (`Id`) REFERENCES `heeftitems` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `KarakterLokatieFK` FOREIGN KEY (`lokatieId`) REFERENCES `lokatie` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `karakter`
--

/*!40000 ALTER TABLE `karakter` DISABLE KEYS */;
INSERT INTO `karakter` (`Id`,`gebruikerId`,`lokatieId`,`naam`) VALUES 
 (7,1,1,'Testaenar'),
 (12,1,1,'Test'),
 (16,2,1,'test');
/*!40000 ALTER TABLE `karakter` ENABLE KEYS */;


--
-- Definition of table `knuppel`
--

DROP TABLE IF EXISTS `knuppel`;
CREATE TABLE `knuppel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  CONSTRAINT `knuppelitemidfk` FOREIGN KEY (`id`) REFERENCES `item` (`Id`)

) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


--
-- Dumping data for table `knuppel`
--

/*!40000 ALTER TABLE `knuppel` DISABLE KEYS */;
INSERT INTO `knuppel` (`id`) VALUES 
 (1);
/*!40000 ALTER TABLE `knuppel` ENABLE KEYS */;


--
-- Definition of table `ladder`
--

DROP TABLE IF EXISTS `ladder`;
CREATE TABLE `ladder` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ladder`
--

/*!40000 ALTER TABLE `ladder` DISABLE KEYS */;
INSERT INTO `ladder` (`id`) VALUES 
 (100);
/*!40000 ALTER TABLE `ladder` ENABLE KEYS */;


--
-- Definition of table `lokatie`
--

DROP TABLE IF EXISTS `lokatie`;
CREATE TABLE `lokatie` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Beschrijving` varchar(140) NOT NULL DEFAULT 'geen omschrijving',
  PRIMARY KEY (`Id`),
  CONSTRAINT `LokatieItemFK` FOREIGN KEY (`Id`) REFERENCES `heeftitems` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lokatie`
--

/*!40000 ALTER TABLE `lokatie` DISABLE KEYS */;
INSERT INTO `lokatie` (`Id`,`Beschrijving`) VALUES 
 (1,'Kelder'),
 (2,'Hoofdingang'),
 (3,'Straat'),
 (4,'Keuken'),
 (5,'Slaapkamer'),
 (6,'Tuin'),
 (14,'Zolder');
/*!40000 ALTER TABLE `lokatie` ENABLE KEYS */;


--
-- Definition of table `lokatiebestemmingen`
--

DROP TABLE IF EXISTS `lokatiebestemmingen`;
CREATE TABLE `lokatiebestemmingen` (
  `LokatieId` int(10) unsigned NOT NULL,
  `BestemmingId` int(10) unsigned NOT NULL,
  `Omschrijving` varchar(150) NOT NULL DEFAULT 'geen omschrijving',
  PRIMARY KEY (`LokatieId`,`BestemmingId`),
  KEY `BestemmingKey` (`BestemmingId`),
  CONSTRAINT `BestemmingKeyFK` FOREIGN KEY (`BestemmingId`) REFERENCES `lokatie` (`Id`),
  CONSTRAINT `LokatieKeyFK` FOREIGN KEY (`LokatieId`) REFERENCES `lokatie` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lokatiebestemmingen`
--

/*!40000 ALTER TABLE `lokatiebestemmingen` DISABLE KEYS */;
INSERT INTO `lokatiebestemmingen` (`LokatieId`,`BestemmingId`,`Omschrijving`) VALUES 
 (1,2,'Trap op'),
 (2,1,'Naar de kelder'),
 (2,3,'Naar buiten'),
 (2,4,'Naar de keuken'),
 (2,5,'Naar de slaapkamer'),
 (3,2,'Naar binnen'),
 (3,6,'Naar de tuin'),
 (4,2,'Naar de hoofdingang'),
 (4,6,'Naar de tuin'),
 (5,2,'Naar de hoofdingang'),
 (6,3,'Naar de straat'),
 (6,4,'Naar de keuken');
/*!40000 ALTER TABLE `lokatiebestemmingen` ENABLE KEYS */;


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
