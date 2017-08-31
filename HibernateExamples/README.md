# Workshop 5 - Week 6 

Object to Relational Mapping (ORM) with Hibernate

### Start Derby in network mode

```
(on Mac)

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/
cd db-derby-10.13.1.1-bin
cd bin
bash startNetworkServer
```

Follow tute note 4.1 for Connecting from Eclipse and working in Database Development Perspective.

### Example output

Run `TestEmployee`.

```
drop table MY_SCHEMA.Employee
create table MY_SCHEMA.Employee (empId integer not null, empName varchar(255), primary key (empId))
Hibernate: insert into MY_SCHEMA.Employee (empName, empId) values (?, ?)
Hibernate: select employee0_.empId as empId0_, employee0_.empName as empName0_ from MY_SCHEMA.Employee employee0_
100 Alice Green
Hibernate: select employee0_.empId as empId0_0_, employee0_.empName as empName0_0_ from MY_SCHEMA.Employee employee0_ where employee0_.empId=?
Hibernate: update MY_SCHEMA.Employee set empName=? where empId=?
Hibernate: select employee0_.empId as empId0_0_, employee0_.empName as empName0_0_ from MY_SCHEMA.Employee employee0_ where employee0_.empId=?
100 Alice Brown
Hibernate: select employee0_.empId as empId0_0_, employee0_.empName as empName0_0_ from MY_SCHEMA.Employee employee0_ where employee0_.empId=?
Hibernate: delete from MY_SCHEMA.Employee where empId=?
Hibernate: select employee0_.empId as empId0_, employee0_.empName as empName0_ from MY_SCHEMA.Employee employee0_
Employee table has total: 0 rows.
```

## Activity 1: Create a database table

Q1. How do you tell Hibernate which classes are persisted?

ANS: `@Entity` annotation.

Q2. Which line of code allows Hibernate to understand how to access the underlying database?

ANS: `config.configure();` allows Hibernate to read its configuration `hibernate.cfg.xml` from classpath.

Q3. Which line of code connects to the underlying database and generates the various tables?

ANS: `new SchemaExport(config).create(true, true);`

## Activity 2: Insert records to a database table

(a) What is a transient instance?

ANS: An attribute that won't get into database persisting.

(b) How do you create a session?

ANS: With Hibernate, using `SessionFactory.getCurrentSession();`

(c) What steps are involved in saving an instance?

ANS: Get the current session, start new transaction, create new `Employee` instance in memory and set necessary attributes, save the in-memory object into (database) session object, and commit the transaction to persist the object inside database.


