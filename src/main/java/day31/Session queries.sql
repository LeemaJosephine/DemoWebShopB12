create database student_DB;

use student_DB;

create table student_details( rno int unique auto_increment, student_name varchar(25), tamil int, english int, credits decimal(5,3));

alter table student_details auto_increment=100;

alter table student_details add others varchar(30);

alter table student_details drop others;

alter table student_details rename column credits to credit_score;

insert into student_details (student_name, tamil, english, credit_score) values ('Arun',70,70,'3.5');

insert into student_details (student_name, tamil, english, credit_score) values 
		('Akash',80,80,'4.5') , ('Arjun',60,60,'3.4'), ('Tina',67,56,'2.5') ;
        
insert into student_details (student_name, tamil, english, credit_score) values (null,70,70,'3.5');

Select * from student_details;
        
select * from student_details where student_name='Tina' AND rno=103;

select credit_score from student_details where student_name='Tina';

select max(english) from student_details;

select * from student_details where student_name='Tina';

select * from student_details order by english desc;

select * from student_details  where student_name is NULL;

select * from student_details where credit_score between '3.5' and '4.5';

select * from student_details where student_name LIKE 'A%';

select * from student_details where student_name like '_k%';

select rno, student_name from student_details;

update student_details set student_name='abc' where student_name is NULL;

delete from student_details where student_name='abc';

truncate table student_details;

drop table student_details;

Select * from demo_table;