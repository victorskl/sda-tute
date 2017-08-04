<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.swen90007.mvc.service.ProductInformationService"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Categories</title>
</head>
<body>
	<h2>Product Categories</h2>
	<%
	    ProductInformationService pis = new ProductInformationService();
		List<String> types = pis.getProductTypes();
		pageContext.setAttribute("types", types);
	%>
	<ul>
		<c:forEach var="i" items="${types}">
			<li><a href="product.html?type=${i}"><c:out value="${i}" /></a></li>
		</c:forEach>
	</ul>
</body>
</html>