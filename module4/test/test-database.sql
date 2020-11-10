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
	