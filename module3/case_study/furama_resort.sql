create database furama_resort;

use furama_resort;

create table vi_tri (
	id_vi_tri int primary key not null,
    ten_vi_tri varchar(45)
);

create table trinh_do (
	id_trinh_do int primary key not null,
    trinh_do varchar (45)
);

create table bo_phan (
	id_bo_phan int primary key not null,
    ten_bo_phan varchar (45)
);

create table loai_khach (
	id_loai_khach int primary key not null,
    ten_loai_khach varchar (45)
);

create table kieu_thue (
	id_kieu_thue int primary key not null,
    ten_kieu_thue varchar (45),
    gia int
);

create table loai_dich_vu (
	id_loai_dich_vu int primary key not null,
    ten_loai_dich_vu varchar (45)
);

create table dich_vu_di_kem (
	id_dich_vu_di_kem int primary key not null,
    ten_dich_vu_di_kem varchar(45),
    gia int,
    don_vi int,
    trang_thai_kha_dung varchar(45)
);

create table khach_hang (

);

create table dich_vu (

);

create table hop_dong (
	
);

create table hop_dong_chi_tiet (
	id_hop_dong_chi_tiet int primary key not null,
    
);

create table nhan_vien (

);