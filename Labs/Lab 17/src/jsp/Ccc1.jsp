<%@ page language="java" contentType="text/html; ISO-8859-1" %>
<%@page import="classes.CBean" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lab 16</title>
</head>
<body>
    <%HttpSession session1=request.getSession();
      CBean cBean=(CBean)session1.getAttribute(session1.getId());  %>
    <br>Value1=<%=cBean.getValue1()%>
    <br>Value2=<%=cBean.getValue2()%>
    <br>Value3=<%=cBean.getValue3()%>
</body>
</html>