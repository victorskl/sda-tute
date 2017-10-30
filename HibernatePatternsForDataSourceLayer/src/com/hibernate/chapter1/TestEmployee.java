package com.hibernate.chapter1;

import java.util.Calendar;
import java.util.Date;

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
	alice.setEmpName("Alice Green");
	alice.setEmpEmailAddress("alice@hibernate.com");
	alice.setPermanent(true);
	
	Calendar cal = Calendar.getInstance();
	cal.set(2016, 6, 24, 8, 30);  // Because of @Temporal(TemporalType.DATE) mapping, time part will be discarded in DB.
	alice.setEmpJoinDate(cal);
	
	alice.setEmpLoginTime(new Date());  // map to @Temporal(TemporalType.TIMESTAMP)
	
	alice.setEmpPassword("mypass"); // this empPassword column won't generated or persisted as it marked as @Transient
	
	session.save(alice);
	session.getTransaction().commit();
    }
}
