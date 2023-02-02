

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- Table structure for table `polls`


CREATE TABLE IF NOT EXISTS `polls` (
  `PollID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(8) DEFAULT NULL,
  `Title` varchar(40) NOT NULL,
  `Question` varchar(100) NOT NULL,
  `Answer1` varchar(100) DEFAULT NULL,
  `Answer2` varchar(100) DEFAULT NULL,
  `Answer3` varchar(100) DEFAULT NULL,
  `Answer4` varchar(100) DEFAULT NULL,
  `Votes1` int(11) DEFAULT '0',
  `Votes2` int(11) DEFAULT '0',
  `Votes3` int(11) DEFAULT '0',
  `Votes4` int(11) DEFAULT '0',
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  `PollOpen` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`PollID`),
  UNIQUE KEY `PollID` (`PollID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=170 ;

--
-- Dumping data for table `polls`
--

INSERT INTO `polls` (`PollID`, `UserID`, `Title`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4`, `Votes1`, `Votes2`, `Votes3`, `Votes4`, `StartDate`, `EndDate`, `PollOpen`) VALUES
(101, 'SamScott', 'Java for Web Applications vs. Mobile App', 'Do you think the future of Java is in Web Applications or in Mobile Technology?', 'Web Applications', 'Mobile Technology', 'Both', 'Neither', 6, 14, 5, 5, '2011-11-20', '2011-11-27', 0),
(104, 'SamScott', 'A poll about Sam.', 'How great is Sam?', 'He''s the greatest!', 'He''s the best thing since sliced bread!', 'I wish I could be him!', 'I heard he wrote most of the Beatles'' songs!', 6, 7, 8, 8, '2012-01-01', '2012-01-02', 0),
(108, 'JoeBlow', 'Sheridan Poll', 'How would you rate your Sheridan experience?', 'Amazing', 'OK (>)', 'Not that great', 'Lousy', 6, 5, 4, 1, '2012-02-01', '2012-02-08', 0),
(109, 'Bubba', 'Bubba''s Pizza', 'What''s the best thing about Bubba''s?', 'Poutine', 'Pizza', 'MSG', 'Atmosphere', 13, 12, 18, 9, '2013-10-01', '2013-10-16', 0),
(166, 'JoeBlow', 'Candy Poll', 'What''s your favourite kind of candy?', 'Smarties', 'Salt Water Taffy', 'Candy Canes', 'I Hate Candy', 1, 5, 0, 1, '2013-01-01', '2013-03-01', 0);
