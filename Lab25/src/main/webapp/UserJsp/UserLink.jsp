<%--
  Created by IntelliJ IDEA.
  User: Chernobushka
  Date: 04.06.2021
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.Lab25.repository.CommentRepository" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="border: solid black;">
        <table>
            <tr>
                <td>
                    <form action="/lab25/UpdateLink" method="post">
                        <input type="hidden" name="id" value="${param.id}"/>
                        <input type="hidden" name="role" value="user"/>
                        <input type="hidden" name="plus" value="${param.plus}"/>
                        <input type="hidden" name="minus" value="${param.minus}"/>
                        <input type="hidden" name="url" value="${param.url}"/>
                        <input type="hidden" name="description" value="${param.description}"/>
                        <input type="hidden" name="updateScore" value="plus"/>
                        <input type="submit" value="+${param.plus}"/>
                    </form>
                </td>
                <td>
                    <form action="/lab25/UpdateLink" method="post">
                        <input type="hidden" name="id" value="${param.id}"/>
                        <input type="hidden" name="role" value="user"/>
                        <input type="hidden" name="plus" value="${param.plus}"/>
                        <input type="hidden" name="minus" value="${param.minus}"/>
                        <input type="hidden" name="url" value="${param.url}"/>
                        <input type="hidden" name="description" value="${param.description}"/>
                        <input type="hidden" name="updateScore" value="minus"/>
                        <input type="submit" value="-${param.minus}"/>
                    </form>
                </td>
                <td><form><input type="button" id="showComments${param.id}" value="Comments"/></form></td>
                <td><form>[${param.id}] <a href="${param.url}">${param.description}</a></form></td>
            </tr>
        </table>
        <div id="commentsDiv${param.id}" style="display: none;">
            <p>Comments:</p>
            <form method="post" action="/lab25/InsertComment">
                <input type="hidden" name="role" value="user"/>
                <input type="hidden" name="author" value="user"/>
                <input type="hidden" name="linkId" value="${param.id}"/>
                <input type="text" name="text"/>
                <input type="submit" value="Add"/>
            </form>

            <c:forEach var="comment" items="${CommentRepository.selectAll(param.id.toString())}">
                <jsp:include page="UserComment.jsp">
                    <jsp:param name="id" value="${comment.getId()}"/>
                    <jsp:param name="text" value="${comment.getText()}"/>
                    <jsp:param name="date" value="${comment.getDate()}"/>
                    <jsp:param name="author" value="${comment.getAuthor()}"/>
                    <jsp:param name="sessionId" value="${comment.getSessionId()}"/>
                </jsp:include>
            </c:forEach>
        </div>


        <script>
            let isVisible${param.id} = false;
            let isCommentsVisible${param.id} = false;
            document.getElementById('showComments${param.id}').addEventListener('click', showComments);

            function showComments(event) {
                if (!isCommentsVisible${param.id}) {
                    document.getElementById("commentsDiv${param.id}").style.display = "block";
                    isCommentsVisible${param.id} = true;
                } else if (isCommentsVisible${param.id}) {
                    document.getElementById("commentsDiv${param.id}").style.display = "none";
                    isCommentsVisible${param.id} = false;
                }
            }
        </script>
    </div>
</body>
</html>
