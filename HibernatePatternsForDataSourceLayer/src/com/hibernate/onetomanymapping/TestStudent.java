package com.hibernate.onetomanymapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestStudent {
    
    public static void main(String[] args) {
	
	// hibernate bootstrap
	AnnotationConfiguration config = new AnnotationConfiguration();
	config.addAnnotatedClass(College.class);
	config.addAnnotatedClass(Student.class);
	config.configure();
	new SchemaExport(config).create(true, true);
	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	
	// persist domain model
	College college1 = new College();
	college1.setCollegeName("New York College");
	
	Student s1 = new Student();
	s1.setStudentName("Alex Rod");
	
	Student s2 = new Student();
	s2.setStudentName("Linda Berry");
	
	s1.setCollege(college1);
	s2.setCollege(college1);
	
	session.save(college1);
	session.save(s1);
	session.save(s2);
	
	session.getTransaction().commit();
    }
}
