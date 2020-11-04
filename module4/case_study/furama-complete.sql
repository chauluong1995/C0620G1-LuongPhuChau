drop database if exists furama;
create database furama;

use furama;

create table `position` (
	id int primary key auto_increment,
    `name` varchar(45)
);

insert into `position` (`name`)
values
	('Receptionist'),
	('Serve'),
	('Expert'),
	('Monitoring'),
	('Manage'),
	('Director');

create table education_degree (
	id int primary key auto_increment,
    `name` varchar (45)
);

insert into education_degree (`name`)
values
	('Intermediate'),
	('College'),
	('University'),
	('After University');

create table division (
	id int primary key auto_increment,
    `name` varchar (45)
);

insert into division (`name`)
values
	('Sale – Marketing'),
	('Administration'),
	('Serve'),
	('Manage');

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

create table rent_type (
	id int primary key auto_increment,
    `name` varchar (45),
    cost double
);

insert into rent_type (`name`)
values
	('Full Day'),
	('Full Week'),
	('Full Month');

create table service_type (
	id int primary key auto_increment,
    `name` varchar (45)
);

insert into service_type (`name`)
values
	('Villa'),
	('House'),
	('Room');

create table attach_service (
	attach_service_id int primary key auto_increment,
    attach_service_name varchar(45),
    attach_service_cost double,
    attach_service_unit int,
    attach_service_status varchar(45)
);

insert into attach_service (attach_service_id, attach_service_name, attach_service_status)
values
	(1, 'Massage', 'Available'),
	(2, 'Karaoke', 'Available'),
	(3, 'Food', 'Available'),
	(4, 'Drink', 'Available'),
	(5, 'Car', 'Available');
	

create table `role` (
	role_id int primary key auto_increment,
    role_name varchar(255)
);

insert into `role` (role_name)
values
	('Manager'),
	('Employee');


create table `user` (
	user_name varchar(255) primary key,
    `password` varchar(255)
);

insert into `user` (user_name, `password`)
values
	('Admin', 'ok'),
	('Client', 'notok');

create table user_role (
	role_id int,
    user_name varchar(255)
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

insert into customer (id, `name`, birthday, gender, email, address, customer_type_id)
values
	('KH-0527', 'Chau Luong', '1995-05-27', 'Male', 'chauluong@codegym.com', 'Quang Nam', 1),
	('KH-0515', 'Mai Ho', '1995-05-15', 'Female', 'maiho@codegym.com', 'Da Nang', 1),
	('KH-2202', 'Lanh Nguyen', '1997-02-02', 'Male', 'lanhnguyen@codegym.com', 'Da Nang', 2),
	('KH-1702', 'Din Luong', '1996-06-06', 'Male', 'dinluong@codegym.com', 'Quang Ngai', 3),
	('KH-0209', 'Khanh Nguyen', '1994-09-02', 'Male', 'khanh@codegym.com', 'Da Nang', 4),
	('KH-0707', 'Vu Nguyen', '1997-07-07', 'Male', 'vunguyen@codegym.com', 'Ha Tinh', 5);

create table service (
	service_id varchar(25) primary key,
    service_name varchar(45),
    service_area int,
    service_cost double,
    service_max_people int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    
    rent_type_id int,
    foreign key (rent_type_id) references rent_type(rent_type_id) on delete cascade on update cascade,
    
    service_type_id int,
    foreign key (service_type_id) references service_type(service_type_id) on delete cascade on update cascade
);

insert into service (service_id, service_name, service_area, service_cost, pool_area, rent_type_id, service_type_id)
values
	('DV-6789', 'Villa Vip', 200, 1000, 70, 3, 1),
	('DV-0515', 'House Vip', 100, 500, 25, 3, 2),
	('DV-2202', 'Room Vip', 50, 200, 0, 2, 3),
	('DV-0606', 'House Standard', 75, 250, 15, 2, 2),
	('DV-0902', 'Room Standard', 35, 100, 0, 1, 3);

create table employee (
	id int primary key auto_increment,
    `name` varchar(45),
    birthday date,
    id_card varchar(45),
    salary double,
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    
    position_id int,
    foreign key(position_id) references `position`(position_id) on delete cascade on update cascade,
    
    education_degree_id int,
    foreign key(education_degree_id) references education_degree(education_degree_id) on delete cascade on update cascade,
    
    division_id int,
    foreign key(division_id) references division(division_id) on delete cascade on update cascade,
    
    user_name varchar(255),
    foreign key(user_name) references `user`(user_name) on delete cascade on update cascade
);

insert into employee (employee_id, employee_name, employee_phone, employee_id_card, employee_birthday, employee_salary, employee_email, employee_address, 
position_id, education_degree_id, division_id, user_name)
values
	('1', 'Phong Tran', '0905052795', '905052795', '1995-05-27', 5000, 'phong@codegym.com', 'Quang Nam', 6, 4, 4, 'Admin'),
	('2', 'Ly Le', '0905051595', '805052795', '1995-05-15', 4500, 'lyle@codegym.com', 'Da Nang', 5, 4, 3, 'Admin'),
	('3', 'Tam Nguyen', '0905020297', '705052795', '1997-02-02', 1000, 'tamnguyen@codegym.com', 'Da Nang', 4, 2, 1, 'Client'),
	('4', 'Giang Ly', '0905060696', '605052795', '1996-06-06', 4500, 'giang@codegym.com', 'Quang Ngai', 3, 4, 3, 'Admin'),
	('5', 'Khoi Huynh', '0905090294', '505052795', '1994-09-02', 3500, 'khoi@codegym.com', 'Da Nang', 2, 4, 2, 'Client'),
	('6', 'Vy Ho', '0905070797', '305052795', '1997-07-07', 1500, 'vyho@codegym.com', 'Ha Tinh', 1, 3, 2, 'Client');

create table contract (
	contract_id int primary key auto_increment,
    contract_start_date datetime,
    contract_end_date datetime,
    contract_deposite double,
    contract_total_money double,
    
    employee_id int,
    constraint fk_employee foreign key(employee_id) references employee(employee_id) on delete cascade on update cascade,
    
    customer_id varchar(25),
    constraint fk_customer foreign key(customer_id) references customer(id) on delete cascade on update cascade,
    
    service_id varchar(25),
    constraint fk_service foreign key(service_id) references service(service_id) on delete cascade on update cascade
);

-- insert into contract (contract_id, contract_start_date, contract_end_date, contract_deposite, employee_id, customer_id, service_id)
-- values
-- 	(1, '2019-01-01', '2019-02-01', 100, 1, 'KH-6789', 'DV-6789'),
-- 	(2, '2019-01-01', '2019-02-01', 100, 2, 'KH-2202', 'DV-0515'),
-- 	(3, '2019-01-01', '2019-01-08', 100, 3, 'KH-0515', 'DV-2202'),
-- 	(4, '2019-01-01', '2019-01-08', 100, 4, 'KH-0606', 'DV-0606'),
-- 	(5, '2019-01-01', '2019-01-02', 100, 5, 'KH-0902', 'DV-0902');

-- create table contract_detail (
-- 	contract_detail_id int primary key auto_increment,
--     quantity int,
--     
--     contract_id int,
--     constraint fk_contract foreign key(contract_id) references contract(contract_id) on delete cascade on update cascade,
--     
--     attach_service_id int,
--     foreign key(attach_service_id) references attach_service(attach_service_id) on delete cascade on update cascade
-- );

-- insert into contract_detail (contract_detail_id, quantity, contract_id, attach_service_id)
-- values
-- 	(1, 1, 1, 1),
-- 	(2, 1, 2, 2),
-- 	(3, 1, 3, 3),
-- 	(4, 1, 4, 4),
-- 	(5, 1, 5, 5);