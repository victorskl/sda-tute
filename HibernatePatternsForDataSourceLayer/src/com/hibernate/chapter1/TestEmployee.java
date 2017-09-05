package com.hibernate.chapter1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

    public static void main(String[] args) {
	AnnotationConfiguration config = new AnnotationConfiguration();
	config.addAnnotatedClass(Employee.class);
	config.configure();

	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();

	session.beginTransaction();

	new SchemaExport(config).create(true, true);
	Employee alice = new Employee();
	// alex.setEmpId(100);
	alice.setEmpName("Alice Green");
	alice.setEmpEmailAddress("alice@hibernate.com");

	session.save(alice);

	session.getTransaction().commit();
    }
}
