SELECT `first_name`, `last_name` FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

SELECT `first_name` FROM `employees`
WHERE `department_id` IN (3, 10) AND
YEAR (`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%';

SELECT `name` FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5, 6)
ORDER BY `name`;

SELECT `town_id`, `name` FROM `towns`
WHERE `name` RLIKE '^[mkbe]'
ORDER BY `name`;

select * from `towns`
where `name` regexp '\[MKBE\]%';

SELECT `town_id`, `name` FROM `towns`
WHERE `name` NOT LIKE 'R%' AND `name` NOT LIKE 'B%' AND `name` NOT LIKE 'D%'
ORDER BY `name`;  

CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` FROM `employees`
WHERE YEAR (`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;

SELECT `first_name`, `last_name` FROM `employees`
WHERE char_length(`last_name`) = 5;

