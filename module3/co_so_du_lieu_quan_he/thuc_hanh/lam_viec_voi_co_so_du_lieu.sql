use classicmodels;

select customername, phone, city, country
from customers;

select *
from customers
limit 0 , 30;

select *
from customers
where customerName = 'Atelier graphique'
limit 0 , 30;

select *
from customers
where customerName like '%A%'
limit 0 , 30;

select *
from customers
where city
in (
	'Nantes','Las Vegas','Warszawa','NYC'
)
limit 0 , 30;

select ordernumber, orderDate
from orders;

select *
from orders
where orderNumber
between 10100 and 10110;

select *
from orders
where orderDate = '2003-03-03' and `status` like 'shipped';