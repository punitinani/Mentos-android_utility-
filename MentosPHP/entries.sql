-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2016 at 06:36 AM
-- Server version: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mentos`
--

-- --------------------------------------------------------

--
-- Table structure for table `entries`
--

CREATE TABLE IF NOT EXISTS `entries` (
  `id` int(11) NOT NULL,
  `device_id` text NOT NULL,
  `status` int(11) NOT NULL,
  `command` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entries`
--

INSERT INTO `entries` (`id`, `device_id`, `status`, `command`) VALUES
(0, '', 1, 0),
(13, '', 1, 3),
(1234, '', 1, 3),
(153619359, '', 0, 0),
(186230296, '3.523060501754E+14', 1, 3),
(204569331, '', 1, 2),
(291090160, '', 1, 3),
(584966065, '', 0, 0),
(631830287, '', 1, 2),
(899937282, '', 1, 2),
(1090701905, '9.1004049200882E+14', 1, 3),
(1103957120, '', 1, 3),
(1205076126, '9.1004049200882E+14', 1, 2),
(1371317450, '', 1, 2),
(1381098707, '3.523060501754E+14', 1, 2),
(1448696724, '9.1004049200882E+14', 1, 3),
(1677416301, '', 0, 0),
(1689062288, '', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `entries`
--
ALTER TABLE `entries`
  ADD PRIMARY KEY (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
