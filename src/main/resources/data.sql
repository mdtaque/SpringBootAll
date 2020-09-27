/*data should be inserted in the order of the column created in h2 db*/
-- insert into Employee values (101, '10-15-1980', 'John Wick');
-- insert into Employee values (102, '08-22-1990', 'Renold');
-- insert into Employee values (103, '11-12-1989', 'Stuart');
-- insert into Employee values (104, '07-25-1960', 'Robert');
-- insert into Employee values (105, '02-11-1999', 'Fredrick');

/*can we insert data automatically for AWS RDS database*/

insert into employee (id,name,salary) values (101, 'data.sql-1', 1000);
insert into employee (id,name,salary) values (102, 'data.sql-2', 1100);
insert into employee (id,name,salary) values (103, 'data.sql-2', 1200);

