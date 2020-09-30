drop database if exists demo;
CREATE DATABASE demo;
USE demo;

create table users (
 id int NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','Kenia');

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.`name`, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

  

DELIMITER $$
CREATE PROCEDURE insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

create table Permision(
id int primary key auto_increment,
`name` varchar(50)
);

 

create table User_Permision(
permision_id int,
user_id int
);

insert into Permision(`name`) values('add');
insert into Permision(`name`) values('edit');
insert into Permision(`name`) values('delete');
insert into Permision(`name`) values('view');

-- Tạo store procedure lấy tất cả thông tin của tất cả các user trong bảng users :
DELIMITER //
CREATE PROCEDURE find_all_user()
BEGIN
	SELECT * FROM users;
END //
DELIMITER ;

-- call find_all_user();



-- Tạo store procedure sửa thông tin user theo id :
DELIMITER //
CREATE PROCEDURE update_user(id_need_update int, name_need_update varchar(120), email_need_update varchar(220), country_need_update varchar(120))
BEGIN
	update users
    set `name` = name_need_update, email = email_need_update, country = country_need_update
    where id = id_need_update;
END //
DELIMITER ;

-- call update_user(6, 'ms666', 'ok', 666, 666, 'ok', 'ok');



-- Tạo store procedure xoá sản phẩm theo id :
DELIMITER //
CREATE PROCEDURE delete_user(id_need_delete int)
BEGIN
	delete from users
    where id = id_need_delete;
END //
DELIMITER ;

-- call delete_product(6);