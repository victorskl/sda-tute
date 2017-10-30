package com.hibernate.onetoonemapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPerson {

    public static void main(String[] args) {
	
	// hibernate bootstrap
	AnnotationConfiguration config = new AnnotationConfiguration();
	config.addAnnotatedClass(Person.class);
	config.addAnnotatedClass(PersonDetail.class);
	config.configure();
	new SchemaExport(config).create(true, true);
	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();

	// persist domain model
	PersonDetail alexDetail = new PersonDetail();
	alexDetail.setZipcode("20815");
	alexDetail.setJob("Accountant");
	alexDetail.setIncome(25000);

	Person alex = new Person();
	alex.setPersonId(100);
	alex.setPersonName("Alex Berry");
	alex.setpDetail(alexDetail);

	session.save(alex);

	Person p = (Person) session.get(Person.class, 100);

	System.out.println("ID " + p.getPersonId() + " Job " + p.getpDetail().getJob());

	session.getTransaction().commit();
    }
}
