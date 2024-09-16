create table person(
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);


INSERT INTO PERSON(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(10001,'RANGA','Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());


--create table people(
--id integer not null,
--name varchar(255) not null,
--location varchar(255),
--birth_date timestamp,
--primary key(id)
--);
--INSERT INTO PEOPLE(ID,NAME,LOCATION,BIRTH_DATE)
--VALUES(20001,'RANGA','Hyderabad',sysdate());
--INSERT INTO PEOPLE (ID, NAME, LOCATION, BIRTH_DATE )
--VALUES(20002,  'James', 'New York',sysdate());
--INSERT INTO PEOPLE (ID, NAME, LOCATION, BIRTH_DATE )
--VALUES(20003,  'Pieter', 'Amsterdam',sysdate());


