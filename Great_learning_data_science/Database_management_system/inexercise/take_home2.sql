use HR;
show  tables ;
select * from departments;
select  department_name from departments where manager_id=NULL;

select departments.department_name,manager_id from departments where manager_id=null;

#1.	List all IT related departments where there are no managers .(2 rows)[NOTE:DEPARTMENT TABLE]
select * from departments where substring(department_name,1,2) = 'IT' and manager_id is null;

#2.	Print a bonafide certificate for an employee (say for emp. id 123) as below:
#"This is to certify that <full name> with employee id <emp. id> is working as <job id> in dept. <dept ID>. (1 ROW)
#[NOTE : EMPLOYEES table].


select concat("This is to certify that " ,employees.first_name," ",last_name," with employee id ",employee_id,"
 is working as", job_id," in dept. ",department_id) from employees;

#3.	Write a  query to display the  employee id, salary & salary range of employees as 'Tier1', 'Tier2' or 'Tier3' as
# per the range <5000, 5000-10000, >10000 respectively,ordering the output by those tiers.(107 ROWS)[NOTE :EMPLOYEES TABLE]

select employees.employee_id,employees.salary, case
when employees.salary< 5000 then 'Tier1'
when employees.salary between 5000 and 10000 then 'Tier2'
when employees.salary >10000 then 'Tier3'
end as Tier from employees;


#4.	Write a query to display the department-wise and job-id-wise
#total  salaries of employees whose salary is more than 25000.(8 rows) [NOTE : EMPLOYEES TABLE]
select  employees.department_id,job_id,sum(employees.salary) as total_salry from employees group by department_id,job_id having total_salry>25000 ;

#5.	Write a query to display names of employees whose first name as well as last name ends with vowels.  (vowels : aeiou )
#(5 rows) [NOTE : EMPLOYEES TABLE]
select employees.first_name,employees.last_name from employees where substring(first_name,length(first_name),1)in ('a','e','i','o','u')
and substring(last_name,length(last_name),1)in ('a','e','i','o','u');


#6.	What is the average salary range (diff. between min & max salary) of all types 'Manager's and 'Clerk's.
 #(2 rows)[NOTE : JOBS TABLE]
select job_id ,max(jobs.max_salary)-min(jobs.min_salary) as average_salry from jobs group by job_id  having substring(job_id,4)
                                                                                                                in('MGR','CLERK');

#7.	Show location id and cities of US or UK whose city name starts from 'S' but not from 'South'.
#(2 rows)[NOTE : LOCATION TABLE]
use orders;
select * from ADDRESS where  COUNTRY in ('US','UK');

#8.	Write a query to display the all the records of customers whose creation date is before ’12-Jan-2006’ and email address contains ‘gmail’ or ‘yahoo’ and user name starts with ‘dave’.
#(2 ROWS)[NOTE : ONLINE_CUSTOMER TABLE]
select * from ONLINE_CUSTOMER where CUSTOMER_CREATION_DATE<'2006-01-12' and (CUSTOMER_EMAIL like '%gmail%' or CUSTOMER_EMAIL like
                                                                                                             '%yahoo%');

#9.	Write query to display the product id,product_description and total worth(product_price * product_quantity available)
# of each product.(60 rows)[NOTE : PRODUCT TABLE]
select PRODUCT.PRODUCT_ID,PRODUCT.PRODUCT_DESC ,PRODUCT.PRODUCT_PRICE*PRODUCT.PRODUCT_QUANTITY_AVAIL as total_worth from PRODUCT;


#10.	Write a query to Display details of customer who have Gmail account and phone number consist of ‘77’ as below:
 # <Customer full name> (<customer user name>) created on <date>. Contact Phone: <Phone no.> E-mail: <E-mail id>.
#(6 rows)[NOTE : ONLINE_CUSTOMER TABLE]

select * from ONLINE_CUSTOMER where CUSTOMER_EMAIL like '%gmail%' and CUSTOMER_PHONE like '%77%';


#11.	Write a query to Show the count of cities in all countries other than US & UK, with more than 1 city,
# in the descending  order of country id.
 #(4 rows)[NOTE : LOCATION TABLE]

select distinct  ADDRESS.COUNTRY from ADDRESS;







