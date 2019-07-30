USE bank;
/* 8.	Find Full Name */
DELIMITER $$

CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT CONCAT_WS(' ', first_name, last_name) AS 'full_name'
    FROM account_holders
    ORDER BY `full_name`, `id`;
END; $$

CALL usp_get_holders_full_name();

/* 9.	People with Balance Higher Than */
DELIMITER $$

CREATE PROCEDURE usp_get_holders_with_balance_higher_than(money_value DOUBLE)
BEGIN
	SELECT mt.first_name, mt.last_name
    FROM (
		SELECT a.id, ah.first_name, ah.last_name, SUM(balance) AS 'total_balance'
        FROM account_holders AS ah
        JOIN accounts AS a
        ON ah.id = a.account_holder_id
        GROUP BY account_holder_id        
    ) AS mt
    WHERE mt.total_balance > money_value
    ORDER BY mt.id;
END; $$

CALL usp_get_holders_with_balance_higher_than(7000);

/* 10.	Future Value Function */
DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value(init_sum DECIMAL(10, 4), yearly_interest DECIMAL(10, 4), number_of_years INT)
RETURNS DECIMAL(10, 4)
BEGIN
	DECLARE future_value DECIMAL(10, 4);
    
    SET future_value := init_sum * POW(1 + yearly_interest, number_of_years);
    
    RETURN future_value;
END; $$

DELIMITER $$
SELECT ufn_calculate_future_value(1000, 0.1, 5); $$

/* 11.	Calculating Interest */
DELIMITER $$

CREATE PROCEDURE usp_calculate_future_value_for_account(id_account INT, interest_rate DECIMAL(10, 4))
BEGIN
	SELECT a.id AS 'account_id', 
    ah.first_name, 
    ah.last_name, 
    a.balance, 
    ufn_calculate_future_value(a.balance, interest_rate, 5) AS 'balance_in_5_years'
    FROM accounts AS a
    JOIN account_holders AS ah
    ON a.account_holder_id = ah.id
    WHERE a.id = id_account;
END; $$

DELIMITER $$ 
CALL usp_calculate_future_value_for_account(1, 0.1); $$

/* 12.	Deposit Money */
DELIMITER $$

CREATE PROCEDURE usp_deposit_money(account_id INT, money_amount DECIMAL)
BEGIN
	START TRANSACTION;
    IF(money_amount < 0 AND ROUND(money_amount, 4) <> money_amount)  THEN 
    ROLLBACK;
    ELSE 
		UPDATE accounts AS a
        SET a.balance = a.balance + money_amount
        WHERE a.id = account_id;
	END IF;	
	COMMIT;
END; $$

CALL usp_deposit_money(1, 10);
SELECT *
FROM accounts
WHERE id = 1;

/* 13.	Withdraw Money */
DELIMITER $$

CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(10, 4))
BEGIN
	START TRANSACTION;
    IF(money_amount < 0 OR money_amount > (SELECT a.balance FROM accounts AS a
    WHERE a.id = account_id)) THEN
    ROLLBACK;
    
    ELSE 
    UPDATE accounts AS a
    SET a.balance = a.balance - money_amount
    WHERE a.id = account_id;
    END IF;
    
    COMMIT;
END; $$

DELIMITER $$
CALL usp_withdraw_money(1, 10);
SELECT * 
FROM accounts AS a
WHERE a.id = 1; $$

/* 14.	Money Transfer */
DELIMITER $$
CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(10, 4))
BEGIN
	START TRANSACTION;
    CASE 
		WHEN ((SELECT a.id FROM accounts AS a WHERE a.id = from_account_id) IS NULL) 
        OR ((SELECT a.id FROM accounts AS a WHERE a.id = to_account_id) IS NULL)
        OR (amount < 0)
        OR (amount > (SELECT a.balance FROM accounts AS a WHERE a.id = from_account_id))
        OR (from_account_id = to_account_id)
        THEN 
        ROLLBACK;
		
        ELSE 
			UPDATE accounts AS a
            SET a.balance = a.balance - amount
            WHERE a.id = from_account_id;
            
            UPDATE accounts AS a
            SET a.balance = a.balance + amount
            WHERE a.id = to_account_id;
        END CASE;
        COMMIT;
END; $$
