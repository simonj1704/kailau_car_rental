DROP DATABASE IF EXISTS kailau_car_rental;
CREATE DATABASE kailau_car_rental;

USE kailau_car_rental;

CREATE TABLE brands
(
brand_id		INT		NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
brand_name		VARCHAR(45) UNIQUE
);

CREATE TABLE model
(
model_id		INT		NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
model_name		VARCHAR(45) UNIQUE,
fuel_type		VARCHAR(45),
car_type		VARCHAR(45),
brand_id		INT,
FOREIGN KEY (brand_id) REFERENCES brands(brand_id)
);

CREATE TABLE cars
(
registration_number		VARCHAR(45)		NOT NULL UNIQUE PRIMARY KEY,
registration_year		DATE,
odometer				INT,
rented				BOOLEAN,
model_id				INT,
FOREIGN KEY (model_id) REFERENCES model(model_id)
);

CREATE TABLE city
(
city_zip			INT		NOT NULL UNIQUE PRIMARY KEY,
city_name		VARCHAR(45)
);

CREATE TABLE address
(
address		VARCHAR(45)		NOT NULL UNIQUE PRIMARY KEY,
city_zip	INT,
FOREIGN KEY (city_zip) REFERENCES city(city_zip)
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
ON DELETE CASCADE
);

CREATE TABLE rental_contracts
(
id_rental_contract		INT 	NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
from_date				DATE,
to_date					DATE,
max_km					INT,
km_on_start				INT,
driver_license_number	INT,
registration_number 	VARCHAR(45),
FOREIGN KEY (driver_license_number)	REFERENCES customers(driver_license_number)
ON DELETE CASCADE,
FOREIGN KEY (registration_number)	REFERENCES	cars(registration_number)
ON DELETE CASCADE
);


INSERT INTO brands(brand_name) VALUES
('Mercedes'),
('BMW'),
('Toyota');

INSERT INTO model(model_name, fuel_type, car_type, brand_id) VALUES
('E250', 'Diesel', 'Luxury', 1),
('Supra', 'Petrol', 'Sport', 3),
('X6', 'Diesel', 'Family', 2);

INSERT INTO cars(registration_number, registration_year, odometer, rented, model_id) VALUES
('AX63648', '2009-12-01', 12500, true, 1);

INSERT INTO city VALUES
(2600, 'Frederiksberg'),
(4600, 'Køge');

INSERT INTO address VALUES
('Nansensgade 12', 2600),
('Bambusvej 7', 4600);

INSERT INTO customers(driver_license_number, customer_name, mobile_phone_number, phone_number, email_address, driver_since_date, address) VALUES
(23235564, 'John Smicht', '+4522334455', '', 'john@mail.com', '2003-05-22', 'Bambusvej 7');

INSERT INTO rental_contracts(from_date, to_date, max_km, km_on_start, driver_license_number, registration_number) VALUES
('2023-04-14', '2023-04-17', 500, 12400, 23235564, 'AX63648');
