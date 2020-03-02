DROP DATABASE IF EXISTS SNAMH;
CREATE DATABASE IF NOT EXISTS SNAMH;
USE SNAMH;


DROP TABLE IF EXISTS Access_Type;

CREATE TABLE Access_Type(
id INTEGER AUTO_INCREMENT,
description VARCHAR (30),	
 PRIMARY KEY (id)
);

CREATE TABLE Login(
email_address VARCHAR (30),
password VARCHAR (30),
access_type INTEGER (30),
username VARCHAR (30),
	
 PRIMARY KEY (email_address)
);

CREATE TABLE User(
id INTEGER (10),
full_name VARCHAR (30),
date_of_birth DATE NOT NULL,
membership VARCHAR (25),
email_address VARCHAR (40),
PRIMARY KEY (id)
);

CREATE TABLE Payment(
id VARCHAR (30),
user_id DECIMAL (30) ,
amount DECIMAL (30),
payment_date Date,
PRIMARY KEY (id)
);

CREATE TABLE Class_Enrollment(
user_id DECIMAL (30),
class_id VARCHAR (30),
payment_type VARCHAR (30),
enrollment_date DATE,
school_name VARCHAR (30),
price DECIMAL (30), 
PRIMARY KEY (user_id) 
);

CREATE TABLE class(
id VARCHAR (20),
name VARCHAR (30),
price DECIMAL (10),
capacity DECIMAL (10),
start_date DATE, 
end_date DATE,
instructor VARCHAR (40),
PRIMARY KEY (id)
);

CREATE TABLE Timetable(
class_id VARCHAR (12),
day_of_week VARCHAR (12),
time TIME,
PRIMARY KEY (class_id)
);


    
     
	

