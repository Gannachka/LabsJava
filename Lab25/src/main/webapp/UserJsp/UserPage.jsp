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
    <title>User Page</title>
</head>
<body>
    <h1>--UWSR/User--</h1>
    <a href="/lab25/AdminJsp/AdminPage.jsp">Admin Menu</a>
    <form action="/lab25/FilterLinks" method="get">
        <label>
            Search: <input type="text" name="filter" value="${LinkRepository.filter}"/>
        </label>
        <input type="hidden" name="role" value="user"/>
        <input type="submit" value="Search"/>
    </form>

    <c:forEach var="link" items="${LinkRepository.filterSelectAll(LinkRepository.filter)}">
        <tr>
            <jsp:include page="UserLink.jsp">
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
