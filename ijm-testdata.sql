-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ijm_exam
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Current Database: `ijm_exam`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ijm_exam` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ijm_exam`;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `grade` float DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'Exam 001',50,'\0'),(3,'Exam 003',100,'\0'),(12,'Exam 012',NULL,''),(13,'Exam 013',NULL,''),(14,'Exam 014',NULL,''),(15,'Exam 015',NULL,''),(16,'Exam 016',NULL,''),(17,'Exam 017',NULL,''),(18,'Exam 018',NULL,'\0'),(19,'Exam 019',NULL,'\0'),(20,'Exam 020',NULL,'\0'),(21,'Exam 021',NULL,'\0'),(22,'Exam 022',NULL,'\0'),(23,'Exam 023',NULL,'\0'),(24,'Exam 024',NULL,'\0'),(25,'Exam 025',NULL,'\0'),(26,'Exam 026',NULL,'\0'),(27,'Exam 027',NULL,'\0'),(28,'Exam 028',NULL,'\0'),(29,'Exam 029',NULL,'\0'),(30,'Exam 030',NULL,'\0'),(31,'Exam 031',NULL,'\0'),(32,'Exam 032',50,'\0'),(33,'Exam 033',66.67,'\0'),(34,'Exam 034',75,'\0'),(35,'Exam 035',50,'\0'),(36,'Exam 036',100,'\0'),(37,'Exam 037',50,'\0'),(38,'Exam 038',50,'\0'),(39,'Exam 039',100,'\0'),(40,'Exam 40',50,'\0'),(41,'Exam 41',100,'\0'),(42,'Exam 42',100,'\0'),(43,'Exam 43',NULL,'\0'),(44,'Exam 044',50,'\0'),(45,'Exam 045',100,'\0'),(46,'Exam 046',100,'\0'),(47,'Exam 047',50,'\0'),(48,'Exam 048',50,'\0'),(49,'Exam 049',100,'\0'),(50,'Exam 050',50,'\0'),(51,'Exam 51',100,''),(52,'Exam 052',50,'\0'),(53,'Exam 053',100,'\0'),(54,'Exam 054',100,'\0'),(55,'Exam 055',100,'\0'),(56,'Exam 056',100,'\0'),(57,'Exam 054',50,'\0'),(58,'Exam 055',100,''),(59,'Exam 059',100,''),(60,'Exam 060',50,''),(61,'Exam 061',100,''),(62,'Exam 062',100,''),(63,'Exam 063',66.67,''),(64,'Exam 064',50,''),(65,'Exam 065',100,''),(66,'Exam 066',50,''),(67,'Exam 70',0,''),(68,'Exam XYZ',50,''),(69,'Exam 069',66.67,''),(70,'Exam 070',100,''),(71,'Exam 071x',50,''),(72,'Exam 077',100,''),(73,'Exam 073',75,''),(74,'Late Exam 01 - Passed!!!',100,''),(75,'New Exame',0,''),(76,'Other',50,''),(77,'asdfasdf',50,'\0'),(78,'asdfsadfasdf',50,'\0'),(79,'zxcvzxcv',0,''),(80,'qqqqq',50,'\0'),(81,'vvvvvvv',50,'\0'),(82,'aaaaaaa',50,'\0'),(83,'fffff',50,'\0'),(84,'undefined',50,'\0'),(85,'asdfasd',50,'\0'),(86,'Today\'s exam',66.67,'\0'),(87,'To be mailed',100,'\0'),(88,'MINCA 01',NULL,'\0'),(89,'undefined',0,'');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_question`
--

DROP TABLE IF EXISTS `exam_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qna_question_id` bigint(20) DEFAULT NULL,
  `qna_answer_id` bigint(20) DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `exam_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_exam_question_exam_idx` (`exam_id`),
  CONSTRAINT `fk_exam_question_exam` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=186 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_question`
--

LOCK TABLES `exam_question` WRITE;
/*!40000 ALTER TABLE `exam_question` DISABLE KEYS */;
INSERT INTO `exam_question` VALUES (1,1,2,'\0',1),(3,2,3,'\0',1),(10,2,4,'\0',3),(11,3,6,'\0',3),(14,3,5,'\0',12),(15,5,10,'\0',12),(16,3,6,'\0',13),(17,4,7,'\0',13),(18,2,4,'\0',13),(19,5,10,'\0',14),(20,3,6,'\0',14),(21,1,1,'\0',15),(22,4,7,'\0',15),(23,1,2,'\0',16),(24,2,4,'\0',16),(25,5,9,'\0',16),(26,1,2,'\0',17),(27,5,10,'\0',17),(28,2,4,'\0',17),(29,1,1,'\0',18),(30,5,9,'\0',18),(31,3,5,'\0',19),(32,4,8,'\0',19),(33,5,9,'\0',20),(34,3,6,'\0',20),(35,2,3,'\0',21),(36,1,2,'\0',21),(37,4,7,'\0',22),(38,1,2,'\0',22),(39,4,NULL,'\0',23),(40,5,10,'\0',23),(41,3,5,'\0',23),(42,5,9,'\0',24),(43,2,4,'\0',24),(44,4,8,'\0',24),(45,5,10,'\0',25),(46,3,6,'\0',25),(47,1,2,'\0',26),(48,5,10,'\0',26),(49,5,10,'\0',27),(50,1,2,'\0',27),(51,2,3,'\0',28),(52,4,8,'\0',28),(53,2,3,'\0',29),(54,5,10,'\0',29),(55,3,6,'\0',29),(56,4,8,'\0',30),(57,3,6,'\0',30),(58,5,10,'\0',31),(59,2,3,'\0',31),(60,2,4,'\0',32),(61,1,1,'\0',32),(62,4,7,'\0',33),(63,5,10,'\0',33),(64,3,6,'\0',33),(65,3,5,'\0',34),(66,1,2,'\0',34),(67,4,8,'\0',34),(68,5,10,'\0',34),(69,1,1,'\0',35),(70,3,6,'\0',35),(71,1,2,'\0',36),(72,5,10,'\0',36),(73,2,3,'\0',37),(74,5,10,'\0',37),(75,2,3,'\0',38),(76,1,2,'\0',38),(77,4,8,'\0',39),(78,3,6,'\0',39),(79,4,7,'\0',40),(80,1,2,'\0',40),(81,3,6,'\0',41),(82,5,10,'\0',41),(83,3,6,'\0',42),(84,2,4,'\0',42),(85,3,6,'\0',43),(86,4,8,'\0',43),(87,5,9,'\0',44),(88,1,2,'\0',44),(89,1,2,'\0',45),(90,3,6,'\0',45),(91,2,4,'\0',46),(92,3,6,'\0',46),(93,4,8,'\0',47),(94,2,3,'\0',47),(95,3,6,'\0',48),(96,1,1,'\0',48),(97,2,4,'\0',49),(98,4,8,'\0',49),(99,3,6,'\0',50),(100,4,7,'\0',50),(101,5,10,'\0',51),(102,1,2,'\0',51),(103,4,7,'\0',52),(104,3,6,'\0',52),(105,1,2,'\0',53),(106,3,6,'\0',53),(107,2,4,'\0',54),(108,4,8,'\0',54),(109,3,6,'\0',55),(110,2,4,'\0',55),(111,5,10,'\0',56),(112,4,8,'\0',56),(113,3,6,'\0',57),(114,4,7,'\0',57),(115,1,2,'\0',58),(116,4,8,'\0',58),(117,5,10,'\0',59),(118,1,2,'\0',59),(119,5,9,'\0',60),(120,3,6,'\0',60),(121,1,2,'\0',61),(122,4,8,'\0',61),(123,5,10,'\0',62),(124,4,8,'\0',62),(125,4,8,'\0',63),(126,1,1,'\0',63),(127,5,10,'\0',63),(128,2,4,'\0',64),(129,1,1,'\0',64),(130,4,8,'\0',65),(131,3,6,'\0',65),(132,2,4,'\0',65),(133,3,6,'\0',66),(134,5,9,'\0',66),(135,3,5,'\0',67),(136,5,9,'\0',67),(137,4,7,'\0',68),(138,1,2,'\0',68),(139,5,10,'\0',69),(140,4,8,'\0',69),(141,1,1,'\0',69),(142,9,13,'\0',70),(143,5,10,'\0',70),(144,3,6,'\0',70),(145,5,10,'\0',71),(146,9,12,'\0',71),(147,3,6,'\0',72),(148,5,10,'\0',72),(149,1,1,'\0',73),(150,9,13,'\0',73),(151,4,8,'\0',73),(152,5,10,'\0',73),(153,1,2,'\0',74),(154,5,10,'\0',74),(155,4,7,'\0',75),(156,5,9,'\0',75),(157,2,4,'\0',76),(158,5,9,'\0',76),(159,2,3,'\0',77),(160,1,2,'\0',77),(161,3,6,'\0',78),(162,9,12,'\0',78),(163,5,NULL,'\0',79),(164,1,NULL,'\0',79),(165,3,6,'\0',80),(166,1,1,'\0',80),(167,4,7,'\0',81),(168,3,6,'\0',81),(169,1,2,'\0',82),(170,9,12,'\0',82),(171,3,6,'\0',83),(172,2,3,'\0',83),(173,5,9,'\0',84),(174,2,4,'\0',84),(175,1,2,'\0',85),(176,3,5,'\0',85),(177,2,4,'\0',86),(178,3,5,'\0',86),(179,5,10,'\0',86),(180,2,4,'\0',87),(181,9,13,'\0',87),(182,2,3,'\0',88),(183,3,6,'\0',88),(184,1,1,'\0',89),(185,4,7,'\0',89);
/*!40000 ALTER TABLE `exam_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ijm_exam'
--

--
-- Dumping routines for database 'ijm_exam'
--

--
-- Current Database: `ijm_qna`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `ijm_qna` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ijm_qna`;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `correct` bit(1) DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `question_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_answer_question_idx` (`question_id`),
  CONSTRAINT `fk_answer_question` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'0','\0','\0',1),(2,'2','','\0',1),(3,'0','\0','\0',2),(4,'4','','\0',2),(5,'0','\0','\0',3),(6,'6','','\0',3),(7,'0','\0','\0',4),(8,'8','','\0',4),(9,'0','\0','\0',5),(10,'10','','\0',5),(12,'0','\0','\0',9),(13,'12','','\0',9);
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'1 + 1 = ?','\0'),(2,'2 + 2 = ?','\0'),(3,'3 + 3 = ?','\0'),(4,'4 + 4 = ?','\0'),(5,'5 + 5 = ?','\0'),(9,'6 + 6 = ?','\0');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ijm_qna'
--

--
-- Dumping routines for database 'ijm_qna'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-21 21:05:04
