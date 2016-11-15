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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `title` tinytext CHARACTER SET utf8,
  `date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `source_link` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  `description` mediumtext CHARACTER SET utf8,
  `username` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `image_url` varchar(500) CHARACTER SET utf8 DEFAULT 'https://s-media-cache-ak0.pinimg.com/564x/69/2b/7f/692b7fdec925793d38b4dd90ffb6e384.jpg',
  `content` mediumtext COLLATE utf8_unicode_ci,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `source_link_UNIQUE` (`source_link`),
  KEY `fk_user` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'Tin giao thông ngày 14/11: Tài xế \'húc\' cảnh sát giao thông bỏ chạy; nhiều phượt thủ chết thảm','2016-11-04 10:51:00','http://tintuc.vn/giao-thong/tin-giao-thong-ngay-1411-tai-xe-huc-canh-sat-giao-thong-bo-chay-nhieu-phuot-thu-chet-tham-163654','Vi phạm giao thông, tài xế húc văng CSGT để bỏ chạy; bàng hoàng những vụ phượt thủ tử vong vì tai nạn giao thông là hai trong số những thông tin giao thông nóng nhất vừa qua.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/14/550x500/xe-tai-can-chet-phuot-thu-doc-cun-un-tac-nghiem-trong-bb-baaabkbzop-bb-baaadoxr0s-bb-baaacjGTsl.jpg',NULL),(2,'Bàng hoàng những vụ phượt thủ tử vong vì tai nạn giao thông','2016-11-03 23:41:00','http://tintuc.vn/giao-thong/bang-hoang-nhung-vu-phuot-thu-tu-vong-vi-tai-nan-giao-thong-163512','Bên cạnh những chuyến phượt nhiều trải nghiệm còn là những câu chuyện đau lòng không đáng có về những mảnh đời rất trẻ mãi mãi phải nằm lại trên những cung đường do TNGT.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/13/550x500/nam-phuot-thu-xau-so-bb-baaacQt784.jpg',NULL),(3,'Va chạm với xe tải ở Sài Gòn, cặp nam nữ thương vong','2016-11-03 23:37:00','http://tintuc.vn/giao-thong/va-cham-voi-xe-tai-o-sai-gon-cap-nam-nu-thuong-vong-163525','Tông vào dải phân cách, đôi trai gái ngã ra đường và xảy ra va chạm với xe tải chạy cùng chiều khiến một người tử vong.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/14/doi-trai-gai-thuong-vong-sau-va-cham-voi-xe-tai-o-sai-gon-bb-baaadF226m.jpg',NULL),(4,'Xe tải cán chết phượt thủ, dốc Cun ùn tắc nghiêm trọng','2016-11-03 14:09:00','http://tintuc.vn/xa-hoi/xe-tai-can-chet-phuot-thu-doc-cun-un-tac-nghiem-trong-163511','Xe máy do một phượt thủ điều khiển xảy ra va chạm với xe tải chở cát chạy chiều ngược lại khiến nạn nhân ngã ra đường và bị bánh xe cán qua đầu, tử vong tại chỗ.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/13/xe-tai-can-chet-phuot-thu-doc-cun-un-tac-nghiem-trong-bb-baaabKBzoP.jpg',NULL),(5,'TPHCM: Ô tô 7 chỗ lật nhào, 3 người thoát chết trước mũi xe container','2016-11-03 10:47:00','http://tintuc.vn/giao-thong/tphcm-o-to-7-cho-lat-nhao-3-nguoi-thoat-chet-truoc-mui-xe-container-163485','3 người trong chiếc ô tô 7 chỗ đã may mắn thoát chết khi chiếc xe phanh gấp lật ngang trên quốc lộ 22, xã Tân Xuân, huyện Hóc Môn, TPHCM. Vụ tai nạn xảy ra vào sáng 13/11.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/13/o-to-7-cho-lat-nhao-3-nguoi-thoat-chet-truoc-mui-xe-container-bb-baaadzZ3B7.jpg',NULL),(6,'Tin giao thông ngày 12/11: Ô tô bị tàu hỏa đâm nát; cha mẹ thất thần bên thi thể con trai chết thảm','2016-11-02 12:29:00','http://tintuc.vn/giao-thong/tin-giao-thong-ngay-1211-o-to-bi-tau-hoa-dam-nat-cha-me-that-than-ben-thi-the-con-trai-chet-tham-163383','Tin tức giao thông nóng nhất vừa qua: Cố băng qua đường ray, ô tô bị tàu hỏa đâm nát; Cha mẹ thất thần bên thi thể con trai bị tai nạn giao thông...',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/12/550x500/14963116-678883488948234-7673660918227886559-n-2308-bb-baaacENOZn.jpg',NULL),(7,'Cố băng qua đường ray, ô tô bị tàu hỏa đâm nát','2016-11-02 07:50:00','http://tintuc.vn/giao-thong/co-bang-qua-duong-ray-o-to-bi-tau-hoa-dam-nat-163365','Cố băng qua đường ray khi tàu đang đến, chiếc ô tô Toyota Innova mang BKS 12A 05739 chở 2 người bị tàu đâm.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/12/550x500/14963116-678883488948234-7673660918227886559-n-2308-bb-baaacENOZn.jpg',NULL),(8,'Tin giao thông ngày 11/11: Người đi ô tô gây tai nạn làm ở Bộ Công an; \'Hung thần\' lao vào nhà dân','2016-11-01 13:04:00','http://tintuc.vn/giao-thong/tin-giao-thong-ngay-1111-nguoi-di-o-to-gay-tai-nan-lam-o-bo-cong-an-hung-than-lao-vao-nha-dan-163237','Thông tin giao thông nóng nhất vừa qua: Tài xế Innova đâm cô gái đang công tác tại Bộ Công an; Hung thần đâm thẳng vào nhà dân, cả gia đình may mắn thoát chết...',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/11/550x500/114-1223-1330-bb-baaadqSlqX.jpg',NULL),(9,'Tài xế lái ô tô tông ngã cô gái trên đường Võ Chí Công rồi bỏ chạy lên tiếng','2016-11-01 07:52:00','http://tintuc.vn/giao-thong/tai-xe-lai-o-to-tong-nga-co-gai-tren-duong-vo-chi-cong-roi-bo-chay-len-tieng-163207','Người điều khiển xe ô tô tông ngã cô gái đi xe máy trên đường Võ Chí Công cho biết, anh đang công tác tại Bộ Công an và không cố tình bỏ chạy khi gây ra tai nạn.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/11/550x500/114-1223-1330-bb-baaadqSlqX.jpg',NULL),(10,'Đề xuất cho xe bus lưu thông vào làn xe máy giờ cao điểm','2016-11-01 00:12:00','http://tintuc.vn/giao-thong/de-xuat-cho-xe-bus-luu-thong-vao-lan-xe-may-gio-cao-diem-163121','Mới đây, đại diện Sở GTVT TP HCM đã đưa ra đề xuất ưu tiên cho xe bus đi vào làn đường xe máy giờ cao điểm.',NULL,'http://media.tintuc.vn/uploads/medias/2016/11/11/de-xuat-cho-xe-bus-luu-thong-vao-lan-xe-may-gio-cao-diem-bb-baaabYhBXW.jpg',NULL),(11,'Tin nhanh:Mẹ chở con đi xe SH chết bất thường - Nạn nhân không phải bị chém - Tai nạn giao thông','2016-11-09 02:20:00','http://www.24h.com.vn/tai-nan-giao-thong/vu-me-cho-con-di-xe-sh-chet-bat-thuong-nan-nhan-khong-phai-bi-chem-c408a832260.html','Tin nhanh - Công an tỉnh Thái Bình đã chính thức có kết luận người mẹ tử vong khi đang chở con trên quốc lộ 39B. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-09/1478658058-147865728579832-tai-nan.jpg',NULL),(12,'Đôi nam nữ thương vong sau vụ va chạm kép - An ninh hình sự - Tin tức 24h','2016-11-14 00:31:00','http://www.24h.com.vn/tai-nan-giao-thong/doi-nam-nu-thuong-vong-sau-vu-va-cham-kep-c408a833342.html','doi nam nu thuong vong sau vu va cham kep - Đôi nam nữ chở nhau trên xe máy bất ngờ tông vào dải phân cách rồi va chạm với chiếc xe tải lưu thông cùng chiều gây',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-14/1479083325-hien-truong-tai-nan.jpg',NULL),(13,'Tai nạn giao thông mới nhất: Va chạm với ô tô, nam sinh viên tử nạn - Tai nạn giao thông','2016-11-13 01:18:00','http://www.24h.com.vn/tai-nan-giao-thong/va-cham-voi-o-to-nam-sinh-vien-tu-nan-c408a833176.html','Tai nan giao thong moi nhat - Đi trên đường quốc lộ 1A, một nam sinh viên trường Lâm nghiệp điều khiển xe mô tô đâm vào xe ngược chiều. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-13/1479003699-va-cham.jpg',NULL),(14,'Đánh nhau như phim chưởng sau va chạm giao thông - An ninh hình sự - Tin tức 24h','2016-11-14 03:20:00','http://www.24h.com.vn/tai-nan-giao-thong/danh-nhau-nhu-phim-chuong-sau-va-cham-giao-thong-c408a833391.html','danh nhau nhu phim chuong sau va cham giao thong - Điều đáng buồn hơn, trong những vụ bạo lực khi tham gia giao thông, đám đông xung quanh không những không can',NULL,'',NULL),(15,'Tai nạn, 3 người văng xuống đường, 1 người chết - An ninh hình sự - Tin tức 24h','2016-11-14 11:45:00','http://www.24h.com.vn/tai-nan-giao-thong/tai-nan-3-nguoi-vang-xuong-duong-1-nguoi-chet-c408a833561.html','Tai nan 3 nguoi vang xuong duong 1 nguoi chet - Vụ TNGT nghiêm trọng xảy ra vào khoảng 19h00 ngày 12/11, tại đường đường Trần Huy Liệu, phường 8, quận Phú',NULL,'',NULL),(16,'Tin tức mới trong ngày: Vừa ra tù vì trộm cắp, thanh niên lại đi “ăn hàng” - Tai nạn giao thông','2016-11-09 13:28:00','http://www.24h.com.vn/tai-nan-giao-thong/vua-ra-tu-vi-trom-cap-thanh-nien-lai-di-an-hang-c408a832437.html','Nghe tiếng truy hô cướp, chiến sĩ công an đang làm nhiệm vụ tại bốt trực Cơ quan đại diện phía Nam – Truyền hình Công an nhân dân lao ra quật ngã, khống chế đối tượng nghi vấn. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-09/1478698092-14786977058185-img_1136.jpg',NULL),(17,'Tin nong trong ngay: Xe tải đâm vào 4 nhà dân, 1 người chết - Tai nạn giao thông','2016-11-14 11:33:00','http://www.24h.com.vn/tai-nan-giao-thong/xe-tai-dam-vao-4-nha-dan-1-nguoi-chet-c408a833555.html','Tin nong trong ngay: Sau khi mất lái, chiếc xe tải đã đâm liên tiếp 4 nhà dân, khiến tài xế tử vong sau khi đưa đi cấp cứu. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-14/1479123154-xe-tai--1-.jpg',NULL),(18,'“Ma men” chửi bới CSGT, cố thủ trong \"xế hộp\" - An ninh hình sự - Tin tức 24h','2016-11-10 09:43:00','http://www.24h.com.vn/tai-nan-giao-thong/ma-men-chui-boi-csgt-co-thu-trong-xe-hop-c408a832641.html','Ma men chui boi CSGT co thu trong xe hop - Khi dừng xe, do có sẵn hơi men trong người, tài xế Ngọc có những lời lẽ thô tục, xúc phạm cán bộ CSGT tỉnh Quảng Nam',NULL,'',NULL),(19,'Tai nạn giao thông mới nhất: Lái xe bỏ chạy sau va chạm khiến nữ sinh 16 tuổi tử vong - Tai nạn giao thông','2016-11-11 10:06:00','http://www.24h.com.vn/tai-nan-giao-thong/lai-xe-bo-chay-sau-va-cham-khien-nu-sinh-16-tuoi-tu-vong-c408a832899.html','Tai nan giao thong moi nhat - Sau khi va chạm làm thiếu nữ 16 tuổi tử nạn, lái xe cẩu đã lái xe rời khỏi hiện trường khiến nhiều người bức xúc. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-11/1478858770-14788587352786-tai-nan-2.jpg',NULL),(20,'Tin mới nhất: TP.HCM: Container lật ngang trên dốc cầu, giao thông tê liệt - Tai nạn giao thông','2016-11-09 02:21:00','http://www.24h.com.vn/tai-nan-giao-thong/tphcm-container-lat-ngang-tren-doc-cau-giao-thong-te-liet-c408a832261.html','Tin mới nhất - Đang chạy ôm cua lên cầu vượt, xe container chở theo thùng hàng loại 40 feet bất ngờ bị nghiêng rồi lật nhào ngang đường - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-09/1478658075-147865793813292-anh-2.jpg',NULL),(21,'Pháp Luật: Công an Thái Bình phân tích vụ mẹ chết bất thường khi chở con - Tai nạn giao thông','2016-11-09 07:51:00','http://www.24h.com.vn/tai-nan-giao-thong/cong-an-thai-binh-phan-tich-vu-me-chet-bat-thuong-khi-cho-con-c408a832342.html','Pháp Luật - Căn cứ lời khai nhân chứng, hình ảnh camera và các tài liệu điều tra, công an tỉnh Thái Bình xác định, chị Cúc tử vong do gặp tai nạn, không phải bị chém. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-09/1478677874-147867720712084-2trong-an.jpg',NULL),(22,'Tin mới: Thùng hàng container xé toạc cabin, tài xế tử vong - Tai nạn giao thông','2016-11-10 14:56:00','http://www.24h.com.vn/tai-nan-giao-thong/thung-hang-container-xe-toac-cabin-tai-xe-tu-vong-c408a832693.html','Tin moi - Đang ôm cua trên đường, thùng hàng container bất ngờ lao về trước xé toạc cabin, tài xế mắc kẹt bên trong. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-10/1478789491-14787892285056-dong-nai-45.jpg',NULL),(23,'Tai nạn giao thông mới nhất: Xế hộp lật nằm giữa đường, container phanh cháy đường - Tai nạn giao thông','2016-11-12 17:15:00','http://www.24h.com.vn/tai-nan-giao-thong/xe-hop-lat-nam-giua-duong-container-phanh-chay-duong-tranh-tai-nan-c408a833223.html','Tai nan giao thong moi nhat - Thấy nhiều người nhốn nháo trong ô tô 7 chỗ lật nhào, tài xế container chạy phía sau phanh gấp “cháy” cả một đoạn đường. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-13/1479013880-147901364663857-anh-2.jpg',NULL),(24,'Lật xe khách, 2 người chết, 14 người bị thương - An ninh hình sự - Tin tức 24h','2016-11-09 10:41:00','http://www.24h.com.vn/tai-nan-giao-thong/lat-xe-khach-2-nguoi-chet-14-nguoi-bi-thuong-c408a832401.html','Lat xe khach 2 nguoi chet 14 nguoi bi thuong - Sáng 9.11, Công an huyện Nam Giang (Quảng Nam) cho biết đơn vị hiện đang khẩn trương ứng cứu, điều tra vụ TNGT',NULL,'',NULL),(25,'Tai nạn giao thông mới nhất: Lật xe khách, 2 người chết, 14 người bị thương - Tai nạn giao thông','2016-11-09 02:30:00','http://www.24h.com.vn/tai-nan-giao-thong/lat-xe-khach-2-nguoi-chet-14-nguoi-bi-thuong-c408a832262.html','Tai nạn giao thông mới nhất - Lực lượng chức năng đang điều xe cứu hộ đến hiện trường cẩu chiếc xe khách bị lật lên để đưa những người bị tử vong ra ngoài. - Tai nạn giao thông',NULL,'http://image.24h.com.vn/upload/4-2016/images/2016-11-09/1478658577-tai-nan--1-.jpg',NULL);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary`
--

DROP TABLE IF EXISTS `summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summary` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NOT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `place` tinytext COLLATE utf8_unicode_ci,
  `deaths` int(11) DEFAULT '0',
  `injuries` int(11) DEFAULT '0',
  `reason` tinytext COLLATE utf8_unicode_ci,
  `vehicles` tinytext COLLATE utf8_unicode_ci,
  `username` varchar(30) COLLATE utf8_unicode_ci DEFAULT 'Tóm tắt tự động',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary`
--

LOCK TABLES `summary` WRITE;
/*!40000 ALTER TABLE `summary` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary_user`
--

DROP TABLE IF EXISTS `summary_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summary_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `place` tinytext COLLATE utf8_unicode_ci,
  `deaths` int(11) DEFAULT '0',
  `injuries` int(11) DEFAULT '0',
  `reason` tinytext COLLATE utf8_unicode_ci,
  `vehicles` tinytext COLLATE utf8_unicode_ci,
  `username` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary_user`
--

LOCK TABLES `summary_user` WRITE;
/*!40000 ALTER TABLE `summary_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `first_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(10) COLLATE utf8_unicode_ci DEFAULT 'MALE',
  `birthday` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `phone_number` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `joined_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `position` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-15  9:32:54
