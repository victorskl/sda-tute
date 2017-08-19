package com.swen90007.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Check details use of @Configuration at API doc
 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/annotation/Configuration.html
 * 
 * Check details use of @Bean at API doc
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/annotation/Bean.html
 * 
 * @author victorskl
 *
 */
@Configuration
public class DispatcherConfig {
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    @Bean(name="/welcome.htm")
    public HelloWorldController controller() {
        HelloWorldController controller = new HelloWorldController();
        controller.setMessage("Hello World!");
        return controller;
    }
}
