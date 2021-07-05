<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@ page language="java" pageEncoding="ISO-8859-1" import= "java.util.*"  %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lab 16</title>
</head>
<body>
<%ServletContext sc = config.getServletContext();
    Enumeration en = sc.getInitParameterNames();
    String x;
    while (en.hasMoreElements()) {
        x = (String) en.nextElement(); %>
<br /><%=x+"="%><%=sc.getInitParameter(x)%>
<%}%>

</body>
</html>