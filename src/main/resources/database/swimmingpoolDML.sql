INSERT INTO Access_Type VALUES (NULL, 'Management');
INSERT INTO Access_Type VALUES (NULL, 'Customer');
INSERT INTO Access_Type VALUES (NULL, 'Staff');

SELECT * FROM Access_Type;


INSERT INTO Login VALUES ('SeanSmith@gmail.com', 'seany1', '1','Seansmith');
INSERT INTO Login VALUES ('Maryshine@gmail.com', 'Mary43', '2','Maryshine');
INSERT INTO Login VALUES ('Tomjones@hotmail.com', 'Tom100', '3','Tomboy');
INSERT INTO Login VALUES ('Juliadarling@hotmail.com','julia12','2','juliebaby');
INSERT INTO Login VALUES ('Ryandalkey@yahoo.co.uk','ryano','2','ryansboy');

SELECT * FROM Login;


INSERT INTO User VALUES ('100','Julia Darling','1978-12-04','walk in adult','Juliadarling@gmail.com');
INSERT INTO User VALUES ('200', 'Mary Shine','2008-05-25', 'walk in child', 'Maryshine@gmail.com');
INSERT INTO User VALUES ('300','Ryan Dalkey', '1972-07-09','full', 'Ryandalkey@hotmail.com');
INSERT INTO User VALUES ('400','Tom Jones', '2000-06-08','full', 'Tomjones@hotmail.com');
INSERT INTO User VALUES ('500','Sean Smith', '1975-04-10','full', 'SeanSmith@gmail.com');

SELECT * FROM User;



INSERT INTO  Payment VALUES ('C1000', '200','5','2020-03-11');
INSERT INTO  Payment VALUES ('C1234', '100','15','2020-03-05');
INSERT INTO  Payment VALUES ('C1278', '300','0.0','2020-03-03');

SELECT * FROM Payment;


INSERT INTO Class_Enrollment VALUES ('100','IM','walk in intermediate', '2020-04-04','Aqua Aerobics','15');
INSERT INTO Class_Enrollment VALUES ('200','PS','walk in child', '2020-04-04',' Kids Aerobics','5');
INSERT INTO Class_Enrollment VALUES ('300','AV','full', '2020-04-04','Keep Fit','0.0');

SELECT * FROM Class_Enrollment;


INSERT INTO Class VALUES ('PS','Primary School','5','40','2020-03-04','2020-06-04','Tom Jones');
INSERT INTO Class VALUES ('BG','Beginner','10','30','2020-03-05','2020-06-05','Sean Smith');
INSERT INTO Class VALUES ('IM','Intermediate','15','30','2020-03-06','2020-06-06','Tom Jones');
INSERT INTO Class VALUES ('AV','Advanced','20','30','2020-03-04','2020-06-04','Sean Smith');
INSERT INTO Class VALUES ('OS','Over 60','5','20','2020-03-05','2020-06-05','Tom Jones');

SELECT * FROM class; 



INSERT INTO Timetable VALUES ('PS','monday','17:00:00');
INSERT INTO Timetable VALUES ('BG','tuesday','20:00:00');
INSERT INTO Timetable VALUES ('IM','wednesday','17:00:00');
INSERT INTO Timetable VALUES ('AV','thursday','17:00:00');
INSERT INTO Timetable VALUES ('OS','friday','13:00:00');

SELECT * FROM Timetable;