-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 10, 2023 at 11:56 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stone_eiland`
--

-- --------------------------------------------------------

--
-- Table structure for table `st_activiteiten`
--

DROP TABLE IF EXISTS `st_activiteiten`;
CREATE TABLE IF NOT EXISTS `st_activiteiten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `act_name` varchar(255) DEFAULT NULL,
  `act_price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `st_boekingen`
--

DROP TABLE IF EXISTS `st_boekingen`;
CREATE TABLE IF NOT EXISTS `st_boekingen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `huis_id` int(11) DEFAULT NULL,
  `activ_id` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `overnight_stay` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `huis_id` (`huis_id`),
  KEY `activ_id` (`activ_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `st_huizen`
--

DROP TABLE IF EXISTS `st_huizen`;
CREATE TABLE IF NOT EXISTS `st_huizen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(255) DEFAULT NULL,
  `house_price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `st_users`
--

DROP TABLE IF EXISTS `st_users`;
CREATE TABLE IF NOT EXISTS `st_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_lastname` varchar(255) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `st_users`
--

INSERT INTO `st_users` (`id`, `user_name`, `user_password`, `user_lastname`, `DOB`, `role`, `status`) VALUES
(1, 'Gerrit', '123456', 'Soerotaroeno', '1993-11-14', 'Beheerder', 'Actief'),
(2, 'Keith', '123456789', 'Tjon Kiem Sang', '2003-05-22', 'Gebruiker', 'Actief');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `st_boekingen`
--
ALTER TABLE `st_boekingen`
  ADD CONSTRAINT `st_boekingen_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `st_users` (`id`),
  ADD CONSTRAINT `st_boekingen_ibfk_2` FOREIGN KEY (`activ_id`) REFERENCES `st_activiteiten` (`id`),
  ADD CONSTRAINT `st_boekingen_ibfk_3` FOREIGN KEY (`huis_id`) REFERENCES `st_huizen` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
