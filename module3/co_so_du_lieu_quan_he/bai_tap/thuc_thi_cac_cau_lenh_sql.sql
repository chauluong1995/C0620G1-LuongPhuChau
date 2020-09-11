use classicmodels;

select customername, phone, city, country
from customers;

select *
from customers;

select *
from customers
where customerName = 'Atelier graphique';

select *
from customers
where customerName like '%A%';

select *
from customers
where city
in (
	'Nantes','Las Vegas','Warszawa','NYC'
);