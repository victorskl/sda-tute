package com.hibernate.activity1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

    public static void main(String[] args) {
        
        // Activity 1
        
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Employee.class);

        // Read the default configuration file hibernate. configuration.xml
        // If the name of the configuration file name is different it can be specified
        // in the constructor.
        config.configure();

        // Create database table - read the method description to understand the
        // parameters
        new SchemaExport(config).create(true, true);

        
        // Activity 2

        // Create a session factory and get a session from the factory
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.getCurrentSession();

        // Create a session
        session.beginTransaction();
        Employee alex = new Employee();
        alex.setEmpId(100);
        alex.setEmpName("Alice Green");

        // Save the data and commit
        session.save(alex);
        session.getTransaction().commit();
        
        
        // Activity 3: Retrieving records from a database table using Hibernate
        
        session = factory.getCurrentSession();
        session.beginTransaction();
        Query q = session.createQuery("from Employee");
        for (Object obj : q.list()) {
            Employee e = (Employee) obj;
            logger.info(e.getEmpId() + " " + e.getEmpName());
        }
        session.getTransaction().commit();
        
        
        // Activity 4: Updating records a database table using Hibernate

        session = factory.getCurrentSession();
        session.beginTransaction();
        Employee alexUpdate = (Employee) session.get(Employee.class, 100);
        alexUpdate.setEmpName("Alice Brown");
        session.merge(alexUpdate);
        session.getTransaction().commit();
        
        // read back the update
        session = factory.getCurrentSession();
        session.beginTransaction();
        Employee e = (Employee) session.get(Employee.class, 100);
        logger.info(e.getEmpId() + " " + e.getEmpName());
        session.getTransaction().commit();
        
        
        // Activity 5: Deleting records from a database table using Hibernate
        
        session = factory.getCurrentSession();
        session.beginTransaction();
        Employee emp = (Employee) session.get(Employee.class, 100);
        session.delete(emp);
        session.getTransaction().commit();
        
        // check the Employee table, should have 0 row now.
        session = factory.getCurrentSession();
        session.beginTransaction();        
        Query query = session.createQuery("from Employee");
        logger.info("Employee table has total: " + query.list().size() + " rows.");
        session.getTransaction().commit();
        
        
        // Activity 6: Design a complete database Schema
        //  will do it in the project.
        
        // Optional Activity: More on Hibernate Annotations
        //  these should be ok. Just read Hibernate documentation. May be do it in the project.
    }
    
    private final static Logger logger = LogManager.getLogger(TestEmployee.class);
}
