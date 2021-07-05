<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>FORM login</title>
</head>
<body>
<div>
	<form method="post" action="j_security_check">
		<h3>username</h3> <input  type="text" name="j_username" />
		<h3>password</h3> <input  type="password" name="j_password" />
		<input type="submit" value="OK"/>
	</form>
</div>
</body>
</html>

