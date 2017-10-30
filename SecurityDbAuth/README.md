# Workshop 7 - Week 8 
Spring Security

## Activity 3. Implementations of Authentication Providers

- Start Derby in network mode `startNetworkServer.bat`

- Connect it (and create `dbauth` database) using Eclipse [Database Development perspective][1]

```
	<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<property name="driverClassName" value="org.apache.derby.jdbc.ClientDriver" />
		<property name="url" value="jdbc:derby://localhost:1527/dbauth;create=true" />
		<property name="username" value="user" />
		<property name="password" value="123" />
	</bean>
```

- Open [`dbauth.sql`](dbauth.sql) script in Eclipse, select each SQL statement line and execute it (`Alt+X` in Eclipse on Windows)
- Make sure create the tables and insert the mock data
- And then run this project.

[1]: https://github.com/victorskl/sda-tute/blob/master/HibernateExamples/README.md