use furama_resort;

insert into trinh_do (trinh_do)
values
	('Trung cấp'),
	('Cao đẳng'),
    ('Đại học'),
    ('Sau đại học');
    
insert into vi_tri (ten_vi_tri)
values
	('Lễ tân'),
	('Phục vụ'),
    ('Chuyên viên'),
    ('Giám sát'),
    ('Quản lý'),
    ('Giám đốc');
    
insert into bo_phan (ten_bo_phan)
values
	('Sale – Marketing'),
	('Hành chính'),
    ('Phục vụ'),
    ('Quản lý');
    
insert into loai_khach (ten_loai_khach)
values
	('Diamond'),
	('Platinium'),
    ('Gold'),
    ('Silver'),
    ('Member');
    
insert into kieu_thue (ten_kieu_thue, gia)
values
	('Nguyên ngày', 100),
	('Nguyên tuần', 500),
    ('Nguyên tháng', 1500),
    ('Nguyên quý', 4000),
    ('Nguyên năm', 15000);
    
insert into loai_dich_vu (ten_loai_dich_vu)
values
	('Villa'),
    ('House'),
    ('Room');
    
insert into dich_vu_di_kem (ten_dich_vu_di_kem, gia, don_vi, trang_thai_kha_dung)
values
	('Massage', 100, 'USD', 'con_hang'),
	('Karaoke', 100, 'USD', 'con_hang'),
    ('Thức ăn', 50, 'USD', 'con_hang'),
    ('Nước uống', 30, 'USD', 'con_hang'),
    ('Xe di chuyển', 200, 'USD', 'con_hang');
    
insert into dich_vu (ten_dich_vu, dien_tich, so_tang, so_nguoi_toi_da, chi_phi_thue, id_kieu_thue, id_loai_dich_vu, trang_thai)
values
	('Villa Vip', 100, 3, 10, 1000, 1, 1, 'còn hàng'),
	('Villa Pro', 100, 5, 25, 5000, 2, 1, 'còn hàng'),
	('House Vip', 50, 2, 2, 300, 1, 2, 'còn hàng'),
	('Room Vip', 30, 1, 2, 200, 2, 3, 'còn hàng'),
	('Room thường', 25, 1, 2, 100, 1, 3, 'còn hàng');
    
insert into nhan_vien (id_nhan_vien, ho_ten, id_vi_tri, id_trinh_do, id_bo_phan, ngay_sinh, so_cmnd, luong, dia_chi)
values
	(101, 'An Nguyen Van', 6, 4, 4, '1989-01-01', 205123456, 1000, 'Hải Châu'),
	(102, 'Kieu Nguyen Thi', 5, 3, 4, '1990-02-02', 205123741, 500, 'Quảng Trị'),
	(103, 'Chinh Nguyen Van', 4, 4, 4, '1989-03-03', 205783456, 300, 'Đà Nẵng'),
	(105, 'Thanh Nguyen Van', 4, 4, 4, '1989-05-05', 205154456, 300, 'Quảng Trị'),
	(106, 'Hong Nguyen Thi', 1, 1, 1, '1989-01-01', 205124156, 100, 'Đà Nẵng'),
	(107, 'Gam Nguyen Thi', 1, 1, 1, '1989-01-01', 205127456, 100, 'Đà Nẵng');
    
insert into khach_hang (id_loai_khach, ho_ten, ngay_sinh, dia_chi)
values
	(1, 'Chau Luong Phu', '1995-05-27', 'Đà Nẵng'),
	(1, 'Din Luong Vu Quang', '1996-05-22', 'Quảng Ngãi'),
	(1, 'Khanh Nguyen Quoc', '1994-09-02', 'Nhật Bản'),
	(2, 'Vu Nguyen Duc', '1997-07-27', 'Quảng Trị'),
	(2, 'Lanh Nguyen Quang Nhat', '1997-02-22', 'Đà Nẵng'),
	(1, 'Mai Ho', '1995-05-15', 'Trên mây'),
	(1, 'Mai Ho', '1995-05-15', 'Trên mây');
    
insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc)
values
	(101, 1, 1, '2019-12-12', '2019-12-19'),
	(102, 2, 2, '2018-01-01', '2018-01-15'),
	(103, 3, 2, '2019-01-20', '2019-01-25'),
	(105, 5, 3, '2019-10-01', '2019-10-10'),
	(106, 1, 3, '2018-01-10', '2018-01-15'),
	(106, 4, 4, '2019-11-01', '2019-11-15'),
	(106, 6, 2, '2015-01-01', '2015-01-15');
    
insert into hop_dong_chi_tiet (id_hop_dong, id_dich_vu_di_kem, so_luong)
values
	(1, 1, 1),
	(1, 3, 1),
	(2, 2, 1),
	(3, 3, 1),
	(4, 4, 11),
	(5, 2, 1),
	(6, 4, 1),
	(7, 5, 1);