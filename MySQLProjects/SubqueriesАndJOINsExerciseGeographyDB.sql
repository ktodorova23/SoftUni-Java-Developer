/* 12.	Highest Peaks in Bulgaria */
SELECT mc.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `mountains_countries` AS mc
JOIN `mountains` AS m
ON mc.`mountain_id` = m.`id`
JOIN `peaks` AS p
ON m.`id` = p.`mountain_id`
WHERE mc.`country_code` = 'BG' 
AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

/* 13.	Count Mountain Ranges */
SELECT mc.`country_code`,
COUNT(`country_code`) AS 'mountain_range'
FROM `mountains_countries` AS mc
GROUP BY `country_code`
HAVING `country_code` IN ('BG', 'RU', 'US')
ORDER BY `mountain_range` DESC;

/* 14.	Countries with Rivers */
SELECT c.`country_name`, r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr
ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r
ON cr.`river_id` = r.`id`
WHERE c.`continent_code` = 'AF'
ORDER BY c.`country_name`
LIMIT 5;

/* 15.	*Continents and Currencies */

/* 16.	Countries without any Mountains */
SELECT COUNT(*) AS 'country_count'
FROM 
(
	SELECT c.`country_code`, COUNT(mc.`mountain_id`) AS 'count_mountains'
	FROM `countries` AS c
	LEFT JOIN `mountains_countries` AS mc
	ON c.`country_code` = mc.`country_code`
	GROUP BY c.`country_code`
    HAVING `count_mountains` = 0
) AS `count`;

/* 17.	Highest Peak and Longest River by Country */
