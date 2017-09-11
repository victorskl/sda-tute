<html>
<head>
<title>USER - Spring Security Example</title>
</head>
<body>
	<h1>${message}</h1>
	
	Your Info:
	<ul>
		<li>${principal.name}</li>
		<li>${principal.authorities}</li>
	</ul>
	
	<hr />
	
	<a href="j_spring_security_logout">logout</a> | <a href="admin">admin</a>
</body>
</html>