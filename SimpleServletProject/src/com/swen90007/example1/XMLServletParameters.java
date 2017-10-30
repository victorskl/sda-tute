package com.swen90007.example1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XMLServletParameters extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public XMLServletParameters() {
	super();
    }
    
    public void init() throws ServletException {
	//super.init();
	System.out.println("init method call...");
	super.init();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//super.service(request, response);
	System.out.println("service method call...");
	super.service(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// Activity 3.1 doGet()
	response.setContentType("text/html");
	System.out.println("Hello from GET method /xmlServletParameterspath");
	PrintWriter writer = response.getWriter();
	writer.println("<h3>[Activity 3] Hello from GET: [" + request.getParameter("userName") + "] [" + request.getParameter("passWord") + "] </h3>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	String userName = request.getParameter("userName");
	String passWord = request.getParameter("passWord");
	
	String initUserName = getServletConfig().getInitParameter("userName");
	String initPassWord = getServletConfig().getInitParameter("passWord");
	
	// Activity 3.2 doPost()
	response.setContentType("text/html");
	System.out.println("Hello from POST method /xmlServletParameterspath");
	PrintWriter writer = response.getWriter();
	writer.println("<h3>[Activity 3] Hello from POST: Your user name is: [" + userName + "], Your password is: [" + passWord + "]. </h3>");
	
	// Activity 4
	writer.println("<hr /> <h2>Activity 4 Result:</h2>");
	String helloMsg = "<h3>Hello World!</h3>";
	String errorMsg = "<h3>[ERROR] Username or password do not match!</h3>";
	if (userName.contentEquals(initUserName) && 
		passWord.contentEquals(initPassWord)) {
	    
	    writer.println(helloMsg);
	    
	    // Activity 5
	    //response.sendRedirect("success.jsp"); // uncomment this line for Activity 5
	} 
	else {
	    writer.println(errorMsg);
	    
	    // Extra experiment
	    //response.sendError(404);
	}
    }
}
