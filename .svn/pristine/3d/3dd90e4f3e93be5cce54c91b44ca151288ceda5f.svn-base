# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.10)
# Database: nbadatabase5
# Generation Time: 2013-05-28 18:31:24 -0700
# ************************************************************

CREATE DATABASE  IF NOT EXISTS `NBADataBase` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `NBADataBase`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Agent
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Agent`;

CREATE TABLE `Agent` (
  `agentName` varchar(45) DEFAULT NULL,
  `agentEmail` varchar(45) NOT NULL DEFAULT '',
  `agency` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`agentEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Agent` WRITE;
/*!40000 ALTER TABLE `Agent` DISABLE KEYS */;

INSERT INTO `Agent` (`agentName`, `agentEmail`, `agency`, `phone`)
VALUES
	('Allen Goodwrite','allen@NBAagent.com','NBA Agency','444-444-4444'),
	('Brian Williams','brian@Agency.com','NBA2 Agency','222-222-2222'),
	('Steve Bobby','steve@NBAagent.com','NBA Agency','333-333-3333');

/*!40000 ALTER TABLE `Agent` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Arena
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Arena`;

CREATE TABLE `Arena` (
  `arenaID` int(11) NOT NULL DEFAULT '0',
  `arenaName` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`arenaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Arena` WRITE;
/*!40000 ALTER TABLE `Arena` DISABLE KEYS */;

INSERT INTO `Arena` (`arenaID`, `arenaName`, `city`, `capacity`)
VALUES
	(1234,'Staples Center','Los Angeles',30000),
	(1235,'Air Canada Centre','Toronto',25000),
	(1236,'Rose Garden','Portland',25000),
	(1237,'American Airlines Arena','Miami',19600),
	(1238,'American Airlines Center','Dallas',20000),
	(1239,'Amway Center','Orlando',19000),
	(1240,'AT&T Center','San Antonio',19000),
	(1241,'Bankers Life Fieldhouse','Indianapolis',18000),
	(1242,'Barclays Center','Brooklyn',17000),
	(1243,'BMO Harris Bradley','Milwaukee',18000),
	(1244,'Chesapeake Energy Arena','Oklahoma City',18000),
	(1245,'EnergySolutions Arena','Salt Lake City',20000),
	(1246,'FedExFormum','Memphis',18000),
	(1247,'Madison Square Garden','New York',20000),
	(1248,'New Orleans Arena','New Orleans',17000),
	(1249,'Oracle Arena','Oakland',19500),
	(1250,'Pepsi Center','Denver',19155),
	(1251,'Philips Arena','Atlanta',18000),
	(1252,'Quicken Loans Arena','Cleveland',20000),
	(1253,'Sleep Train Arena','Sacramento',17000),
	(1254,'Target Center','Minneapolis',19000),
	(1255,'TD Garden','Boston',18500),
	(1266,'The Palace of Auburn Hills','Auburn Hills',22000),
	(1267,'The Warner Cable Arena','Charlotte',19000),
	(1268,'Toyota Center','Houston',18000),
	(1269,'United Center','Chicago',19000),
	(1270,'US Airways Center','Phoenix',18000),
	(1271,'Verizon Center','Washington DC',20000),
	(1272,'Wells Fargo Center','Philadelphia',20000);

/*!40000 ALTER TABLE `Arena` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table BoxScore
# ------------------------------------------------------------

DROP TABLE IF EXISTS `BoxScore`;

CREATE TABLE `BoxScore` (
  `gameID` int(11) NOT NULL DEFAULT '0',
  `playerID` int(11) NOT NULL DEFAULT '0',
  `minutes` int(11) DEFAULT NULL,
  `blocks` int(11) DEFAULT NULL,
  `steals` int(11) DEFAULT NULL,
  `assist` int(11) DEFAULT NULL,
  `offRebounds` int(11) DEFAULT NULL,
  `defRebounds` int(11) DEFAULT NULL,
  `turnovers` int(11) DEFAULT NULL,
  `FTM` int(11) DEFAULT NULL,
  `FTA` int(11) DEFAULT NULL,
  `FGM` int(11) DEFAULT NULL,
  `FGA` int(11) DEFAULT NULL,
  `3PM` int(11) DEFAULT NULL,
  `3PA` int(11) DEFAULT NULL,
  `ejections` int(11) DEFAULT NULL,
  `technicals` int(11) DEFAULT NULL,
  `flagrant` int(11) DEFAULT NULL,
  `personalFouls` int(11) DEFAULT NULL,
  PRIMARY KEY (`gameID`,`playerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `BoxScore` WRITE;
/*!40000 ALTER TABLE `BoxScore` DISABLE KEYS */;

INSERT INTO `BoxScore` (`gameID`, `playerID`, `minutes`, `blocks`, `steals`, `assist`, `offRebounds`, `defRebounds`, `turnovers`, `FTM`, `FTA`, `FGM`, `FGA`, `3PM`, `3PA`, `ejections`, `technicals`, `flagrant`, `personalFouls`)
VALUES
	(120,1,30,0,1,12,3,3,0,1,2,10,12,0,1,0,0,0,2),
	(120,2,33,4,5,13,1,14,4,12,19,12,19,2,4,0,0,0,3),
	(121,2,30,3,4,8,12,11,1,12,18,19,22,1,1,0,1,1,4),
	(121,3,30,2,2,3,10,1,4,12,19,14,29,3,5,0,1,1,4),
	(122,1,47,3,8,3,7,2,8,2,8,23,28,1,8,1,1,0,1),
	(122,3,39,9,8,7,12,18,8,19,22,3,9,1,1,0,1,3,3),
	(123,1,44,7,3,6,12,11,6,8,9,23,29,5,5,0,1,1,4),
	(123,5,35,7,9,6,3,1,2,12,19,21,28,2,8,0,1,0,3),
	(300,6,21,0,3,3,3,2,2,2,3,12,15,3,5,0,0,0,2),
	(300,7,13,0,1,1,2,1,1,3,4,11,15,3,5,0,0,0,1),
	(300,8,15,0,2,2,4,3,2,1,2,14,15,3,5,0,0,0,2),
	(300,9,35,3,1,4,2,1,1,3,3,15,18,3,5,0,0,0,1),
	(300,10,34,2,2,2,4,2,21,3,3,15,18,3,5,0,1,0,2),
	(300,11,26,0,1,4,42,1,1,2,2,11,13,3,5,0,0,0,3),
	(300,12,39,0,0,2,2,1,2,3,3,15,22,3,5,0,0,0,2),
	(300,13,21,1,2,4,1,3,1,4,4,16,22,3,5,0,0,0,3),
	(300,14,33,3,3,2,2,2,1,2,2,17,22,3,5,0,0,0,2),
	(300,15,10,5,1,2,3,1,21,4,4,22,22,3,5,0,0,0,1);

/*!40000 ALTER TABLE `BoxScore` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Contract
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Contract`;

CREATE TABLE `Contract` (
  `contractID` int(11) NOT NULL DEFAULT '0',
  `playerID` int(11) NOT NULL DEFAULT '0',
  `startYear` int(11) DEFAULT NULL,
  `endYear` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`contractID`,`playerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Contract` WRITE;
/*!40000 ALTER TABLE `Contract` DISABLE KEYS */;

INSERT INTO `Contract` (`contractID`, `playerID`, `startYear`, `endYear`, `salary`)
VALUES
	(100,1,2000,2005,2000000),
	(101,2,2005,2008,10000000),
	(102,3,1992,1995,10000000),
	(103,1,2008,2015,200000000),
	(104,5,2009,2009,30000000);

/*!40000 ALTER TABLE `Contract` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Game
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Game`;

CREATE TABLE `Game` (
  `team1ID` int(11) NOT NULL DEFAULT '0',
  `team2ID` int(11) NOT NULL DEFAULT '0',
  `date` int(11) NOT NULL DEFAULT '0',
  `gameID` int(11) DEFAULT NULL,
  PRIMARY KEY (`team1ID`,`team2ID`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Game` WRITE;
/*!40000 ALTER TABLE `Game` DISABLE KEYS */;

INSERT INTO `Game` (`team1ID`, `team2ID`, `date`, `gameID`)
VALUES
	(1,2,2010,300),
	(5,14,2013,122),
	(5,16,2013,121),
	(14,16,2012,120),
	(14,29,2013,123);
/*!40000 ALTER TABLE `Game` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Manager
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Manager`;

CREATE TABLE `Manager` (
  `playerID` int(11) NOT NULL DEFAULT '0',
  `agentEmail` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`playerID`,`agentEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Manager` WRITE;
/*!40000 ALTER TABLE `Manager` DISABLE KEYS */;

INSERT INTO `Manager` (`playerID`, `agentEmail`)
VALUES
	(1,'steve@NBAagent.com'),
	(2,'steve@NBAagent.com'),
	(4,'brian@Agency.com'),
	(3,'brian@Agency.com');

/*!40000 ALTER TABLE `Manager` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Player
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Player`;

CREATE TABLE `Player` (
  `playerID` int(11) NOT NULL DEFAULT '0',
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `nationality` varchar(45) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `college` varchar(45) DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `ethnicity` varchar(45) DEFAULT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`playerID`),
  UNIQUE KEY `playerID_UNIQUE` (`playerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Player` WRITE;
/*!40000 ALTER TABLE `Player` DISABLE KEYS */;

INSERT INTO `Player` (`playerID`, `firstName`, `lastName`, `nationality`, `weight`, `position`, `college`, `height`, `ethnicity`, `birthday`)
VALUES
	(1,'Kobe','Bryant','American',240,'Guard','N/A','1.98','Black','1980'),
	(2,'Lebron','James','American',230,'Foward','N/A','2.03','Black','1980'),
	(3,'Michael','Jordan','American',230,'Guard','North Carolina','1.98','Black','1960'),
	(4,'Jason','Williams','American',200,'Guard','Duke','1.88','Black','1982'),
	(5,'Marvin','Williams','American',230,'Forward','North Carolina','2.06','Black','1986'),
	(6,'Joe','Johnson',NULL,210,'Guard',NULL,NULL,NULL,NULL),
	(7,'Josh','Smith',NULL,213,'Forward',NULL,NULL,NULL,NULL),
	(8,'Jason ','Collins',NULL,190,'Center',NULL,NULL,NULL,NULL),
	(9,'Kirk','Hinrich',NULL,124,'Guard',NULL,NULL,NULL,NULL),
	(10,'Jeff','Teague',NULL,412,'Guad',NULL,NULL,NULL,NULL),
	(11,'Eric','Dampler',NULL,123,'Center',NULL,NULL,NULL,NULL),
	(12,'Tracy','McGrady',NULL,146,'Guard',NULL,NULL,NULL,NULL),
	(13,'Willie','Green',NULL,254,'Guard',NULL,NULL,NULL,NULL),
	(14,'Jannero','Pargo',NULL,232,'Guard',NULL,NULL,NULL,NULL),
	(15,'Marvin ','Williams',NULL,222,'Forward',NULL,NULL,NULL,NULL);

/*!40000 ALTER TABLE `Player` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table PlaysAt
# ------------------------------------------------------------

DROP TABLE IF EXISTS `PlaysAt`;

CREATE TABLE `PlaysAt` (
  `arenaID` int(11) NOT NULL DEFAULT '0',
  `teamID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`arenaID`,`teamID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `PlaysAt` WRITE;
/*!40000 ALTER TABLE `PlaysAt` DISABLE KEYS */;

INSERT INTO `PlaysAt` (`arenaID`, `teamID`)
VALUES
	(1234,14),
	(1237,16),
	(1245,29),
	(1269,5);

/*!40000 ALTER TABLE `PlaysAt` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table PlaysFor
# ------------------------------------------------------------

DROP TABLE IF EXISTS `PlaysFor`;

CREATE TABLE `PlaysFor` (
  `playerID` int(11) NOT NULL DEFAULT '0',
  `year` int(11) NOT NULL DEFAULT '0',
  `teamID` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`playerID`,`year`,`teamID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `PlaysFor` WRITE;
/*!40000 ALTER TABLE `PlaysFor` DISABLE KEYS */;

INSERT INTO `PlaysFor` (`playerID`, `year`, `teamID`)
VALUES
	(1,2013,14),
	(2,2006,6),
	(2,2012,16),
	(3,1992,5),
	(3,2013,5),
	(4,2006,5),
	(5,2010,1),
	(6,2010,1),
	(7,2010,1),
	(8,2010,1),
	(9,2010,1),
	(10,2010,1),
	(11,2010,2),
	(12,2010,2),
	(13,2010,2),
	(14,2010,2),
	(15,2010,2);
/*!40000 ALTER TABLE `PlaysFor` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Team
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Team`;

CREATE TABLE `Team` (
  `TeamID` int(11) NOT NULL AUTO_INCREMENT,
  `teamName` char(60) DEFAULT NULL,
  `Owner` char(150) DEFAULT NULL,
  `division` char(60) DEFAULT NULL,
  `city` char(60) DEFAULT NULL,
  `conference` char(60) DEFAULT NULL,
  `mascot` char(60) DEFAULT NULL,
  PRIMARY KEY (`TeamID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Team` WRITE;
/*!40000 ALTER TABLE `Team` DISABLE KEYS */;

INSERT INTO `Team` (`TeamID`, `teamName`, `Owner`, `division`, `city`, `conference`, `mascot`)
VALUES
	(1,'Atlanta Hawks','Michael Gearon Jr','Southeast','Atlanta','Eastern','Skyhawk'),
	(2,'Boston Celtics','H. Irving Grousbeck, Wycliffe Grousbeck, Steve Pagliuca','Atlantic','Boston','Eastern','Leprechaun'),
	(3,'Brooklyn Nets','Mikhail Prokhorov, Bruce Ratner','Atlantic','Brooklyn','Eastern','BrooklyKnight'),
	(4,'Charlotte Bobcats','Michael Jordan','Southeast','Charlotte','Eastern','Lynx'),
	(5,'Chicago Bulls','Jerry Reinsdorf','Central','Chicago','Eastern','Bull'),
	(6,'Cleveland Cavaliers','Dan Gilbert, Gary Gilbert, Dan Katzman, Usher Raymond, Gordon Gund','Central','Cleveland','Eastern','Moondog'),
	(7,'Dallas Mavericks','Mark Cuban Dallas Basketball Limited 2000','Southwest','Dallas','Western','Champ'),
	(8,'Denver Nuggets','Stan Kroenke','Northwest','Denver','Western','Lion'),
	(9,'Detroit Pistons','Tom Gores','Central','Auburn Hills','Eastern','Hooper'),
	(10,'Golden State Warriors','Peter Guber','Pacific','Oakland','Western','none'),
	(11,'Houston Rockets','Leslie Alexander','Southwest','Houston','Western','Bear'),
	(12,'Indiana Pacers','Herbert Simon','Central','Indianapolis','Eastern','Boomer'),
	(13,'Los Angeles Clippers','Donald Sterling','Pacific','Los Angeles','Western','none'),
	(14,'Los Angeles Lakers','Jerry Buss family trust','Pacific','Los Angeles','Western','none'),
	(15,'Memphis Grizzlies','Robert J. Pera','Southwest','Memphis','Western','Grizz'),
	(16,'Miami Heat','Micky Arison','Southeast','Miami','Eastern','Burnie'),
	(17,'Milwaukee Bucks','Herb Kohl','Central','Milwaukee','Eastern','Bango The Buck'),
	(18,'Minnesota Timberwolves','Glen Taylor','Northwest','Minneapolis','Western','Wolf'),
	(19,'New Orleans Pelicans','Tom Benson','Southwest','New Orleans','Western','TBA'),
	(20,'New York Knicks','James Dolan','Atlantic','New York','Eastern','none'),
	(21,'Oklahoma City Thunder','Clayton Bennett','Northwest','Oklahoma City','Western','Bison'),
	(22,'Orlando Magic','RDV Sports, Inc. (Richard DeVos, Chairman','Southeast','Orlando','Eastern','Dragon'),
	(23,'Philadelphia 76ers','Joshua Harris, Adam Aron','Atlantic','Philadelphia','Eastern','TBD'),
	(24,'Phoenix Suns','Robert Sarver','Pacific','Phoenix','Western','Gorilla'),
	(25,'Portland Trail Blazers','Paul Allen','Northwest','Portland','Western','Cat'),
	(26,'Sacramento Kings','Joe Maloof, Gavin Maloof','Pacific','Sacramento','Western','Lion'),
	(27,'San Antonio Spurs','Peter Holt','Southwest','San Antonio','Western','Coyote'),
	(28,'Toronto Raptors','Richard Peddie','Atlantic','Toronto','Eastern','Raptor'),
	(29,'Utah Jazz','Greg Miller, Larry H. Miller','Northwest','Salt Lake City','Western','Bear'),
	(30,'Washington Wizards','Ted Leonsis','Southeast','Washington DC','Eastern','G-Wiz');

/*!40000 ALTER TABLE `Team` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
