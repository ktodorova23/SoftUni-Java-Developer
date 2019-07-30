/* Records’ Count */
SELECT COUNT(*)
FROM `wizzard_deposits`;

/* Longest Magic Wand */
SELECT MAX(`magic_wand_size`) AS 'longest_magic_wand'
FROM `wizzard_deposits`;

/* Longest Magic Wand per Deposit Groups */
SELECT `deposit_group`, MAX(`magic_wand_size`) AS 'longest_magic_wand'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand`, `deposit_group`;

/* Smallest Deposit Group per Magic Wand Size */
SELECT `deposit_group`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
# HAVING AVG(magic_wand_size)
ORDER BY AVG(`magic_wand_size`)
LIMIT 1;

/* Deposits Sum */
SELECT `deposit_group`, SUM(`deposit_amount`) AS 'total_sum'
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;

/* Deposits Sum for Ollivander family */
SELECT `deposit_group`, SUM(`deposit_amount`) AS 'total_sum'
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;

/* Deposits Filter */
SELECT `deposit_group`, SUM(`deposit_amount`) AS 'total_sum'
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

/* Deposit charge */
SELECT `deposit_group`, `magic_wand_creator`, MIN(`deposit_charge`)
FROM `wizzard_deposits`
GROUP BY `deposit_group`, `magic_wand_creator`
ORDER BY `magic_wand_creator`, `deposit_group`;

/* Age Groups */
SELECT
CASE
WHEN `age` <= 10 THEN '[0-10]'
WHEN `age` <= 20 THEN '[11-20]'
WHEN `age` <= 30 THEN '[21-30]'
WHEN `age` <= 40 THEN '[31-40]'
WHEN `age` <= 50 THEN '[41-50]'
WHEN `age` <= 60 THEN '[51-60]'
ELSE '[61+]'
END AS 'age_group',
COUNT(`age`) AS 'wizzard_count'
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;

/*  First Letter */
SELECT SUBSTRING(`first_name`, 1, 1) AS 'first_letter'
FROM `wizzard_deposits`
WHERE `deposit_group` = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;

/* Average Interest */
SELECT `deposit_group`, `is_deposit_expired`,
AVG(`deposit_interest`) AS 'average_interest'
FROM `wizzard_deposits`
WHERE `deposit_start_date` > '1985/01/01'
GROUP BY `deposit_group`, `is_deposit_expired`
ORDER BY `deposit_group` DESC, `is_deposit_expired`;

/* 	Rich Wizard, Poor Wizard*  */
SELECT SUM(difference.nextWizzard) AS 'sum_difference'
FROM 
	(SELECT `deposit_amount` - 
		(SELECT `deposit_amount` 
        FROM `wizzard_deposits`
        WHERE `id` = CurrentDeposit.id + 1) AS nextWizzard
	FROM `wizzard_deposits` AS CurrentDeposit) AS difference;


