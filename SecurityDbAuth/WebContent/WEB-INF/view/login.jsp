<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<h3>Login</h3>

	<form action="j_spring_security_check" method="post">
	
		Username: <input type="text" name="j_username">
		<br />
		
		Password: <input type="password" name="j_password">
		<br />
		
		<input type="submit" value="Login">
		
	</form>

	<hr />
	
	<table border="1">
		<tr>
			<th>Username</th>
			<th>Password</th>
		</tr>
		<tr>
			<td>admin</td>
			<td>admin</td>
		<tr>
		<tr>
			<td>victor</td>
			<td>123</td>
		<tr>
		<tr>
			<td>alan</td>
			<td>123</td>
		<tr>		
	</table>

</body>
</html>