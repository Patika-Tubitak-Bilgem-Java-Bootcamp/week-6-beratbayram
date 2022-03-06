SELECT
    city.city,
    country.country
FROM
    city
INNER JOIN 
    country
ON city.id = country.city_id
----------
SELECT
    customer.first_name,
    customer.last_name,
    payment.payment_id
FROM
    customer
INNER JOIN 
    payment 
ON 
    customer.id = payment.customer_id
----------
SELECT
    rental.rental_id,
    customer.first_name,
    customer.last_name
FROM
    customer
INNER JOIN 
    rental 
ON 
    customer.id = rental.customer_id