CREATE SCHEMA `car_rental`;

USE `car_rental`;

CREATE TABLE `categories` (
`id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
`category` VARCHAR(45) NOT NULL,
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE,
`monthly_rate` DOUBLE,
`weekend_rate` DOUBLE
);

INSERT INTO `categories` (`category`)
VALUES ('used'),
('new'),
('used');

CREATE TABLE `cars` (
`id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
`plate_number` VARCHAR(10) NOT NULL,
`make` VARCHAR(45) NOT NULL,
`model` VARCHAR(45) NOT NULL,
`car_year` YEAR,
`category_id` INT(11),
`doors` INT,
`picture` BLOB,
`car_condition` VARCHAR(45),
`available` BOOLEAN
);

INSERT INTO `cars` (`plate_number`, `make`, `model`, `doors`)
VALUES ('CA1510BT', 'Seat','Leon', 4),
('CB7841MA', 'Volkswagen','Polo', 2),
('C1234KT', 'Nissan','Pulsar', 4);

CREATE TABLE `employees` (
`id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
`first_name` VARCHAR(45) NOT NULL,
`last_name` VARCHAR(45) NOT NULL,
`title` VARCHAR(45),
`notes` TEXT
);

INSERT INTO `employees` (`first_name`, `last_name`, `title`)
VALUES ('Ivan', 'Ivanov', 'Customer support'),
('Pesho', 'Peshev', 'Seller'),
('Sonq', 'Ivanova', 'Customer support');

CREATE TABLE `customers` (
`id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
`driver_licence_number` VARCHAR(45),
`full_name` VARCHAR(100) NOT NULL,
`address` VARCHAR(255),
`city` VARCHAR(45),
`zip_code` INT,
`notes` TEXT
);

INSERT INTO `customers` (`full_name`)
VALUES ('Miroslav Angelov'),
('Razvigor Popov'),
('Razcvet Ivanov');

CREATE TABLE `rental_orders` (
`id` INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
`employee_id` INT(11) NOT NULL,
`customer_id` INT(11) NOT NULL,
`car_id` INT(11) NOT NULL,
`car_condition` VARCHAR(45) NOT NULL,
`tank_level` VARCHAR(45) NOT NULL,
`kilometrage_start` VARCHAR(45) NOT NULL,
`kilometrage_end` VARCHAR(45) NOT NULL,
`total_kilometrage`VARCHAR(45) NOT NULL,
`start_date` DATE NOT NULL,
`end_date` DATE NOT NULL,
`total_days` INT NOT NULL,
`rate_applied` DOUBLE NOT NULL,
`tax_rate` DOUBLE NOT NULL,
`order_status` VARCHAR(45),
`notes` TEXT
);

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`, `kilometrage_start`, `kilometrage_end`, `total_kilometrage`, `start_date`, 
`end_date`, `total_days`, `rate_applied`, `tax_rate`)
VALUES (1, 2, 1, 'used', 15, 10000, 10500, 10500, '2019-05-01', '2019-05-03', 2, 1.5, 1.5),
(1, 2, 1, 'used', 15, 10000, 10500, 10500, '2019-05-01', '2019-05-03', 2, 1.5, 1.5),
(1, 2, 1, 'used', 15, 10000, 10500, 10500, '2019-05-01', '2019-05-03', 2, 1.5, 1.5);



