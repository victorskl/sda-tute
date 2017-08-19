package com.swen90007.example1;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Activity 4.7: 
 * 
 * Code-based approach: Instead of the web.xml, the Dispatcher Servlet can be 
 * initialised by using AppInitializer which is a class that implements WebApplicationInitializer 
 * interface. Try to figure out how to use WebApplicationInitializer in your application.
 * 
 * Examples from
 * 
 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/WebApplicationInitializer.html
 * 
 * @author victorskl
 *
 */
public class AppInitializer implements WebApplicationInitializer {
    
    // Generally there are 3 different way to bootstrap the Spring container.
    // Only one should be active at a time. Use block comment to try one by one.


// ------ approach 1
    
    // Uncomment this if you want to try The traditional, XML-based approach at web.xml
    // Remember if you just go with web.xml, you don't even need this AppInitializer all together.
/*    
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        System.out.println("spring will still pick up during initialization");
        // Spring scan and auto-discover any WebApplicationInitializer
        // this shows that it can still use both web.xml and the use of Java code to initialize at the same time.
        // but this might be confusing. generally just pick one method to bootstrap the spring context.
        // since this is just for exercise purpose, I leave it here.
    }
*/


    
// ------ approach 2
    
    // The code-based approach with WebApplicationInitializer but still use of xml for Spring configuration.
    // REMEMBER!!! to comment out the dispatcher servlet configuration at web.xml
    // Otherwise, you are initializing the beans twice and get error.
/*
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        appContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.htm");     
    }
*/

    
// ------ approach 3
    
    // A 100% code-based approach to configuration i.e. without use of any xml configurations.
    // This approach has been the modern Spring usage. But the choice is yours!
    // To try this:
    //    Comment out the dispatcher servlet configuration at web.xml.
    //    Comment out all above methods.
    //    And uncomment out this.
    
    @Override
    public void onStartup(ServletContext container) {
      // Create the 'root' Spring application context
      AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
      rootContext.register(AppConfig.class);

      // Manage the lifecycle of the root application context
      container.addListener(new ContextLoaderListener(rootContext));

      // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(DispatcherConfig.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("*.htm");
    }


}
