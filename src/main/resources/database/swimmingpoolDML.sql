INSERT INTO User VALUES (NULL,'Isabel Roses', 'F','1984-06-15', 'staff','manager@snamh.com','080-07674321','15 Dublin Road', 'Athlone');
INSERT INTO User VALUES (NULL,'Paul Marques','M','1990-03-01', 'staff','staff@snamh.com','080-25774528','02 Glasson Street', 'Athlone');
INSERT INTO User VALUES (NULL,'Julia Darling','F','1978-12-04','walk in adult','Juliadarling@gmail.com','083-0751278','05 Sky Road', 'Athlone');
INSERT INTO User VALUES (NULL, 'Mary Shine','F','2008-05-25', 'walk in child', 'Maryshine@gmail.com','083-05748642','25 Castle Street', 'Athlone');
INSERT INTO User VALUES (NULL,'Ryan Dalkey','M', '1972-07-09','full', 'Ryandalkey@hotmail.com','087-057962895','14 Obeye Street', 'Athlone');
INSERT INTO User VALUES (NULL,'Tom Jones','M','2000-06-08','staff', 'Tomjones@snamh.com','086-07846842','10 King George', 'Athlone');
INSERT INTO User VALUES (NULL,'Sean Smith','M', '1975-04-10','staff', 'SeanSmith@snamh.com','080-214579461','12 Clonby Crescent', 'Athlone');

INSERT INTO Access_Type VALUES (1, 'Management');
INSERT INTO Access_Type VALUES (2, 'Staff');
INSERT INTO Access_Type VALUES (3, 'Customer');

INSERT INTO Login VALUES ('manager@snamh.com','123',1);
INSERT INTO Login VALUES ('staff@snamh.com','1234',2);
INSERT INTO Login VALUES ('Juliadarling@gmail.com','j100',3);
INSERT INTO Login VALUES ('Maryshine@gmail.com','Mary43',3);
INSERT INTO Login VALUES ('Ryandalkey@hotmail.com','ryano',3);
INSERT INTO Login VALUES ('Tomjones@snamh.com','Tom100',3);
INSERT INTO Login VALUES ('SeanSmith@snamh.com','seany1',3);

INSERT INTO  Payment VALUES (1000, 3,'15.00','2020-02-25');
INSERT INTO  Payment VALUES (1001, 4,'5.00','2020-03-05');
INSERT INTO  Payment VALUES (1002, 5,'0.00','2020-03-03');

INSERT INTO Class VALUES ('PS','Primary School','5','40','2020-03-04','2020-06-04','Tom Jones');
INSERT INTO Class VALUES ('BG','Beginner','10','30','2020-03-05','2020-06-05','Sean Smith');
INSERT INTO Class VALUES ('IM','Intermediate','15','30','2020-03-06','2020-06-06','Tom Jones');
INSERT INTO Class VALUES ('AV','Advanced','20','30','2020-03-04','2020-06-04','Sean Smith');
INSERT INTO Class VALUES ('OS','Over 60','5','20','2020-03-05','2020-06-05','Tom Jones');

INSERT INTO Timetable VALUES ('PS','monday','17:00:00');
INSERT INTO Timetable VALUES ('BG','tuesday','20:00:00');
INSERT INTO Timetable VALUES ('IM','wednesday','17:00:00');
INSERT INTO Timetable VALUES ('AV','thursday','17:00:00');
INSERT INTO Timetable VALUES ('OS','friday','13:00:00');

INSERT INTO Class_Enrollment VALUES (3,'BG', 1000,'2020-04-04','St Marys','15.0');
INSERT INTO Class_Enrollment VALUES (4,'PS',1001,'2020-04-04','Kids Aerobics','5.0');
INSERT INTO Class_Enrollment VALUES (5,'OS',1002,'2020-04-04','Keep Fit','0.0');


SELECT * FROM User;
SELECT * FROM Access_Type;
SELECT * FROM Login;
SELECT * FROM Payment;
SELECT * FROM class; 
SELECT * FROM Timetable;
SELECT * FROM Class_Enrollment;
