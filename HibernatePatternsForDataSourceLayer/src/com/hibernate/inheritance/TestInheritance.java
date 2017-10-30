package com.hibernate.inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestInheritance {

    public static void main(String[] args) {
	
	// hibernate bootstap
	AnnotationConfiguration config = new AnnotationConfiguration();
	config.addAnnotatedClass(Project.class);
	config.addAnnotatedClass(Module.class);
	config.addAnnotatedClass(Task.class);
	config.configure();
	new SchemaExport(config).create(true, true);
	SessionFactory factory = config.buildSessionFactory();
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	
	// persist domain model
	Project project = new Project();
	project.setProjectId(1000);
	project.setProjectName("Project_1000");
	
	Module module = new Module();
	module.setModuleName("MODULE_01");
	module.setProjectId(1001);
	module.setProjectName("Project_1001");
	
	Task task = new Task();
	task.setTaskName("TASK_01");
	task.setModuleName("MODULE_02");
	task.setProjectId(1002);
	task.setProjectName("Project_1002");
	
	session.save(project);
	session.save(module);
	session.save(task);
	
	session.getTransaction().commit();
    }
}
