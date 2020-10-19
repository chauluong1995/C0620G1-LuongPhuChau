drop database if exists product_manager;

create database product_manager;

use product_manager;

create table product (
	product_id varchar(50) primary key,
    product_name varchar(100),
    color varchar(25),
    manufacturer varchar(50)
);

insert into product
values
	('PD-111', 'Acer Nitro 5', 'Yellow', 'Acer'),
	('PD-222', 'Sony Xperia XZ Premium', 'Titan', 'Sony'),
	('PD-333', 'Realme C1', 'Black', 'Realme'),
	('PD-555', 'Yamaha R15', 'Red', 'Yamaha'),
	('PD-777', 'Lamborghini Veneno', 'Blue', 'Lamborghini');