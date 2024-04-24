-- Drop previous database if it exists
DROP DATABASE IF EXISTS currency_app;

-- Create a new database
CREATE DATABASE currency_app;

-- Use the newly created database
USE currency_app;

-- Create a table for storing Currency objects
CREATE TABLE currency (
    id INT AUTO_INCREMENT PRIMARY KEY,
    abbreviation VARCHAR(10) NOT NULL,
    name VARCHAR(100) NOT NULL,
    rate DECIMAL(10, 4) NOT NULL
);

-- Populate the table with sample data for eight currencies
INSERT INTO currency (abbreviation, name, rate) 
VALUES 
    ('USD', 'US Dollar', 1.0000),
    ('EUR', 'Euro', 0.8832),
    ('GBP', 'British Pound', 0.7532),
    ('JPY', 'Japanese Yen', 113.8700),
    ('AUD', 'Australian Dollar', 1.3802),
    ('CAD', 'Canadian Dollar', 1.2830),
    ('CHF', 'Swiss Franc', 0.9217),
    ('CNY', 'Chinese Yuan', 6.3778);

-- Drop the user account appuser if it exists
DROP USER IF EXISTS 'appuser'@'localhost';

-- Create the user account appuser
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password123';

-- Grant necessary privileges to the appuser
GRANT ALL PRIVILEGES ON currency_app.* TO 'appuser'@'localhost';

-- Flush privileges to apply changes
FLUSH PRIVILEGES;
