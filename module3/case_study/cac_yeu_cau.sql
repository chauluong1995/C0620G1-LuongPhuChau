use furama_resort;

-- 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự :
select *
from nhan_vien;

select *
from nhan_vien
where ho_ten
regexp '^[HKT]{1}(.)*$' and length(ho_ten) <= 15;  -- Tìm tên theo kiểu tên trước họ sau !
-- '^([a-zA-Z]+[ ])+[H,T,K][a-zA-Z]+$' : Tìm tên viết theo kiểu họ trước tên sau !
-- '(H|K|T)[:alpha:]*$' : Tìm tên tiếng Việt viết theo kiểu họ trước tên sau !

-- 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị” :
select *
from khach_hang;

select *
from khach_hang
where (year(now()) - year(ngay_sinh) between 18 and 50) and (dia_chi in ('Đà Nẵng','Quảng Trị'));

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
--      Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select count(hd.id_khach_hang) as 'so_lan_dat_phong',kh.ho_ten,l.ten_loai_khach
from hop_dong hd
right join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
inner join loai_khach l on l.id_loai_khach = kh.id_loai_khach
group by kh.id_khach_hang
having l.ten_loai_khach = 'Diamond'
order by count(hd.id_khach_hang);

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
--      (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong * Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
--      cho tất cả các Khách hàng đã từng đặt phòng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra) :
