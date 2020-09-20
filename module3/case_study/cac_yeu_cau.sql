use furama_resort;



-- Task 2. Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự :
select *
from nhan_vien;

select *
from nhan_vien
where ho_ten
regexp '^[HKT]{1}(.)*$' and length(ho_ten) <= 15;  -- Tìm tên theo kiểu tên trước họ sau !
-- '^([a-zA-Z]+[ ])+[H,K,T][a-zA-Z]+$' : Tìm tên viết theo kiểu họ trước tên sau !
-- '(H|K|T)[:alpha:]*$' : Tìm tên tiếng Việt viết theo kiểu họ trước tên sau !



-- Task 3. Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị” :
select *
from khach_hang;

select *
from khach_hang
where (year(now()) - year(ngay_sinh) between 18 and 50) and (dia_chi in ('Đà Nẵng','Quảng Trị'));



-- Task 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
--         Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select count(hd.id_khach_hang) as 'so_lan_dat_phong', kh.ho_ten, l.ten_loai_khach
from hop_dong hd
	right join khach_hang kh on hd.id_khach_hang = kh.id_khach_hang
	inner join loai_khach l on l.id_loai_khach = kh.id_loai_khach
where l.ten_loai_khach = 'Diamond'
group by kh.id_khach_hang
order by count(hd.id_khach_hang);



-- Task 5. Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
--         (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong * Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
--         cho tất cả các Khách hàng đã từng đặt phòng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra) :
create view thong_ke as
select sum(dv.chi_phi_thue + hdct.so_luong * dvdk.gia) as 'tong_tien', kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.id_hop_dong, hdct.id_dich_vu_di_kem, hdct.so_luong,
	   dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc
from khach_hang kh
	left join hop_dong hd on hd.id_khach_hang = kh.id_khach_hang
	left join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
	left join dich_vu dv on hd.id_dich_vu = dv.id_dich_vu
	left join hop_dong_chi_tiet hdct on hdct.id_hop_dong = hd.id_hop_dong
	left join dich_vu_di_kem dvdk on hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
group by kh.id_khach_hang
order by sum(dv.chi_phi_thue + hdct.so_luong * dvdk.gia);



-- Task 6. Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt trong quý 1
--         của năm 2019 (Quý 1 là tháng 1, 2, 3) :
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
	left join hop_dong hd using(id_dich_vu)
	left join loai_dich_vu ldv using(id_loai_dich_vu)
where dv.ten_dich_vu not in (
	select dv.ten_dich_vu
    from dich_vu dv
		left join hop_dong hd using(id_dich_vu)
	where hd.ngay_lam_hop_dong > '2019-01-01' and hd.ngay_lam_hop_dong < '2019-03-31' and dv.ten_dich_vu is not null
)
group by dv.ten_dich_vu;



-- Task 7. Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng 
--         trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng trong năm 2019 :
select dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
from dich_vu dv
	left join hop_dong hd using(id_dich_vu)
	left join loai_dich_vu ldv using(id_loai_dich_vu)
where hd.ngay_lam_hop_dong > '2017-12-31' and hd.ngay_lam_hop_dong < '2019-01-01'
and dv.ten_dich_vu not in (
	select dv.ten_dich_vu
    from dich_vu dv
		left join hop_dong hd using(id_dich_vu)
	where hd.ngay_lam_hop_dong > '2018-12-31' and hd.ngay_lam_hop_dong < '2020-01-01' and dv.ten_dich_vu is not null
)
group by dv.ten_dich_vu;



-- Task 8. Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
--         Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên :

-- Cách 1 :
select distinct kh.ho_ten
from khach_hang kh;

-- Cách 2 :
select kh.ho_ten
from khach_hang kh
group by kh.ho_ten;

-- Cách 3 :
select kh.ho_ten
from khach_hang kh
union
select kh.ho_ten
from khach_hang kh;



-- Task 9. Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng :
-- Cách 1 :
select month(hd.ngay_lam_hop_dong) as 'thang', count(kh.id_khach_hang) as 'so_lan_dat_phong'
from hop_dong hd
	join khach_hang kh using(id_khach_hang)
where year(hd.ngay_lam_hop_dong) = '2019'
group by month(hd.ngay_lam_hop_dong)
order by month(hd.ngay_lam_hop_dong);

-- Cách 2 :
select tong_doanh_thu.thang, count(hd.id_khach_hang) as so_lan_dat_phong
from (
	select '01' as 'thang'
	union
	select '02'
	union
	select '03'
	union
	select '04'
	union
	select '05'
	union
	select '06'
	union
	select '07'
	union
	select '08'
	union
	select '09'
	union
	select '10'
	union
	select '11'
	union
	select '12'
) as tong_doanh_thu
left join hop_dong hd on month(hd.ngay_lam_hop_dong) = tong_doanh_thu.thang and year(hd.ngay_lam_hop_dong) = '2019'
group by tong_doanh_thu.thang;



-- Task 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, 
--          TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet) :
select hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, count(hdct.id_hop_dong_chi_tiet) as 'so_luong_dich_vu_di_kem'
from hop_dong hd
	left join hop_dong_chi_tiet hdct using(id_hop_dong)
    left join dich_vu_di_kem dvdk using(id_dich_vu_di_kem)
group by hd.id_hop_dong;



-- Task 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi” :
select dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi, dvdk.trang_thai_kha_dung, kh.ho_ten, kh.dia_chi
from dich_vu_di_kem dvdk
	left join hop_dong_chi_tiet hdct using(id_dich_vu_di_kem)
    left join hop_dong hd using(id_hop_dong)
    left join khach_hang kh using(id_khach_hang)
    left join loai_khach lk using(id_loai_khach)
where lk.ten_loai_khach = 'Diamond' and kh.dia_chi in ('Vinh', 'Quảng Ngãi')
group by dvdk.ten_dich_vu_di_kem;



-- Task 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), 
--          TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019 :
select hd.id_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, hd.tien_dat_coc, count(hdct.id_hop_dong_chi_tiet) as 'so_luong'
from hop_dong hd
	left join hop_dong_chi_tiet hdct using(id_hop_dong)
    left join nhan_vien nv using(id_nhan_vien)
    left join khach_hang kh using(id_khach_hang)
    left join dich_vu dv using(id_dich_vu)
where hd.ngay_lam_hop_dong > '2019-09-30' and hd.ngay_lam_hop_dong < '2020-01-01'
and dv.ten_dich_vu not in (
	select dv.ten_dich_vu
    from dich_vu dv
		left join hop_dong hd using(id_dich_vu)
	where hd.ngay_lam_hop_dong > '2018-12-31' and hd.ngay_lam_hop_dong < '2019-07-01' and dv.ten_dich_vu is not null
)
group by hd.id_hop_dong;



-- Task 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau) :
create view thong_tin as
select dvdk.id_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem, dvdk.gia, dvdk.don_vi, dvdk.trang_thai_kha_dung, count(hdct.id_dich_vu_di_kem) as 'so_lan_su_dung'
from dich_vu_di_kem dvdk
	left join hop_dong_chi_tiet hdct using(id_dich_vu_di_kem)
group by dvdk.id_dich_vu_di_kem;

select *
from thong_tin
where so_lan_su_dung in (
	select max(so_lan_su_dung)
    from thong_tin
    where so_lan_su_dung is not null
);

drop view if exists thong_tin;



-- Task 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem,
--          SoLanSuDung :
select hd.id_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, count(hdct.id_dich_vu_di_kem) as 'so_lan_su_dung'
from hop_dong hd
	join hop_dong_chi_tiet hdct using(id_hop_dong)
    join dich_vu_di_kem dvdk using(id_dich_vu_di_kem)
    join dich_vu dv using(id_dich_vu)
    join loai_dich_vu ldv using(id_loai_dich_vu)
group by dvdk.id_dich_vu_di_kem
having count(hdct.id_dich_vu_di_kem) = 1;



-- Task 15.	Hiển thị thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019 :
select nv.id_nhan_vien, nv.ho_ten, td.trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi, count(hd.id_nhan_vien) as so_luong_hop_dong
from nhan_vien nv
	left join hop_dong hd using(id_nhan_vien)
    left join trinh_do td using(id_trinh_do)
    left join bo_phan bp using(id_bo_phan)
where nv.id_nhan_vien not in (
	select nv.id_nhan_vien
    from nhan_vien nv
		left join hop_dong hd using(id_nhan_vien)
    where year(hd.ngay_lam_hop_dong) = 2018 and hd.id_nhan_vien is not null
    group by hd.id_nhan_vien
    having count(hd.id_nhan_vien) > 3
)
group by nv.id_nhan_vien
order by nv.id_nhan_vien;



-- Task 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019 :
delete from nhan_vien
where nhan_vien.id_nhan_vien not in (
	select danh_sach.id_nhan_vien
    from (
		select nv.id_nhan_vien
        from nhan_vien nv
			left join hop_dong hd using(id_nhan_vien)
		where year(hd.ngay_lam_hop_dong) in ('2017', '2018', '2019')
        group by nv.id_nhan_vien
    ) as danh_sach
);



-- Task 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán 
--          trong năm 2019 là lớn hơn 10.000.000 VNĐ :
-- Dùng task 5 create view thong_ke :
update khach_hang
set khach_hang.id_loai_khach = 1
where khach_hang.id_khach_hang in (
	select tk.id_khach_hang
    from thong_ke tk
    where tk.ten_loai_khach = 'Platinium' and tk.tong_tien > (10000000 / 25000)
);
drop view if exists thong_ke;



-- Task 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng) :
alter table hop_dong
drop foreign key fk_khach_hang;
 
alter table hop_dong
add constraint fk_khach_hang foreign key(id_khach_hang) references khach_hang(id_khach_hang) on delete cascade
on update cascade;
 
alter table hop_dong_chi_tiet
drop foreign key fk_hop_dong;
 
alter table hop_dong_chi_tiet
add constraint fk_hop_dong foreign key(id_hop_dong) references hop_dong(id_hop_dong) on delete cascade
on update cascade;

delete from khach_hang
where id_khach_hang in (
	select bang_tam.id_khach_hang
	from (
		select kh.id_khach_hang
		from khach_hang kh
			inner join hop_dong hd using(id_khach_hang)
		where year(hd.ngay_lam_hop_dong) < '2016'
	) as bang_tam
);



-- Task 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi :
update dich_vu_di_kem
set gia = gia * 2
where id_dich_vu_di_kem in (
	select id_dich_vu_di_kem
    from thong_ke tk
    group by tk.id_dich_vu_di_kem
    having sum(tk.so_luong) > 10
);
drop view if exists thong_ke;



-- Task 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, 
--          SoDienThoai, NgaySinh, DiaChi :
select nv.id_nhan_vien as id, nv.ho_ten, nv.email, nv.so_dien_thoai, nv.ngay_sinh, nv.dia_chi
from nhan_vien nv
union all
select kh.id_khach_hang, kh.ho_ten, kh.email, kh.so_dien_thoai, kh.ngay_sinh, kh.dia_chi
from khach_hang kh;



-- Task 21. Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều 
--     Khách hàng bất kỳ với ngày lập hợp đồng là “12/12/2019” :
drop view if exists V_NHANVIEN;

create view V_NHANVIEN as
select nv.id_nhan_vien, nv.ho_ten, nv.ngay_sinh, nv.dia_chi, hd.ngay_lam_hop_dong
from nhan_vien nv
	join hop_dong hd using(id_nhan_vien)
where nv.dia_chi = 'Hải Châu' and hd.ngay_lam_hop_dong = '2019-12-12';

select * from V_NHANVIEN;



-- Task 22. Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này :
update V_NHANVIEN
set dia_chi = 'Liên Chiểu';

drop view if exists V_NHANVIEN;



-- Task 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1 :
drop procedure if exists Sp_1;
DELIMITER //
CREATE PROCEDURE Sp_1(id_need_delete int)
BEGIN
	delete from khach_hang
    where id_khach_hang = id_need_delete;
END //
DELIMITER ;

call Sp_1(7);



-- Task 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc
--          không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan :
drop procedure if exists Sp_2;
DELIMITER //
CREATE PROCEDURE Sp_2(id_nhan_vien_add int, id_khach_hang_add int, id_dich_vu_add int, ngay_lam_hop_dong_moi date, ngay_ket_thuc_moi date)
BEGIN
	insert into hop_dong (id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc)
    value (id_nhan_vien_add, id_khach_hang_add, id_dich_vu_add, ngay_lam_hop_dong_moi, ngay_ket_thuc_moi);
END //
DELIMITER ;

call Sp_2(101, 1, 1, '2020-09-20', '2020-09-25');
drop procedure if exists Sp_2;



-- Task 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database :
drop trigger if exists Tr_1;
delimiter //
create trigger Tr_1
after delete
on hop_dong for each row
begin
	
end; //
delimiter ;



-- Task 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: 
--          Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ
--          thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database :
drop trigger if exists Tr_2;
delimiter //
create trigger Tr_2
after update
on hop_dong for each row
begin
	
end; //
delimiter ;



-- Task 27.	Tạo user function thực hiện yêu cầu sau:
--          a. Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
--          b. Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện
--             thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng).
--             Mã của Khách hàng được truyền vào như là 1 tham số của function này :




-- Task 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin
--          của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong)
--          và những bản liên quan khác :
