package com.hibernate.chapter2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hibernate.chapter2.Customer;

public class TestCustomer {

    /**
     * @param args
     */
    public static void main(String[] args) {
	AnnotationConfiguration config = new AnnotationConfiguration();
	config.addAnnotatedClass(Customer.class);
	config.configure();

	new SchemaExport(config).create(true, true);

	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();

	Customer alex = new Customer();
	alex.setCustomerId(100);
	alex.setCustomerName("Alex Rod");
	alex.setCustomerAddress("101 Melbourne Victoria");
	alex.setCreditScore(780);
	alex.setRewardPoints(1200);

	session.beginTransaction();
	session.save(alex);

	Customer c = (Customer) session.get(Customer.class, 100);
	session.getTransaction().commit();
	System.out
		.println("ID " + c.getCustomerId() + " Name " + c.getCustomerName() + " Points " + c.getRewardPoints());
    }
}
