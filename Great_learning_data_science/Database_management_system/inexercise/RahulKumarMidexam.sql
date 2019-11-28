
use HR;
show tables ;

/*1.A) Display the first name, last name, department number, and department name for each employee*/
select e.first_name,e.last_name,e.department_id from employees e;

/*
1.B)Display the first name, last name, department number, and department name,
# for all employees whose department_id is 80 or 40 and arrange it in ascending order based on last name? */
select e.first_name,e.last_name,e.department_id,d.department_name from employees e join departments d on e.department_id = d.department_id
where d.department_id in(80,40) order by e.last_name desc ;


/* 1.c)
   Display the list of employees where their name starts with “z” &
 display the following: First name, last name, department, city, and state province.*/
select ed.first_name,ed.last_name,ed.department_name,ed.city,ed.state_province from emp_details_view ed where ed.first_name
like 'z%';



/*1.D)
 List out all employees and their managers with first name including who are not working under any manager?
 */

select b.first_name ,e.employee_id,e.first_name as 'manager_first_name' from employees e,employees b where e.employee_id=b.manager_id;





/*
 1.E
 List out the department names with an employee salary greater than 10,000
 */
select d.department_name from employees e join departments d on e.department_id = d.department_id where e.salary>10000
group by d.department_id ;

/*
 2.A) Display the name of the physicians who are not specialized physicians.(5 Marks)
 */
#select p.name  from physician where substr(p.position,length(p.position)-8)!='Physician';
select p.name  from physician p join tranined_in t on p.employeeid not in (t.physician);
/*
 2.B)
 Find the name of the nurses and the room scheduled, where they will assist the physicians.
 */
select n.name,a.examinationroom from nurse n join appointment a on n.employeeid=a.prenurse;

/*
 3.A)
 List the employee_id, first name and hire date of employees who are retiring as they completed more than 20Years
 */
select e.employee_id,e.first_name , e.hire_date from employees e where (datediff(current_date,e.hire_date)/365)>20;

/*
 3.B)
 List out the employee who earns 2nd highest salary without using ‘limit’ function
 */

select e1.employee_id,e1.first_name  from employees e1 where e1.salary =(
select max(e.salary) from employees e
where salary!=(select max(salary) from employees));

/*
3.c) List out in which departments more than 5 employees are working
 */

select e.department_id,count(e.employee_id)  total_emp from employees e group by e.department_id having total_emp >5;




















