INSERT INTO person(id, name, location, birth_date) VALUES(10000, 'Alex', 'Mexico', CURRENT_TIMESTAMP());
INSERT INTO person(id, name, location, birth_date) VALUES(10001, 'Test', 'Mexico', CURRENT_TIMESTAMP());

INSERT INTO course(id, name) VALUES('101', 'Jpa');
INSERT INTO course(id, name) VALUES('102', 'Jpa');

INSERT INTO passport(id, number) VALUES('40001', 'E34T7');
INSERT INTO passport(id, number) VALUES('40002', 'G48T4');
INSERT INTO passport(id, number) VALUES('40003', 'H48943');
INSERT INTO passport(id, number) VALUES('40004', 'H48943deded');

INSERT INTO student(id, name, passport_id) VALUES('101', 'Alex', '40001');
INSERT INTO student(id, name, passport_id) VALUES('102', 'Mike', '40002');
INSERT INTO student(id, name, passport_id) VALUES('103', 'Jane', '40003');

INSERT INTO review(id, rating, description, course_id) VALUES('50001', '5', 'Great Course', '101');
INSERT INTO review(id, rating, description, course_id) VALUES('50002', '4', 'Good', '101');
INSERT INTO review(id, rating, description, course_id) VALUES('50003', '1', 'Bad Course', '102');