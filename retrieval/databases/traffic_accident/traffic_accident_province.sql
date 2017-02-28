-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: traffic_accident
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `province`
--

DROP TABLE IF EXISTS `province`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `province` (
  `id` varchar(5) NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `province`
--

LOCK TABLES `province` WRITE;
/*!40000 ALTER TABLE `province` DISABLE KEYS */;
INSERT INTO `province` VALUES ('01','Hà Nội','Thành Phố'),('02','Hà Giang','Tỉnh'),('04','Cao Bằng','Tỉnh'),('06','Bắc Kạn','Tỉnh'),('08','Tuyên Quang','Tỉnh'),('10','Lào Cai','Tỉnh'),('11','Điện Biên','Tỉnh'),('12','Lai Châu','Tỉnh'),('14','Sơn La','Tỉnh'),('15','Yên Bái','Tỉnh'),('17','Hòa Bình','Tỉnh'),('19','Thái Nguyên','Tỉnh'),('20','Lạng Sơn','Tỉnh'),('22','Quảng Ninh','Tỉnh'),('24','Bắc Giang','Tỉnh'),('25','Phú Thọ','Tỉnh'),('26','Vĩnh Phúc','Tỉnh'),('27','Bắc Ninh','Tỉnh'),('30','Hải Dương','Tỉnh'),('31','Hải Phòng','Thành Phố'),('33','Hưng Yên','Tỉnh'),('34','Thái Bình','Tỉnh'),('35','Hà Nam','Tỉnh'),('36','Nam Định','Tỉnh'),('37','Ninh Bình','Tỉnh'),('38','Thanh Hóa','Tỉnh'),('40','Nghệ An','Tỉnh'),('42','Hà Tĩnh','Tỉnh'),('44','Quảng Bình','Tỉnh'),('45','Quảng Trị','Tỉnh'),('46','Thừa Thiên Huế','Tỉnh'),('48','Đà Nẵng','Thành Phố'),('49','Quảng Nam','Tỉnh'),('51','Quảng Ngãi','Tỉnh'),('52','Bình Định','Tỉnh'),('54','Phú Yên','Tỉnh'),('56','Khánh Hòa','Tỉnh'),('58','Ninh Thuận','Tỉnh'),('60','Bình Thuận','Tỉnh'),('62','Kon Tum','Tỉnh'),('64','Gia Lai','Tỉnh'),('66','Đắk Lắk','Tỉnh'),('67','Đắk Nông','Tỉnh'),('68','Lâm Đồng','Tỉnh'),('70','Bình Phước','Tỉnh'),('72','Tây Ninh','Tỉnh'),('74','Bình Dương','Tỉnh'),('75','Đồng Nai','Tỉnh'),('77','Bà Rịa - Vũng Tàu','Tỉnh'),('79','Hồ Chí Minh','Thành Phố'),('80','Long An','Tỉnh'),('82','Tiền Giang','Tỉnh'),('83','Bến Tre','Tỉnh'),('84','Trà Vinh','Tỉnh'),('86','Vĩnh Long','Tỉnh'),('87','Đồng Tháp','Tỉnh'),('89','An Giang','Tỉnh'),('91','Kiên Giang','Tỉnh'),('92','Cần Thơ','Thành Phố'),('93','Hậu Giang','Tỉnh'),('94','Sóc Trăng','Tỉnh'),('95','Bạc Liêu','Tỉnh'),('96','Cà Mau','Tỉnh');
/*!40000 ALTER TABLE `province` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-28 12:22:09
