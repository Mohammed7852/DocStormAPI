-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 13, 2017 at 10:05 AM
-- Server version: 5.6.27-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `docstorm`
--
CREATE DATABASE IF NOT EXISTS `docstorm` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `docstorm`;

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
  `docname` varchar(100) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `docwriter` int(11) NOT NULL,
  `date` date NOT NULL,
  `docid` int(11) NOT NULL,
  PRIMARY KEY (`docid`),
  KEY `docwriter` (`docwriter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `document`
--

INSERT INTO `document` (`docname`, `tag`, `docwriter`, `date`, `docid`) VALUES
('Spring Document', 'Java', 4, '2017-08-12', 5),
('Eclipse Tutorial', 'Programming', 14, '2017-08-13', 15),
('Netbeanse Tutorial', 'Programming', 14, '2017-08-13', 17),
('C++ Introduction', 'Programming', 4, '2017-08-13', 30);

-- --------------------------------------------------------

--
-- Table structure for table `documenttranlation`
--

CREATE TABLE IF NOT EXISTS `documenttranlation` (
  `Docid` int(11) NOT NULL,
  `LangCode` varchar(20) NOT NULL,
  `Translation` text NOT NULL,
  `Createdate` date NOT NULL,
  `transid` int(11) NOT NULL,
  PRIMARY KEY (`transid`),
  KEY `Docid` (`Docid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `documenttranlation`
--

INSERT INTO `documenttranlation` (`Docid`, `LangCode`, `Translation`, `Createdate`, `transid`) VALUES
(5, 'english', 'this document is an english version of spring boot....', '2017-08-12', 6),
(5, 'frensh', 'the frensh version of Spring boot document.....', '2017-08-12', 7),
(15, 'english', 'this document will provide an eclipse tutorial....', '2017-08-13', 16),
(17, 'english', 'this document will provide an Netbeanse tutorial....', '2017-08-13', 18),
(30, 'english', 'this document will introduce  some info about c++ .....', '2017-08-13', 31),
(30, 'frensh', 'this is the frensh version of C++ introduction', '2017-08-13', 32);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(33),
(33),
(33);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) NOT NULL,
  `useremail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `usertype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `useremail` (`useremail`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `useremail`, `password`, `userid`, `usertype`) VALUES
('Mohammed Shabanah', 'm.alishabanah2017@gmail.com', '123456789', 4, 'admin'),
('Ahmed Ali', 'ahmedali@gmail.com', '852147', 14, 'admin'),
('Mohammed Taha', 'taha@gmail.com', '22222222', 21, 'normal');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `FK199csc86vnx0ylpebdhc8lh1j` FOREIGN KEY (`docwriter`) REFERENCES `user` (`userid`),
  ADD CONSTRAINT `document_ibfk_1` FOREIGN KEY (`docwriter`) REFERENCES `user` (`userid`);

--
-- Constraints for table `documenttranlation`
--
ALTER TABLE `documenttranlation`
  ADD CONSTRAINT `FK4abyirk322ry13aydr7rxs4o0` FOREIGN KEY (`Docid`) REFERENCES `document` (`docid`),
  ADD CONSTRAINT `documenttranlation_ibfk_1` FOREIGN KEY (`Docid`) REFERENCES `document` (`docid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
