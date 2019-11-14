select  null >null;
select  null>5;
select 5>5;
select  10+30 as "sum";

select  * from employees where salary>5000 and salary <250000;
select * from employees where  salary between  5000 and 25000;

#wild card operators -pattern matching.
select * from employees where ename='N%';
select * from employees where ename='%H';
select * from employees where ename LIKE 'R%';

#DEP NAME TECH DEPID 10 SALARY >100  AND NAME START WITH N
SELECT  * FROM employees WHERE  depit=10 AND ename LIKE 'N%' AND salary>2500;

#dep number 10 or 30 or age should be 80

# bodmas rule in math and precedence rule in sql - in this query (depit=20 and age=18) will be treated first and  then or operator.
select  * from employees where depit =10 or depit=20 and age=18;
SELECT  * FROM employees WHERE  salary LIKE '2%';

#constraints-not null,nuique,default value,check (gender M/F/MA),primary key,foreign key
select * from  employees;







use mysql;
#default
#primary key
#foreign key
#check
#unique
#nit null

alter table  employees1 add constraint deptno int check (deptno in(10,20,30,40));

create  table  employees1
    (empid int primary key  unique ,
    ename varchar(20) not null ,
    salary int,
    deptno int ,
    deptname varchar(20),
   constraint f1 foreign key (deptno) references dept(deptno)
    on update  cascade on delete no action );
#on update cascade on delete set null
create table dept
(deptno int primary key ,
deptname varchar(20) not null unique );



insert into dept
values (10,'sales');
insert  into dept
values (20,'Marketing');
insert into dept
values (30,'Finanance');
insert into dept
values (40,'Analytics');


insert into employees1 values
(101,'Namrata',2000,10,'sales');
insert into employees1 values
(102,'Ritika',2300,20,'marketing');
show  databases ;
use information_schema;
show  tables ;


desc  TABLE_CONSTRAINTS;
select  * from TABLE_CONSTRAINTS
where TABLE_NAME='dept';

select * from TABLE_CONSTRAINTS
where TABLE_NAME='employees1';

use mysql;
drop table dept;
drop table employees1

#cascade will communicate with child table

use mysql;
update dept
set deptno =80
where deptno=10;


delete  from dept
where  deptno=20;





use mysql;
create  table  tab1
(sno int,phone varchar(10) default 'N/A');
insert into tab1 values(1,'983443');
insert into tab1 values(2,'983443');
insert into tab1 (sno)values (3); #sno is column name

select  * from tab1;
# create a table with two composite key


create  table dummy1(
    empid int,
    email varchar(20),
    ename varchar(30),
    primary key (empid,email)
);
#salary Decimal(5,2)
#Date '2019-09-2019'
#Datetime '2019-08-01 hh:mm:ss'
#Timestamp '20190801342344'
drop  table  mysql.tab1;
create  table tab1(
    sno char
);
create  table  tab2(
    sno varchar(20)
);

insert into tab1 values ('a');
insert into tab2 values ('dagg');





#constraints,create,where,ddl,order by,show


create table  tab3(
    sno int
);
create table tab4(
    sno int
);

insert into  tab3 values (1);
insert into  tab3 values (2);
insert into  tab3 values (3);
insert into  tab3 values (4);


insert into  tab4 values (1);
insert into  tab4 values (2);
insert into  tab4 values (3);
insert into  tab4 values (4);
insert into  tab4 values (5);
insert into tab3 values (1);
insert into  tab4 values (1);
insert into  tab4 values (1);



select  t3.sno,t4.sno
from  tab3 t3
inner  join  tab4 t4  on t3.sno=t4.sno;

select  t3.sno,t4.sno
from  tab3 t3,tab4 t4 where  t3.sno=t4.sno;


select  * from tab3;
select * from tab4;

select  * from tab3 z right outer join  tab4 t on z.sno = t.sno;


select count(employees.employee_id),first_name from HR.employees;


#Day 3
use HR;
select  * from employees;
select * from departments where location_id='1700';
select * from locations;

#Find all the department who works on 1700 location and number of employees

select l.location_id,d.department_id,count(employees.employee_id)
from employees join  departments d on employees.department_id = d.department_id join locations l on d.location_id = l.location_id
group by l.location_id, d.department_id having l.location_id=1700;
#Find all the department who works on 1700 location and number of employees -2nd method
select d.location_id,d.department_id, count(e.employee_id)
from employees e join departments d on e.department_id = d.department_id group by location_id,d.department_id
having location_id=1700;




use HR;
select department_id,job_id from employees
group by department_id;

select * from employees where department_id=30;