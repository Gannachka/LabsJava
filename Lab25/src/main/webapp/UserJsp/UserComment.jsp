<%--
  Created by IntelliJ IDEA.
  User: Chernobushka
  Date: 05.06.2021
  Time: 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Lab25.repository.CommentRepository" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <% CommentRepository.sessionId = request.getSession().getId(); %>

    <div style="border: solid black 1px;">
        <table>
            <tr>
                <td><form><p>Date: ${param.date}</p></form></td>
                <c:if test="${param.author.equals(CommentRepository.userName) && param.sessionId.equals(CommentRepository.sessionId)}">
                <td><form action="/lab25/DeleteComment" method="post">
                    <input type="hidden" name="id" value="${param.id}"/>
                    <input type="hidden" name="role" value="user"/>
                    <input type="submit" value="Delete"/>
                </form></td>
                </c:if>
            </tr>
        </table>
        <c:if test="${param.author.equals(CommentRepository.userName) && param.sessionId.equals(CommentRepository.sessionId)}">
            <form method="post" action="/lab25/UpdateComment">
                <label>
                    <input type="text" name="text" value="${param.text}"/>
                </label>
                <input type="hidden" name="id" value="${param.id}">
                <input type="hidden" name="role" value="user"/>
                <input type="submit" value="Update"/>
            </form>
        </c:if>

        <p>${param.text}</p>


    </div>
</head>
<body>

</body>
</html>
