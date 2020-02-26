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
INSERT INTO management VALUES ('Tom Jones', 'Tomjones@hotmail.com', '0874896554', 'Main street, Athlone');
INSERT INTO management VALUES ('Eleanor Kelly', 'eleanorkelly@yahoo.co.uk', '0877899332', 'Ballybay, Roscommon');
INSERT INTO management VALUES ('Margaret Shaw', 'Margaretshaw@hotmail.com', '089435556', 'monksland, Athlone');

select * from management;

CREATE TABLE staff (
FullName VARCHAR (30) not null primary key,
Email varchar(30) not null,
PhoneNumber int (30)not null,
Address VARCHAR (30)

);
SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO staff VALUES ('Marion Kilmartin', 'MarionKilmartin@gmail.com', '0896554334', 'Main street, Athlone');
INSERT INTO staff VALUES ('Jamie Smith', 'Jamiesmith@gmail.com', '0866643588', 'Brewery street, Tullamore');
INSERT INTO staff VALUES ('Orla Thornton', 'orlathornton@hotmail.com', '0877773356', 'long road, Tullamore');
INSERT INTO staff VALUES ('Joan Lennon', 'Joanlennon@hotmail.com', '0864443556', 'bonavalley, Athlone');
INSERT INTO staff VALUES ('Joe Bloggs', 'JoeBloggs@gmail.com', '0864343599', '3 monksland, Athlone');

select * from staff;

CREATE TABLE customer (
FullName VARCHAR (30) not null primary key,
Email varchar(30) not null,
Address VARCHAR (30),
MembershipStatus  VARCHAR (10),
LEVEL  VARCHAR (30)

);
SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO customer VALUES ('Sharon Shannon', 'SharonShannon@gmail.com', '21 Red road, athlone', 'full', 'beginner');
INSERT INTO customer VALUES ('Alan Richards', 'AlanRichards@gmail.com', '1 ros ard, athlone','full', 'advanced');
INSERT INTO customer VALUES ('Joan Spain', 'Joanspain@gmail.com', '1 cluain broic, athlone','walk in', 'advanced');
INSERT INTO customer VALUES ('Alan Ryan', 'Alanryan@gmail.com', '27 ridgeway, athlone','walk in', 'beginner');
INSERT INTO customer VALUES ('Sarah Saurman', 'sarahsaurman@hotmail.com', '5 abbey road, athlone','full', 'beginner');


select * from customer;

CREATE TABLE classes (
Event VARCHAR (30) not null primary key,
teacher varchar(30) not null,
StartDate  DATETIME NOT NULL


);

SELECT 'INSERTING DATA INTO DATABASE' as 'INFO';

INSERT INTO classes VALUES ('Aqua Aerobics', 'Marion Kilmartin', '2020-03-03 17:00:00');
INSERT INTO classes VALUES ('Speed Training', 'Orla Thornton','2020-03-05 11:00:00' );
INSERT INTO classes VALUES ('kids swimming lessons', 'Orla Thornton','2020-03-07 15:00:00' );
INSERT INTO classes VALUES ('Adult swimming lessons', 'Marion Kilmartin','2020-03-08 20:00:00' );
INSERT INTO classes VALUES ('Seniors keep fit', 'Orla Thornton','2020-03-06 11:00:00' );

select * from classes;




    
     
	

