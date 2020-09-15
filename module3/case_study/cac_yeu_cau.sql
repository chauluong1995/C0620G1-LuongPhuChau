use furama_resort;

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự :
select *
from nhan_vien;

select *
from nhan_vien
where ho_ten
regexp '^[HKT].+$' and length(ho_ten) <= 15;  -- Tìm tên theo kiểu tên trước họ sau !
-- ^([a-zA-Z]+[ ])+[H,T,C][a-zA-Z]+$ : Tìm tên viết theo kiểu họ trước tên sau !

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị” :
select *
from khach_hang;

select *
from khach_hang
where ngay_sinh < '2002-01-01' and ngay_sinh > '1969-12-31' and (dia_chi = 'Đà Nẵng' or dia_chi = 'Quảng Trị');