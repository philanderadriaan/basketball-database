
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

INSERT INTO `Team` (`teamName`, `Owner`, `division`, `city`, `conference`, `mascot`)
VALUES
 
 ('Atlanta Hawks',  		'Michael Gearon Jr', NULL, NULL, NULL, NULL),
 ('Boston Celtics',  		'H. Irving Grousbeck, Wycliffe Grousbeck, Steve Pagliuca', NULL, NULL, NULL, NULL),
 ('Brooklyn Nets',  		'Mikhail Prokhorov, Bruce Ratner ', NULL, NULL, NULL, NULL),
 ('Charlotte Bobcats', 		'Michael Jordan', NULL, NULL, NULL, NULL),
 ('Chicago Bulls',  		'Jerry Reinsdorf', NULL, NULL, NULL, NULL),
 ('Cleveland Cavaliers',	'Dan Gilbert, Gary Gilbert, Dan Katzman, Usher Raymond, Gordon Gund ', NULL, NULL, NULL, NULL),
 ('Dallas Mavericks ', 		'Mark Cuban Dallas Basketball Limited 2000', NULL, NULL, NULL, NULL),
 ('Denver Nuggets ', 		'Stan Kroenke ', NULL, NULL, NULL, NULL),
 ('Detroit Pistons',  		'Tom Gores ', NULL, NULL, NULL, NULL),
 ('Golden State Warriors', 	'Peter Guber', NULL, NULL, NULL, NULL),
 ('Houston Rockets',  		'Leslie Alexander ', NULL, NULL, NULL, NULL),
 ('Indiana Pacers',  		'Herbert Simon ', NULL, NULL, NULL, NULL),
 ('Los Angeles Clippers',	'Donald Sterling', NULL, NULL, NULL, NULL),
 ('Los Angeles Lakers', 	'Jerry Buss family trust', NULL, NULL, NULL, NULL),
 ('Memphis Grizzlies', 		'Robert J. Pera', NULL, NULL, NULL, NULL),
 ('Miami Heat',   			'Micky Arison', NULL, NULL, NULL, NULL),
 ('Milwaukee Bucks',  		'Herb Kohl', NULL, NULL, NULL, NULL),
 ('Minnesota Timberwolves', 'Glen Taylor', NULL, NULL, NULL, NULL),
 ('New Orleans Pelicans ', 	'Tom Benson', NULL, NULL, NULL, NULL),
 ('New York Knicks',  		'James Dolan', NULL, NULL, NULL, NULL),
 ('Oklahoma City Thunder', 	'Clayton Bennett', NULL, NULL, NULL, NULL),
 ('Orlando Magic',  		'RDV Sports, Inc. (Richard DeVos, Chairman', NULL, NULL, NULL, NULL),
 ('Philadelphia 76ers', 	'Joshua Harris, Adam Aron', NULL, NULL, NULL, NULL),
 ('Phoenix Suns ',  		'Robert Sarver', NULL, NULL, NULL, NULL),
 ('Portland Trail Blazers', 'Paul Allen', NULL, NULL, NULL, NULL),
 ('Sacramento Kings ', 		'Joe Maloof, Gavin Maloof', NULL, NULL, NULL, NULL),
 ('San Antonio Spurs', 		'Peter Holt', NULL, NULL, NULL, NULL),
 ('Toronto Raptors',  		'Richard Peddie', NULL, NULL, NULL, NULL),
 ('Utah Jazz',   			'Greg Miller, Larry H. Miller', NULL, NULL, NULL, NULL),
 ('Washington Wizards', 	'Ted Leonsis', NULL, NULL, NULL, NULL);

UNLOCK TABLES;


