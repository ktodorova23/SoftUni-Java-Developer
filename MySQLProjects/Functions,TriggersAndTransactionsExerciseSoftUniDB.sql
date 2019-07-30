/* 1.	Employees with Salary Above 35000 */
DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
	SELECT `first_name`, `last_name`
    FROM employees
    WHERE salary > 35000
    ORDER BY first_name, last_name, employee_id;
END; $$

CALL usp_get_employees_salary_above_35000;

/* 2.	Employees with Salary Above Number */
DELIMITER $$

CREATE PROCEDURE usp_get_employees_salary_above(amount DOUBLE)
BEGIN
	SELECT first_name, last_name
    FROM employees
    WHERE salary >= amount
    ORDER BY first_name, last_name, employee_id;
END; $$

CALL usp_get_employees_salary_above(48100);

/*3.	Town Names Starting With */
DELIMITER $$

CREATE PROCEDURE usp_get_towns_starting_with(begin_name VARCHAR(10))
BEGIN
	SELECT `name` AS 'town_name'
    FROM `towns`
    WHERE `name` LIKE CONCAT(begin_name, '%')
    ORDER BY `town_name`;
END; $$

CALL usp_get_towns_starting_with('b');

/* 4.	Employees from Town */
DELIMITER $$

CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(10))
BEGIN
	SELECT e.first_name, e.last_name
    FROM employees AS e
    JOIN addresses AS a
    ON e.address_id = a.address_id
    JOIN towns AS t
    ON a.town_id = t.town_id
    WHERE t.name = town_name
    ORDER BY first_name, last_name, employee_id;
END; $$

CALL usp_get_employees_from_town('Sofia');

/* 5.	Salary Level Function */
DELIMITER $$

CREATE FUNCTION ufn_get_salary_level(salary_value DOUBLE)
RETURNS VARCHAR(15)
BEGIN
	DECLARE result VARCHAR(15);
    
    IF salary_value < 30000 THEN SET result := 'Low';
    ELSEIF salary_value BETWEEN 30000 AND 50000 THEN SET result := 'Average';
    ELSE SET result := 'High';
    END IF;
    
    RETURN result;
END; $$

SELECT ufn_get_salary_level(13500.00);

/* 6.	Employees by Salary Level */

DELIMITER $$

CREATE PROCEDURE usp_get_employees_by_salary_level(salary_definition VARCHAR(8))
BEGIN
SELECT first_name, last_name
FROM employees
WHERE ufn_get_salary_level(salary) = salary_definition
ORDER BY first_name DESC, last_name DESC;
END; $$

CALL usp_get_employees_by_salary_level('high');

/* 7.	Define Function */
DELIMITER $$

CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT
BEGIN
	DECLARE indx INT;
    DECLARE symbol VARCHAR(1);
    
    SET indx = 1;
    
    WHILE indx <= CHAR_LENGTH(word) DO
    
    SET symbol = SUBSTRING(word, indx, 1);
    
    IF (LOCATE(symbol, set_of_letters) = 0) THEN
    RETURN 0;
    END IF;
    
    SET indx = indx + 1;
    END WHILE;
    
    RETURN 1;
END; $$

SELECT ufn_is_word_comprised('pppp', 'Guy');