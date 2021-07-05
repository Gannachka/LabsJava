<%@ page import="servlet.ChoiseXXX" %>
<%@ page language="java" contentType="text/html;charset=ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab_17</title>

</head>
<body>
<%
	String d = (String) config.getServletContext().getInitParameter("doc-dir");
	ChoiseXXX ch = new ChoiseXXX(d, "docx");
	String ll = null;
	for (int i = 0; i < ch.listxxx.length; i++) {
		ll = ch.listxxx[i];
%>
<br />
<a href="Sss?file=<%=ll%>"> <%=ll%> </a>
<%}%>

</body>
</html>