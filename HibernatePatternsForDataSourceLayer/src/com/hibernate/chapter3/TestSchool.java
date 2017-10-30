package com.hibernate.chapter3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.chapter3.School;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestSchool {
    
    public static void main(String[] args) {
	
	// hibernate bootstrap
	AnnotationConfiguration config = new AnnotationConfiguration();
	config.addAnnotatedClass(School.class);
	config.configure();
	new SchemaExport(config).create(true, true);
	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();

	// persist domain model
	SchoolDetail annsDetail = new SchoolDetail();
	annsDetail.setPublicSchool(false);
	annsDetail.setSchooldAddress("101 washington DC");
	annsDetail.setStudentCount(300);

	School stanns = new School();
	stanns.setSchoolName("St Anns School");
	stanns.setSchoolDetail(annsDetail);

	session.save(stanns);

	session.getTransaction().commit();
    }
}
