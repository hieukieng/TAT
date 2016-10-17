-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2016 at 02:27 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `traffic_accident`
--

-- --------------------------------------------------------

--
-- Table structure for table `newscontent`
--

CREATE TABLE `newscontent` (
  `contentID` int(11) NOT NULL,
  `content` mediumtext CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `newsheader`
--

CREATE TABLE `newsheader` (
  `newsID` int(11) NOT NULL,
  `newsTitle` tinytext CHARACTER SET utf8,
  `newsDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sourceLink` tinytext CHARACTER SET utf8 NOT NULL,
  `newsDescription` mediumtext COLLATE utf8_unicode_ci,
  `username` varchar(30) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `newsheader`
--

INSERT INTO `newsheader` (`newsID`, `newsTitle`, `newsDate`, `sourceLink`, `newsDescription`, `username`) VALUES
(1, 'Container bất ngờ đâm 4 nhà dân trong đêm', '2016-10-15 17:00:56', 'http://www.24h.com.vn/tai-nan-giao-thong/container-bat-ngo-dam-4-nha-dan-trong-dem-c408a826051.html', 'Chiếc xe container đang lưu thông bỗng đột ngột đâm vào bốn ngôi nhà ven đường khiến một nhà bị sập, ba nhà bị hư hỏng phần mái, một cặp vợ chồng bị thương nhẹ.', 'user1'),
(2, 'Xe máy “đội” xe tải lúc 0 giờ, 1 người chết', '2016-10-15 17:00:56', 'http://www.24h.com.vn/tai-nan-giao-thong/xe-may-doi-xe-tai-luc-0-gio-1-nguoi-chet-c408a825756.html', 'Cú đối đầu cực mạnh khiến xe máy bị kẹt cứng dưới gầm xe tải và bị kéo đi một đoạn. Người đàn ông điều khiển xe máy bị lọt dưới gầm xe tải.', 'user2'),
(3, 'Tài xế, phụ xe tử vong sau gần 2 giờ kẹt trong cabin', '2016-10-15 17:03:36', 'http://www.24h.com.vn/tai-nan-giao-thong/2-nguoi-mat-ket-trong-cabin-tu-vong-vi-duong-tron-c408a826014.html', 'Vụ tai nạn nghiêm trọng xảy ra vào chiều tối 13-10, trên quốc lộ 1A (đoạn qua Phường Đậu Liêu, thị xã Hồng Lĩnh, Hà Tĩnh), xe tải đâm vào đuôi xe chở xi măng khiến tài xế và phụ xe mắc kẹt trong cabin, tử vong.', 'user3'),
(4, 'Xe 7 chỗ tông xe đạp điện, 2 vợ chồng tử vong', '2016-10-15 17:03:36', 'http://www.24h.com.vn/tai-nan-giao-thong/xe-7-cho-tong-xe-dap-dien-2-vo-chong-tu-vong-c408a824428.html', 'Khoảng hơn 8 giờ ngày 7-10, xe 7 chỗ tông vào xe đạp điện trên Quốc lộ 13, làm 2 vợ chồng tử vong.', 'user4'),
(5, 'Xe tải tông đổ cột đèn cao áp, 4 người nguy kịch', '2016-10-15 17:05:06', 'http://www.24h.com.vn/tin-tuc-trong-ngay/xe-tai-tong-do-cot-den-cao-ap-4-nguoi-nguy-kich-c46a796716.html', 'Mất lái, chiếc xe tải lao lên dải phân cách giữa đường tông đổ cột đèn cao áp vào sáng nay 11-6, khiến 4 người trên xe bị thương nặng được đưa vào bệnh viện cấp cứu.', 'user1'),
(6, 'Xe tải tông xe đầu kéo rồi bốc cháy, 2 người chết', '2016-10-15 17:05:06', 'http://www.24h.com.vn/tin-tuc-trong-ngay/xe-tai-tong-xe-dau-keo-roi-boc-chay-2-nguoi-chet-c46a805360.html', 'Một xe tải chở 6 người tông trực diện với xe đầu kéo dẫn đến cả hai xe bốc cháy, bị thiêu rụi hoàn toàn khiến 2 người thiệt mạng.', 'user2');

-- --------------------------------------------------------

--
-- Table structure for table `summary`
--

CREATE TABLE `summary` (
  `newsID` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `place` tinytext COLLATE utf8_unicode_ci,
  `deaths` int(11) DEFAULT '0',
  `injuries` int(11) DEFAULT '0',
  `reason` tinytext COLLATE utf8_unicode_ci,
  `vehicles` tinytext COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `task` varchar(20) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `newscontent`
--
ALTER TABLE `newscontent`
  ADD PRIMARY KEY (`contentID`);

--
-- Indexes for table `newsheader`
--
ALTER TABLE `newsheader`
  ADD PRIMARY KEY (`newsID`),
  ADD KEY `fk_user` (`username`);

--
-- Indexes for table `summary`
--
ALTER TABLE `summary`
  ADD PRIMARY KEY (`time`),
  ADD KEY `sum_header_idx` (`newsID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `newscontent`
--
ALTER TABLE `newscontent`
  MODIFY `contentID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `newsheader`
--
ALTER TABLE `newsheader`
  MODIFY `newsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `summary`
--
ALTER TABLE `summary`
  ADD CONSTRAINT `sum_header` FOREIGN KEY (`newsID`) REFERENCES `newsheader` (`newsID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
