package com.swen90007.example1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController {
    
    private String message;
    
    @Autowired
    private HelloService helloService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        helloService.doSomething(); // example use of the @Autowired helloService bean injection which its life-cycle is maintained by Spring IoC container.
        return new ModelAndView("welcomePage", "welcomeMessage", message);
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
