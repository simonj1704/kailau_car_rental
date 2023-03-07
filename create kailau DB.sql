DROP DATABASE IF EXISTS kailau_car_rental;
CREATE DATABASE kailau_car_rental;

USE kailau_car_rental;

CREATE TABLE brands
(
brand_id		INT		NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
brand_name		VARCHAR(45)
);

CREATE TABLE model
(
model_id		INT		NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
mode_name		VARCHAR(45),
fuel_type		VARCHAR(45),
car_type		VARCHAR(45),
brand_id		INT,
FOREIGN KEY (brand_id) REFERENCES brands(brand_id)
);

CREATE TABLE cars
(
registration_number		INT		NOT NULL UNIQUE PRIMARY KEY,
registration_year		DATE,
odometer				DOUBLE,
available				BOOLEAN,
model_id				INT,
FOREIGN KEY (model_id) REFERENCES model(model_id)
);

CREATE TABLE city
(
zip			INT		NOT NULL UNIQUE PRIMARY KEY,
city		VARCHAR(45)
);

CREATE TABLE address
(
address		VARCHAR(45)		NOT NULL UNIQUE,
city_zip	INT				NOT NULL UNIQUE,
PRIMARY KEY (address, city_zip),
FOREIGN KEY (city_zip) REFERENCES city(zip)
);

CREATE TABLE customers
(
driver_license_number	INT		NOT NULL UNIQUE PRIMARY KEY,
customer_name			VARCHAR(45),
mobile_phone_number		VARCHAR(45),
phone_number			VARCHAR(45),
email_address			VARCHAR(45),
driver_since_date		DATE,
address					VARCHAR(45),
FOREIGN KEY (address) REFERENCES address(address)
);

CREATE TABLE rental_contracts
(
id_rental_contract		INT 	NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
from_date				DATE,
to_date					DATE,
max_km					DOUBLE,
km_on_start				DOUBLE,
driver_license_number	INT,
registration_number 	INT,
FOREIGN KEY (driver_license_number)	REFERENCES customers(driver_license_number),
FOREIGN KEY (registration_number)	REFERENCES	cars(registration_number)
);

SELECT * FROM customers;
