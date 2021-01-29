use project3_thesis_management;

INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, phone, number_student) VALUES (1, 'trungdoan@codegym.com', 'Doan Phuoc Trung', '205555666', '0905123456', 10);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, phone, number_student) VALUES (2, 'trungdang@codegym.com', 'Dang Chi Trung', '205555666', '0905456789', 15);
INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, phone, number_student) VALUES (3, 'tiennguyen@codegym.com', 'Nguyen Vu Thanh Tien', '205555666', '0905987321', 10);

INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (1, 3, '2021-01-21 11:28:59', 'Hệ thống giúp nhà trường, giáo viên và học sinh quản lý đề tài tốt nghiệp thuận lợi hơn.', 'Quản lý thực hiện đề tài tốt nghiệp', 1);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (2, 3, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý bãi đỗ xe thuận lợi hơn.', 'Quản lý bãi đỗ xe', 1);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (3, 3, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý quá trình tiêm vacxin thuận lợi hơn.', 'Quản lý tiêm chủng vacxin', 1);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (4, 5, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý phòng bán vé máy bay thuận lợi hơn.', 'Quản lý phòng bán vé máy bay', 1);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (5, 5, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý trang trại heo thuận lợi hơn.', 'Quản lý trang trại heo', 1);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (6, 5, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý hệ thống bán hàng thuận lợi hơn.', 'Quản lý hệ thống bán hàng', 1);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (7, 3, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý khách hàng thuận lợi hơn.', 'Quản lý khách hàng', 2);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (8, 5, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý ô tô thuận lợi hơn.', 'Quản lý ô tô', 2);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (9, 3, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý xe máy thuận lợi hơn.', 'Quản lý xe máy', 2);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (10, 3, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý nhà kho thuận lợi hơn.', 'Quản lý nhà kho', 3);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (11, 5, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý siêu thị thuận lợi hơn.', 'Quản lý siêu thị', 3);
INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (12, 3, '2021-01-21 11:28:59', 'Hệ thống giúp quản lý công viên thuận lợi hơn.', 'Quản lý công viên', 3);

INSERT INTO project3_thesis_management.student_group (id, file_url, group_name, quantity, teacher_id) VALUES (1, '', 'Xóm Nhà Lá', 3, 1);
INSERT INTO project3_thesis_management.student_group (id, file_url, group_name, quantity, teacher_id) VALUES (2, '', 'Xóm Bê Đê', 3, 2);
INSERT INTO project3_thesis_management.student_group (id, file_url, group_name, quantity, teacher_id) VALUES (3, '', 'Xóm Nhà Nghèo', 5, 1);

INSERT INTO project3_thesis_management.check_thesis (id, check_date, status, student_group_id, thesis_id) VALUES (1, '2021-01-23 08:30:00', true, 2, 7);
INSERT INTO project3_thesis_management.check_thesis (id, check_date, status, student_group_id, thesis_id) VALUES (2, '2021-01-23 08:30:00', true, 3, 2);

INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (1, 'supea52795@gmail.com', 'Luong Phu Chau', '0975985541', true, 'SV-55555', '', null, null, 1);
INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (2, 'hoquynhmai1505@gmail.com', 'Ho Quynh Mai', '0909999999', null, 'SV-99999', null, null, null, 1);
INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (3, 'nhatlanh2202@gmail.com', 'Nguyen Quang Nhat Lanh', '0902222222', null, 'SV-22222', null, null, null, 1);
INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (4, 'supea52795@gmail.com', 'Luong Vu Quang Din', '0902222222', true, 'SV-11111', null, null, null, 2);
INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (5, 'khanhnguyen@gmail.com', 'Nguyen Quoc Khanh', '0902222222', null, 'SV-33333', null, null, null, 2);
INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (6, 'danhnguyen@gmail.com', 'Nguyen Quang Danh', '0902222222', null, 'SV-77777', null, null, null, 2);

CREATE VIEW instruction_status AS
    SELECT 
        project3_thesis_management.teacher.id AS id,
        project3_thesis_management.teacher.full_name AS fullName,
        project3_thesis_management.teacher.email AS email,
        project3_thesis_management.teacher.phone AS phone,
        project3_thesis_management.teacher.number_student AS limitStudentRegister,
        project3_thesis_management.student_group.quantity AS numberStudentRegister,
        SUM(project3_thesis_management.student_group.quantity) AS totalStudentRegister
    FROM
        project3_thesis_management.teacher
            LEFT JOIN
        project3_thesis_management.student_group ON teacher.id = student_group.teacher_id
    GROUP BY project3_thesis_management.teacher.id