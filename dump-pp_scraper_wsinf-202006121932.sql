-- MySQL dump 10.13  Distrib 5.5.62, for Win64 (AMD64)
--
-- Host: localhost    Database: pp_scraper_wsinf
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.11-MariaDB

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
-- Table structure for table `rejestr_wynikow`
--

DROP TABLE IF EXISTS `rejestr_wynikow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejestr_wynikow` (
  `data_operacji` datetime NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `typ_wartosci` varchar(250) NOT NULL,
  `user_id` varchar(100) NOT NULL,
  `url` text NOT NULL,
  `zawartosc` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `newtable_user_id_IDX` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejestr_wynikow`
--

LOCK TABLES `rejestr_wynikow` WRITE;
/*!40000 ALTER TABLE `rejestr_wynikow` DISABLE KEYS */;
INSERT INTO `rejestr_wynikow` VALUES ('2020-06-12 19:18:45',1,'naglowek','adam','https://www.otomoto.pl','Czego szukasz?'),('2020-06-12 19:18:45',2,'naglowek','adam','https://www.otomoto.pl','Osobowe'),('2020-06-12 19:18:45',3,'naglowek','adam','https://www.otomoto.pl','Części'),('2020-06-12 19:18:45',4,'naglowek','adam','https://www.otomoto.pl','Motocykle'),('2020-06-12 19:18:45',5,'naglowek','adam','https://www.otomoto.pl','Dostawcze'),('2020-06-12 19:18:45',6,'naglowek','adam','https://www.otomoto.pl','Ciężarowe'),('2020-06-12 19:18:45',7,'naglowek','adam','https://www.otomoto.pl','Budowlane'),('2020-06-12 19:18:45',8,'naglowek','adam','https://www.otomoto.pl','Przyczepy'),('2020-06-12 19:18:45',9,'naglowek','adam','https://www.otomoto.pl','Rolnicze'),('2020-06-12 19:18:45',10,'naglowek','adam','https://www.otomoto.pl','Oferta dnia'),('2020-06-12 19:18:45',11,'naglowek','adam','https://www.otomoto.pl','Oferty Wyróżnione'),('2020-06-12 19:18:45',12,'naglowek','adam','https://www.otomoto.pl','Ford Mondeo 2.0Tdci TITANIUM 85.000 km !!'),('2020-06-12 19:18:45',13,'naglowek','adam','https://www.otomoto.pl','Toyota Avensis Toyota Avensis 10.09.2009 / 126KW/ 125255km'),('2020-06-12 19:18:45',14,'naglowek','adam','https://www.otomoto.pl','Land Rover Range Rover Sport RANGE ROVER SPORT 3.0 SDV6 Autobiography Dynamic !! Piękny !!'),('2020-06-12 19:18:45',15,'naglowek','adam','https://www.otomoto.pl','Volvo S90 S90 Momentum T4, Geartronic, 8 bieg. Model 2019 Webasto, Navi,'),('2020-06-12 19:18:45',16,'naglowek','adam','https://www.otomoto.pl','Renault Megane'),('2020-06-12 19:18:45',17,'naglowek','adam','https://www.otomoto.pl','Volkswagen Golf 1,6 TDI Highline wersja limitowana Allstar'),('2020-06-12 19:18:45',18,'naglowek','adam','https://www.otomoto.pl','Mercedes-Benz GLC 200 4M Advantage AsystentParkowania KeylessGo KameraCofania'),('2020-06-12 19:18:45',19,'naglowek','adam','https://www.otomoto.pl','BMW X6 M BMW X6m50d, max wyposażenie, super deal rata 3.300'),('2020-06-12 19:18:45',20,'naglowek','adam','https://www.otomoto.pl','Volvo C70 Europa SUMMUM Serwis, Xenon Navi Skóra KABRIOLET Automat R Design'),('2020-06-12 19:18:45',21,'naglowek','adam','https://www.otomoto.pl','Volkswagen Caravelle Volkswagen Caravelle 2.5 TDI'),('2020-06-12 19:18:45',22,'naglowek','adam','https://www.otomoto.pl','BMW Seria 3 320 Sport Line 190PS Automat Stan Salonowy!'),('2020-06-12 19:18:45',23,'naglowek','adam','https://www.otomoto.pl','Najpopularniejsze marki samochodów:'),('2020-06-12 19:18:45',24,'naglowek','adam','https://www.otomoto.pl','Najpopularniejsze modele samochodów:'),('2020-06-12 19:18:45',25,'naglowek','adam','https://www.otomoto.pl','Najpopularniejsze marki motocykli:'),('2020-06-12 19:18:45',26,'naglowek','adam','https://www.otomoto.pl','Pozostałe pojazdy na sprzedaż:'),('2020-06-12 19:18:45',27,'naglowek','adam','https://www.otomoto.pl','Popularne modele Volkswagena:'),('2020-06-12 19:18:45',28,'naglowek','adam','https://www.otomoto.pl','Popularne modele BMW:'),('2020-06-12 19:18:45',29,'naglowek','adam','https://www.otomoto.pl','Popularne modele Audi:'),('2020-06-12 19:18:45',30,'naglowek','adam','https://www.otomoto.pl','Szukaj w miastach:'),('2020-06-12 19:18:45',31,'naglowek','adam','https://www.otomoto.pl','Szukaj w województwach:'),('2020-06-12 19:18:45',32,'naglowek','adam','https://www.otomoto.pl','Jesteś klientem profesjonalnym?'),('2020-06-12 19:18:45',33,'naglowek','adam','https://www.otomoto.pl','OTOMOTO'),('2020-06-12 19:18:45',34,'naglowek','adam','https://www.otomoto.pl','USŁUGI I NARZĘDZIA'),('2020-06-12 19:18:45',35,'naglowek','adam','https://www.otomoto.pl','PRZYDATNE INFORMACJE'),('2020-06-12 19:18:45',36,'naglowek','adam','https://www.otomoto.pl','Customer Support'),('2020-06-12 19:18:45',37,'naglowek','adam','https://www.otomoto.pl','Nasze aplikacje w twoim telefonie'),('2020-06-12 19:18:45',38,'naglowek','adam','https://www.otomoto.pl','Finansowanie na OTOMOTO'),('2020-06-12 19:18:45',39,'naglowek','adam','https://www.otomoto.pl','Ogłoszenia'),('2020-06-12 19:18:45',40,'naglowek','adam','https://www.otomoto.pl','Wyszukiwania'),('2020-06-12 19:18:45',41,'naglowek','adam','https://www.otomoto.pl','Zaloguj się'),('2020-06-12 19:18:45',42,'naglowek','adam','https://www.otomoto.pl','Zarejestruj się'),('2020-06-12 19:18:45',43,'naglowek','adam','https://www.otomoto.pl','Utwórz konto biznesowe');
/*!40000 ALTER TABLE `rejestr_wynikow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rejestr_zapytan`
--

DROP TABLE IF EXISTS `rejestr_zapytan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rejestr_zapytan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data_zapytania` datetime NOT NULL,
  `kod_zapytania` text DEFAULT NULL,
  `user_id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rejestr_zapytan_user_id_IDX` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rejestr_zapytan`
--

LOCK TABLES `rejestr_zapytan` WRITE;
/*!40000 ALTER TABLE `rejestr_zapytan` DISABLE KEYS */;
INSERT INTO `rejestr_zapytan` VALUES (7,'2020-06-11 19:53:19','about','adam'),(8,'2020-06-11 19:53:25','about','adam'),(9,'2020-06-11 21:04:47','about','adam'),(10,'2020-06-11 21:06:33','about','adam'),(11,'2020-06-12 19:17:22','apiScrapuj','adam'),(12,'2020-06-12 19:18:45','apiScrapuj','adam'),(13,'2020-06-12 19:19:04','apiListaScrapowanychElementow','adam');
/*!40000 ALTER TABLE `rejestr_zapytan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_dane`
--

DROP TABLE IF EXISTS `user_dane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_dane` (
  `user_id` varchar(100) NOT NULL,
  `klucz` text NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_dane_un` (`klucz`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_dane`
--

LOCK TABLES `user_dane` WRITE;
/*!40000 ALTER TABLE `user_dane` DISABLE KEYS */;
INSERT INTO `user_dane` VALUES ('adam','PanDaTrzy');
/*!40000 ALTER TABLE `user_dane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pp_scraper_wsinf'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-12 19:32:53
