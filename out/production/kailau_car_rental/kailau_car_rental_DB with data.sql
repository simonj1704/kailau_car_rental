-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: kailau_car_rental
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address` varchar(45) NOT NULL,
  `city_zip` int NOT NULL,
  PRIMARY KEY (`address`,`city_zip`),
  UNIQUE KEY `address` (`address`),
  UNIQUE KEY `city_zip` (`city_zip`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`city_zip`) REFERENCES `city` (`zip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES ('222 Boylston St',2116),('789 Broadway',10001),('101 State St',60601),('111 Michigan Ave',60611),('567 Elm St',75001),('234 Sunset Blvd',90012),('333 Wilshire Blvd',90024),('456 Vine St',90210),('890 Market St',94105),('123 Main St',96813);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brands` (
  `brand_id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`brand_id`),
  UNIQUE KEY `brand_id` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,'Toyota'),(2,'Honda'),(3,'BMW'),(4,'Mercedes-Benz'),(5,'Audi'),(6,'Ford'),(7,'Chevrolet'),(8,'Nissan'),(9,'Hyundai'),(10,'Kia'),(11,'Mazda'),(12,'Subaru'),(13,'Volkswagen'),(14,'Volvo'),(15,'Ferrari'),(16,'Lamborghini'),(17,'Porsche'),(18,'Jeep'),(19,'Land Rover'),(20,'Tesla');
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cars` (
  `registration_number` int NOT NULL,
  `registration_year` date DEFAULT NULL,
  `odometer` double DEFAULT NULL,
  `available` tinyint(1) DEFAULT NULL,
  `model_id` int DEFAULT NULL,
  PRIMARY KEY (`registration_number`),
  UNIQUE KEY `registration_number` (`registration_number`),
  KEY `model_id` (`model_id`),
  CONSTRAINT `cars_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `model` (`model_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (112233,'2018-07-07',28000,1,19),(112234,'2022-10-10',150,1,10),(123456,'2020-01-01',5000,1,1),(223344,'2021-08-08',1500,0,20),(223345,'2020-11-11',3500,0,11),(234567,'2019-02-02',15000,1,2),(334455,'2018-12-12',18000,1,12),(345678,'2020-03-03',2000,0,3),(445566,'2019-01-01',16000,0,13),(456789,'2019-04-04',10000,1,4),(556677,'2021-02-02',2000,1,14),(567890,'2018-05-05',25000,1,5),(667788,'2018-03-03',22000,0,15),(678901,'2021-06-06',800,0,6),(778899,'2020-04-04',500,1,16),(789012,'2017-07-07',30000,1,7),(889900,'2019-05-05',10000,0,17),(890123,'2020-08-08',4000,1,8),(901234,'2019-09-09',12000,0,9),(990011,'2022-06-06',120,1,18);
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `zip` int NOT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`zip`),
  UNIQUE KEY `zip` (`zip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (2116,'Boston'),(10001,'New York'),(60601,'Chicago'),(60611,'Chicago'),(75001,'Dallas'),(90012,'Los Angeles'),(90024,'Los Angeles'),(90210,'Beverly Hills'),(94105,'San Francisco'),(96813,'Honolulu');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `driver_license_number` int NOT NULL,
  `customer_name` varchar(45) DEFAULT NULL,
  `mobile_phone_number` varchar(45) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `email_address` varchar(45) DEFAULT NULL,
  `driver_since_date` date DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`driver_license_number`),
  UNIQUE KEY `driver_license_number` (`driver_license_number`),
  KEY `address` (`address`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`address`) REFERENCES `address` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (112233445,'Emily Chen','808-555-1122','808-555-5566','emilychen@email.com','2019-10-10','333 Wilshire Blvd'),(123456789,'John Doe','808-555-1234','808-555-5678','johndoe@email.com','2010-01-01','123 Main St'),(234567890,'Jane Smith','808-555-2345','808-555-6789','janesmith@email.com','2011-02-02','456 Vine St'),(345678901,'Bob Johnson','808-555-3456','808-555-7890','bobjohnson@email.com','2012-03-03','789 Broadway'),(456789012,'Amy Lee','808-555-4567','808-555-8901','amylee@email.com','2013-04-04','101 State St'),(567890123,'Tom Davis','808-555-5678','808-555-9012','tomdavis@email.com','2014-05-05','234 Sunset Blvd'),(678901234,'Samantha Brown','808-555-6789','808-555-0123','samanthabrown@email.com','2015-06-06','567 Elm St'),(789012345,'David Kim','808-555-7890','808-555-1234','davidkim@email.com','2016-07-07','890 Market St'),(890123456,'Jessica Wu','808-555-8901','808-555-2345','jessicawu@email.com','2017-08-08','111 Michigan Ave'),(901234567,'Andrew Chen','808-555-9012','808-555-3456','andrewchen@email.com','2018-09-09','222 Boylston St');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `model` (
  `model_id` int NOT NULL AUTO_INCREMENT,
  `mode_name` varchar(45) DEFAULT NULL,
  `fuel_type` varchar(45) DEFAULT NULL,
  `car_type` varchar(45) DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  PRIMARY KEY (`model_id`),
  UNIQUE KEY `model_id` (`model_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `model_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brands` (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'Corolla','Gasoline','Sedan',1),(2,'Civic','Gasoline','Sedan',2),(3,'3 Series','Gasoline','Sedan',3),(4,'E-Class','Diesel','Sedan',4),(5,'A4','Gasoline','Sedan',5),(6,'Escape','Gasoline','SUV',6),(7,'Equinox','Gasoline','SUV',7),(8,'Rogue','Gasoline','SUV',8),(9,'Santa Fe','Gasoline','SUV',9),(10,'Sportage','Gasoline','SUV',10),(11,'CX-5','Gasoline','SUV',11),(12,'Forester','Gasoline','SUV',12),(13,'Tiguan','Gasoline','SUV',13),(14,'XC90','Gasoline','SUV',14),(15,'California','Gasoline','Sports',15),(16,'Aventador','Gasoline','Sports',16),(17,'911','Gasoline','Sports',17),(18,'Wrangler','Gasoline','Off-road',18),(19,'Range Rover','Diesel','Off-road',19),(20,'Model S','Electric','Sedan',20);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental_contracts`
--

DROP TABLE IF EXISTS `rental_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental_contracts` (
  `id_rental_contract` int NOT NULL AUTO_INCREMENT,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `max_km` double DEFAULT NULL,
  `km_on_start` double DEFAULT NULL,
  `driver_license_number` int DEFAULT NULL,
  `registration_number` int DEFAULT NULL,
  PRIMARY KEY (`id_rental_contract`),
  UNIQUE KEY `id_rental_contract` (`id_rental_contract`),
  KEY `driver_license_number` (`driver_license_number`),
  KEY `registration_number` (`registration_number`),
  CONSTRAINT `rental_contracts_ibfk_1` FOREIGN KEY (`driver_license_number`) REFERENCES `customers` (`driver_license_number`),
  CONSTRAINT `rental_contracts_ibfk_2` FOREIGN KEY (`registration_number`) REFERENCES `cars` (`registration_number`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental_contracts`
--

LOCK TABLES `rental_contracts` WRITE;
/*!40000 ALTER TABLE `rental_contracts` DISABLE KEYS */;
INSERT INTO `rental_contracts` VALUES (1,'2022-03-01','2022-03-05',500,100,123456789,123456),(2,'2022-03-05','2022-03-08',300,200,234567890,234567),(3,'2022-03-10','2022-03-15',600,300,345678901,345678),(4,'2022-03-15','2022-03-20',400,1000,456789012,456789),(5,'2022-03-20','2022-03-25',500,500,567890123,567890),(6,'2022-03-25','2022-03-30',200,250,678901234,678901),(7,'2022-03-30','2022-04-05',800,100,789012345,789012),(8,'2022-04-05','2022-04-10',400,200,890123456,890123),(9,'2022-04-10','2022-04-15',300,150,901234567,901234),(10,'2022-04-15','2022-04-20',500,50,112233445,123456),(11,'2022-04-20','2022-04-25',400,500,123456789,234567),(12,'2022-04-25','2022-04-30',600,100,234567890,345678),(13,'2022-04-30','2022-05-05',500,900,345678901,456789),(14,'2022-05-05','2022-05-10',200,400,456789012,567890),(15,'2022-05-10','2022-05-15',800,700,567890123,678901),(16,'2022-05-15','2022-05-20',400,100,678901234,789012),(17,'2022-05-20','2022-05-25',300,50,789012345,890123),(18,'2022-05-25','2022-05-30',500,800,890123456,901234),(19,'2022-05-30','2022-06-05',400,200,901234567,123456),(20,'2022-06-05','2022-06-10',300,100,112233445,234567);
/*!40000 ALTER TABLE `rental_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'kailau_car_rental'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-08  9:14:09
