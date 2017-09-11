<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ADMIN - Spring Security Example</title>
</head>
<body>
	<h1>${message}</h1>

	<table border="1">
		<tr>
			<th>USER_ID</th>
			<th>USERNAME</th>
			<th>PASSWORD</th>
			<th>ENABLED</th>
			<th>USER_ROLE_ID</th>
			<th>ROLE</th>
		</tr>
		<c:forEach var="dto" items="${dtos}">
			<tr>
				<td>${dto.userId}</td>
				<td>${dto.username}</td>
				<td>${dto.password}</td>
				<td>${dto.enabled}</td>
				<td>${dto.roleId}</td>
				<td>${dto.role}</td>
			</tr>
		</c:forEach>
	</table>

	<hr />

	<a href="j_spring_security_logout">logout</a> |
	<a href="welcome">welcome</a>
</body>
</html>