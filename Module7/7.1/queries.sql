-- Query 1: Retrieve all currencies
SELECT * FROM currency;

-- Query 2: Retrieve the currency with abbreviation EUR
SELECT * FROM currency WHERE abbreviation = 'EUR';

-- Query 3: Retrieve the number of currencies in the database
SELECT COUNT(*) AS number_of_currencies FROM currency;

-- Query 4: Retrieve the currency with the highest exchange rate
SELECT * FROM currency ORDER BY rate DESC LIMIT 1;
