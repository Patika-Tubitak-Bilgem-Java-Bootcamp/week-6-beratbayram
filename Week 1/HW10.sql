SELECT
    city.name,
    country.name
FROM
    city
LEFT JOIN 
    country 
ON 
    city.country_id = country.id;
----------
SELECT
    payment.payment_id,
    customer.first_name,
    customer.last_name
FROM
    customer
RIGHT JOIN 
    payment 
ON 
    customer.id = payment.customer_id;
----------
SELECT
    rental.rental_id,
    customer.first_name,
    customer.last_name
FROM
    customer FULL
JOIN 
    rental
ON
    customer.id = rental.customer_id;