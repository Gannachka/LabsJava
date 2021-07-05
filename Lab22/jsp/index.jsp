<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" import= "others.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<%
    String d = request.getServletContext().getInitParameter("doc-dir");
    ChoiseXXX ch = new ChoiseXXX(d, "docx");
    String ll = null;
    for (int i = 0; i < ch.listxxx.length; i++) {
        ll = ch.listxxx[i];
%>
<br />
<a href="Sss?file=<%=ll%>"> <%=ll%> </a>
<%}%>
<br><br>
<a href="Sss">SSS</a>


<form method="post" action="Sss1" enctype="multipart/form-data">
    Choose a file: <input type="file" name="file" />
    <input type="submit" value="Upload" />
</form>
</body>
</html>
