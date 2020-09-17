drop database if exists demo;
create database demo;
use demo;



-- Tạo bảng Products :
create table product (
	id int primary key not null,
    product_code varchar(50),
    product_name varchar(50),
	product_price int,
	product_amount int,
	product_description varchar(50),
	product_status varchar(50)
);



-- Chèn dữ liệu cho bảng Products :
insert into product
values
	(1, 'ms001', 'ao thun', 100, 10, 'nice', 'con hang'),
	(2, 'ms002', 'quan dai', 200, 10, 'nice', 'con hang'),
	(3, 'ms003', 'ao so mi', 150, 11, 'nice', 'con hang'),
	(4, 'ms004', 'ao dai', 300, 10, 'nice', 'con hang'),
	(5, 'ms005', 'quan jeans', 300, 15, 'nice', 'con hang');
    
    
    
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục) :
alter table product
add unique index idx_product_code(product_code);



-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice) :
alter table product
add index idx_product_name_and_price(product_name, product_price);

EXPLAIN SELECT *
FROM product
where product_code = 200;



-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products :
create view product_view as
select product_code, product_name, product_price, product_status
from product;



-- Xem product_view :
select * from product_view;



-- Sửa đổi product_view :
create or replace view product_view as
select * from product;



-- Xóa product_view :
drop view product_view;



-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product :
DELIMITER //
CREATE PROCEDURE find_all_product()
BEGIN
	SELECT * FROM product;
END //
DELIMITER ;

call find_all_product();



-- Tạo store procedure thêm một sản phẩm mới :
DELIMITER //
CREATE PROCEDURE add_product(id int, product_code varchar(50), product_name varchar(50), product_price int, product_amount int, 
							 product_description varchar(50), product_status varchar(50))
BEGIN
	insert into product
    value (id, product_code, product_name, product_price, product_amount, product_description, product_status);
END //
DELIMITER ;

call add_product(6, 'ms006', 'ao jeans', 250, 10, 'nice', 'con hang');



-- Tạo store procedure sửa thông tin sản phẩm theo id :
DELIMITER //
CREATE PROCEDURE update_product(id_need_update int, product_code_update varchar(50), product_name_update varchar(50), product_price_update int, product_amount_update int, 
							 product_description_update varchar(50), product_status_update varchar(50))
BEGIN
	update product
    set product_code = product_code_update, product_name = product_name_update, product_price = product_price_update, product_amount = product_amount_update,
		product_description = product_description_update, product_status = product_status_update
    where id = id_need_update;
END //
DELIMITER ;

call update_product(6, 'ms666', 'ok', 666, 666, 'ok', 'ok');



-- Tạo store procedure xoá sản phẩm theo id :
DELIMITER //
CREATE PROCEDURE delete_product(id_need_delete int)
BEGIN
	delete from product
    where id = id_need_delete;
END //
DELIMITER ;

call delete_product(6);