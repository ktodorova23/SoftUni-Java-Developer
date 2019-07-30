CREATE SCHEMA `Hotel`;

USE `Hotel`;

CREATE TABLE employees (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
title VARCHAR (50),
notes TEXT
);

CREATE TABLE customers(
account_number VARCHAR(50) NOT NULL PRIMARY KEY,
first_name VARCHAR(50),
last_name VARCHAR(50),
phone_number VARCHAR(50),
emergency_name VARCHAR(50),
emergency_number INT NOT NULL,
notes TEXT
);

CREATE TABLE room_status (
room_status VARCHAR(50) PRIMARY KEY NOT NULL,
notes TEXT
);

CREATE TABLE room_types (
room_type VARCHAR(50) PRIMARY KEY NOT NULL,
notes TEXT
);

CREATE TABLE bed_types (
bed_type VARCHAR(50) PRIMARY KEY NOT NULL,
notes TEXT
);

CREATE TABLE rooms (
room_number INT PRIMARY KEY NOT NULL,
room_type VARCHAR(50),
bed_type VARCHAR (50),
rate DOUBLE NOT NULL,
room_status VARCHAR (50),
notes TEXT
);

CREATE TABLE payments (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
employee_id INT NOT NULL,
payment_date DATETIME,
account_number VARCHAR(50) NOT NULL,
first_date_occupied TIMESTAMP,
last_date_occupied TIMESTAMP,
total_days INT,
amount_charged DOUBLE,
tax_rate DOUBLE,
tax_amount DOUBLE,
payment_total DOUBLE,
notes TEXT
);

CREATE TABLE occupancies (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
employee_id INT NOT NULL,
date_occupied DATETIME,
account_number VARCHAR(50) NOT NULL,
room_number INT NOT NULL,
rate_applied DOUBLE,
phone_charge DOUBLE,
notes TEXT
);

INSERT INTO employees VALUES (1, "Pesho", "Peshov", "Mr", NULL),
(2, "Herman", "Hermanov", "Mr", NULL),
(3, "Petq", "Yordanova", "Miss", NULL);

INSERT INTO customers VALUES ("1234123", "Edjo", "Ejov", "08888888", "SOS", 111, NULL),
("57567575454", "Polqka", "Polishov", "8291892891", "SOS", 999, NULL),
("8291891", "Ivailo", "Pashov", "9898919819", "SOS", 888, NULL);

INSERT INTO room_status VALUES ("Available", NULL),
("Not available", NULL),
("Reserved", NULL);

INSERT INTO room_types VALUES ("Deluxe", NULL), ("One bedroom", NULL), ("Two bedroom", NULL);

INSERT INTO bed_types VALUES ("Single", NULL), ("Double", NULL), ("King", NULL);

INSERT INTO rooms VALUES (22, "One bedroom", "Single", 40, "Available", NULL),
(33, "Two bedroom", "Double", 80, "Available", NULL),
(44, "Deluxe", "King", 160, "Not available", NULL);

INSERT INTO payments VALUES (1, 1, "2000-10-10 00:00:00", "128912891", "2000-10-10", "2000-10-10", 4, 80, 20, 20, 160, NULL),
(2, 2, "2000-10-11 00:00:00", "3187381", "2000-12-10", "2000-12-10", 2, 90, 20, 20, 200, NULL),
(3, 3, "2012-10-10 00:00:00", "8931931", "2013-11-10", "2012-12-10", 9, 190, 20, 20, 1000, NULL);

INSERT INTO occupancies VALUES (1, 1, "2000-10-10 00:00:00", "2128181", 22, 80, 2, NULL),
(2, 2, "2000-10-10 00:00:00", "1241241", 33, 160, 5, NULL),
(3, 3, "2000-10-10 00:00:00", "12312412412", 44, 200, 10, NULL);

UPDATE `payments`
SET `tax_rate` = `tax_rate` * 0.97;

SELECT `tax_rate` FROM `payments`;

DELETE FROM `occupancies`;