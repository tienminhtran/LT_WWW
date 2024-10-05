-- Dumping database structure for mydb
CREATE DATABASE IF NOT EXISTS `week1` /*!40100 DEFAULT CHARACTER SET latin1 
COLLATE latin1_swedish_ci */;
USE `week1`;
-- Dumping structure for table mydb.account
CREATE TABLE IF NOT EXISTS `account` (
`account_id` varchar(50) NOT NULL,
`full_name` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`email` varchar(50) DEFAULT NULL,
`phone` varchar(50) DEFAULT NULL,
`status` tinyint(4) NOT NULL DEFAULT 1,
PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- Dumping structure for table mydb.role
CREATE TABLE IF NOT EXISTS `role` (
`role_id` varchar(50) NOT NULL,
`role_name` varchar(50) NOT NULL,
`description` varchar(50) DEFAULT NULL,
`status` tinyint(4) NOT NULL,
PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=LATIN1_SWEDISH_CI;

-- Dumping structure for table mydb.grant_access
CREATE TABLE IF NOT EXISTS `grant_access` (
`role_id` varchar(50) NOT NULL,
`account_id` varchar(50) NOT NULL,
`is_grant` bit(1) NOT NULL DEFAULT b'1',
`note` varchar(250) DEFAULT '',
PRIMARY KEY (`role_id`,`account_id`),
KEY `account_grant` (`account_id`),
CONSTRAINT `account_grant` FOREIGN KEY (`account_id`) REFERENCES `account`(`account_id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `role_grant` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci; 

-- Dumping structure for table mydb.log
CREATE TABLE IF NOT EXISTS `log` (
`id` bigint(20) NOT NULL AUTO_INCREMENT,
`account_id` varchar(50) NOT NULL,
`login_time` datetime NOT NULL DEFAULT current_timestamp(),
`logout_time` datetime NOT NULL DEFAULT current_timestamp(),
`notes` varchar(250) NOT NULL DEFAULT '',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 
COLLATE=latin1_swedish_ci COMMENT='ghi logs';
-- Dumping data for table mydb.log: ~0 rows (approximately)


-- Dumping data for table mydb.account: ~2 rows (approximately)
INSERT INTO `account` (`account_id`, `full_name`, `password`, `email`,`phone`, `status`) VALUES
('met', 'Tran Thi Met', '123', 'met@gmail.com', '0904567890', 1),
('teo', 'NGuyen Van Teo', '123', 'teo@gmail.com', '0903123456', 1);

('anh', 'Nguyen Thi Anh', '123', 'anh@gmail.com', '0909876543', 1),
('bao', 'Tran Minh Bao', '123', 'bao@gmail.com', '0901122334', 1),
('cuong', 'Pham Van Cuong', '123', 'cuong@gmail.com', '0902233445', 1),
('dung', 'Le Thi Dung', '123', 'dung@gmail.com', '0903344556', 1),
('huong', 'Nguyen Van Huong', '123', 'huong@gmail.com', '0904455667', 1),
('khanh', 'Pham Thi Khanh', '123', 'khanh@gmail.com', '0905566778', 1),
('long', 'Le Minh Long', '123', 'long@gmail.com', '0906677889', 1),
('mai', 'Tran Thi Mai', '123', 'mai@gmail.com', '0907788990', 1);
-- Dumping data for table mydb.role: ~2 rows (approximately)
INSERT INTO `role` (`role_id`, `role_name`, `description`, `status`) VALUES
('admin', 'administrator', 'admin role', 1),
('user', 'user', 'user role', 1);
-- Dumping data for table mydb.grant_access: ~2 rows (approximately)
INSERT INTO `grant_access` (`role_id`, `account_id`, `is_grant`, `note`)VALUES
('admin', 'teo', b'1', ''),
('user', 'met', b'1', '');
('admin', 'anh', b'1', ''),
('user', 'bao', b'1', ''),
('user', 'cuong', b'1', ''),
('user', 'dung', b'1', ''),
('user', 'huong', b'1', ''),
('user', 'khanh', b'1', ''),
('user', 'long', b'1', ''),
('user', 'mai', b'1', '');
