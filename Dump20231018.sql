-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `allcollegedata`
--

DROP TABLE IF EXISTS `allcollegedata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allcollegedata` (
  `DIVISION_NAME` varchar(45) DEFAULT NULL,
  `DISTRICT_NAME` varchar(45) DEFAULT NULL,
  `THANA_NAME` varchar(45) DEFAULT NULL,
  `TYP` varchar(45) DEFAULT NULL,
  `LVL` varchar(45) DEFAULT NULL,
  `EIIN` varchar(45) DEFAULT NULL,
  `INSTITUTE_NAME_NEW` varchar(255) DEFAULT NULL,
  `POST_OFFICE` varchar(45) DEFAULT NULL,
  `LOCATION` varchar(45) DEFAULT NULL,
  `MOBPHONE` varchar(45) DEFAULT NULL,
  `KEY_COLUMN` int DEFAULT NULL,
  `ai` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ai`),
  UNIQUE KEY `ai_UNIQUE` (`ai`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allcollegedata`
--

LOCK TABLES `allcollegedata` WRITE;
/*!40000 ALTER TABLE `allcollegedata` DISABLE KEYS */;
/*!40000 ALTER TABLE `allcollegedata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendence`
--

DROP TABLE IF EXISTS `attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendence` (
  `attendanceId` int NOT NULL AUTO_INCREMENT,
  `traineeId` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `attendance` tinyint NOT NULL,
  PRIMARY KEY (`attendanceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendence`
--

LOCK TABLES `attendence` WRITE;
/*!40000 ALTER TABLE `attendence` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `attemp` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`attemp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'sabit','4321'),(2,'nahid','5678');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff_attendence`
--

DROP TABLE IF EXISTS `staff_attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff_attendence` (
  `staffId` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `attendence` tinyint(1) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`staffId`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff_attendence`
--

LOCK TABLES `staff_attendence` WRITE;
/*!40000 ALTER TABLE `staff_attendence` DISABLE KEYS */;
INSERT INTO `staff_attendence` VALUES (1,'nahid@gmail.com',1,'2023-10-07'),(1,'nahid@gmail.com',1,'2023-10-13'),(1,'nahid@gmail.com',1,'2023-10-31'),(2,'demo2@gmaill.com',1,'2023-10-07'),(2,'demo2@gmaill.com',1,'2023-10-13'),(2,'demo2@gmaill.com',1,'2023-10-31'),(4,'demo4@gmail.com',0,'2023-10-07'),(4,'demo4@gmail.com',1,'2023-10-13'),(4,'demo4@gmail.com',1,'2023-10-31'),(15,'slkdjfkfj',1,'2023-10-07'),(15,'slkdjfkfj',0,'2023-10-13'),(15,'slkdjfkfj',0,'2023-10-31');
/*!40000 ALTER TABLE `staff_attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staffdata`
--

DROP TABLE IF EXISTS `staffdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffdata` (
  `staffId` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `staffPicturePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staffId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staffdata`
--

LOCK TABLES `staffdata` WRITE;
/*!40000 ALTER TABLE `staffdata` DISABLE KEYS */;
INSERT INTO `staffdata` VALUES (1,'nahid@gmail.com',26,'Male','2023-10-07',NULL),(2,'demo2@gmaill.com',27,'Male','2023-10-05',NULL),(4,'demo4@gmail.com',27,'Male','2023-10-05',NULL),(15,'slkdjfkfj',25,'Male','2023-10-13','C:\\Users\\imran\\Desktop\\Scan.jpg');
/*!40000 ALTER TABLE `staffdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `std_attendance`
--

DROP TABLE IF EXISTS `std_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `std_attendance` (
  `traineeId` int NOT NULL,
  `batchId` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `attendance` tinyint(1) DEFAULT NULL,
  `date` varchar(45) NOT NULL,
  PRIMARY KEY (`traineeId`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `std_attendance`
--

LOCK TABLES `std_attendance` WRITE;
/*!40000 ALTER TABLE `std_attendance` DISABLE KEYS */;
INSERT INTO `std_attendance` VALUES (1,'2023','sabit',1,''),(1212,'12','1212',0,''),(1264,'66556','skdfkdf',1,''),(2121,'1212','ghj',0,''),(12345,'2023','ghj',1,''),(23232,'25','sabit',0,''),(101234,'dfd','dfd',0,''),(454545,'454','ghdg',0,'');
/*!40000 ALTER TABLE `std_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `std_attendence1`
--

DROP TABLE IF EXISTS `std_attendence1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `std_attendence1` (
  `roll` int NOT NULL,
  `stdClass` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `attendance` tinyint(1) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`roll`,`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `std_attendence1`
--

LOCK TABLES `std_attendence1` WRITE;
/*!40000 ALTER TABLE `std_attendence1` DISABLE KEYS */;
INSERT INTO `std_attendence1` VALUES (1,'1','ddfd',1,'2023-10-07'),(1,'2023','sabit',1,'2023-10-22'),(1,'2023','sabit',1,'2023-10-26'),(1,'2023','sabit',0,'2023-10-27'),(1,'2023','sabit',0,'2023-10-30'),(2,'1','df',1,'2023-10-07'),(3,'1','sdsds',0,'2023-10-07'),(25,'2023','dfdf',0,'2023-10-22'),(1212,'12','1212',1,'2023-10-22'),(1212,'12','1212',1,'2023-10-26'),(1212,'12','1212',0,'2023-10-27'),(1212,'12','1212',0,'2023-10-30'),(1264,'66556','skdfkdf',0,'2023-10-22'),(1264,'66556','skdfkdf',1,'2023-10-26'),(1264,'66556','skdfkdf',0,'2023-10-27'),(1264,'66556','skdfkdf',0,'2023-10-30'),(2121,'1212','ghj',1,'2023-10-22'),(2121,'1212','ghj',1,'2023-10-26'),(2121,'1212','ghj',0,'2023-10-27'),(2121,'1212','ghj',1,'2023-10-30'),(3333,'2023','santo',1,'2023-10-22'),(12345,'2023','ghj',0,'2023-10-22'),(12345,'2023','ghj',0,'2023-10-26'),(12345,'2023','ghj',1,'2023-10-27'),(12345,'2023','ghj',1,'2023-10-30'),(23232,'25','sabit',1,'2023-10-22'),(23232,'25','sabit',0,'2023-10-26'),(23232,'25','sabit',1,'2023-10-27'),(23232,'25','sabit',1,'2023-10-30'),(101234,'dfd','dfd',0,'2023-10-22'),(101234,'dfd','dfd',0,'2023-10-26'),(101234,'dfd','dfd',1,'2023-10-27'),(101234,'dfd','dfd',0,'2023-10-30'),(454545,'454','ghdg',0,'2023-10-22'),(454545,'454','ghdg',0,'2023-10-26'),(454545,'454','ghdg',1,'2023-10-27'),(454545,'454','ghdg',0,'2023-10-30');
/*!40000 ALTER TABLE `std_attendence1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentattendance`
--

DROP TABLE IF EXISTS `studentattendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentattendance` (
  `traineeId` int NOT NULL,
  `batchId` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `attendence_date` date NOT NULL,
  `attendened` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`traineeId`,`attendence_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentattendance`
--

LOCK TABLES `studentattendance` WRITE;
/*!40000 ALTER TABLE `studentattendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentattendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentdata`
--

DROP TABLE IF EXISTS `studentdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentdata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roll` int DEFAULT NULL,
  `stdClass` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `fathersName` varchar(45) DEFAULT NULL,
  `mothersName` varchar(45) DEFAULT NULL,
  `address` varchar(155) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `age` int DEFAULT NULL,
  `picturePath` varchar(255) DEFAULT NULL,
  `accountNumber` varchar(45) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `cardName` varchar(45) DEFAULT NULL,
  `paymentMethod` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentdata`
--

LOCK TABLES `studentdata` WRITE;
/*!40000 ALTER TABLE `studentdata` DISABLE KEYS */;
INSERT INTO `studentdata` VALUES (1,1,1,'ddfd','dfdf','dfd','dfd','dfdf','Male','2023-10-13',25,'C:\\Users\\imran\\Desktop\\Scan.jpg','4554',454,'2023-10-05','dfdf',NULL),(2,2,1,'df','dfd','dfd','df','dfd','Male','2023-10-13',25,'C:\\Users\\imran\\Desktop\\Scan.jpg','sdfdf',5000,'2023-10-17','assds',NULL),(3,3,1,'sdsds','sdsdds','sdsdds','sds','sdds','Male','2023-10-06',25,'C:\\Users\\imran\\Desktop\\Scan.jpg','dfdf',5000,'2023-10-06','ghg','Bkash');
/*!40000 ALTER TABLE `studentdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_attendence`
--

DROP TABLE IF EXISTS `teacher_attendence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_attendence` (
  `teacherId` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `attendence` tinyint(1) DEFAULT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`date`,`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_attendence`
--

LOCK TABLES `teacher_attendence` WRITE;
/*!40000 ALTER TABLE `teacher_attendence` DISABLE KEYS */;
INSERT INTO `teacher_attendence` VALUES (444,'dfd',0,'2023-10-01'),(2121,'sdfd',0,'2023-10-01'),(3311,'sadfdf',1,'2023-10-01'),(3333,'sabit@gmail.com',0,'2023-10-01'),(9999,'ddf',1,'2023-10-01'),(11111,'dfdf',1,'2023-10-01'),(21212,'dfdf',1,'2023-10-01'),(22222,'fgfgf',0,'2023-10-01'),(77777,'sdsd',1,'2023-10-01'),(101010,'fsfds',0,'2023-10-01'),(444,'dfd',1,'2023-10-02'),(2121,'sdfd',0,'2023-10-02'),(3311,'sadfdf',1,'2023-10-02'),(3333,'sabit@gmail.com',1,'2023-10-02'),(9999,'ddf',0,'2023-10-02'),(11111,'dfdf',1,'2023-10-02'),(21212,'dfdf',0,'2023-10-02'),(22222,'fgfgf',0,'2023-10-02'),(77777,'sdsd',0,'2023-10-02'),(101010,'fsfds',0,'2023-10-02'),(444,'dfd',0,'2023-10-03'),(2121,'sdfd',0,'2023-10-03'),(3311,'sadfdf',1,'2023-10-03'),(3333,'sabit@gmail.com',0,'2023-10-03'),(9999,'ddf',1,'2023-10-03'),(11111,'dfdf',0,'2023-10-03'),(21212,'dfdf',1,'2023-10-03'),(22222,'fgfgf',0,'2023-10-03'),(77777,'sdsd',1,'2023-10-03'),(101010,'fsfds',0,'2023-10-03'),(444,'dfd',1,'2023-10-14'),(2121,'sdfd',1,'2023-10-14'),(3311,'sadfdf',1,'2023-10-14'),(3333,'sabit@gmail.com',1,'2023-10-14'),(9999,'ddf',1,'2023-10-14'),(11111,'dfdf',1,'2023-10-14'),(21212,'dfdf',1,'2023-10-14'),(22222,'fgfgf',1,'2023-10-14'),(77777,'sdsd',1,'2023-10-14'),(101010,'fsfds',1,'2023-10-14'),(444,'dfd',0,'2023-10-21'),(2121,'sdfd',1,'2023-10-21'),(3311,'sadfdf',1,'2023-10-21'),(3333,'sabit@gmail.com',0,'2023-10-21'),(9999,'ddf',1,'2023-10-21'),(11111,'dfdf',1,'2023-10-21'),(21212,'dfdf',1,'2023-10-21'),(22222,'fgfgf',0,'2023-10-21'),(77777,'sdsd',0,'2023-10-21'),(101010,'fsfds',0,'2023-10-21'),(444,'dfd',1,'2023-10-28'),(2121,'sdfd',1,'2023-10-28'),(3311,'sadfdf',0,'2023-10-28'),(3333,'sabit@gmail.com',1,'2023-10-28'),(9999,'ddf',1,'2023-10-28'),(11111,'dfdf',0,'2023-10-28'),(21212,'dfdf',0,'2023-10-28'),(22222,'fgfgf',0,'2023-10-28'),(77777,'sdsd',0,'2023-10-28'),(101010,'fsfds',0,'2023-10-28'),(444,'dfd',0,'2023-10-31'),(2121,'sdfd',0,'2023-10-31'),(3311,'sadfdf',1,'2023-10-31'),(3333,'sabit@gmail.com',0,'2023-10-31'),(9999,'ddf',0,'2023-10-31'),(11111,'dfdf',1,'2023-10-31'),(21212,'dfdf',1,'2023-10-31'),(22222,'fgfgf',1,'2023-10-31'),(77777,'sdsd',1,'2023-10-31'),(101010,'fsfds',0,'2023-10-31');
/*!40000 ALTER TABLE `teacher_attendence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacherdata`
--

DROP TABLE IF EXISTS `teacherdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacherdata` (
  `teacherId` int NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `teacherPicturePath` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacherId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacherdata`
--

LOCK TABLES `teacherdata` WRITE;
/*!40000 ALTER TABLE `teacherdata` DISABLE KEYS */;
INSERT INTO `teacherdata` VALUES (444,'dfd',454,'Male','2023-10-07','C:\\Users\\imran\\Desktop\\sir.png'),(2121,'sdfd',32,'Male','2023-10-07','C:\\Users\\imran\\Desktop\\sir.png'),(3311,'sadfdf',65,'Male','2023-10-06','C:\\Users\\imran\\Desktop\\demo5.png'),(3333,'sabit@gmail.com',25,'Male','2023-10-03','C:\\Users\\imran\\Desktop\\Scan.jpg'),(9999,'ddf',454,'Male','2023-10-07','C:\\Users\\imran\\Desktop\\Scan.jpg'),(11111,'dfdf',12,'Male','2023-10-06','C:\\Users\\imran\\Desktop\\Scan.jpg'),(21212,'dfdf',25,'Male','2023-10-07','C:\\Users\\imran\\Desktop\\demo2.png'),(22222,'fgfgf',45,'Male','2023-10-07','C:\\Users\\imran\\Desktop\\Scan.jpg'),(77777,'sdsd',25,'Male','2023-10-07','C:\\Users\\imran\\Desktop\\Scan.jpg'),(101010,'fsfds',25,'Male','2023-10-14','C:\\Users\\imran\\Desktop\\Scan.jpg');
/*!40000 ALTER TABLE `teacherdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-18  5:20:38
