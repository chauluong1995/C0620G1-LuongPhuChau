INSERT INTO project3_thesis_management.teacher (id, email, full_name, identity_number, phone, teacher_code, app_account_id) VALUES (1, '', 'Doan Phuoc Trung', null, null, null, null);

INSERT INTO project3_thesis_management.thesis (id, amount, create_date, description, statement, teacher_id) VALUES (1, 3, '2021-01-21 11:28:59', 'Hệ thống giúp nhà trường, giáo viên và học sinh quản lý đề tài tốt nghiệp thuận lợi hơn.', 'Quản lý thực hiện đề tài tốt nghiệp', 1);

INSERT INTO project3_thesis_management.student_group (id, file_url, group_name, quantity, teacher_id) VALUES (1, '', 'Xóm Nhà Lá', 3, null);

INSERT INTO project3_thesis_management.check_thesis (id, check_date, status, student_group_id, thesis_id) VALUES (1, '2021-01-16 22:30:52', true, 1, 1);

INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (1, 'supea52795@gmail.com', 'Luong Phu Chau', '0975985541', true, 'SV-55555', '', null, null, 1);
INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (2, 'hoquynhmai1505@gmail.com', 'Ho Quynh Mai', '0909999999', null, 'SV-99999', null, null, null, 1);
INSERT INTO project3_thesis_management.student (id, email, full_name, phone, position, student_code, teacher, topic, app_account_id, group_id) VALUES (3, 'nhatlanh2202@gmail.com', 'Nguyen Quang Nhat Lanh', '0902222222', null, 'SV-22222', null, null, null, 1);