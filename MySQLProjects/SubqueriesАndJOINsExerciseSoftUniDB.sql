/* 1.	Employee Address */
SELECT e.`employee_id`, e.`job_title`, e.`address_id`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
ORDER BY `address_id`
LIMIT 5;

/* 2.	Addresses with Towns */
SELECT e.`first_name`, e.`last_name`, t.`name` AS 'town', a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a 
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON a.`town_id` = t.`town_id`
ORDER BY e.`first_name`, e.`last_name`
LIMIT 5;

/* 3.	Sales Employee */
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY e.`employee_id` DESC;

/* 4.	Employee Departments */
SELECT e.`employee_id`, e.`first_name`, e.`salary`, d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`salary` > 15000
ORDER BY e.`department_id` DESC,
e.`salary` DESC
LIMIT 5;

/* 5.	Employees Without Project */
SELECT DISTINCT e.`employee_id`, e.`first_name`
FROM `employees` AS e
LEFT JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
WHERE ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

/* 6.	Employees Hired After */
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` AS 'dept_name'
FROM `employees` AS e
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE d.`name` IN ('Sales', 'Finance') 
AND DATE(e.`hire_date`) > '1999/01/01'
ORDER BY e.`hire_date`;

/* 7.	Employees with Project */
SELECT e.`employee_id`, e.`first_name`, p.`name` AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p
ON ep.`project_id` = p.`project_id`
WHERE DATE(p.`start_date`) > '2002/08/13' 
AND p.`end_date` IS NULL
ORDER BY e.`first_name`,
`project_name`
LIMIT 5;

/* 8.	Employee 24 */
SELECT e.`employee_id`, e.`first_name`, IF(YEAR(p.`start_date`) >= 2005, NULL, p.`name`) AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep
ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p
ON ep.`project_id` = p.`project_id`
WHERE e.`employee_id` = 24
ORDER BY `project_name`;

/* 9.	Employee Manager */
SELECT e.`employee_id`, e.`first_name`, e.`manager_id`, e2.`first_name` AS 'manager_name'
FROM `employees` AS e
JOIN `employees` AS e2
ON e.`manager_id` = e2.`employee_id`
WHERE e.`manager_id` IN (3, 7)
ORDER BY e.`first_name`;

/* 10.	Employee Summary */
SELECT e.`employee_id`, 
concat_ws(' ', e.`first_name`, e.`last_name`) AS 'employee_name',
concat_ws(' ', e2.`first_name`, e2.`last_name`) AS 'manager_name',
d.`name` AS 'department_name'
FROM `employees` AS e
LEFT JOIN `employees` AS e2
ON e.`manager_id` = e2.`employee_id`
JOIN `departments` AS d
ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` > 0
ORDER BY e.`employee_id`
LIMIT 5;

/* 11.	Min Average Salary */
SELECT MIN(`average_salaries`) AS 'min_average_salary'
FROM 
(
	SELECT AVG(`salary`) AS 'average_salaries'
    FROM `employees` 
    GROUP BY `department_id`
) 
AS `min_value`;
    
