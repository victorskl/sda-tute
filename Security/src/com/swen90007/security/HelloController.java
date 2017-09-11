package com.swen90007.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

    @RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
	model.addAttribute("message", "Welcome to your first Spring Security Example");
	return "Welcome";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
	return "loginPage";
    }
    
    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public String mypage(ModelMap model) {
	return "mypage";
    }
    
    @RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
    public String logout(ModelMap model) {
	return "logoutPage";
    }
}