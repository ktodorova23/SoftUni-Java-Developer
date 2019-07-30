CREATE TABLE `people`(
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR (200) NOT NULL,
`picture` TINYBLOB,
`height` DOUBLE (3, 2),
`weight` DOUBLE (5, 2),
`gender` ENUM ('m', 'f') NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT
);

INSERT INTO `people` (`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`) VALUES ('Petyr', NULL, 1.8, 80, 'm', '2000-08-18', NULL);
INSERT INTO `people` (`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`) VALUES ('Sofiq', NULL, 1.58, 50, 'f', '2000-07-18', NULL);
INSERT INTO `people` (`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`) VALUES ('Petyr', NULL, 1.91, 95, 'm', '2000-08-30', NULL);
INSERT INTO `people` (`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`) VALUES ('Ivan', NULL, 1.8, 80, 'm', '2000-08-18', NULL);
INSERT INTO `people` (`name`, `picture`, `height`, `weight`, `gender`, `birthdate`, `biography`) VALUES ('Stanislava', NULL, 1.67, 62, 'f', '1998-06-08', NULL);

CREATE TABLE `users` (
`id` INT(11) PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) UNIQUE NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` DATETIME,
`is_deleted` BOOLEAN
);

INSERT INTO `users` (`username`, `password`, `is_deleted`) VALUES ('vankata', 'neshtotam', true);
INSERT INTO `users` (`username`, `password`, `is_deleted`) VALUES ('vankata0', 'neshtotam', false);
INSERT INTO `users` (`username`, `password`, `is_deleted`) VALUES ('vankata1', 'neshtoSitam', false);
INSERT INTO `users` (`username`, `password`, `is_deleted`) VALUES ('vankata2', 'neshtoimatam', false);
INSERT INTO `users` (`username`, `password`, `is_deleted`) VALUES ('vankata3', 'neshtodatam', false);

ALTER TABLE `users`
MODIFY COLUMN `id` INT(11);

ALTER TABLE `users`
DROP PRIMARY KEY;

ALTER TABLE `users`
ADD PRIMARY KEY (id, username);

ALTER TABLE `users`
MODIFY `last_login_time`
TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE `users`
MODIFY COLUMN `username` VARCHAR(30) UNIQUE;

ALTER TABLE `users`
MODIFY COLUMN `id` INT(11);


ALTER TABLE `users`
DROP PRIMARY KEY;

ALTER TABLE `users`
ADD PRIMARY KEY (`id`);

ALTER TABLE `users`





30)