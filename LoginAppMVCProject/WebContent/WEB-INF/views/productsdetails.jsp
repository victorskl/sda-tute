<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products Details</title>
</head>
<body>
	<h3><c:out value="${category}" /></h3>
	<c:forEach var="p" items="${products}">
		<ul>
			<li><c:out value="${p.name}" /></li>
			<li><c:out value="${p.price}" /></li>
		</ul>
	</c:forEach>
</body>
</html>