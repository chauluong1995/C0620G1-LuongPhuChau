drop database if exists furama;
create database furama;

use furama;

create table APP_USER ( USER_ID BIGINT not null , USER_NAME VARCHAR(36) not null, ENCRYTED_PASSWORD VARCHAR(128) not null, ENABLED BIT not null ) ;
alter table APP_USER add constraint APP_USER_PK primary key (USER_ID);
alter table APP_USER add constraint APP_USER_UK unique (USER_NAME);

create table APP_ROLE ( ROLE_ID BIGINT not null, ROLE_NAME VARCHAR(30) not null ) ;
alter table APP_ROLE add constraint APP_ROLE_PK primary key (ROLE_ID);
alter table APP_ROLE add constraint APP_ROLE_UK unique (ROLE_NAME);

create table USER_ROLE ( ID BIGINT not null, USER_ID BIGINT not null, ROLE_ID BIGINT not null );
alter table USER_ROLE add constraint USER_ROLE_PK primary key (ID);
alter table USER_ROLE add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);
alter table USER_ROLE add constraint USER_ROLE_FK1 foreign key (USER_ID) references APP_USER (USER_ID);
alter table USER_ROLE add constraint USER_ROLE_FK2 foreign key (ROLE_ID) references APP_ROLE (ROLE_ID);

CREATE TABLE Persistent_Logins (
    username VARCHAR(64) NOT NULL,
    series VARCHAR(64) NOT NULL,
    token VARCHAR(64) NOT NULL,
    last_used TIMESTAMP NOT NULL,
    PRIMARY KEY (series)
);

insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');
insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_MEMBER');

-- insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (1, 'LUONG PHU CHAU', '$2y$11$tngL5fyeWbtaSh8m5ngKcOS2b4PIs7.brx2xOD63y2UC/Nc7TwEq6', 1);
-- insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (2, 'Member', '$2y$12$yyPZBpFFjUDrmWl2CHMJc.ezoUAAzG5.b4dqIudTBQUsPYJ3Q0plK', 1);
-- insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);
-- insert into user_role (ID, USER_ID, ROLE_ID) values (2, 2, 2);
-- insert into user_role (ID, USER_ID, ROLE_ID) values (3, 1, 2);

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
	id int primary key auto_increment,
    `name` varchar(45),
    cost double,
    unit int,
    `status` varchar(45)
);

insert into attach_service (id, `name`, `status`)
values
	(1, 'Massage', 'Available'),
	(2, 'Karaoke', 'Available'),
	(3, 'Food', 'Available'),
	(4, 'Drink', 'Available'),
	(5, 'Car', 'Available');

create table customer (
	id varchar(25) primary key,
    `name` varchar(45),
    birth_day date,
    gender varchar(45),
    id_card varchar(45),
    phone_number varchar(45),
    email varchar(45),
    address varchar(45),
    
    customer_type_id int,
    foreign key (customer_type_id) references customer_type(id) on delete cascade on update cascade
);

insert into customer
values
	('KH-2222', 'Neymar Jr', '1992-02-02', 'Male', '222222222', '0905222222', 'neymar@gmail.com', 'Brazil', 1),
	('KH-3333', 'Alisson Becker', '1993-03-03', 'Male', '333333333', '0905333333', 'alisson@gmail.com', 'Brazil', 2),
	('KH-5555', 'Michael Owen', '1995-05-05', 'Male', '555555555', '0905555555', 'owen@gmail.com', 'England', 3),
	('KH-7777', 'Butterfly', '1997-07-07', 'Female', '777777777', '0905777777', 'butterfly@gmail.com', 'Spain', 1),
	('KH-9999', 'Zanis', '1999-09-09', 'Male', '999999999', '0905999999', 'zanis@gmail.com', 'China', 1);
	

create table service_furama (
	id varchar(25) primary key,
    `name` varchar(45),
    area int,
    cost double,
    max_people int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    
    rent_type_id int,
    foreign key (rent_type_id) references rent_type(id) on delete cascade on update cascade,
    
    service_type_id int,
    foreign key (service_type_id) references service_type(id) on delete cascade on update cascade
);

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
    foreign key(position_id) references `position`(id) on delete cascade on update cascade,
    
    education_degree_id int,
    foreign key(education_degree_id) references education_degree(id) on delete cascade on update cascade,
    
    division_id int,
    foreign key(division_id) references division(id) on delete cascade on update cascade
    
-- 	   user_id bigint,
--     foreign key(user_id) references app_user(user_id) on delete cascade on update cascade
);

insert into employee
values
	('1', 'Chau Luong', '1995-05-27', '205052795', 5000, '0905052795', 'chauluong@codegym.com', 'Quang Nam', 6, 4, 4),
	('2', 'Mai Ho', '1995-05-15', '205051595', 4500 , '0905051595', 'maiho@codegym.com', 'Da Nang', 5, 4, 4),
	('3', 'Lanh Nguyen', '1997-02-22', '205220297', 3000 , '0905220297', 'lanhnguyen@codegym.com', 'Da Nang', 4, 3, 3),
	('4', 'Din Luong', '1996-02-17', '205170296', 3000 , '0905170296', 'dinluong@codegym.com', 'Quang Ngai', 3, 3, 3),
	('5', 'Khanh Nguyen', '1994-09-02', '205020994', 2500 , '0905020994', 'khanh@codegym.com', 'Da Nang', 2, 2, 2),
	('6', 'Vu Nguyen', '1997-07-07', '205070797', 1000 , '0905070797', 'vunguyen@codegym.com', 'Ha Tinh', 1, 1, 1);

create table contract (
	id int primary key auto_increment,
    start_date datetime,
    end_date datetime,
    deposit double,
    total_money double,
    
    employee_id int,
    constraint fk_employee foreign key(employee_id) references employee(id) on delete cascade on update cascade,
    
    customer_id varchar(25),
    constraint fk_customer foreign key(customer_id) references customer(id) on delete cascade on update cascade,
    
    service_id varchar(25),
    constraint fk_service foreign key(service_id) references service_furama(id) on delete cascade on update cascade
);

create table contract_detail (
	id int primary key auto_increment,
    quantity int,
    
    contract_id int,
    constraint fk_contract foreign key(contract_id) references contract(id) on delete cascade on update cascade,
    
    attach_service_id int,
    foreign key(attach_service_id) references attach_service(id) on delete cascade on update cascade
);