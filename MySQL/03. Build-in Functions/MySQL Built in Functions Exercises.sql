# PART 1 - Soft_Uni Database
-- 1. Find Names of All Employees by First Name

SELECT
	first_name, last_name
FROM employees
WHERE first_name LIKE 'Sa%'
ORDER BY employee_id;

-- 2. Find Names of All Employees by Last Name

SELECT 
	first_name, last_name
FROM employees
WHERE last_name LIKE '%ei%'
ORDER BY employee_id;

-- 3. Find First Names of All Employees

SELECT first_name FROM employees
WHERE department_id IN (3, 10)
	AND YEAR(hire_date) BETWEEN 1995 AND 2005
ORDER BY employee_id;

-- 4. Find All Employees Except Engineers

SELECT first_name, last_name FROM employees
WHERE job_title NOT LIKE '%engineer%'
ORDER BY employee_id;

-- 5. Find Towns with Name Length

SELECT `name` FROM towns
WHERE LENGTH(name) IN (5, 6)
ORDER BY name;

-- 6. Find Towns Starting With

SELECT * FROM towns
WHERE UPPER(`name`) LIKE ('M%')
	OR UPPER(`name`) LIKE ('K%')
    OR UPPER(`name`) LIKE ('B%')
    OR UPPER(`name`) LIKE ('E%')
ORDER BY name;

-- 7. Find Towns Not Starting With

SELECT * FROM towns
WHERE name NOT LIKE 'R%'
    AND name NOT LIKE 'B%'
    AND name NOT LIKE 'D%'
ORDER BY name;

-- 8. Create View Employees Hired After 2000 Year

SELECT 
	first_name, last_name, hire_date
FROM employees
WHERE EXTRACT(YEAR FROM hire_date) > 2000;

-- 9. Length of Last Name

SELECT
	first_name, last_name
FROM employees
WHERE LENGTH(last_name) = 5;

# PART 2 - Geography Database
-- 10. Countries Holding 'A' 3 or More Times

SELECT
	country_name,
    iso_code
FROM countries
WHERE UPPER(country_name) LIKE ('%A%A%A%')
ORDER BY iso_code;

-- 11. Mix of Peak and River Names

SELECT
	p.peak_name,
    r.river_name,
    LOWER(CONCAT(p.peak_name, r.river_name)) AS mix
FROM
	rivers AS r,
    peaks AS p
WHERE
	UPPER(RIGHT(p.peak_name, 1)) = UPPER(LEFT(r.river_name, 1))
ORDER BY mix;

# PART 3 - Diablo Database
-- 12. Games from 2011 and 2012 Year

SELECT 
	`name`,
    DATE(`start`) AS `start`
FROM games
WHERE YEAR(`start`) BETWEEN 2011 AND 2012
ORDER BY `start`, `name`
LIMIT 50;

-- 13. . User Email Providers

SELECT
	user_name,
    SUBSTRING_INDEX(email, '@', -1) AS 'email_provider'
FROM users
ORDER BY email_provider, user_name;

-- 14. Get Users with IP Address Like Pattern

SELECT user_name, ip_address FROM users
WHERE ip_address LIKE ('___.1%.%.___')
ORDER BY user_name;

-- 15. Show All Games with Duration and Part of the Day

SELECT
	name AS game,
    CASE
		WHEN HOUR(start) BETWEEN 0 AND 11 THEN 'Morning' 
        WHEN HOUR(start) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
	END AS 'Part of the Day',
    CASE
		WHEN duration <= 3 THEN 'Extra Short'
        WHEN duration BETWEEN 4 AND 6 THEN 'Short'
        WHEN duration BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM games;

# PART 4 - Date Functions Queries
-- 16. Orders Table

SELECT
	product_name,
    order_date,
    DATE_ADD(order_date, INTERVAL 3 DAY) AS pay_due,
    DATE_ADD(order_date, INTERVAL 1 MONTH) AS deliver_due
FROM orders;
