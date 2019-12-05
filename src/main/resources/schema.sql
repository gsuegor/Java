CREATE DATABASE schedule;

USE schedule;

CREATE TABLE teacher (
                         id_teacher int(11) NOT NULL AUTO_INCREMENT,
                         full_name varchar(100) NOT NULL,
                         lectures_per_week int(2) NOT NULL,
                         students_on_lectures int(2) NOT NULL,
                         PRIMARY KEY (id_teacher)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE lecture (
                         id_lecture int(11) NOT NULL AUTO_INCREMENT,
                         name varchar(200) NOT NULL,
                         location varchar(100) NOT NULL,
                         lecture_day varchar(100) NOT NULL,
                         teacher_id int(11) NOT NULL,
                         PRIMARY KEY (id_lecture),
                         FOREIGN KEY (teacher_id) REFERENCES teacher (id_teacher)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO schedule.teacher (id_teacher, full_name, lectures_per_week, students_on_lectures) VALUES (1, 'Pup Pupkov Pupkovich', 4, 20);
INSERT INTO schedule.teacher (id_teacher, full_name, lectures_per_week, students_on_lectures) VALUES (2, 'Sob Sobkov Sobokov', 3, 20);
INSERT INTO schedule.teacher (id_teacher, full_name, lectures_per_week, students_on_lectures) VALUES (3, 'Kop Kopkov Kopkovich', 4, 15);
INSERT INTO schedule.teacher (id_teacher, full_name, lectures_per_week, students_on_lectures) VALUES (4, 'Tent Tentkov Tenkovich', 5, 15);
INSERT INTO schedule.teacher (id_teacher, full_name, lectures_per_week, students_on_lectures) VALUES (5, 'Gap Gapkov Gapkovich', 2, 60);

INSERT INTO schedule.lecture (id_lecture, name, location, lecture_day, teacher_id) VALUES (1, 'Fizika', '4-20', 'Monday', 1);
INSERT INTO schedule.lecture (id_lecture, name, location, lecture_day, teacher_id) VALUES (2, 'Chemistry', '4-20', 'Wednesday', 1);
INSERT INTO schedule.lecture (id_lecture, name, location, lecture_day, teacher_id) VALUES (3, 'English Language', '2-20', 'Friday', 2);
INSERT INTO schedule.lecture (id_lecture, name, location, lecture_day, teacher_id) VALUES (4, 'Programming', '2-20', 'Wednesday', 2);
INSERT INTO schedule.lecture (id_lecture, name, location, lecture_day, teacher_id) VALUES (5, 'Geography', '2-20', 'Wednesday', 5);