drop database if exists furama_heroku;
create database furama_heroku;

use furama_heroku;

create table customer_type (
	id int primary key auto_increment,
    `name` varchar (45)
);

create table customer (
	id varchar(25) primary key,
    `name` varchar(45),
    birthday date,
    gender varchar(45),
    id_card varchar(45),
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    
    customer_type_id int,
    foreign key (customer_type_id) references customer_type(id) on delete cascade on update cascade
);