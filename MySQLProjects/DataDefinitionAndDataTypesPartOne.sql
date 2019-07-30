CREATE SCHEMA `minions`;

CREATE TABLE `minions` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`age` INT NULL
);

CREATE TABLE `towns` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL
);

ALTER TABLE `minions`
ADD COLUMN `town_id` INT;

ALTER TABLE `minions`
ADD CONSTRAINT fk_minions_towns FOREIGN KEY (`town_id`) REFERENCES `towns` (`id`);

INSERT INTO `towns` (`id`, `name`) VALUES (1, 'Sofia');
INSERT INTO `towns` (`id`, `name`) VALUES (2, 'Plovdiv');
INSERT INTO `towns` (`id`, `name`) VALUES (3, 'Varna');

INSERT INTO `minions` (`id`, `name`, `age`, `town_id`) VALUES (1, 'Kevin', 22, 1);
INSERT INTO `minions` (`id`, `name`, `age`, `town_id`) VALUES (2, 'Bob', 15, 3);
INSERT INTO `minions` (`id`, `name`, `age`, `town_id`) VALUES (3, 'Steward', NULL, 2);

TRUNCATE `minions`;

DROP TABLES `minions`;

TRUNCATE `minions`;

DROP TABLE `minions`;

DROP TABLE `towns`;

