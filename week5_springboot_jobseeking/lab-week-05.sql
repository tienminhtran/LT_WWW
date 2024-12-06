-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.2.0-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for works
CREATE DATABASE IF NOT EXISTS `works` /*!40100 DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci */;
USE `works`;

-- Dumping structure for table works.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `street` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` smallint(6) DEFAULT NULL CHECK (`country` between 0 and 201),
  `number` varchar(20) DEFAULT NULL,
  `zipcode` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table works.candidate
CREATE TABLE IF NOT EXISTS `candidate` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dob` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `address` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qfut8ruekode092nlkipgl09g` (`email`),
  UNIQUE KEY `UK_9i5yt1gvm0chg5e10qkns7tll` (`phone`),
  UNIQUE KEY `UK_m8qhlm4wu215gr34dhxp0dour` (`address`),
  CONSTRAINT `FKa8gnyyhbb2qnhp94grci1n0o9` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table works.candidate_skill
CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) NOT NULL CHECK (`skill_level` between 0 and 2),
  `skill_id` bigint(20) NOT NULL,
  `can_id` bigint(20) NOT NULL,
  PRIMARY KEY (`can_id`,`skill_id`),
  KEY `FKb7cxhiqhcah7c20a2cdlvr1f8` (`skill_id`),
  CONSTRAINT `FKb0m5tm3fi0upa3b3kjx3vrlxs` FOREIGN KEY (`can_id`) REFERENCES `candidate` (`id`),
  CONSTRAINT `FKb7cxhiqhcah7c20a2cdlvr1f8` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table works.company
CREATE TABLE IF NOT EXISTS `company` (
  `comp_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `about` varchar(2000) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `comp_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `web_url` varchar(255) DEFAULT NULL,
  `address` bigint(20) NOT NULL,
  PRIMARY KEY (`comp_id`),
  UNIQUE KEY `UK_rvp2hunsq4sgmpxe3a7i1ym3m` (`address`),
  CONSTRAINT `FKd5occp4cjwihejbxdbpvkp5tv` FOREIGN KEY (`address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table works.job
CREATE TABLE IF NOT EXISTS `job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `job_desc` varchar(2000) NOT NULL,
  `job_name` varchar(255) NOT NULL,
  `company` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `FKbaqlvluu78phmo9ld89um7wnm` (`company`),
  CONSTRAINT `FKbaqlvluu78phmo9ld89um7wnm` FOREIGN KEY (`company`) REFERENCES `company` (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table works.job_skill
CREATE TABLE IF NOT EXISTS `job_skill` (
  `more_infos` varchar(1000) DEFAULT NULL,
  `skill_level` tinyint(4) NOT NULL CHECK (`skill_level` between 0 and 2),
  `job_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FKj33qbbf3vk1lvhqpcosnh54u1` (`skill_id`),
  CONSTRAINT `FK9ix4wg520ii2gu2felxdhdup6` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `FKj33qbbf3vk1lvhqpcosnh54u1` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

-- Dumping structure for table works.skill
CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `skill_description` varchar(255) DEFAULT NULL,
  `skill_name` varchar(255) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL CHECK (`type` between 0 and 2),
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Data exporting was unselected.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;


INSERT INTO `address` (`id`, `street`, `city`, `country`, `number`, `zipcode`) VALUES
(1, 'Rua do Ouro', 'Lisboa', 1, '123', '1100'),
(2, 'Rua da Prata', 'Lisboa', 1, '456', '1100'),
(3, 'Rua Augusta', 'Lisboa', 1, '789', '1100'),
(4, 'Rua do Ouro', 'Porto', 2, '123', '4000'),
(5, 'Rua da Prata', 'Porto', 2, '456', '4000'),
(6, 'Rua Augusta', 'Porto', 2, '789', '4000');

INSERT INTO `candidate` (`id`, `dob`, `email`, `full_name`, `phone`, `address`) VALUES
(1, '1990-01-01', 'join@gmail.com', 'João Silva', '912345678', 1),
(1, '1990-01-01', 'join@gmail.com', 'João Silva', '912345678', 2),
(3, '1990-01-01', 'join@gmail.com', 'João Silva', '912345678', 3),
(4, '1990-01-01', 'join@gmail.com', 'João Silva', '912345678', 4),
(5, '1990-01-01', 'join@gmail.com', 'João Silva', '912345678', 5),
(6, '1990-01-01', 'join@gmail.com', 'João Silva', '912345678', 6),

INSERT INTO `company` (`comp_id`, `about`, `email`, `comp_name`, `phone`, `web_url`, `address`) VALUES
    (1, 'Leading software company', 'info@techcorp.com', 'TechCorp', '555123456', 'http://techcorp.com', 1),
    (2, 'Innovative startup', 'contact@startuphub.com', 'StartupHub', '555987654', 'http://startuphub.com', 2),
    (3, 'Global consulting firm', 'support@consultingglobal.com', 'ConsultingGlobal', '555456789', 'http://consultingglobal.com', 3);
INSERT INTO `job` (`job_id`, `job_desc`, `job_name`, `company`) VALUES
    (1, 'Software Developer', 'Software Developer', 1),
    (2, 'Data Analyst', 'Data Analyst', 2),
    (3, 'Business Analyst', 'Business Analyst', 3);

INSERT INTO `job_skill` (`more_infos`, `skill_level`, `job_id`, `skill_id`) VALUES
 ('Must have 3 years of experience', 2, 1, 1),
 ('React knowledge is a plus', 1, 2, 2),
  ('SQL and database optimization', 2, 3, 3);

INSERT INTO `skill` (`skill_id`, `skill_description`, `skill_name`, `type`) VALUES
    (1, 'Java programming language', 'Java', 1),
    (2, 'React library', 'React', 1),
    (3, 'SQL language', 'SQL', 1);

