-- 1. minions database

CREATE DATABASE minions;
USE minions;

CREATE TABLE minions (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
age INT NOT NULL
);

CREATE TABLE towns (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL
);

ALTER TABLE minions
ADD COLUMN town_id INT;

ALTER TABLE minions
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (town_id)
REFERENCES towns(id);

DROP TABLE minions;
DROP TABLE towns;

-- 2. people

CREATE TABLE people (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
picture BLOB,
height DOUBLE(19,2),
weight DOUBLE(19,2),
gender ENUM('m', 'f') NOT NULL,
birthdate DATE NOT NULL,
biography TEXT
);

-- 3. users

CREATE TABLE users (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL,
password VARCHAR(26) NOT NULL,
profile_picture BLOB,
last_login_time DATETIME,
is_deleted BOOLEAN
);

ALTER TABLE users
DROP CONSTRAINT pk_users,
ADD CONSTRAINT pk_users_id_username
PRIMARY KEY (id, username);

ALTER TABLE users
MODIFY COLUMN last_login_time DATETIME DEFAULT NOW();

-- 4. movies database

CREATE DATABASE movies;
USE movies;

CREATE TABLE directors (
	id INT PRIMARY KEY AUTO_INCREMENT,
    director_name VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE genres (
	id INT PRIMARY KEY AUTO_INCREMENT,
    genre_name VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE categories (
	id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE movies (
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    director_id INT,
    copyright_year DATE,
    length DATETIME,
    genre_id INT,
    category_id INT,
    rating DOUBLE(19,4),
    notes TEXT,
    CONSTRAINT fk_movies_directors
		FOREIGN KEY (director_id)
        REFERENCES directors(id),
	CONSTRAINT fk_movies_genres
		FOREIGN KEY (genre_id)
        REFERENCES genres(id),
	CONSTRAINT fk_movies_categoris
		FOREIGN KEY (category_id)
        REFERENCES categories(id)
);

-- 5. soft_uni database

CREATE DATABASE soft_uni;
USE soft_uni;

CREATE TABLE towns (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE addresses (
	id INT PRIMARY KEY AUTO_INCREMENT,
    address_text VARCHAR(255) NOT NULL,
    town_id INT,
    CONSTRAINT fk_addresses_towns
		FOREIGN KEY (town_id)
        REFERENCES towns(id)
);

CREATE TABLE departments (
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    department_id INT,
    hire_date DATE,
    salary DOUBLE(19,4),
    address_id INT
);


ALTER TABLE employees
ADD CONSTRAINT fk_empl_dep
	FOREIGN KEY (department_id)
    REFERENCES departments(id),
ADD CONSTRAINT fk_empl_addresses
	FOREIGN KEY (address_id)
    REFERENCES addresses(id);
    
INSERT INTO towns (name)
VALUES ('Sofia'), ('Plovdiv'), ('Varna'), ('Burgas');

INSERT INTO departments (name)
VALUES ('Engineering'), ('Sales'), ('Marketing'), ('Software Development'), ('Quality Assurance');

INSERT INTO employees (first_name, middle_name, last_name, job_title, department_id, hire_date, salary)
VALUES ('Ivan', 'Ivanov', 'Ivanov', '.NET Developer', 4, NOW(), 3500),
('Petar', 'Petrov', 'Petrov', 'Senior Engineer', 1, NOW(), 4000),
('Maria', 'Petrova', 'Ivanova', 'Intern', 5, NOW(), 725);

SELECT * FROM towns;
SELECT * FROM departments;
SELECT * FROM employees;

SELECT * FROM towns
ORDER BY name;

SELECT * FROM departments
ORDER BY name ASC;

SELECT * FROM employees
ORDER BY salary DESC;

SELECT `name` FROM towns
ORDER BY name;

SELECT `name` FROM departments
ORDER BY name;

SELECT first_name, last_name, job_title, salary
FROM employees
ORDER BY salary DESC;

UPDATE employees
SET salary = salary * 1.1;

SELECT salary FROM employees;