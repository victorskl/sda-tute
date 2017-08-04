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
	    User user = (User) request.getAttribute("user");
	%>

	<h3>
		Welcome
		<%=user.getUserFullName()%>
		| Logging in was successful.
	</h3>

	The time is now
	<%=new java.util.Date()%>

	<hr />
	<a href="login.jsp">Goto Login Page</a> |
	<a href="index.html">Goto Index Page</a> |
	<a href="products.jsp">Goto Products Page</a>

</body>
</html>