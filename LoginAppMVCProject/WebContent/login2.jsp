<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login2</title>
</head>
<body>

	<h2>Activity 2.2 Using Request Dispatcher class</h2>

	<h3>Login2</h3>
	
	<p>You may enter any username and password you like. However, if you like to observe
	 	pre-defined username and password authentication, use the following.
	 </p>
	 
 	<ul>
		<li>Username: Joe Do</li>
 		<li>Passowrd: 1234</li>
 	</ul> 
	
	<form action="loginController2" method="post">
	
		Username: <input type="text" name="username">
		<br />
		
		Password: <input type="password" name="password">
		<br />
		
		<input type="submit" value="Login">
		
	</form>
	
	<hr />
	
	<a href="login.jsp">Goto Login</a>
	
</body>
</html>