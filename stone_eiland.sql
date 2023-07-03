-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 03, 2023 at 10:58 PM
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
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `st_activiteiten`
--

INSERT INTO `st_activiteiten` (`id`, `act_name`, `act_price`, `status`) VALUES
(1, 'Boswandeling', '50', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `st_boekingen`
--

DROP TABLE IF EXISTS `st_boekingen`;
CREATE TABLE IF NOT EXISTS `st_boekingen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `klant_naam` varchar(255) DEFAULT NULL,
  `klant_DOB` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `activiteit_naam` varchar(255) DEFAULT NULL,
  `huis_naam` varchar(255) DEFAULT NULL,
  `datum_reservering` date DEFAULT NULL,
  `datum_incheck` date DEFAULT NULL,
  `datum_uitcheck` date DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `overnight_stay` int(100) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `gebruiker` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `st_boekingen`
--

INSERT INTO `st_boekingen` (`id`, `klant_naam`, `klant_DOB`, `gender`, `activiteit_naam`, `huis_naam`, `datum_reservering`, `datum_incheck`, `datum_uitcheck`, `reason`, `overnight_stay`, `status`, `gebruiker`) VALUES
(1, 'Gerrit', '1993-11-14', 'M', 'Boswandeling', 'Afobakka', '2023-06-21', '2023-06-28', '2023-06-30', 'Betaald', 5, 'Bevestigd', 'Gerrit');

-- --------------------------------------------------------

--
-- Table structure for table `st_huizen`
--

DROP TABLE IF EXISTS `st_huizen`;
CREATE TABLE IF NOT EXISTS `st_huizen` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `house_name` varchar(255) DEFAULT NULL,
  `house_price` decimal(10,0) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `st_huizen`
--

INSERT INTO `st_huizen` (`id`, `house_name`, `house_price`, `status`) VALUES
(1, 'Suralco Vakantie huis', '200', 'Available');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `st_users`
--

INSERT INTO `st_users` (`id`, `user_name`, `user_password`, `user_lastname`, `DOB`, `role`, `status`) VALUES
(1, 'Gerrit', '123456', 'Soerotaroeno', '1993-11-14', 'Beheerder', 'Actief'),
(2, 'Keith', '123456789', 'Tjon Kiem Sang', '2003-05-22', 'Gebruiker', 'Actief'),
(4, 'Angelino', '12345678', 'Spreeuw', '1986-05-01', 'Beheerder', 'Actief');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
