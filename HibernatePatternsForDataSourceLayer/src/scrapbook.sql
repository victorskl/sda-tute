-- select each SQL line, right click > Execute Selected Text (or Alt+X)

select * from MY_SCHEMA.EMPLOYEEINFO;
select * from MY_SCHEMA.EMPPKTB;

select * from MY_SCHEMA.ACCOUNTS;

select * from MY_SCHEMA.CUSTOMER;
select * from MY_SCHEMA.CUSTOMERDETAILS;

select * from MY_SCHEMA.SCHOOL;

select * from MY_SCHEMA.PERSON;
select * from MY_SCHEMA.PERSONDETAIL
select * from MY_SCHEMA.PERSON as p inner join MY_SCHEMA.PERSONDETAIL as pd on pd.DETAILID_PK = p.PDETAIL_FK;

drop table MY_SCHEMA.hibernate_unique_key;
select * from MY_SCHEMA.COLLEGE;
select * from MY_SCHEMA.STUDENT;
select * from MY_SCHEMA.COLLEGE as c inner join MY_SCHEMA.STUDENT as s on s.COLLEGE_COLLEGEID = c.COLLEGEID;

select * from MY_SCHEMA.DELEGATE;
select * from MY_SCHEMA.EVENT
select * from MY_SCHEMA.JOIN_DELEGATE_EVENT;