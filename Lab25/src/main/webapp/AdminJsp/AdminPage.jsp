<%@ page import="com.example.Lab25.repository.LinkRepository" %><%--
  Created by IntelliJ IDEA.
  User: Chernobushka
  Date: 30.05.2021
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
    <h1>--UWSR/Admin--</h1>
    <form action="/lab25/InsertLink" method="post">
        <label>
            Url: <input type="text" name="url"/>
        </label><br/>
        <label>
            Description: <input type="text" name="description">
        </label><br/>
        <input type="hidden" name="role" value="admin"/>
        <input type="submit" value="Add"/>
        <input type="reset" value="Cancel"/>
    </form>
    <form action="/lab25/FilterLinks" method="get">
        <label>
            Search: <input type="text" name="filter" value="${LinkRepository.filter}"/>
        </label>
        <input type="hidden" name="role" value="admin"/>
        <input type="submit" value="Search"/>
    </form>

    <c:forEach var="link" items="${LinkRepository.filterSelectAll(LinkRepository.filter)}">
        <tr>
            <jsp:include page="AdminLink.jsp">
                <jsp:param name="id" value="${link.getId()}"/>
                <jsp:param name="url" value="${link.getUrl()}"/>
                <jsp:param name="description" value="${link.getDescription()}"/>
                <jsp:param name="plus" value="${link.getPlus()}"/>
                <jsp:param name="minus" value="${link.getMinus()}"/>
            </jsp:include>
        </tr>
    </c:forEach>

</body>
</html>
