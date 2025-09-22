-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.3.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for tuan09
DROP DATABASE IF EXISTS `tuan09`;
CREATE DATABASE IF NOT EXISTS `tuan09` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `tuan09`;

-- Dumping structure for table tuan09.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table tuan09.category: ~4 rows (approximately)
INSERT INTO `category` (`cart_id`, `name`) VALUES
	(1, 'Book'),
	(2, 'Food'),
	(3, 'Game'),
	(4, 'Phone'),
	(5, 'Table');

-- Dumping structure for table tuan09.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double DEFAULT NULL,
  `register_date` datetime(6) DEFAULT NULL,
  `cart_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtpn0u2u177t0ufycirtv9ag7x` (`cart_id`),
  CONSTRAINT `FKtpn0u2u177t0ufycirtv9ag7x` FOREIGN KEY (`cart_id`) REFERENCES `category` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table tuan09.product: ~11 rows (approximately)
INSERT INTO `product` (`id`, `code`, `description`, `name`, `price`, `register_date`, `cart_id`) VALUES
	(1, 'Pro123-05', 'Mô tả', 'Tuduynguoc', 10.5, '2024-11-30 19:48:16.869000', 1),
	(2, 'Pro123-01', 'CNTT', 'Congnghe', 25.25, '2024-11-30 20:36:44.030000', 2),
	(3, 'Pro123-02', 'KhoaHocMoTa', 'KhoaHoc', 50.01, '2024-11-30 20:37:07.960000', 3),
	(4, 'Pro123-03', 'Sinhton', 'PUPG', 25, '2024-11-30 20:37:29.112000', 3),
	(5, 'Pro123-05', 'Điện thoại', 'Iphone', 235.5, '2024-11-30 20:38:02.125000', 4),
	(6, 'Pro123-06', 'NguVan', 'VoNhat', 20.2, '2024-11-30 20:38:57.478000', 1),
	(7, 'Pro123-10', 'Giaoduc', 'Education', 10, '2024-11-30 20:41:05.621000', 1),
	(8, 'Pro123-11', 'Banh', 'Pizza', 50, '2024-11-30 20:41:23.770000', 2),
	(9, 'Pro123-12', 'GiaiTri', 'Lienquan', 50, '2024-11-30 20:41:42.835000', 3),
	(10, 'Pro123-12', 'dienThoai', 'Samsung', 100, '2024-11-30 20:42:40.706000', 4),
	(11, 'Pro123-08', 'NguVan', 'LaoHac', 70, '2024-11-30 20:43:06.146000', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
