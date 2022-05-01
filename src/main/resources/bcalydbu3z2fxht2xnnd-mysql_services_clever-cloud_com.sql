-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: bcalydbu3z2fxht2xnnd-mysql.services.clever-cloud.com:3306
-- Generation Time: May 01, 2022 at 06:18 PM
-- Server version: 8.0.22-13
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bcalydbu3z2fxht2xnnd`
--
CREATE DATABASE IF NOT EXISTS `bcalydbu3z2fxht2xnnd` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bcalydbu3z2fxht2xnnd`;

-- --------------------------------------------------------

--
-- Table structure for table `April`
--

CREATE TABLE `April` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `April`
--

INSERT INTO `April` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, 'here', 'here', 'here', 'here', 'holiday', 'holiday', 'here', 'here', 'here', 'not here', 'here', 'holiday', 'holiday', 'here', 'here', 'here', 'here', 'here', 'holiday', 'holiday', NULL, NULL, 'sick', NULL, NULL, 'sick', 2),
(NULL, 'holiday', 'holiday', 'here', 'here', 'here', 'here', 'here', 'holiday', 'holiday', 'not here', 'sick', 'sick', 'sick', 'here', 'holiday', 'holiday', 'here', 'here', 'here', 'here', 'here', 'holiday', 'holiday', 'here', 'here', NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, 'sick', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `August`
--

CREATE TABLE `August` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `31` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `August`
--

INSERT INTO `August` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `Clients`
--

CREATE TABLE `Clients` (
  `ClientID` int NOT NULL,
  `HotelID` int NOT NULL,
  `Name` int NOT NULL,
  `Fullname` varchar(45) NOT NULL,
  `Passport` varchar(45) NOT NULL,
  `DateOfBirth` date NOT NULL,
  `CheckInTime` date NOT NULL,
  `CheckOutTime` date NOT NULL,
  `Amount` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Clients`
--

INSERT INTO `Clients` (`ClientID`, `HotelID`, `Name`, `Fullname`, `Passport`, `DateOfBirth`, `CheckInTime`, `CheckOutTime`, `Amount`) VALUES
(9, 2, 5, 'test', 'test', '2022-03-01', '2022-03-25', '2022-03-27', NULL),
(10, 2, 4, 'test', 'test', '2022-03-01', '2022-03-25', '2022-03-27', NULL),
(11, 2, 4, 'kj', 'jhg6yhgf5', '2022-03-02', '2022-03-25', '2022-03-27', NULL),
(13, 2, 2, 'New CLient', 'gfdhtfh', '2022-03-27', '2022-04-01', '2022-04-08', NULL),
(14, 2, 3, 'fdsafadsf', 'gfdsv', '2022-04-07', '2022-03-29', '2022-03-31', NULL),
(23, 2, 1, 'test', 'test', '2022-03-29', '2022-03-27', '2022-03-30', 3000),
(24, 2, 1, 'Ylya', 'fdsr446', '2022-04-06', '2022-04-01', '2022-04-11', 10000),
(25, 2, 3, 'Diyor', 'gd56yd', '2019-04-29', '2022-04-02', '2022-04-06', 40000),
(26, 2, 6, 'Diyor', 'gds57fg', '2022-03-27', '2022-04-03', '2022-04-30', 59400),
(27, 2, 4, 'Test', 'gggggggggggg', '2022-03-20', '2022-04-10', '2022-04-30', 117000),
(28, 2, 3, 'Nikolay', 'gg44gg', '2022-04-12', '2022-04-13', '2022-04-30', 170000),
(29, 2, 1, 'Ggg', 'fdsa', '2022-04-14', '2022-04-05', '2022-04-28', 23000),
(30, 2, 2, 'GG', 'GFDS', '2022-04-06', '2022-04-03', '2022-04-11', 17600),
(31, 2, 5, 'test2', 'fds', '2022-04-15', '2022-04-04', '2022-04-22', 36000),
(32, 2, 7, 'ff', 'gfdaas', '2022-04-05', '2022-04-03', '2022-04-05', 12600),
(33, 2, 3, 'Aidar', 'ggffgggg', '2022-05-17', '2022-05-02', '2022-05-17', 150000),
(34, 2, 6, 'Diyor', 'gfds', '2022-05-09', '2022-05-01', '2022-05-25', 91200),
(35, 2, 1, 'Keso', 'fdsafds', '2022-05-11', '2022-05-01', '2022-05-17', 16000),
(36, 2, 4, 'Cj', 'fdsfaf', '2022-05-03', '2022-05-01', '2022-05-23', 143000);

-- --------------------------------------------------------

--
-- Table structure for table `Countries`
--

CREATE TABLE `Countries` (
  `id` int NOT NULL,
  `name` varchar(80) NOT NULL,
  `capital` varchar(80) DEFAULT NULL,
  `continent` varchar(30) DEFAULT NULL,
  `clients` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Countries`
--

INSERT INTO `Countries` (`id`, `name`, `capital`, `continent`, `clients`) VALUES
(1, 'Afghanistan', 'Kabul', 'Asia', 0),
(2, 'Aland Islands', 'Mariehamn', 'Europe', 0),
(3, 'Albania', 'Tirana', 'Europe', 0),
(4, 'Algeria', 'Algiers', 'Africa', 0),
(5, 'American Samoa', 'Pago Pago', 'Oceania', 0),
(6, 'Andorra', 'Andorra la Vella', 'Europe', 0),
(7, 'Angola', 'Luanda', 'Africa', 0),
(8, 'Anguilla', 'The Valley', 'North America', 0),
(9, 'Antarctica', 'Antarctica', 'Antarctica', 0),
(10, 'Antigua and Barbuda', 'St. John\'s', 'North America', 0),
(11, 'Argentina', 'Buenos Aires', 'South America', 0),
(12, 'Armenia', 'Yerevan', 'Asia', 0),
(13, 'Aruba', 'Oranjestad', 'North America', 0),
(14, 'Australia', 'Canberra', 'Oceania', 0),
(15, 'Austria', 'Vienna', 'Europe', 0),
(16, 'Azerbaijan', 'Baku', 'Asia', 0),
(17, 'Bahamas', 'Nassau', 'North America', 0),
(18, 'Bahrain', 'Manama', 'Asia', 0),
(19, 'Bangladesh', 'Dhaka', 'Asia', 0),
(20, 'Barbados', 'Bridgetown', 'North America', 0),
(21, 'Belarus', 'Minsk', 'Europe', 0),
(22, 'Belgium', 'Brussels', 'Europe', 0),
(23, 'Belize', 'Belmopan', 'North America', 0),
(24, 'Benin', 'Porto-Novo', 'Africa', 0),
(25, 'Bermuda', 'Hamilton', 'North America', 0),
(26, 'Bhutan', 'Thimphu', 'Asia', 0),
(27, 'Bolivia', 'Sucre', 'South America', 0),
(28, 'Bonaire, Sint Eustatius and Saba', 'Kralendijk', 'North America', 0),
(29, 'Bosnia and Herzegovina', 'Sarajevo', 'Europe', 0),
(30, 'Botswana', 'Gaborone', 'Africa', 0),
(31, 'Bouvet Island', '', 'Antarctica', 0),
(32, 'Brazil', 'Brasilia', 'South America', 0),
(33, 'British Indian Ocean Territory', 'Diego Garcia', 'Asia', 0),
(34, 'Brunei Darussalam', 'Bandar Seri Begawan', 'Asia', 0),
(35, 'Bulgaria', 'Sofia', 'Europe', 0),
(36, 'Burkina Faso', 'Ouagadougou', 'Africa', 0),
(37, 'Burundi', 'Bujumbura', 'Africa', 0),
(38, 'Cambodia', 'Phnom Penh', 'Asia', 0),
(39, 'Cameroon', 'Yaounde', 'Africa', 0),
(40, 'Canada', 'Ottawa', 'North America', 36),
(41, 'Cape Verde', 'Praia', 'Africa', 0),
(42, 'Cayman Islands', 'George Town', 'North America', 0),
(43, 'Central African Republic', 'Bangui', 'Africa', 0),
(44, 'Chad', 'N\'Djamena', 'Africa', 0),
(45, 'Chile', 'Santiago', 'South America', 0),
(46, 'China', 'Beijing', 'Asia', 32),
(47, 'Christmas Island', 'Flying Fish Cove', 'Asia', 0),
(48, 'Cocos (Keeling) Islands', 'West Island', 'Asia', 0),
(49, 'Colombia', 'Bogota', 'South America', 0),
(50, 'Comoros', 'Moroni', 'Africa', 0),
(51, 'Congo', 'Brazzaville', 'Africa', 2),
(52, 'Congo, Democratic Republic of the Congo', 'Kinshasa', 'Africa', 0),
(53, 'Cook Islands', 'Avarua', 'Oceania', 0),
(54, 'Costa Rica', 'San Jose', 'North America', 5),
(55, 'Cote D\'Ivoire', 'Yamoussoukro', 'Africa', 0),
(56, 'Croatia', 'Zagreb', 'Europe', 0),
(57, 'Cuba', 'Havana', 'North America', 0),
(58, 'Curacao', 'Willemstad', 'North America', 0),
(59, 'Cyprus', 'Nicosia', 'Asia', 0),
(60, 'Czech Republic', 'Prague', 'Europe', 0),
(61, 'Denmark', 'Copenhagen', 'Europe', 0),
(62, 'Djibouti', 'Djibouti', 'Africa', 0),
(63, 'Dominica', 'Roseau', 'North America', 0),
(64, 'Dominican Republic', 'Santo Domingo', 'North America', 0),
(65, 'Ecuador', 'Quito', 'South America', 0),
(66, 'Egypt', 'Cairo', 'Africa', 0),
(67, 'El Salvador', 'San Salvador', 'North America', 0),
(68, 'Equatorial Guinea', 'Malabo', 'Africa', 0),
(69, 'Eritrea', 'Asmara', 'Africa', 0),
(70, 'Estonia', 'Tallinn', 'Europe', 0),
(71, 'Ethiopia', 'Addis Ababa', 'Africa', 0),
(72, 'Falkland Islands (Malvinas)', 'Stanley', 'South America', 0),
(73, 'Faroe Islands', 'Torshavn', 'Europe', 0),
(74, 'Fiji', 'Suva', 'Oceania', 0),
(75, 'Finland', 'Helsinki', 'Europe', 0),
(76, 'France', 'Paris', 'Europe', 0),
(77, 'French Guiana', 'Cayenne', 'South America', 0),
(78, 'French Polynesia', 'Papeete', 'Oceania', 0),
(79, 'French Southern Territories', 'Port-aux-Francais', 'Antarctica', 0),
(80, 'Gabon', 'Libreville', 'Africa', 0),
(81, 'Gambia', 'Banjul', 'Africa', 0),
(82, 'Georgia', 'Tbilisi', 'Asia', 0),
(83, 'Germany', 'Berlin', 'Europe', 0),
(84, 'Ghana', 'Accra', 'Africa', 0),
(85, 'Gibraltar', 'Gibraltar', 'Europe', 0),
(86, 'Greece', 'Athens', 'Europe', 0),
(87, 'Greenland', 'Nuuk', 'North America', 0),
(88, 'Grenada', 'St. George\'s', 'North America', 0),
(89, 'Guadeloupe', 'Basse-Terre', 'North America', 0),
(90, 'Guam', 'Hagatna', 'Oceania', 0),
(91, 'Guatemala', 'Guatemala City', 'North America', 0),
(92, 'Guernsey', 'St Peter Port', 'Europe', 0),
(93, 'Guinea', 'Conakry', 'Africa', 0),
(94, 'Guinea-Bissau', 'Bissau', 'Africa', 0),
(95, 'Guyana', 'Georgetown', 'South America', 0),
(96, 'Haiti', 'Port-au-Prince', 'North America', 0),
(97, 'Heard Island and Mcdonald Islands', '', 'Antarctica', 0),
(98, 'Holy See (Vatican City State)', 'Vatican City', 'Europe', 0),
(99, 'Honduras', 'Tegucigalpa', 'North America', 0),
(100, 'Hong Kong', 'Hong Kong', 'Asia', 0),
(101, 'Hungary', 'Budapest', 'Europe', 0),
(102, 'Iceland', 'Reykjavik', 'Europe', 0),
(103, 'India', 'New Delhi', 'Asia', 0),
(104, 'Indonesia', 'Jakarta', 'Asia', 0),
(105, 'Iran, Islamic Republic of', 'Tehran', 'Asia', 0),
(106, 'Iraq', 'Baghdad', 'Asia', 0),
(107, 'Ireland', 'Dublin', 'Europe', 0),
(108, 'Isle of Man', 'Douglas, Isle of Man', 'Europe', 0),
(109, 'Israel', 'Jerusalem', 'Asia', 0),
(110, 'Italy', 'Rome', 'Europe', 0),
(111, 'Jamaica', 'Kingston', 'North America', 0),
(112, 'Japan', 'Tokyo', 'Asia', 22),
(113, 'Jersey', 'Saint Helier', 'Europe', 0),
(114, 'Jordan', 'Amman', 'Asia', 0),
(115, 'Kazakhstan', 'Astana', 'Asia', 60),
(116, 'Kenya', 'Nairobi', 'Africa', 0),
(117, 'Kiribati', 'Tarawa', 'Oceania', 0),
(118, 'Korea, Democratic People\'s Republic of', 'Pyongyang', 'Asia', 0),
(119, 'Korea, Republic of', 'Seoul', 'Asia', 0),
(120, 'Kosovo', 'Pristina', 'Europe', 0),
(121, 'Kuwait', 'Kuwait City', 'Asia', 0),
(122, 'Kyrgyzstan', 'Bishkek', 'Asia', 55),
(123, 'Lao People\'s Democratic Republic', 'Vientiane', 'Asia', 0),
(124, 'Latvia', 'Riga', 'Europe', 0),
(125, 'Lebanon', 'Beirut', 'Asia', 0),
(126, 'Lesotho', 'Maseru', 'Africa', 0),
(127, 'Liberia', 'Monrovia', 'Africa', 0),
(128, 'Libyan Arab Jamahiriya', 'Tripolis', 'Africa', 0),
(129, 'Liechtenstein', 'Vaduz', 'Europe', 0),
(130, 'Lithuania', 'Vilnius', 'Europe', 0),
(131, 'Luxembourg', 'Luxembourg', 'Europe', 0),
(132, 'Macao', 'Macao', 'Asia', 0),
(133, 'Macedonia, the Former Yugoslav Republic of', 'Skopje', 'Europe', 0),
(134, 'Madagascar', 'Antananarivo', 'Africa', 0),
(135, 'Malawi', 'Lilongwe', 'Africa', 0),
(136, 'Malaysia', 'Kuala Lumpur', 'Asia', 0),
(137, 'Maldives', 'Male', 'Asia', 0),
(138, 'Mali', 'Bamako', 'Africa', 0),
(139, 'Malta', 'Valletta', 'Europe', 0),
(140, 'Marshall Islands', 'Majuro', 'Oceania', 0),
(141, 'Martinique', 'Fort-de-France', 'North America', 0),
(142, 'Mauritania', 'Nouakchott', 'Africa', 0),
(143, 'Mauritius', 'Port Louis', 'Africa', 0),
(144, 'Mayotte', 'Mamoudzou', 'Africa', 0),
(145, 'Mexico', 'Mexico City', 'North America', 0),
(146, 'Micronesia, Federated States of', 'Palikir', 'Oceania', 0),
(147, 'Moldova, Republic of', 'Chisinau', 'Europe', 0),
(148, 'Monaco', 'Monaco', 'Europe', 0),
(149, 'Mongolia', 'Ulan Bator', 'Asia', 0),
(150, 'Montenegro', 'Podgorica', 'Europe', 0),
(151, 'Montserrat', 'Plymouth', 'North America', 0),
(152, 'Morocco', 'Rabat', 'Africa', 0),
(153, 'Mozambique', 'Maputo', 'Africa', 0),
(154, 'Myanmar', 'Nay Pyi Taw', 'Asia', 0),
(155, 'Namibia', 'Windhoek', 'Africa', 0),
(156, 'Nauru', 'Yaren', 'Oceania', 0),
(157, 'Nepal', 'Kathmandu', 'Asia', 0),
(158, 'Netherlands', 'Amsterdam', 'Europe', 0),
(159, 'Netherlands Antilles', 'Willemstad', 'North America', 0),
(160, 'New Caledonia', 'Noumea', 'Oceania', 0),
(161, 'New Zealand', 'Wellington', 'Oceania', 0),
(162, 'Nicaragua', 'Managua', 'North America', 0),
(163, 'Niger', 'Niamey', 'Africa', 0),
(164, 'Nigeria', 'Abuja', 'Africa', 0),
(165, 'Niue', 'Alofi', 'Oceania', 0),
(166, 'Norfolk Island', 'Kingston', 'Oceania', 0),
(167, 'Northern Mariana Islands', 'Saipan', 'Oceania', 0),
(168, 'Norway', 'Oslo', 'Europe', 0),
(169, 'Oman', 'Muscat', 'Asia', 0),
(170, 'Pakistan', 'Islamabad', 'Asia', 0),
(171, 'Palau', 'Melekeok', 'Oceania', 0),
(172, 'Palestinian Territory, Occupied', 'East Jerusalem', 'Asia', 0),
(173, 'Panama', 'Panama City', 'North America', 0),
(174, 'Papua New Guinea', 'Port Moresby', 'Oceania', 0),
(175, 'Paraguay', 'Asuncion', 'South America', 0),
(176, 'Peru', 'Lima', 'South America', 0),
(177, 'Philippines', 'Manila', 'Asia', 0),
(178, 'Pitcairn', 'Adamstown', 'Oceania', 0),
(179, 'Poland', 'Warsaw', 'Europe', 0),
(180, 'Portugal', 'Lisbon', 'Europe', 0),
(181, 'Puerto Rico', 'San Juan', 'North America', 0),
(182, 'Qatar', 'Doha', 'Asia', 0),
(183, 'Reunion', 'Saint-Denis', 'Africa', 0),
(184, 'Romania', 'Bucharest', 'Europe', 0),
(185, 'Russian Federation', 'Moscow', 'Asia', 1),
(186, 'Rwanda', 'Kigali', 'Africa', 0),
(187, 'Saint Barthelemy', 'Gustavia', 'North America', 0),
(188, 'Saint Helena', 'Jamestown', 'Africa', 0),
(189, 'Saint Kitts and Nevis', 'Basseterre', 'North America', 0),
(190, 'Saint Lucia', 'Castries', 'North America', 0),
(191, 'Saint Martin', 'Marigot', 'North America', 0),
(192, 'Saint Pierre and Miquelon', 'Saint-Pierre', 'North America', 0),
(193, 'Saint Vincent and the Grenadines', 'Kingstown', 'North America', 0),
(194, 'Samoa', 'Apia', 'Oceania', 0),
(195, 'San Marino', 'San Marino', 'Europe', 0),
(196, 'Sao Tome and Principe', 'Sao Tome', 'Africa', 0),
(197, 'Saudi Arabia', 'Riyadh', 'Asia', 0),
(198, 'Senegal', 'Dakar', 'Africa', 0),
(199, 'Serbia', 'Belgrade', 'Europe', 0),
(200, 'Serbia and Montenegro', 'Belgrade', 'Europe', 0),
(201, 'Seychelles', 'Victoria', 'Africa', 0),
(202, 'Sierra Leone', 'Freetown', 'Africa', 0),
(203, 'Singapore', 'Singapur', 'Asia', 0),
(204, 'Sint Maarten', 'Philipsburg', 'North America', 0),
(205, 'Slovakia', 'Bratislava', 'Europe', 0),
(206, 'Slovenia', 'Ljubljana', 'Europe', 0),
(207, 'Solomon Islands', 'Honiara', 'Oceania', 0),
(208, 'Somalia', 'Mogadishu', 'Africa', 0),
(209, 'South Africa', 'Pretoria', 'Africa', 0),
(210, 'South Georgia and the South Sandwich Islands', 'Grytviken', 'Antarctica', 0),
(211, 'South Sudan', 'Juba', 'Africa', 0),
(212, 'Spain', 'Madrid', 'Europe', 0),
(213, 'Sri Lanka', 'Colombo', 'Asia', 0),
(214, 'Sudan', 'Khartoum', 'Africa', 0),
(215, 'Suriname', 'Paramaribo', 'South America', 0),
(216, 'Svalbard and Jan Mayen', 'Longyearbyen', 'Europe', 0),
(217, 'Swaziland', 'Mbabane', 'Africa', 0),
(218, 'Sweden', 'Stockholm', 'Europe', 0),
(219, 'Switzerland', 'Berne', 'Europe', 0),
(220, 'Syrian Arab Republic', 'Damascus', 'Asia', 0),
(221, 'Taiwan, Province of China', 'Taipei', 'Asia', 0),
(222, 'Tajikistan', 'Dushanbe', 'Asia', 0),
(223, 'Tanzania, United Republic of', 'Dodoma', 'Africa', 0),
(224, 'Thailand', 'Bangkok', 'Asia', 0),
(225, 'Timor-Leste', 'Dili', 'Asia', 0),
(226, 'Togo', 'Lome', 'Africa', 0),
(227, 'Tokelau', '', 'Oceania', 0),
(228, 'Tonga', 'Nuku\'alofa', 'Oceania', 0),
(229, 'Trinidad and Tobago', 'Port of Spain', 'North America', 0),
(230, 'Tunisia', 'Tunis', 'Africa', 0),
(231, 'Turkey', 'Ankara', 'Asia', 0),
(232, 'Turkmenistan', 'Ashgabat', 'Asia', 0),
(233, 'Turks and Caicos Islands', 'Cockburn Town', 'North America', 0),
(234, 'Tuvalu', 'Funafuti', 'Oceania', 0),
(235, 'Uganda', 'Kampala', 'Africa', 0),
(236, 'Ukraine', 'Kiev', 'Europe', 0),
(237, 'United Arab Emirates', 'Abu Dhabi', 'Asia', 0),
(238, 'United Kingdom', 'London', 'Europe', 0),
(239, 'United States', 'Washington', 'North America', 0),
(240, 'United States Minor Outlying Islands', '', 'North America', 0),
(241, 'Uruguay', 'Montevideo', 'South America', 0),
(242, 'Uzbekistan', 'Tashkent', 'Asia', 0),
(243, 'Vanuatu', 'Port Vila', 'Oceania', 0),
(244, 'Venezuela', 'Caracas', 'South America', 0),
(245, 'Viet Nam', 'Hanoi', 'Asia', 0),
(246, 'Virgin Islands, British', 'Road Town', 'North America', 0),
(247, 'Virgin Islands, U.s.', 'Charlotte Amalie', 'North America', 0),
(248, 'Wallis and Futuna', 'Mata Utu', 'Oceania', 0),
(249, 'Western Sahara', 'El-Aaiun', 'Africa', 0),
(250, 'Yemen', 'Sanaa', 'Asia', 0),
(251, 'Zambia', 'Lusaka', 'Africa', 0),
(252, 'Zimbabwe', 'Harare', 'Africa', 0);

-- --------------------------------------------------------

--
-- Table structure for table `December`
--

CREATE TABLE `December` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `31` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `December`
--

INSERT INTO `December` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `February`
--

CREATE TABLE `February` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `February`
--

INSERT INTO `February` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `Hotels`
--

CREATE TABLE `Hotels` (
  `HotelID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Stars` int NOT NULL,
  `Workers` mediumtext NOT NULL,
  `Clients` int NOT NULL,
  `Finances` mediumtext NOT NULL,
  `Rooms` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Hotels`
--

INSERT INTO `Hotels` (`HotelID`, `Name`, `Address`, `Stars`, `Workers`, `Clients`, `Finances`, `Rooms`) VALUES
(0, 'Other', 'other', 0, '0', 0, '23465774', 0),
(1, 'test', 'test', 5, '59', 54, '2455', 53),
(2, 'Land Scapa', 'Bishkek, Ahunbaeva 7', 3, '15', 16, '1000000', 56),
(3, 'Shift Lk', 'Almaty, GQ 2', 2, '1', 0, '1000', 0);

-- --------------------------------------------------------

--
-- Table structure for table `January`
--

CREATE TABLE `January` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `31` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `January`
--

INSERT INTO `January` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `July`
--

CREATE TABLE `July` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `31` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `July`
--

INSERT INTO `July` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `June`
--

CREATE TABLE `June` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `June`
--

INSERT INTO `June` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `Loss`
--

CREATE TABLE `Loss` (
  `January` int DEFAULT NULL,
  `February` int DEFAULT NULL,
  `March` int DEFAULT NULL,
  `April` int DEFAULT NULL,
  `May` int DEFAULT NULL,
  `June` int DEFAULT NULL,
  `July` int DEFAULT NULL,
  `August` int DEFAULT NULL,
  `September` int DEFAULT NULL,
  `November` int DEFAULT NULL,
  `December` int DEFAULT NULL,
  `HotelID` int DEFAULT NULL,
  `October` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Loss`
--

INSERT INTO `Loss` (`January`, `February`, `March`, `April`, `May`, `June`, `July`, `August`, `September`, `November`, `December`, `HotelID`, `October`) VALUES
(105600, 534200, 566800, 270100, 270100, 543500, 654600, 765500, 234500, 543500, 645600, 2, 432400);

-- --------------------------------------------------------

--
-- Table structure for table `Map`
--

CREATE TABLE `Map` (
  `MapID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Count` int NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `March`
--

CREATE TABLE `March` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `31` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `March`
--

INSERT INTO `March` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `May`
--

CREATE TABLE `May` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `31` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `May`
--

INSERT INTO `May` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31`, `WorkerID`) VALUES
('holiday', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `monetary_fine`
--

CREATE TABLE `monetary_fine` (
  `WorkerID` int NOT NULL,
  `Date` date NOT NULL,
  `Description` varchar(45) NOT NULL,
  `Price` int NOT NULL,
  `HotelID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `monetary_fine`
--

INSERT INTO `monetary_fine` (`WorkerID`, `Date`, `Description`, `Price`, `HotelID`) VALUES
(1, '2022-04-02', 'Aidar lohhhhhh', 5000, 2),
(2, '2022-04-22', 'не пришел на англ', 15000, 2),
(2, '2022-04-23', 'просто так', 100000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `November`
--

CREATE TABLE `November` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `November`
--

INSERT INTO `November` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `October`
--

CREATE TABLE `October` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `31` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `October`
--

INSERT INTO `October` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `31`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `profile`
--

CREATE TABLE `profile` (
  `hours` varchar(100) DEFAULT NULL,
  `monday` varchar(100) DEFAULT NULL,
  `tuesday` varchar(100) DEFAULT NULL,
  `wednesday` varchar(100) DEFAULT NULL,
  `thursday` varchar(100) DEFAULT NULL,
  `friday` varchar(100) DEFAULT NULL,
  `satuday` varchar(100) DEFAULT NULL,
  `sunday` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profile`
--

INSERT INTO `profile` (`hours`, `monday`, `tuesday`, `wednesday`, `thursday`, `friday`, `satuday`, `sunday`) VALUES
('Куурдак', '9 30', 'Самсы', 'Куурдак', 'Самсы', 'Куурдак', 'Самсы', 'Куурдак'),
('rhaslk', '9 30', '', '', '', '', '', ''),
('Куурдак', '9 30', 'Куурдак', 'самсы', 'Плов', 'Плов', 'Куурдак', 'Плов'),
('ldld', 'kkdk', 'dlld', 'dlld', 'ldldl', 'dsf', 'asdsafafd', 'sddsaf'),
('sdjfglkjsd', '994994', '', '', '', '', '', ''),
('df;\'g\'ds;', '\'p\'aod', '', '', '', '', '', ''),
('ll;aldskjl', 'u4999', 'sdklfl;ksd', 'djslfasdkjl;', 'jkldslakj;s', 'ldafjslk;ads', 'sdjfl;aksd', 'dsajads;klas');

-- --------------------------------------------------------

--
-- Table structure for table `Profit`
--

CREATE TABLE `Profit` (
  `January` int NOT NULL,
  `February` int NOT NULL,
  `March` int NOT NULL,
  `April` int NOT NULL,
  `May` int NOT NULL,
  `June` int NOT NULL,
  `July` int NOT NULL,
  `August` int NOT NULL,
  `September` int NOT NULL,
  `November` int NOT NULL,
  `December` int NOT NULL,
  `HotelID` int NOT NULL,
  `October` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Profit`
--

INSERT INTO `Profit` (`January`, `February`, `March`, `April`, `May`, `June`, `July`, `August`, `September`, `November`, `December`, `HotelID`, `October`) VALUES
(764000, 74760, 534600, 605600, 400200, 765400, 636300, 425500, 643600, 876500, 245600, 2, 766500);

-- --------------------------------------------------------

--
-- Table structure for table `Rooms`
--

CREATE TABLE `Rooms` (
  `RoomID` int NOT NULL,
  `HotelID` int NOT NULL,
  `Price` int NOT NULL,
  `isAvailable` tinyint(1) NOT NULL DEFAULT '1',
  `Size` varchar(45) NOT NULL,
  `Extra_bed` tinyint(1) NOT NULL DEFAULT '0',
  `Child` tinyint(1) NOT NULL DEFAULT '0',
  `Type` varchar(45) NOT NULL,
  `View` varchar(45) NOT NULL,
  `Name` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Rooms`
--

INSERT INTO `Rooms` (`RoomID`, `HotelID`, `Price`, `isAvailable`, `Size`, `Extra_bed`, `Child`, `Type`, `View`, `Name`) VALUES
(1, 2, 1000, 0, 'Single', 1, 1, 'Suite', 'Ocean View', 1),
(2, 2, 2200, 1, 'Double', 0, 1, 'Family Room', 'Run of House', 2),
(3, 2, 10000, 0, 'Triple', 1, 1, 'Presidential', 'Pool View', 3),
(4, 2, 6500, 0, 'Single', 0, 0, 'Duplex', 'Park View', 4),
(5, 2, 2000, 1, 'Double', 0, 1, 'Standart', 'Run of House', 5),
(6, 2, 3800, 0, 'Double', 0, 1, 'Apartament', 'Sea View', 6),
(7, 2, 6300, 1, 'Triple', 1, 1, 'Family Room', 'Mountain View', 7),
(8, 2, 1000, 1, 'Single', 0, 1, 'Standart', 'Ocean View', 8),
(9, 2, 1000, 1, 'Triple', 1, 0, 'Presidential', 'City View', 9);

-- --------------------------------------------------------

--
-- Table structure for table `September`
--

CREATE TABLE `September` (
  `1` varchar(45) DEFAULT NULL,
  `2` varchar(45) DEFAULT NULL,
  `3` varchar(45) DEFAULT NULL,
  `4` varchar(45) DEFAULT NULL,
  `5` varchar(45) DEFAULT NULL,
  `6` varchar(45) DEFAULT NULL,
  `7` varchar(45) DEFAULT NULL,
  `8` varchar(45) DEFAULT NULL,
  `9` varchar(45) DEFAULT NULL,
  `10` varchar(45) DEFAULT NULL,
  `11` varchar(45) DEFAULT NULL,
  `12` varchar(45) DEFAULT NULL,
  `13` varchar(45) DEFAULT NULL,
  `14` varchar(45) DEFAULT NULL,
  `15` varchar(45) DEFAULT NULL,
  `16` varchar(45) DEFAULT NULL,
  `17` varchar(45) DEFAULT NULL,
  `18` varchar(45) DEFAULT NULL,
  `19` varchar(45) DEFAULT NULL,
  `20` varchar(45) DEFAULT NULL,
  `21` varchar(45) DEFAULT NULL,
  `22` varchar(45) DEFAULT NULL,
  `23` varchar(45) DEFAULT NULL,
  `24` varchar(45) DEFAULT NULL,
  `25` varchar(45) DEFAULT NULL,
  `26` varchar(45) DEFAULT NULL,
  `27` varchar(45) DEFAULT NULL,
  `28` varchar(45) DEFAULT NULL,
  `29` varchar(45) DEFAULT NULL,
  `30` varchar(45) DEFAULT NULL,
  `WorkerID` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `September`
--

INSERT INTO `September` (`1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`, `14`, `15`, `16`, `17`, `18`, `19`, `20`, `21`, `22`, `23`, `24`, `25`, `26`, `27`, `28`, `29`, `30`, `WorkerID`) VALUES
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13),
(NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 15);

-- --------------------------------------------------------

--
-- Table structure for table `Workers`
--

CREATE TABLE `Workers` (
  `WorkerID` int NOT NULL,
  `HotelID` int NOT NULL,
  `Fullname` varchar(45) NOT NULL,
  `Passport` varchar(45) NOT NULL,
  `Salary` int NOT NULL,
  `Post` varchar(45) NOT NULL,
  `Login` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL DEFAULT '12345',
  `Email` varchar(45) NOT NULL,
  `Email_password` varchar(45) DEFAULT NULL,
  `Loss` int DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Workers`
--

INSERT INTO `Workers` (`WorkerID`, `HotelID`, `Fullname`, `Passport`, `Salary`, `Post`, `Login`, `Password`, `Email`, `Email_password`, `Loss`) VALUES
(1, 2, 'Diyor', 'gg55gg', 100000, 'Director', 'Di', '12345', 'Di@poh.com', NULL, 0),
(2, 2, 'Aidar', 'gfhy65yn', 10000, 'Receptionist', 'Aidar', '12345', 'gg@gmail.com', NULL, 0),
(12, 2, 'Amir', 'fs4syr', 10000, 'HRmanager', 'Amir', '12345', 'hrmanagergg@gmail.com', 'nikonnikon1', 0),
(13, 2, 'Ylya', 'gsd4t4', 150000, 'Admin', 'gay', '12345', 'Gay@poh.com', NULL, 0),
(15, 2, 'gfds', 'fgds', 100, 'Cook', 'keso', '12345', 'ggfds', NULL, 0),
(16, 0, 'Dj', 'ghfds', 10000, 'Marketing', 'Dj', '12345', 'GFDSG@gmail.com', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Сlassification_of_rooms`
--

CREATE TABLE `Сlassification_of_rooms` (
  `RoomID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `ShorName` varchar(45) DEFAULT NULL,
  `Description` varchar(500) DEFAULT NULL,
  `Type` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Сlassification_of_rooms`
--

INSERT INTO `Сlassification_of_rooms` (`RoomID`, `Name`, `ShorName`, `Description`, `Type`) VALUES
(1, 'Single', 'SGL', 'A room with a single bed that is intended for one person to sleep in.', 'Basic'),
(2, 'Double', 'DBL', 'A double room is a room intended for two people, usually a couple, to stay in.', 'Basic'),
(3, 'Triple', 'TRPL', 'A room with sufficient space for three person to stay in at a time with a double bed and one single bed or three single beds.', 'Basic'),
(4, 'Extra Bed', 'EXB', 'The extra bed is a typical single bed with dimensions 85x185cm and mattress of 17cm tall.', 'Optionally'),
(5, 'Child', 'CHD', 'Child from 3 to 12 years old.', 'Optionally'),
(6, 'Junior Suite', NULL, 'Smaller than a regular suite but more importantly, typically don\'t have a solid separation between the bedrooms and living area.', 'Comfort'),
(7, 'Suite', NULL, 'A basic suite or executive suite comes with a separate living space connected to one or more bedrooms.', 'Comfort'),
(8, 'De Luxe', NULL, 'Deluxe rooms, are modern decorated, can accommodate up to 2 persons, totally soundproofed and equipped with high tech comforts such as high speed internet access, USB ports , smart TV, room cleaning touch system and private hydromassage bathtub.', 'Comfort'),
(9, 'Duplex', NULL, 'It\'s a two-level room. It consists of at least one bedroom on one floor and a living room or bedroom on the second floor. You can also find more bedrooms on any of the floors.', 'Comfort'),
(10, 'Family Room', NULL, 'A family room is an informal, all-purpose room in a house. The family room is designed to be a place where family and guests gather for group recreation like talking, reading, watching TV, and other family activities.', 'Comfort'),
(11, 'Studio', NULL, 'A studio apartment, by definition, is a single-room dwelling that combines the bedroom, kitchen, and living area into one large room. The open floor plan does not have walls separating the sleeping and living areas, and the kitchen area may or may not be separated by a wall.', 'Comfort'),
(12, 'Standart', NULL, 'A standard room includes all kinds of basic facilities such as a table, chair, desk, cupboard, dressing table, DVD player, television, telephone, coffee maker and a private bathroom.', 'Comfort'),
(13, 'Bungalow', NULL, 'A bungalow is a style of house or cottage that is typically either a single story or has a second, half, or partial story, that is built into a sloped roof. ', 'Comfort'),
(14, 'Apartament', NULL, 'Separate self-catering apartments.', 'Comfort'),
(15, 'Honeymoon Room', NULL, 'A honeymoon suite, or a \'romance suite\', in a hotel or other places of accommodation denotes a suite with special amenities primarily aimed at couples and newlyweds.', 'Comfort'),
(16, 'Villa', NULL, 'A villa is a type of house that was originally an ancient Roman upper-class country house.', 'Comfort'),
(17, 'Presidential', NULL, 'Featuring a fully-equipped kitchen, bedroom, large living room - including a working and dining area - and guest restroom, the Presidential Suite is the ultimate in creating a feeling of home.', 'Comfort'),
(18, 'Pool View', 'PK', NULL, 'View'),
(19, 'Park View', NULL, NULL, 'View'),
(20, 'Sea View', 'SV', NULL, 'View'),
(21, 'City View', 'CV', NULL, 'View'),
(22, 'Mountain View', 'MV', NULL, 'View'),
(23, 'Ocean View', 'OV', NULL, 'View'),
(24, 'Run of House', NULL, NULL, 'View');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `April`
--
ALTER TABLE `April`
  ADD PRIMARY KEY (`WorkerID`);

--
-- Indexes for table `August`
--
ALTER TABLE `August`
  ADD KEY `fk_August_WorkerID` (`WorkerID`);

--
-- Indexes for table `Clients`
--
ALTER TABLE `Clients`
  ADD PRIMARY KEY (`ClientID`),
  ADD KEY `fk_Clients_HotelID` (`HotelID`),
  ADD KEY `fk_Clients_RoomID` (`Name`);

--
-- Indexes for table `Countries`
--
ALTER TABLE `Countries`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `December`
--
ALTER TABLE `December`
  ADD KEY `fk_December_WorkerID` (`WorkerID`);

--
-- Indexes for table `February`
--
ALTER TABLE `February`
  ADD KEY `fk_February_WorkerID` (`WorkerID`);

--
-- Indexes for table `Hotels`
--
ALTER TABLE `Hotels`
  ADD PRIMARY KEY (`HotelID`);

--
-- Indexes for table `January`
--
ALTER TABLE `January`
  ADD KEY `fk_January_WorkerID` (`WorkerID`);

--
-- Indexes for table `July`
--
ALTER TABLE `July`
  ADD KEY `fk_July_WorkerID` (`WorkerID`);

--
-- Indexes for table `June`
--
ALTER TABLE `June`
  ADD KEY `fk_June_WorkerID` (`WorkerID`);

--
-- Indexes for table `Map`
--
ALTER TABLE `Map`
  ADD PRIMARY KEY (`MapID`);

--
-- Indexes for table `March`
--
ALTER TABLE `March`
  ADD KEY `fk_March_WorkerID` (`WorkerID`);

--
-- Indexes for table `May`
--
ALTER TABLE `May`
  ADD PRIMARY KEY (`WorkerID`);

--
-- Indexes for table `monetary_fine`
--
ALTER TABLE `monetary_fine`
  ADD KEY `monetary_fine_Workers_WorkerID_fk` (`WorkerID`);

--
-- Indexes for table `November`
--
ALTER TABLE `November`
  ADD KEY `fk_November_WorkerID` (`WorkerID`);

--
-- Indexes for table `October`
--
ALTER TABLE `October`
  ADD KEY `fk_October_WorkerID` (`WorkerID`);

--
-- Indexes for table `Profit`
--
ALTER TABLE `Profit`
  ADD PRIMARY KEY (`HotelID`);

--
-- Indexes for table `Rooms`
--
ALTER TABLE `Rooms`
  ADD PRIMARY KEY (`RoomID`),
  ADD KEY `fk_Rooms_HotelID` (`HotelID`);

--
-- Indexes for table `September`
--
ALTER TABLE `September`
  ADD KEY `fk_September_WorkerID` (`WorkerID`);

--
-- Indexes for table `Workers`
--
ALTER TABLE `Workers`
  ADD PRIMARY KEY (`WorkerID`),
  ADD KEY `fk_Workers_HotelID` (`HotelID`);

--
-- Indexes for table `Сlassification_of_rooms`
--
ALTER TABLE `Сlassification_of_rooms`
  ADD PRIMARY KEY (`RoomID`),
  ADD UNIQUE KEY `Сlassification_of_rooms_Name_uindex` (`Name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Clients`
--
ALTER TABLE `Clients`
  MODIFY `ClientID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `Countries`
--
ALTER TABLE `Countries`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=253;

--
-- AUTO_INCREMENT for table `Map`
--
ALTER TABLE `Map`
  MODIFY `MapID` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Rooms`
--
ALTER TABLE `Rooms`
  MODIFY `RoomID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `Workers`
--
ALTER TABLE `Workers`
  MODIFY `WorkerID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `April`
--
ALTER TABLE `April`
  ADD CONSTRAINT `fk_April_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `August`
--
ALTER TABLE `August`
  ADD CONSTRAINT `fk_August_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `Clients`
--
ALTER TABLE `Clients`
  ADD CONSTRAINT `fk_Clients_HotelID` FOREIGN KEY (`HotelID`) REFERENCES `Hotels` (`HotelID`);

--
-- Constraints for table `December`
--
ALTER TABLE `December`
  ADD CONSTRAINT `fk_December_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `February`
--
ALTER TABLE `February`
  ADD CONSTRAINT `fk_February_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `January`
--
ALTER TABLE `January`
  ADD CONSTRAINT `fk_January_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `July`
--
ALTER TABLE `July`
  ADD CONSTRAINT `fk_July_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `June`
--
ALTER TABLE `June`
  ADD CONSTRAINT `fk_June_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `March`
--
ALTER TABLE `March`
  ADD CONSTRAINT `fk_March_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `May`
--
ALTER TABLE `May`
  ADD CONSTRAINT `fk_May_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `monetary_fine`
--
ALTER TABLE `monetary_fine`
  ADD CONSTRAINT `monetary_fine_Workers_WorkerID_fk` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `November`
--
ALTER TABLE `November`
  ADD CONSTRAINT `fk_November_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `October`
--
ALTER TABLE `October`
  ADD CONSTRAINT `fk_October_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `Rooms`
--
ALTER TABLE `Rooms`
  ADD CONSTRAINT `fk_Rooms_HotelID` FOREIGN KEY (`HotelID`) REFERENCES `Hotels` (`HotelID`);

--
-- Constraints for table `September`
--
ALTER TABLE `September`
  ADD CONSTRAINT `fk_September_WorkerID` FOREIGN KEY (`WorkerID`) REFERENCES `Workers` (`WorkerID`) ON DELETE CASCADE;

--
-- Constraints for table `Workers`
--
ALTER TABLE `Workers`
  ADD CONSTRAINT `fk_Workers_HotelID` FOREIGN KEY (`HotelID`) REFERENCES `Hotels` (`HotelID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
