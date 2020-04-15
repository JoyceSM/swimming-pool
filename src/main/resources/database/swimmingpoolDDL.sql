CREATE TABLE User(
user_id INTEGER AUTO_INCREMENT NOT NULL,
full_name VARCHAR (60) NOT NULL,
gender VARCHAR (1),
date_of_birth DATE NOT NULL,
membership BOOLEAN,
email_address VARCHAR (40) NOT NULL,
phone VARCHAR(24) NOT NULL,
address VARCHAR(60) NOT NULL,
city VARCHAR(15) NOT NULL,
PRIMARY KEY (user_id),
UNIQUE KEY (email_address)
);

CREATE TABLE Access_Type(
access_id INTEGER,
function_type VARCHAR (30) NOT NULL,	
 PRIMARY KEY (access_id)
);

CREATE TABLE Login(
username VARCHAR(30) NOT NULL,
password VARCHAR(20) NOT NULL,
access_id INTEGER,
PRIMARY KEY (username),
FOREIGN KEY (username)
REFERENCES User (email_address),
FOREIGN KEY (access_id)
REFERENCES Access_Type (access_id)
);

CREATE TABLE Payment(
payment_id INTEGER AUTO_INCREMENT NOT NULL,
user_id INTEGER,
amount DECIMAL (30,2)NOT NULL,
payment_date Date,
PRIMARY KEY (payment_id),
FOREIGN KEY (user_id)
REFERENCES User (user_id)
);

CREATE TABLE Class(
class_id VARCHAR
 (20),
class_name VARCHAR (30),
price DECIMAL (10,2),
capacity INTEGER (10),
start_date DATE, 
end_date DATE,
instructor VARCHAR (40),
PRIMARY KEY (class_id)
);

CREATE TABLE Timetable(
class_id VARCHAR (12),
day_of_week VARCHAR (12),
class_time VARCHAR (20),
FOREIGN KEY (class_id)
REFERENCES Class (class_id)
);

CREATE TABLE Class_Enrollment(
user_id INTEGER,
class_id VARCHAR (20),
payment_id INTEGER,
enrollment_date DATE,
school_name VARCHAR (30),
price DECIMAL (30,2), 
FOREIGN KEY (user_id)
REFERENCES User (user_id),
FOREIGN KEY (class_id)
REFERENCES Class (class_id)
);
