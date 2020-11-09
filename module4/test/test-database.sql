drop database if exists test_complete;
create database test_complete;

use test_complete;

create table customer_type (
	id int primary key auto_increment,
    `name` varchar (45)
);

insert into customer_type (`name`)
values
	('Diamond'),
	('Platinium'),
	('Gold'),
	('Silver'),
	('Member');
    
    create table customer (
	id varchar(25) primary key,
    `name` varchar(45),
    birth_day date,
    gender varchar(45),
    salary double,
    id_card varchar(45),
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    
    customer_type_id int,
    foreign key (customer_type_id) references customer_type(id) on delete cascade on update cascade
);

insert into customer
values
	('KH-11111', 'Zanis', '1991-01-01', 'Male', 5500, '111111111', '0905111111', 'zanis@gmail.com', 'China', 1),
	('KH-22222', 'Neymar Jr', '1992-02-02', 'Male', 5000, '222222222', '0905222222', 'neymar@gmail.com', 'Brazil', 2),
	('KH-33333', 'Alisson Becker', '1993-03-03', 'Male', 3500, '333333333', '0905333333', 'alisson@gmail.com', 'Brazil', 3),
	('KH-55555', 'Michael Owen', '1995-05-05', 'Male', 2500, '555555555', '0905555555', 'owen@gmail.com', 'England', 4),
	('KH-77777', 'Amily', '1997-07-07', 'Female', 4500, '777777777', '0905777777', 'amily@gmail.com', 'Spain', 5),
	('KH-88888', 'Butterfly', '1998-08-08', 'Female', 4500, '888888888', '0905888888', 'butterfly@gmail.com', 'Portugal', 5),
	('KH-99999', 'Capheny', '1999-09-09', 'Female', 4500, '999999999', '0905999999', 'capheny@gmail.com', 'Italia', 5);
	