<%@ page language="java"   contentType="text/html;charset=ISO-8859-1"%> 
<%@ page import="jspclass.CBean "%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AS_i13</title>

</head>
<body>
	<%  HttpSession ss = request.getSession();%>
	<% if (ss.getAttribute(ss.getId()) == null) { %>
		<h1>Object CBean not initialized</h1>
	<%} else {%>
		<%CBean Cb = (CBean)ss.getAttribute(ss.getId());%>
		<br><%=request.getParameter("CBean")%> Value1 = <%=Cb.GetValue1()%>
		<br><%=request.getParameter("CBean")%> Value2 = <%=Cb.GetValue2()%>
		<br><%=request.getParameter("CBean")%> Value3 = <%=Cb.GetValue3()%>
	<%}%>
	<br><% flt.FltRequest frq = (flt.FltRequest)request;%> Filter1: <%=frq.GetAA()%>
</body>
</html>