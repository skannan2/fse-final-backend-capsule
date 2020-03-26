-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.38 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for task_manager_new
CREATE DATABASE IF NOT EXISTS `task_manager_new` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `task_manager_new`;

-- Dumping structure for table task_manager_new.parent_task_tbl
CREATE TABLE IF NOT EXISTS `parent_task_tbl` (
  `parent_task_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_task` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`parent_task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table task_manager_new.task_tbl
CREATE TABLE IF NOT EXISTS `task_tbl` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `end_date` date DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `task` varchar(255) DEFAULT NULL,
  `parent_task_tbl_parent_task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  KEY `FKghfxeilwov2kx52hn1x84thx4` (`parent_task_tbl_parent_task_id`),
  CONSTRAINT `FKghfxeilwov2kx52hn1x84thx4` FOREIGN KEY (`parent_task_tbl_parent_task_id`) REFERENCES `parent_task_tbl` (`parent_task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
