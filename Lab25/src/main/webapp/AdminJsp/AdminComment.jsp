<%--
  Created by IntelliJ IDEA.
  User: Chernobushka
  Date: 05.06.2021
  Time: 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border: solid black 1px;">
    <table>
        <tr>
            <td><form><p>Date: ${param.date}</p></form></td>
            <td><form action="/lab25/DeleteComment" method="post">
                <input type="hidden" name="id" value="${param.id}"/>
                <input type="hidden" name="role" value="admin"/>
                <input type="submit" value="Delete"/>
            </form></td>
        </tr>
    </table>
    <form method="post" action="/lab25/UpdateComment">
        <label>
            <input type="text" name="text" value="${param.text}"/>
        </label>
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" name="role" value="admin"/>
        <input type="submit" value="Update"/>
    </form>
</div>
</body>
</html>
