drop database if exists test_complete;
create database test_complete;

use test_complete;

create table product_type (
	id int primary key auto_increment,
    `name` varchar (45)
);

insert into product_type (`name`)
values
	('Phone'),
	('Laptop'),
	('Television');
    
create table product (
	id int primary key auto_increment,
    `name` varchar(45),
    price double,
    `status` varchar(45),
    
    product_type_id int,
    foreign key (product_type_id) references product_type(id) on delete cascade on update cascade
);