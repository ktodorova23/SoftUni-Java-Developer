CREATE SCHEMA ruk_database;

USE ruk_database;

/* 0.	1.	Section 1: Data Definition Language (DDL) – 40 pts */ 
CREATE TABLE `branches` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
);

CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  `started_on` date NOT NULL,
  `branch_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employees_branches_idx` (`branch_id`),
  CONSTRAINT `fk_employees_branches` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`)
) ;

CREATE TABLE `clients`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`full_name` VARCHAR(50) NOT NULL,
`age` INT NOT NULL
);

CREATE TABLE `employees_clients`(
`employee_id` INT,
`client_id` INT,
CONSTRAINT fk_ec_employees 
FOREIGN KEY (`employee_id`)
REFERENCES `employees`(`id`),
CONSTRAINT fk_ec_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `bank_accounts`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`account_number` VARCHAR(10) NOT NULL,
`balance` DECIMAL(10, 2) NOT NULL,
`client_id` INT NOT NULL UNIQUE,
CONSTRAINT fk_ba_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients`(`id`)
);

CREATE TABLE `cards`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`card_number` VARCHAR(19) NOT NULL,
`card_status` VARCHAR(7) NOT NULL,
`bank_account_id` INT NOT NULL,
CONSTRAINT fk_cards_ba
FOREIGN KEY(`bank_account_id`)
REFERENCES `bank_accounts`(`id`)
);

/* 2.	Section 2: Data Manipulation Language (DML) – 30 pts */
/* 02.	Insert */
INSERT INTO `cards`(`card_number`, `card_status`, `bank_account_id`)
SELECT REVERSE(c.`full_name`) AS 'card_number', 'Active' AS 'card_status',
c.`id` AS 'bank_account_id'
FROM `clients` AS c
WHERE `id` BETWEEN 191 AND 200;

/* 03.	Update */ #????????????
UPDATE `employees_clients` AS ec
SET ec.`employee_id` = 

(SELECT e.`id`
FROM `employees` AS e
WHERE e.`id` IN (SELECT `employee_id`
FROM (SELECT `employee_id`
FROM `employees_clients`
GROUP BY `employee_id`
ORDER BY COUNT(`employee_id`), `employee_id`
LIMIT 1)
AS `c`) ) 
WHERE ec.`employee_id` = ec.`client_id`;

/* 04.	Delete */ 
DELETE FROM `employees`
WHERE `id` NOT IN(SELECT `employee_id` 
FROM `employees_clients`);

/* 2.	Section 3: Querying – 50 pts */
/* 05.	Clients */
SELECT `id`, `full_name` 
FROM `clients`
ORDER BY `id`;

/* 06.	Newbies */
SELECT e.`id`, 
CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'full_name',
CONCAT('$', e.`salary`) AS 'salary',
e.`started_on`
FROM `employees` AS e
WHERE e.`salary` >= 100000 
AND DATE(e.`started_on`) >= '2018-01-01'
ORDER BY e.`salary` DESC;

/* 07.	Cards against Humanity */ 
SELECT c.`id`, 
CONCAT(c.`card_number`, ' : ', cl.`full_name`) AS 'card_token'
FROM `cards` AS c
JOIN `bank_accounts` AS ba
ON c.`bank_account_id` = ba.`id`
JOIN `clients` AS cl
ON ba.`client_id` = cl.`id`
ORDER BY c.`id` DESC;

/* 08.	Top 5 Employees */
SELECT CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'name',
e.`started_on`,
COUNT(ec.`employee_id`) AS 'count_of_clients'
FROM `employees` AS e
JOIN `employees_clients` AS ec
ON e.`id` = ec.`employee_id`
GROUP BY ec.`employee_id`
ORDER BY `count_of_clients` DESC,
e.`id`
LIMIT 5;

/* 09.	Branch cards */
SELECT b.`name`, COUNT(c.`id`) AS 'count_of_cards'
FROM `branches` AS b
LEFT JOIN `employees` AS emp
ON b.`id` = emp.`branch_id`
LEFT JOIN `employees_clients` AS ec
ON emp.`id` = ec.`employee_id`
LEFT JOIN `clients` AS cl 
ON ec.`client_id` = cl.`id`
LEFT JOIN `bank_accounts` AS ba
ON cl.`id` = ba.`client_id`
LEFT JOIN `cards` AS c
ON ba.`id` = c.`bank_account_id`
GROUP BY b.`name`
ORDER BY `count_of_cards` DESC,
b.`name`;

/* 3.	Section 4: Programmability – 30 pts */
/* 10.	Extract client cards count */
DELIMITER $$

CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))
RETURNS INT
BEGIN
	DECLARE result INT;
    SET result := (SELECT `count_of_cards`
    FROM (
		SELECT c.`full_name`, COUNT(car.`id`) AS 'count_of_cards'
		FROM `clients` AS c
		JOIN `bank_accounts` AS ba
		ON c.`id` = ba.`client_id`
		JOIN `cards` AS car
		ON ba.`id` = car.`bank_account_id`
		GROUP BY c.`full_name`
    ) AS t
    WHERE t.`full_name` = name);
    RETURN result;
END; $$

SELECT udf_client_cards_count('Baxy David');

/* 11.	Extract Client Info */
DELIMITER $$
CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(50))
BEGIN
	SELECT c.`full_name`, c.`age`,
	ba.`account_number`, CONCAT('$', ba.`balance`) AS 'balance'
	FROM `clients` AS c
	JOIN `bank_accounts` AS ba
	ON c.`id` = ba.`client_id`
    WHERE c.`full_name` = full_name;
END; $$

CALL udp_clientinfo('Hunter Wesgate');

