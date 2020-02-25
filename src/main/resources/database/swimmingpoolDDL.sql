DROP DATABASE IF EXISTS SWIMMINGPOOL;
CREATE DATABASE IF NOT EXISTS SWIMMINGPOOL;
USE SWIMMINGPOOL;

DROP TABLE IF EXISTS SWIMMINGPOOL;


CREATE TABLE management (
FullName VARCHAR (30) not null primary key,
Email varchar(30) ,
PhoneNumber int (30)not null,
Address VARCHAR (30)

);

SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO management VALUES ('Sean Smith', 'SeanSmith@gmail.com', '0876565443', 'The Hill, Athlone');
INSERT INTO management VALUES ('Mary Shine', 'MaryShine@gmail.com', '0874356776', 'Bog Road, Ballinasloe');

select * from management;
