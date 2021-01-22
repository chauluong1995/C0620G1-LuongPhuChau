# Role
insert into project2_parking_management.app_role (id, role_name) values (1, 'Admin');
insert into project2_parking_management.app_role (id, role_name) values (2, 'Employee');
insert into project2_parking_management.app_role (id, role_name) values (3, 'Customer');
# Slot Type
insert into project2_parking_management.slot_type (id, height, slot_name, width) values (1, 1900, 'S', 4950);
insert into project2_parking_management.slot_type (id, height, slot_name, width) values (2, 1850, 'M', 5350);
insert into project2_parking_management.slot_type (id, height, slot_name, width) values (3, 2000, 'L', 5500);
# Member Card Type
insert into project2_parking_management.member_card_type (id, member_type_name) values (1, 'Tuần');
insert into project2_parking_management.member_card_type (id, member_type_name) values (2, 'Tháng');
insert into project2_parking_management.member_card_type (id, member_type_name) values (3, 'Năm');
# Car Type
insert into project2_parking_management.car_type (id, car_type_name) values (1, '4 chỗ');
insert into project2_parking_management.car_type (id, car_type_name) values (2, '7 chỗ');
insert into project2_parking_management.car_type (id, car_type_name) values (3, '9 chỗ');
insert into project2_parking_management.car_type (id, car_type_name) values (4, 'Bán tải');
insert into project2_parking_management.car_type (id, car_type_name) values (5, 'Tải 500kg');
insert into project2_parking_management.car_type (id, car_type_name) values (6, 'Khác');
# Account
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (1, true, 'Aqwerty1', 'c0620g1@gmail.com', 'fiptbxUB', 1);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (2, true, 'Aqwerty1', 'vinhblue97@gmail.com', 'EtmhzYKj', 1);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (3, true, 'Aqwerty1', 'Nguyễn Quang Danh', 'lTXflNqy', 1);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (4, true, 'Aqwerty1', 'hoquynhmai1505@gmail.com', 'fItadAJo', 1);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (5, true, 'Aqwerty1', 'nguyentrandat9999@gmail.com', 'VgBdjVbc', 1);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (6, true, 'Aqwerty1', 'nguyenhongnhat71298@gmail.com', 'DyVHQsWD', 1);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (7, true, 'Aqwerty1', 'pkhanh2994@gmail.com', 'yuvIuzgB', 2);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (8, true, 'Aqwerty1', 'luongvuquangdin@gmail.com', 'ZyTPGTrQ', 2);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (9, true, 'Aqwerty1', 'Ngantrandn15@gmail.com', 'DFaDQIPo', 2);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (10, true, 'Aqwerty1', 'vanhoat1631997@gmail.com', 'BvsHeCpg', 2);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (11, true, 'Aqwerty1', 'quocnguyen1405@gmail.com', 'haUMONHe', 2);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (12, true, 'Aqwerty1', 'khanh06111993@gmail.com', 'YaEsArdP', 2);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (13, true, 'Aqwerty1', 'thhg17399@gmail.com', 'zBChdNSH', 3);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (14, true, 'Aqwerty1', 'ericnguyen6166@gmail.com', 'KLqMJPso', 3);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (15, true, 'Aqwerty1', 'supea52795@gmail.com', 'oEMVwvmV', 3);
insert into project2_parking_management.app_account (id, enabled, password, username, verification_code, app_role_id) values (16, true, 'Aqwerty1', 'nhatlanh2202@gmail.com', 'xdixVwDX', 3);
# Customer
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (1, 'Sài Gòn', '1992-07-20', '2020-12-30 00:00:00', 'KH-0001', 'c0620g1@gmail.com', 'Hoàng Minh Quân', true, 111111111, null, 0901234567, 1);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (2, 'Quảng Trị', '1997-01-16', '2020-12-31 00:00:00', 'KH-0002', 'vinhblue97@gmail.com', 'Mai Thế Vinh', true, 222222222, null, 0902345678, 2);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (3, 'Đà Nẵng', '1994-06-15', '2021-07-12 00:00:00', 'KH-0003', 'Nguyễn Quang Danh', 'Nguyễn Quang Danh', true, 333333333, null, 0903456789, 3);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (4, 'Đà Nẵng', '1995-06-15', '2021-09-26 00:00:00', 'KH-0004', 'hoquynhmai1505@gmail.com', 'Hồ Thị Quỳnh Mai', false, 444444444, null, 0912345678, 4);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (5, 'Quảng Nam', '2021-01-21', '2021-01-01 00:00:00', 'KH-0005', 'nguyentrandat9999@gmail.com', 'Nguyễn Trần Đạt', true, 555555555, null, 0923456789, 5);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (6, 'Đà Nẵng', '1998-02-12', '2021-01-01 00:00:00', 'KH-0006', 'nguyenhongnhat71298@gmail.com', 'Nguyễn Hồng Nhật', true, 666666666, null, 0934567890, 6);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (7, 'Đà Nẵng', '1994-03-17', '2020-02-03 00:00:00', 'KH-0007', 'pkhanh2994@gmail.com', 'Nguyễn Quốc Khánh', true, 777777777, null, 0941235678, 7);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (8, 'Quảng Nam', '1995-04-13', '2020-04-03 00:00:00', 'KH-0008', 'luongvuquangdin@gmail.com', 'Lương Vũ Quang Đin', true, 888888888, null, 0951231231, 8);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (9, 'Đà Nẵng', '1991-05-16', '2020-04-03 00:00:00', 'KH-0009', 'Ngantrandn15@gmail.com', 'Trần Huỳnh Kim Ngân', false, 999999999, null, 0981237123, 9);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (10, 'Quảng Nam', '2021-01-15', '2020-02-03 00:00:00', 'KH-0010', 'vanhoat1631997@gmail.com', 'Lê Văn Hoạt', true, 123124235, null, 0912385722, 10);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (11, 'Quảng Nam', '1991-08-22', '2020-02-20 20:20:00', 'KH-0011', 'quocnguyen1405@gmail.com', 'Nguyễn Tiến Quốc', true, 234523523, null, 0987567367, 11);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (12, 'Quảng Trị', '1993-10-15', '2021-01-01 00:00:00', 'KH-0012', 'khanh06111993@gmail.com', 'Phan Quốc Khánh', true, 562124631, null, 0975271342, 12);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (13, 'Đà Nẵng', '2021-01-20', '2020-02-03 00:00:00', 'KH-0013', 'thhg17399@gmail.com', 'Trần Thanh Hoàng', true, 123634134, null, 0991232111, 13);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (14, 'Hải Phòng', '1993-12-16', '2020-04-03 00:00:00', 'KH-0014', 'ericnguyen6166@gmail.com', 'Nguyễn Hải Đăng', true, 723452342, null, 0923857188, 14);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (15, 'Đà Nẵng', '1995-11-30', '2020-04-03 00:00:00', 'KH-0015', 'supea52795@gmail.com', 'Lương Phú Châu', true, 123512221, null, 0984584881, 15);
insert into project2_parking_management.customer (id, address, birthday, create_date, customer_code, email, full_name, gender, identity_number, image_avatar, phone, app_account_id) values (16, 'Đà Nẵng', '1997-10-16', '2020-02-03 00:00:00', 'KH-0016', 'nhatlanh2202@gmail.com', 'Nguyễn Quang Nhật Lành', true, 823412111, null, 0912311233, 16);
# Car
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (1, 'Honda', null, 'PP587A0', 1, 1);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (2, 'Honda', null, 'RK755AJ', 1, 2);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (3, 'Honda', null, 'SI819AK', 1, 3);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (4, 'Honda', null, 'RK115AN', 1, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (5, 'Honda', null, 'TS260AK', 1, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (6, 'Vinfast', null, 'RK099AN', 1, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (7, 'Vinfast', null, 'RK828AG', 1, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (8, 'Vinfast', null, 'LM298AI', 1, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (9, 'Vinfast', null, '1T43213', 1, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (10, 'Vinfast', null, '22U-14599', 1, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (11, 'Toyota', null, '76K-03759', 2, 2);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (12, 'Toyota', null, '91G-09156', 2, 3);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (13, 'Toyota', null, '92B-78642', 2, 4);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (14, 'Toyota', null, '44A-4444', 2, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (15, 'Toyota', null, '11I-1111', 2, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (16, 'Mercedes', null, '99R-9999', 2, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (17, 'Mercedes', null, '22Z-2222', 2, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (18, 'Mercedes', null, 33E-3333, 2, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (19, 'Mercedes', null, '66G-6666', 2, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (20, 'Mercedes', null, '88B-8888', 2, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (21, 'Ferrari', null, '72N-22002', 3, 3);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (22, 'Ferrari', null, '28O-75719', 3, 4);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (23, 'Ferrari', null, 'KHANH-2K', 3, 5);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (24, 'Ferrari', null, '43F-1232', 3, 6);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (25, 'Ferrari', null, '43S-8888', 3, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (26, 'Tesla', null, '55S-55555', 3, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (27, 'Tesla', null, 'T9QZ9QYN', 3, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (28, 'Tesla', null, '3ACV6VMI', 3, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (29, 'Tesla', null, 'D9K9EVPU', 3, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (30, 'Tesla', null, 'UTFNRSCX', 3, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (31, 'Hyundai', null, 'WY900ZHE', 4, 5);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (32, 'Hyundai', null, 'QTK2YUWQ', 4, 6);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (33, 'Hyundai', null, 'NTKKDGI4', 4, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (35, 'Hyundai', null, '27IJ14PX', 4, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (36, 'Mazda', null, 'RRKKV376', 4, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (37, 'Mazda', null, 'HJ14PP6N', 4, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (38, 'Mazda', null, 'SV8HU8GK', 4, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (39, 'Mazda', null, 'FK5G8DHS', 4, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (40, 'Mazda', null, 'ER7USYXC', 4, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (41, 'Lamborghini', null, 'QPZZXV88', 5, 1);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (42, 'Lamborghini', null, 'YG9LIKKM', 5, 1);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (43, 'Lamborghini', null, '43A55555', 5, 15);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (44, 'Lamborghini', null, '43A52795', 5, 15);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (45, 'Lamborghini', null, '43A51595', 5, 15);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (46, 'Porsche', null, 'TGP6JVOE', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (47, 'Porsche', null, 'DSFXGSUX', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (48, 'Porsche', null, '3N6W6OZZ', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (49, 'Porsche', null, 'QQ0H4TKX', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (50, 'Porsche', null, 'Q3JITMKX', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (51, 'Ford', null, 'QY8RC8B7', 6, 1);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (52, 'Ford', null, 'P2MCSSA7', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (53, 'Ford', null, 'NX0NJMWO', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (54, 'Ford', null, 'R3J5CWDH', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (55, 'Ford', null, 'KUFZZH71', 6, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (56, 'BMW
', null, 'R83ZZTDS', 5, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (57, 'BMW
', null, 'V1WQJQKQ', 6, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (58, 'BMW
', null, 'PWOIX3BH', 6, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (59, 'BMW
', null, 'XZOU24EO', 6, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (60, 'BMW
', null, 'P7D74UBA', 6, null);
insert into project2_parking_management.car (id, brand_name, image_plate_number, plate_number, car_type_id, customer_id) values (61, 'BMW', null, 'XEHETHAN', 1, 1);
# Parking Slot
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (1, 1, false, 1, true, 4, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (2, 1, false, 2, true, 5, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (3, 1, false, 3, true, 6, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (4, 1, false, 4, true, 7, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (5, 1, false, 5, true, 8, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (6, 1, false, 6, true, 9, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (7, 1, false, 7, true, 10, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (8, 1, false, 8, true, 14, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (9, 1, false, 9, true, 15, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (10, 1, false, 10, true, 16, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (11, 1, false, 11, true, 17, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (12, 1, false, 12, true, 18, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (13, 1, false, 13, true, 19, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (14, 1, false, 14, true, 20, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (15, 1, false, 15, true, 61, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (16, 1, false, 16, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (17, 1, false, 17, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (18, 1, false, 18, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (19, 1, false, 19, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (20, 1, false, 20, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (21, 1, false, 21, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (22, 1, false, 22, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (23, 1, false, 23, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (24, 1, false, 24, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (25, 1, false, 25, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (26, 1, false, 26, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (27, 1, false, 27, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (28, 1, false, 28, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (29, 1, false, 29, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (30, 1, false, 30, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (31, 1, true, 31, false, 1, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (32, 1, true, 32, true, 2, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (33, 1, true, 33, false, 3, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (34, 1, false, 34, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (35, 1, false, 35, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (36, 1, false, 36, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (37, 1, false, 37, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (38, 1, false, 38, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (39, 1, false, 39, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (40, 1, false, 40, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (41, 1, false, 41, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (42, 1, false, 42, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (43, 1, false, 43, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (44, 1, false, 44, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (45, 1, false, 45, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (46, 1, false, 46, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (47, 1, false, 47, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (48, 1, false, 48, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (49, 1, false, 49, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (50, 1, false, 50, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (51, 2, false, 1, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (52, 2, false, 2, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (53, 2, false, 3, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (54, 2, false, 4, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (55, 2, false, 5, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (56, 2, false, 6, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (57, 2, false, 7, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (58, 2, false, 8, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (59, 2, false, 9, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (60, 2, false, 10, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (61, 2, false, 11, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (62, 2, false, 12, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (63, 2, false, 13, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (64, 2, false, 14, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (65, 2, false, 15, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (66, 2, false, 16, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (67, 2, false, 17, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (68, 2, false, 18, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (69, 2, false, 19, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (70, 2, false, 20, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (71, 2, false, 21, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (72, 2, false, 22, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (73, 2, false, 23, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (74, 2, false, 24, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (75, 2, false, 25, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (76, 2, false, 26, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (77, 2, false, 27, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (78, 2, false, 28, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (79, 2, false, 29, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (80, 2, false, 30, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (81, 2, false, 31, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (82, 2, false, 32, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (83, 2, false, 33, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (84, 2, false, 34, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (85, 2, false, 35, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (86, 2, false, 36, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (87, 2, false, 37, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (88, 2, false, 38, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (89, 2, false, 39, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (90, 2, false, 40, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (91, 2, false, 41, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (92, 2, false, 42, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (93, 2, false, 43, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (94, 2, false, 44, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (95, 2, false, 45, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (96, 2, false, 46, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (97, 2, false, 47, false, null, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (98, 2, true, 48, false, 11, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (99, 2, true, 49, false, 12, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (100, 2, true, 50, false, 13, 1);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (101, 3, false, 1, true, 25, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (102, 3, false, 2, true, 26, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (103, 3, false, 3, true, 27, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (104, 3, false, 4, true, 28, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (105, 3, false, 5, true, 29, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (106, 3, false, 6, true, 30, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (107, 3, false, 7, true, 33, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (108, 3, false, 8, true, 35, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (109, 3, false, 9, true, 36, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (110, 3, false, 10, true, 37, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (111, 3, false, 11, true, 38, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (112, 3, false, 12, true, 39, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (113, 3, false, 13, true, 40, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (114, 3, false, 14, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (115, 3, false, 15, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (116, 3, false, 16, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (117, 3, false, 17, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (118, 3, false, 18, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (119, 3, false, 19, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (120, 3, false, 20, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (121, 3, false, 21, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (122, 3, false, 22, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (123, 3, false, 23, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (124, 3, false, 24, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (125, 3, false, 25, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (126, 3, false, 26, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (127, 3, false, 27, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (128, 3, false, 28, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (129, 3, false, 29, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (130, 3, false, 30, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (131, 3, true, 31, true, 21, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (132, 3, false, 32, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (133, 3, true, 33, false, 22, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (134, 3, false, 34, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (135, 3, true, 35, false, 23, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (136, 3, false, 36, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (137, 3, true, 37, true, 24, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (138, 3, false, 38, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (139, 3, false, 39, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (140, 3, false, 40, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (141, 3, false, 41, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (142, 3, true, 42, false, 31, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (143, 3, false, 43, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (144, 3, false, 44, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (145, 3, false, 45, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (146, 3, false, 46, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (147, 3, false, 47, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (148, 3, false, 48, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (149, 3, true, 49, false, 32, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (150, 3, false, 50, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (151, 4, false, 1, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (152, 4, false, 2, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (153, 4, false, 3, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (154, 4, false, 4, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (155, 4, false, 5, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (156, 4, false, 6, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (157, 4, false, 7, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (158, 4, false, 8, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (159, 4, false, 9, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (160, 4, false, 10, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (161, 4, false, 11, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (162, 4, false, 12, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (163, 4, false, 13, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (164, 4, false, 14, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (165, 4, false, 15, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (166, 4, false, 16, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (167, 4, false, 17, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (168, 4, false, 18, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (169, 4, false, 19, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (170, 4, false, 20, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (171, 4, false, 21, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (172, 4, false, 22, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (173, 4, false, 23, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (174, 4, false, 24, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (175, 4, false, 25, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (176, 4, false, 26, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (177, 4, false, 27, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (178, 4, false, 28, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (179, 4, false, 29, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (180, 4, false, 30, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (181, 4, false, 31, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (182, 4, false, 32, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (183, 4, false, 33, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (184, 4, false, 34, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (185, 4, false, 35, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (186, 4, false, 36, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (187, 4, false, 37, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (188, 4, false, 38, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (189, 4, false, 39, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (190, 4, false, 40, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (191, 4, false, 41, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (192, 4, false, 42, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (193, 4, false, 43, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (194, 4, false, 44, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (195, 4, false, 45, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (196, 4, false, 46, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (197, 4, false, 47, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (198, 4, false, 48, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (199, 4, false, 49, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (200, 4, false, 50, false, null, 2);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (201, 5, false, 1, true, 44, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (202, 5, false, 2, true, 45, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (203, 5, false, 3, true, 46, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (204, 5, false, 4, true, 47, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (205, 5, false, 5, true, 48, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (206, 5, false, 6, true, 49, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (207, 5, false, 7, true, 50, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (208, 5, false, 8, true, 52, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (209, 5, false, 9, true, 53, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (210, 5, false, 10, true, 54, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (211, 5, false, 11, true, 59, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (212, 5, false, 12, true, 56, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (213, 5, false, 13, true, 57, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (214, 5, false, 14, true, 58, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (215, 5, false, 15, true, 60, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (216, 5, false, 16, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (217, 5, false, 17, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (218, 5, false, 18, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (219, 5, false, 19, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (220, 5, false, 20, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (221, 5, false, 21, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (222, 5, false, 22, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (223, 5, false, 23, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (224, 5, false, 24, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (225, 5, false, 25, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (226, 5, false, 26, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (227, 5, false, 27, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (228, 5, false, 28, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (229, 5, false, 29, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (230, 5, false, 30, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (231, 5, true, 31, false, 41, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (232, 5, false, 32, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (233, 5, false, 33, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (234, 5, false, 34, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (235, 5, false, 35, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (236, 5, true, 36, false, 42, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (237, 5, false, 37, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (238, 5, false, 38, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (239, 5, false, 39, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (240, 5, false, 40, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (241, 5, false, 41, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (242, 5, false, 42, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (243, 5, false, 43, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (244, 5, true, 44, false, 43, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (245, 5, false, 45, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (246, 5, false, 46, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (247, 5, false, 47, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (248, 5, false, 48, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (249, 5, false, 49, false, null, 3);
insert into project2_parking_management.parking_slot (id, floor, reserved, slot_number, status, car_id, slot_type_id) values (250, 5, true, 50, true, 51, 3);
# Ticket
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (1, '2021-01-06 20:16:48', null, 0, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (2, '2021-01-07 03:47:00', null, 0, 2);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (3, '2021-01-07 03:47:00', null, 0, 2);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (4, '2021-01-07 03:47:00', '2021-01-07 08:05:00', 4472180000, 2);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (5, '2021-01-06 20:16:48', null, 0, 3);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (6, '2021-01-07 03:47:00', '2021-01-09 04:31:00', 8945240000, 3);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (7, '2021-01-07 03:47:00', null, 0, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (8, '2021-01-07 03:47:00', null, 0, 7);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (9, '2021-01-06 20:16:48', '2021-01-07 08:05:00', 4472180000, 8);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (10, '2021-01-07 03:47:00', null, 0, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (11, '2021-01-07 03:47:00', null, 0, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (12, '2021-01-07 03:47:00', null, 0, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (13, '2021-01-06 20:16:48', null, 0, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (14, '2021-01-07 03:47:00', null, 0, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (15, '2021-01-07 03:47:00', null, 0, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (16, '2021-01-07 03:47:00', null, 0, 11);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (17, '2021-01-06 20:16:48', '2021-01-07 08:05:00', 4472180000, 11);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (18, '2021-01-07 03:47:00', '2021-01-07 08:05:00', 4472180000, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (19, '2021-01-07 03:47:00', null, 0, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (20, '2021-01-07 03:47:00', null, 500, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (21, '2021-01-06 20:16:48', null, 1000, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (22, '2021-01-07 03:47:00', null, null, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (23, '2021-01-07 03:47:00', '2021-01-09 04:46:00', 13417860000, 6);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (24, '2021-01-07 03:47:00', '2021-01-09 04:46:00', 13417860000, 5);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (25, '2021-01-06 20:16:48', '2021-01-08 02:01:00', 8944720000, 15);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (26, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (27, '2021-01-07 03:47:00', null, null, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (28, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (29, '2021-01-06 20:16:48', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (30, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (31, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (32, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (33, '2021-01-06 20:16:48', null, null, 17);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (34, '2021-01-07 03:47:00', null, null, 17);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (35, '2021-01-07 03:47:00', null, null, 17);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (36, '2021-01-07 03:47:00', '2021-01-08 02:01:00', 13417080000, 17);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (37, '2021-01-06 20:16:48', '2021-01-08 02:00:00', 13417050000, 18);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (38, '2021-01-07 03:47:00', '2021-01-08 02:01:00', 8944720000, 19);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (39, '2021-01-07 03:47:00', null, null, 20);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (40, '2021-01-07 03:47:00', null, null, 21);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (41, '2021-01-06 20:16:48', null, null, 23);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (42, '2021-01-07 03:47:00', null, null, 23);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (43, '2021-01-07 03:47:00', '2021-01-07 08:05:00', 4472180000, 23);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (44, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (45, '2021-01-06 20:16:48', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (46, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (47, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (48, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (49, '2021-01-06 20:16:48', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (50, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (51, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (52, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (53, '2021-01-06 20:16:48', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (54, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (55, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (56, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (57, '2021-01-06 20:16:48', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (58, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (59, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (60, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (61, '2021-01-06 20:16:48', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (62, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (63, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (64, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (65, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (66, '2021-01-06 20:16:48', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (67, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (68, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (69, '2021-01-07 03:47:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (70, '2021-01-07 03:10:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (71, '2021-01-07 03:12:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (72, '2021-01-07 03:19:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (73, '2021-01-07 03:21:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (74, '2021-01-07 03:25:00', '2021-01-07 03:25:00', null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (75, '2021-01-07 03:35:00', '2021-01-07 03:46:00', null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (76, '2021-01-07 03:46:00', '2021-01-07 03:47:00', null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (77, '2021-01-07 03:47:00', '2021-01-07 03:49:00', null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (78, '2021-01-07 03:50:00', '2021-01-07 05:14:00', 40000, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (79, '2021-01-07 03:47:00', '2021-01-09 05:59:00', 8945260000, 25);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (80, '2021-01-07 05:17:00', '2021-01-07 05:18:00', 20000, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (81, '2021-01-07 05:18:00', '2021-01-07 05:18:00', 0, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (82, '2021-01-07 05:19:00', '2021-01-07 05:19:00', 0, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (83, '2021-01-07 08:06:00', null, null, 26);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (84, '2021-01-07 09:32:00', '2021-01-09 06:00:00', 450000, 23);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (85, '2021-01-07 10:39:00', null, null, 1);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (86, '2021-01-07 10:39:00', null, null, 2);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (87, '2021-01-07 10:45:00', '2021-01-07 10:45:00', 0, 2);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (88, '2021-01-07 10:45:00', null, null, 2);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (89, '2021-01-08 11:48:00', '2021-01-08 11:48:00', 0, 13);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (90, '2021-01-08 08:34:00', '2021-01-08 08:35:00', 10000, 13);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (91, '2021-01-08 08:35:00', '2021-01-09 05:54:00', 440000, 15);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (92, '2021-01-09 04:46:00', '2021-01-09 04:49:00', 30000, 6);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (93, '2021-01-09 04:50:00', '2021-01-09 07:15:00', 90000, 6);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (94, '2021-01-09 05:57:00', '2021-01-09 05:57:00', 0, 15);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (95, '2021-01-09 05:57:00', '2021-01-09 06:00:00', 10000, 24);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (96, '2021-01-09 04:50:00', '2021-01-09 05:58:00', 13417890000, 27);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (97, '2021-01-09 07:51:00', '2021-01-09 08:00:00', 10000, 61);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (98, '2021-01-09 08:00:00', '2021-01-09 08:00:00', 0, 61);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (99, '2021-01-09 08:05:00', null, null, 4);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (100, '2021-01-09 08:05:00', null, null, 5);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (101, '2021-01-09 08:05:00', null, null, 6);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (102, '2021-01-09 08:05:00', null, null, 7);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (103, '2021-01-09 08:05:00', null, null, 8);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (104, '2021-01-09 08:05:00', null, null, 9);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (105, '2021-01-09 08:05:00', null, null, 10);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (106, '2021-01-09 08:05:00', null, null, 10);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (107, '2021-01-09 08:05:00', null, null, 10);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (108, '2021-01-09 08:06:00', null, null, 14);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (109, '2021-01-09 08:06:00', null, null, 15);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (110, '2021-01-09 04:50:00', null, null, 16);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (111, '2021-01-09 08:06:00', null, null, 17);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (112, '2021-01-09 04:50:00', null, null, 18);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (113, '2021-01-09 08:07:00', null, null, 19);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (114, '2021-01-09 04:50:00', null, null, 20);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (115, '2021-01-09 08:07:00', null, null, 25);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (116, '2021-01-09 08:07:00', null, null, 26);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (117, '2021-01-09 08:08:00', null, null, 27);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (118, '2021-01-09 04:50:00', null, null, 28);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (119, '2021-01-09 04:50:00', null, null, 29);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (120, '2021-01-09 04:50:00', null, null, 30);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (121, '2021-01-09 08:12:00', null, null, 33);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (122, '2021-01-09 08:12:00', null, null, 35);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (123, '2021-01-09 08:12:00', null, null, 36);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (124, '2021-01-09 08:12:00', null, null, 37);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (125, '2021-01-09 08:13:00', null, null, 38);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (126, '2021-01-09 04:50:00', null, null, 39);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (127, '2021-01-09 04:50:00', null, null, 40);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (128, '2021-01-09 08:13:00', null, null, 44);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (129, '2021-01-09 04:50:00', null, null, 45);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (130, '2021-01-09 08:13:00', null, null, 46);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (131, '2021-01-09 04:50:00', null, null, 47);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (132, '2021-01-09 04:50:00', null, null, 48);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (133, '2021-01-09 04:50:00', null, null, 49);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (134, '2021-01-09 08:12:00', null, null, 50);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (135, '2021-01-09 08:12:00', null, null, 52);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (136, '2021-01-09 08:12:00', null, null, 53);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (137, '2021-01-09 08:12:00', null, null, 54);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (138, '2021-01-09 08:13:00', '2021-01-09 08:14:00', 13417980000, 55);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (139, '2021-01-09 04:50:00', null, null, 56);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (140, '2021-01-09 04:50:00', null, null, 57);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (141, '2021-01-09 08:13:00', '2021-01-09 08:15:00', 13417980000, 58);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (142, '2021-01-09 04:50:00', null, null, 59);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (143, '2021-01-09 08:13:00', null, null, 60);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (144, '2021-01-09 08:14:00', '2021-01-09 08:22:00', 10000, 61);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (145, '2021-01-09 08:15:00', null, null, 58);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (146, '2021-01-09 20:22:34', null, null, 61);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (147, '2021-01-09 20:23:14', '2021-01-09 08:23:00', 0, 61);
insert into project2_parking_management.ticket (id, enter_date, exit_date, price, car_id) values (148, '2021-01-09 20:25:14', null, null, 61);
# Member card
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (1, '2019-01-07 20:13:18', 30000000, '2018-01-07 20:13:12', 1, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (2, '2021-02-07 20:13:18', 3000000, '2021-01-07 20:13:12', 1, 2);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (3, '2021-02-09 19:11:41', 3000000, '2021-01-09 19:11:53', 2, 2);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (4, '2022-02-09 19:11:56', 3000000, '2021-01-09 19:12:11', 3, 2);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (5, '2022-01-09 19:12:00', 30000000, '2021-01-09 19:12:14', 11, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (6, '2022-01-09 19:12:28', 30000000, '2021-01-09 19:12:16', 12, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (7, '2022-01-09 19:11:41', 30000000, '2021-01-09 19:12:17', 13, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (8, '2022-01-09 19:11:56', 30000000, '2021-01-09 19:12:18', 21, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (9, '2022-01-09 19:12:00', 30000000, '2021-01-09 19:12:19', 22, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (10, '2022-01-09 19:12:28', 30000000, '2021-01-09 19:12:19', 23, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (11, '2022-01-09 19:11:41', 30000000, '2021-01-09 19:12:20', 24, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (12, '2022-01-09 19:11:56', 30000000, '2021-01-09 19:12:21', 31, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (13, '2022-02-01 19:12:00', 30000000, '2021-01-01 19:12:22', 32, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (14, '2021-01-11 19:12:28', 30000000, '2021-01-09 19:12:23', 41, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (15, '2021-01-11 19:11:41', 30000000, '2021-01-09 19:12:23', 42, 3);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (20, '2021-01-14 17:30:00', 1000000, '2021-01-08 17:30:00', 43, 1);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (21, '2021-01-14 17:30:00', 3000000, '2020-12-15 17:30:00', 44, 2);
insert into project2_parking_management.member_card (id, end_date, price, start_date, car_id, member_card_id) values (22, '2021-01-14 17:30:00', 9000000, '2020-01-15 17:30:00', 45, 3);
# Entry Log
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (1, '2021-01-05 20:17:56', '2021-01-07 22:28:57', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (2, '2021-01-07 03:47:00', '2021-01-07 22:35:41', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (3, '2021-01-07 03:47:00', '2021-01-07 22:35:49', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (4, '2021-01-06 20:16:48', '2021-01-07 22:38:02', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (5, '2021-01-07 03:47:00', '2021-01-07 23:12:59', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (6, '2021-01-07 03:47:00', '2021-01-07 23:15:29', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (7, '2021-01-07 03:47:00', '2021-01-07 23:15:35', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (8, '2021-01-07 03:47:00', '2021-01-07 23:15:36', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (9, '2021-01-07 03:47:00', '2021-01-07 23:15:36', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (10, '2021-01-06 20:16:48', '2021-01-07 23:15:36', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (11, '2021-01-07 03:47:00', '2021-01-07 23:17:37', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (12, '2021-01-07 03:47:00', '2021-01-07 23:18:11', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (13, '2021-01-07 03:47:00', '2021-01-07 23:18:40', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (14, '2021-01-07 03:47:00', '2021-01-07 23:20:37', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (15, '2021-01-07 03:47:00', '2021-01-07 23:22:20', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (16, '2021-01-06 20:16:48', '2021-01-07 23:22:26', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (17, '2021-01-07 03:47:00', '2021-01-08 00:02:32', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (18, '2021-01-07 03:47:00', '2021-01-08 00:05:11', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (19, '2021-01-07 03:47:00', '2021-01-08 00:05:25', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (20, '2021-01-08 08:26:50', '2021-01-08 08:27:01', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (21, '2021-01-08 08:27:17', '2021-01-08 08:27:28', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (22, '2021-01-08 08:34:25', '2021-01-08 08:34:33', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (23, '2021-01-08 08:38:39', '2021-01-08 08:38:42', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (24, '2021-01-08 09:51:51', '2021-01-08 09:52:14', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (25, '2021-01-08 09:52:23', '2021-01-08 10:04:10', 1);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (26, '2021-01-08 10:05:34', '2021-01-08 10:05:38', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (27, '2021-01-08 10:06:11', '2021-01-08 10:07:15', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (28, '2021-01-08 11:43:11', '2021-01-08 11:43:20', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (29, '2021-01-08 11:43:45', '2021-01-08 11:43:59', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (30, '2021-01-08 11:44:07', '2021-01-08 11:44:17', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (31, '2021-01-08 11:44:33', '2021-01-08 11:44:47', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (32, '2021-01-08 15:58:32', '2021-01-08 15:58:44', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (33, '2021-01-08 16:39:01', '2021-01-08 16:39:10', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (34, '2021-01-08 17:09:52', '2021-01-08 17:09:56', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (35, '2021-01-08 19:07:18', '2021-01-08 19:07:23', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (36, '2021-01-08 20:38:33', '2021-01-08 20:41:27', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (37, '2021-01-08 20:46:57', '2021-01-08 22:39:23', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (38, '2021-01-08 22:50:26', '2021-01-09 19:15:20', 2);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (39, '2021-01-09 19:27:51', null, 8);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (40, '2021-01-09 19:28:15', '2021-01-09 19:42:10', 21);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (41, '2021-01-09 19:28:33', null, 3);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (42, '2021-01-09 19:28:52', '2021-01-09 19:29:09', 11);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (43, '2021-01-09 19:29:15', '2021-01-09 19:33:38', 11);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (44, '2021-01-09 19:33:41', null, 11);
insert into project2_parking_management.entry_log (id, enter_date, exit_date, member_card_id) values (45, '2021-01-09 19:42:23', null, 21);

use project2_parking_management;

# Statistic
# View Thống kê các loại xe đang có tại bãi
create view statistics_brand_car as
select count(project2_parking_management.car.brand_name) as total_car_type,
       car.brand_name from project2_parking_management.parking_slot
inner join project2_parking_management.car on parking_slot.car_id = car.id
where project2_parking_management.parking_slot.status = 1
group by project2_parking_management.car.brand_name;
# View Thống kê tổng số lượng vé mỗi loại (tuần/ tháng/ năm)
create view statistics_member_card_type as
select count(project2_parking_management.member_card.id) as total_member_card_type, project2_parking_management.member_card_type.member_type_name from project2_parking_management.member_card
inner join project2_parking_management.member_card_type on member_card.member_card_id = member_card_type.id
group by project2_parking_management.member_card_type.member_type_name;
# View Thống kê số lượng xe của mỗi khách hàng
create view statistics_total_car_customer as
select count(project2_parking_management.car.id) as total_car_customer, project2_parking_management.customer.full_name from project2_parking_management.car
inner join project2_parking_management.customer on car.customer_id = customer.id
group by project2_parking_management.customer.full_name;
# View Thống kê số lượng khách hàng đăng ký trong khoảng thời gian
create view statistics_total_customer as
select project2_parking_management.customer.create_date,
       count(project2_parking_management.customer.full_name) as total_customer
from project2_parking_management.customer
group by project2_parking_management.customer.create_date
order by project2_parking_management.customer.create_date asc;
# View Thống kê doanh thu && tổng số vé trong khoảng thời gian (member card)
create view statistic_total_revenue_member_card as
select
date(project2_parking_management.member_card.start_date) as date_payment,
sum(project2_parking_management.member_card.price) as total_price,
count(project2_parking_management.member_card.start_date) as total_member_card
from project2_parking_management.member_card
group by date(project2_parking_management.member_card.start_date)
order by project2_parking_management.member_card.start_date asc;
# View Thống kê doanh thu trong khoảng thời gian (ticket)
create view statistic_total_revenue_ticket as
select date(project2_parking_management.ticket.enter_date) as date_payment,
       sum(if(datediff(date(project2_parking_management.ticket.exit_date),
                       date(project2_parking_management.ticket.enter_date)) != 0,
              project2_parking_management.ticket.price * datediff(date(project2_parking_management.ticket.exit_date),
                                                                  date(project2_parking_management.ticket.enter_date)),
              project2_parking_management.ticket.price)) as total_price
from project2_parking_management.ticket
group by project2_parking_management.ticket.enter_date
order by project2_parking_management.ticket.enter_date asc;
# View thống kê vé theo ngày tháng năm
create view statistic_member_card_time as
select date(project2_parking_management.member_card.start_date)        as date,
       count(date(project2_parking_management.member_card.start_date)) as total_member_card_day
from project2_parking_management.member_card
group by date(project2_parking_management.member_card.start_date)
order by project2_parking_management.member_card.start_date;
