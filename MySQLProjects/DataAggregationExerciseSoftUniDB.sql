/* Employees Minimum Salaries */ 
SELECT `department_id`, 
MIN(`salary`) AS 'minimum_salary'
FROM `employees`
WHERE DATE(`hire_date`) > '2000/01/01' AND `department_id` IN (2, 5, 7)
GROUP BY `department_id`
ORDER BY `department_id`;

/* Employees Average Salaries */
CREATE TABLE `temporary2`
AS SELECT *
FROM `employees`
WHERE `salary` > 30000;

DELETE FROM `temporary2`
WHERE `manager_id` = 42;

UPDATE `temporary2`
SET `salary` = `salary` + 5000
WHERE `department_id` = 1;

SELECT `department_id`,
	AVG(`salary`) AS 'avg_salary'
FROM `temporary2`
GROUP BY `department_id`
ORDER BY `department_id`;

/* Employees Maximum Salaries */
SELECT `department_id`,
MAX(`salary`) AS 'max_salary'
FROM `employees`
GROUP BY `department_id`
HAVING `max_salary` < 30000 OR `max_salary` > 70000
ORDER BY `department_id`;

/* Employees Count Salaries */
SELECT COUNT(`salary`) 
FROM `employees`
WHERE `manager_id` IS NULL;

/* Departments Total Salaries */
SELECT `department_id`,  
SUM(`salary`) AS 'total_salary'
FROM `employees`
GROUP BY `department_id`
ORDER BY `department_id`;
