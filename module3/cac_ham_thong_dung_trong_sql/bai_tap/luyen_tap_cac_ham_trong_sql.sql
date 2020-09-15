drop database cac_ham_thong_dung;
create database cac_ham_thong_dung;
use cac_ham_thong_dung;

create table hoc_vien (
	id int primary key auto_increment,
    ten varchar (25),
    tuoi int,
    khoa_hoc varchar (55),
    so_tien int
);

insert into hoc_vien
values (
	'Hoang', 21, 'CNTT', 400000,
	'Viet', 19, 'DTVT', 320000,
	'Thanh', 18, 'KTDN', 400000,
	'Nhan', 19, 'CK', 450000,
	'Huong', 20, 'TCNH', 500000,
	'Huong', 20, 'TCNH', 200000
);