package com.swen90007.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swen90007.mvc.model.User;
import com.swen90007.mvc.service.LoginService;

@WebServlet("/loginController2")
public class LoginController2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws IOException, ServletException {

	String username = request.getParameter("username");
	String password = request.getParameter("password");

	LoginService loginService = new LoginService();
	boolean result = loginService.authenticate(username, password);

	if (result) {

	    // Activity 2.2
	    User user = loginService.getUserDetails(password);
	    request.setAttribute("user", user);
	    RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("success2.jsp");
	    dispatcher.forward(request, response);
	    
	} else {
	    response.sendRedirect("login2.jsp");
	}
    }
}
