CREATE SCHEMA `table_relations`;

USE `table_relations`;

/* 1.	One-To-One Relationship */
CREATE TABLE `passports` (
`passport_id` INT PRIMARY KEY NOT NULL,
`passport_number` VARCHAR(8) NOT NULL UNIQUE
);

INSERT INTO `passports` (`passport_id`, `passport_number`) 
VALUES (101, 'N34FG21B'),
(102, 'K65LO4R7'),
(103, 'ZE657QP2');

CREATE TABLE `persons` (
`person_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`salary` DECIMAL(10, 2) NOT NULL,
`passport_id` INT NOT NULL UNIQUE,
CONSTRAINT `fk_persons_passports`
FOREIGN KEY `persons`(`passport_id`) 
REFERENCES `passports`(`passport_id`)
);

INSERT INTO `persons` (`first_name`, `salary`, `passport_id`)
VALUES ('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);

/* 2.	One-To-Many Relationship */
CREATE TABLE `manufacturers` (
`manufacturer_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) UNIQUE NOT NULL,
`established_on` DATE
);

INSERT INTO `manufacturers` (`name`, `established_on`)
VALUES ('BMW', '1916/03/01'),
('Tesla', '2003/01/01'),
('Lada', '1966/05/01');

CREATE TABLE `models` (
`model_id` INT UNIQUE NOT NULL PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`manufacturer_id` INT,
CONSTRAINT `fk_model_manufacturer`
FOREIGN KEY `models`(`manufacturer_id`)
REFERENCES `manufacturers`(`manufacturer_id`)
);

INSERT INTO `models` (`model_id`, `name`, `manufacturer_id`)
VALUES (101, 'X1', 1), 
(102, 'i6', 1), 
(103, 'Model S', 2), 
(104, 'Model X', 2), 
(105, 'Model 3', 2), 
(106, 'Nova', 3);

/* 3.	Many-To-Many Relationship */
CREATE TABLE `students`(
`student_id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50)
);

INSERT INTO `students` (`name`)
VALUES ('Mila'), ('Toni'), ('Ron');

CREATE TABLE `exams`(
`exam_id` INT NOT NULL PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

INSERT INTO `exams`(`exam_id`, `name`)
VALUES (101, 'Spring MVC'),
(102, 'Neo4j'),
(103, 'Oracle 11g');

CREATE TABLE `students_exams`(
`student_id` INT NOT NULL,
`exam_id` INT NOT NULL,
CONSTRAINT `pk_student_exam`
PRIMARY KEY(`student_id`, `exam_id`),
CONSTRAINT `fk_se_student`
FOREIGN KEY `students_exams`(`student_id`)
REFERENCES `students`(`student_id`),
CONSTRAINT `fk_se_exams`
FOREIGN KEY `students_exams`(`exam_id`)
REFERENCES `exams` (`exam_id`)
);

INSERT INTO `students_exams` (`student_id`, `exam_id`)
VALUES (1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

/* 4.	Self-Referencing */
CREATE TABLE `teachers`(
`teacher_id` INT UNIQUE PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`manager_id` INT
);

INSERT INTO `teachers`(`teacher_id`, `name`, `manager_id`)
VALUES (101, 'John', NULL),
(102, 'Maya', 106),
(103, 'Silvia', 106),
(104, 'Ted', 105),
(105, 'Mark', 101),
(106, 'Greta', 101);

ALTER TABLE `teachers`
ADD CONSTRAINT `fk_teacher_id_manager_id`
FOREIGN KEY `teachers`(`manager_id`)
REFERENCES `teachers`(`teacher_id`);

 /* 5.	Online Store Database */
 CREATE TABLE `item_types`(
 `item_type_id` INT(11) PRIMARY KEY,
 `name` VARCHAR(50)
 );
 
 CREATE TABLE `items`(
 `item_id` INT(11) PRIMARY KEY,
 `name` VARCHAR(50),
 `item_type_id` INT(11),
 CONSTRAINT `fk_items_item_types`
 FOREIGN KEY `item_types`(`item_type_id`)
 REFERENCES `item_types`(`item_type_id`)
 );
 
 CREATE TABLE `cities`(
	`city_id` INT(11) PRIMARY KEY,
    `name` VARCHAR(50)
 );
 
 CREATE TABLE `customers`(
 `customer_id` INT(11) PRIMARY KEY,
 `name` VARCHAR(50),
 `birthday` DATE,
 `city_id` INT(11),
 CONSTRAINT `fk_customers_cities`
 FOREIGN KEY `customers`(`city_id`)
 REFERENCES `cities`(`city_id`)
 );
 
 CREATE TABLE `orders`(
 `order_id` INT(11) PRIMARY KEY,
 `customer_id` INT(11),
 CONSTRAINT `fk_orders_customers`
 FOREIGN KEY `orders`(`customer_id`)
 REFERENCES `customers`(`customer_id`)
 );
 
 CREATE TABLE `order_items`(
 `order_id` INT(11),
 `item_id` INT(11),
 CONSTRAINT `pk_order_items`
 PRIMARY KEY(`order_id`, `item_id`),
 CONSTRAINT `fk_order_items_orders`
 FOREIGN KEY `order_items`(`order_id`)
 REFERENCES `orders`(`order_id`),
 CONSTRAINT `fk_order_items_items`
 FOREIGN KEY `order_items`(`item_id`)
 REFERENCES `items`(`item_id`)
 );
 
 
 /* 5.	University Database */
 CREATE TABLE `subjects`(
 `subject_id` INT(11) PRIMARY KEY,
 `subject_name` VARCHAR(50)
 );
 
 CREATE TABLE `majors`(
 `major_id` INT(11) PRIMARY KEY,
 `name` VARCHAR(50)
 );
 
 CREATE TABLE `students`(
 `student_id` INT(11) PRIMARY KEY,
 `student_number` VARCHAR(12),
 `student_name` VARCHAR(50),
 `major_id` INT(11),
 CONSTRAINT `fk_students_majors`
 FOREIGN KEY `students`(`major_id`)
 REFERENCES `majors`(`major_id`)
 );
 
 CREATE TABLE `agenda`(
 `student_id` INT(11),
 `subject_id` INT(11),
 CONSTRAINT `pk_agenda`
 PRIMARY KEY (`student_id`, `subject_id`),
 CONSTRAINT `fk_agenda_subjects`
 FOREIGN KEY `agenda`(`subject_id`)
 REFERENCES `subjects`(`subject_id`),
 CONSTRAINT `fk_agenda_students`
 FOREIGN KEY `agenda`(`student_id`)
 REFERENCES `students`(`student_id`)
 );
 
 CREATE TABLE `payments`(
 `payment_id` INT(11) PRIMARY KEY,
 `payment_date` DATE,
 `payment_amount` DECIMAL(8, 2),
 `student_id` INT(11),
 CONSTRAINT `fk_payment_student`
 FOREIGN KEY `payments`(`student_id`)
 REFERENCES `students`(`student_id`)
 );
 
/* 8.	Peaks in Rila */
SELECT m.`mountain_range`, p.`peak_name`, p.`elevation` AS 'peak_elevation' 
FROM `peaks` AS p
JOIN `mountains` AS m 
ON m.`id` = p.`mountain_id`
WHERE m.`mountain_range` = 'Rila'
ORDER BY `peak_elevation` DESC;
 
 
 
 