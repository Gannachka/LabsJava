<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import= "others.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>lab 23</title>
</head>
<body>
<h1>Task 1</h1>
<%
	String d = (String) getServletContext().getInitParameter("doc-dir");
	ChoiseXXX ch = new ChoiseXXX(d, "doc");
	String ll = null; 
	for (int i = 0; i < ch.listxxx.length; i++) {
	   ll = ch.listxxx[i];	
%>
<br />
<a href="Sss?file=<%=ll%>"> <%=ll%> </a> 
<%}%>

<br/>
<h1>Task 2</h1>
<form action="Sss" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" />
</form>

</body>
</html>
