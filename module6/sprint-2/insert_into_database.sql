# Role
INSERT INTO project2_parking_management.app_role (id, role_name) VALUES (1, 'Admin');
INSERT INTO project2_parking_management.app_role (id, role_name) VALUES (2, 'Employee');
INSERT INTO project2_parking_management.app_role (id, role_name) VALUES (3, 'Customer');
# Car type
INSERT INTO project2_parking_management.car_type (id, car_type_name) VALUES (1, '4 chỗ');
INSERT INTO project2_parking_management.car_type (id, car_type_name) VALUES (2, '7 chỗ');
INSERT INTO project2_parking_management.car_type (id, car_type_name) VALUES (3, '9 chỗ');
INSERT INTO project2_parking_management.car_type (id, car_type_name) VALUES (4, 'Bán tải');
INSERT INTO project2_parking_management.car_type (id, car_type_name) VALUES (5, 'Tải 500kg');
INSERT INTO project2_parking_management.car_type (id, car_type_name) VALUES (6, 'Khác');
# Member card type
INSERT INTO project2_parking_management.member_card_type (id, member_type_name) VALUES (1, 'Tuần');
INSERT INTO project2_parking_management.member_card_type (id, member_type_name) VALUES (2, 'Tháng');
INSERT INTO project2_parking_management.member_card_type (id, member_type_name) VALUES (3, 'Năm');
# Slot type
INSERT INTO project2_parking_management.slot_type (id, height, slot_name, width) VALUES (1, 1900, 'S', 4950);
INSERT INTO project2_parking_management.slot_type (id, height, slot_name, width) VALUES (2, 1850, 'M', 5350);
INSERT INTO project2_parking_management.slot_type (id, height, slot_name, width) VALUES (3, 2000, 'L', 5500);
# Customer
INSERT INTO project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) VALUES (1, 'Đà Nẵng', '2020-12-15', '2020-12-29 16:27:18', 'KH-5555', 'hoquynhmai1505@gmail.com', 'Hồ Quỳnh Mai', true, '205555555', null, '', null);
INSERT INTO project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) VALUES (2, 'Quảng Nam', '2020-12-17', '2020-12-29 16:27:43', 'KH-7777', 'supea52795@gmail.com', 'SuPea Jr', true, '205777777', null, null, null);
INSERT INTO project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) VALUES (3, 'Sài Gòn', '2020-12-01', '2020-12-29 16:27:44', 'KH-9999', 'sankyo222@gmail.com', 'Nguyễn Nhật Lành', true, '205999999', null, null, null);
# Car
INSERT INTO project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) VALUES (1, 'Lykan Hypersport', null, '43A1-51595', null, 1);
INSERT INTO project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) VALUES (2, 'Lamborghini', null, '43A1-56789', null, 2);
INSERT INTO project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) VALUES (3, 'Mercedes Benz', null, '43A1-02222', null, 3);
INSERT INTO project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) VALUES (4, 'Bugatti', null, '43A1-52795', null, 2);
# MemberCard
INSERT INTO project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) VALUES (3, '2021-01-02 17:30:00', 9000000, '2020-12-22 17:30:00', 3, 3);
INSERT INTO project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) VALUES (2, '2021-01-02 17:30:00', 7000000, '2020-12-21 17:30:00', 2, 2);
INSERT INTO project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) VALUES (1, '2021-01-02 17:30:00', 5000000, '2020-12-20 17:30:00', 1, 1);
INSERT INTO project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) VALUES (4, '2021-01-02 17:30:00', 7000000, '2020-12-21 17:30:00', 4, 2);
