<%@ page import="com.swen90007.mvc.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
	<%
	    User user = (User) session.getAttribute("user");
	%>

	<h3>
		Welcome
		<%=user.getUserFullName()%>
		| Logging in was successful.
	</h3>

	The time is now
	<%=new java.util.Date()%>

	<hr />
	<h3>Session Info</h3>
	<ul>
		<li>Session ID: <%=session.getId()%></li>
	</ul>

	<h3>ServletContext Info</h3>
	<%
	    ServletContext cxt = session.getServletContext();
	%>
	<ul>
		<li>ContextPath: <%=cxt.getContextPath()%></li>
		<li>ContextName: <%=cxt.getServletContextName()%></li>
		<li>ServerInfo: <%=cxt.getServerInfo()%></li>
	</ul>

	<hr />

	<h3>jsp:useBean</h3>
	<!-- Scope can be: page, request, session or application -->
	<jsp:useBean id="u" class="com.swen90007.mvc.model.User" scope="page">
		<jsp:setProperty name="u" property="userFullName" value="Mr.Bean" />
		<jsp:setProperty name="u" property="password"
			value="Mr.Bean's Secret Passw0rd" />
	</jsp:useBean>

	<jsp:getProperty name="u" property="userFullName" />
	<br />
	<jsp:getProperty name="u" property="password" />

	<hr />
	<a href="login.jsp">Goto Login Page</a> |
	<a href="index.html">Goto Index Page</a> |
	<a href="products.jsp">Goto Products Page</a>


</body>
</html>