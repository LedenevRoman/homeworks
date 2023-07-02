use tmp;
select department_id,
	count(*) as cnt,
    max(salary) as max_salary
from employee
group by department_id
having max(salary) < 500000;

use hr;
select t1.first_name,
		t1.last_name,
        t1.salary
from employees t1
inner join (
		select department_id,
			max(salary) as max_salary
        from employees
        group by department_id
) t2
on t1.department_id = t2.department_id
and t1.salary = t2.max_salary;

select t1.first_name,
		t1.last_name,
        t1.salary,
        t1.department_id
from employees t1
inner join (
		select department_id,
			avg(salary) as avg_salary
        from employees
        group by department_id
) t2
on t1.department_id = t2.department_id
where t1.salary <= t2.avg_salary;

select t1.department_name,
		t2.cnt
from departments t1
inner join (
	select department_id,
		count(*) as cnt
    from employees
    group by department_id
    ) t2
on t1.department_id = t2.department_id;

use tmp;

select * from tasks;
select * from employee;

select t1.name,
		t1.lastname,
        t1.salary + coalesce(t2.sum_payment, 0) as total_payment,
        CASE
			when t2.sum_payment is null
				then 0
			else t2.sum_payment
        END as sum_payment
from employee t1
left join (
			select employee_id,
            sum(payment) as sum_payment
            from tasks
			where done_flg = 1
            group by employee_id
            ) t2
on t1.id = t2.employee_id;

		select manager_id,
			count(*) as cnt
		from employee
		group by manager_id;

select name, lastname
from employee t1
inner join (
		select manager_id,
			count(*) as cnt
		from employee
		group by manager_id
) t2
on t1.id = t2.manager_id
where t2.cnt > 2;

use hr;

select * from employees;

SELECT 
    employees.first_name,
    employees.last_name,
    departments.department_name
FROM employees
	INNER JOIN
    departments ON employees.department_id = departments.department_id;
    
select 
		t1.department_name, t2.first_name, t2.last_name
from departments t1
inner join employees t2 on t1.manager_id = t2.employee_id;

-- вывести имя и фамилию сотрудников, которые в подчинении данного менеджера
select 
		t1.department_name, t2.first_name as manager_first_name, t2.last_name as manager_last_name, t3.first_name, t3.last_name
from departments t1
left join employees t2 on t1.manager_id = t2.employee_id
left join employees t3 on t2.employee_id = t3.manager_id;

-- используя employees вывести имя и фамилию сотрудников и имя и фамилию их менеджеров
select 
		t1.first_name, 
        t1.last_name, 
        t2.first_name as manager_first_name, 
        t2.last_name as manager_last_name
from employees t1
left join employees t2 on t1.manager_id = t2.employee_id
where t1.salary > t2.salary;

-- найти сотрудников, у которых зп больше зарплаты их менеджера
select 
		t1.first_name, 
        t1.last_name, 
        t2.first_name as manager_first_name, 
        t2.last_name as manager_last_name
from employees t1
inner join employees t2 on t1.manager_id = t2.employee_id
where t1.salary > t2.salary;

use homework;

select 
	gender, avg(age)
from customers
group by gender;

select name, lastname
from customers
order by age desc
limit 1;

select name, lastname
from customers
where age = (select max(age)
			from customers
            where gender = 'm')
and gender = 'm';

select 
		t1.name, 
        t1.lastname,
        t2.id as order_id
from customers t1
left join orders t2 on t1.id = t2.customerid;

-- найти кол-во заказов сделаных мужчинами и женщинами поля gender и cnt
select 
		t1.gender,
        count(*) as order_count
from customers t1
inner join orders t2
on t1.id = t2.customerid
group by t1.gender;

select 
		count(*) as count,
        ordertype
from orders
group by ordertype;

-- вывести имя и фамилию покупателей у которых есть хотя бы один онлайн заказ
select distinct
	t1.name,
	t1.lastname
from customers t1
inner join orders t2
on t1.id = t2.customerid
where t2.ordertype = 'online';

SELECT
 customerid,
 count(
  case 
   when t2.ordertype = 'online'
    then 1
  end
 ) as tmp
FROM customers t1
inner join orders t2
on t1.id = t2.customerid
group by customerid;
