package com.swen90007.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    
    @Bean
    @Scope("singleton")
    public HelloService helloService() {
        return new HelloService();
    }
}
