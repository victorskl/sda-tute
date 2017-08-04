package com.swen90007.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.swen90007.mvc.model.User;
import com.swen90007.mvc.service.LoginService;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws IOException {

	String username = request.getParameter("username");
	String password = request.getParameter("password");

	LoginService loginService = new LoginService();
	boolean result = loginService.authenticate(username, password);

	if (result) {

	    // Activity 2.1
	    User user = loginService.getUserDetails(password);
	    //request.getSession().setAttribute("user", user);
	    
	    // Activity 3.1 - Using HTTPSession class to persist state across requests
	    HttpSession session = request.getSession();
	    session.setAttribute("user", user);
	    
	    // Activity 3.2 - Using ServletContext class to persist values across sessions
	    ServletContext context = request.getServletContext();
	    context.setAttribute("user", user);

	    // Activity 1
	    response.sendRedirect("success.jsp");

	} else {
	    response.sendRedirect("login.jsp");
	}
    }
}
