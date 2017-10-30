# Workshop 6 - Week 7

Patterns for Data-source Layer

- Integrating Hibernate and Spring Framework

- Required Derby running in Network mode with `sample` database as below:

```
	<bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource"
		destroy-method="close">
		<property name="driverClassName" value="org.apache.derby.jdbc.ClientDriver" />
		<property name="url" value="jdbc:derby://localhost:1527/sample;create=true" />
		<property name="username" value="user" />
		<property name="password" value="123" />
	</bean>
```

- Refer [HibernateExamples\README.md][1] on 
Database Development Perspective and Add **new Derby connection > New (Derby) Driver Definition** setup.

[1]: https://github.com/victorskl/sda-tute/blob/master/HibernateExamples/README.md