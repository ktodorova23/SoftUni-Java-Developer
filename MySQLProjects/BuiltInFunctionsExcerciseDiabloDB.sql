SELECT `name`, DATE_FORMAT(`start`, '%Y-%m-%d') AS 'start'
FROM `games`
WHERE YEAR(`start`) IN (2011, 2012)
ORDER BY `start`, `name`
LIMIT 50;

SELECT `user_name`, SUBSTRING_INDEX(`email`, '@', -1) AS 'Email Provider'
FROM `users`
ORDER BY `Email Provider`, `user_name`;

/*  Get Users with IP Address Like Pattern  */
SELECT `user_name`, `ip_address`
FROM `users`
WHERE `ip_address` LIKE '%___.1%.%.___%'
ORDER BY `user_name`;

/* Show all games with duration nad part of the day */
SELECT `name` AS 'game',
CASE 
WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN 'Morning'
WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN 'Afternoon'
WHEN HOUR(`start`) >= 18 AND HOUR(`start`) < 24 THEN 'Evening'
END AS 'Part of the day',
CASE 
WHEN `duration` BETWEEN 0 AND 3 THEN 'Extra Short'
WHEN `duration` BETWEEN 3 AND 6 THEN 'Short'
WHEN `duration` BETWEEN 6 AND 10 THEN 'Long'
ELSE 'Extra Long'
END AS 'Duration'
FROM `games`;

