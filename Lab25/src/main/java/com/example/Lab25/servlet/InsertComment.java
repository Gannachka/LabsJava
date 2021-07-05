package com.example.Lab25.servlet;

import com.example.Lab25.model.Comment;
import com.example.Lab25.repository.CommentRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InsertComment")
public class InsertComment extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = request.getParameter("role");
        String text = request.getParameter("text");
        String author = request.getParameter("author");
        int linkId = Integer.parseInt(request.getParameter("linkId"));

        Comment comment = new Comment();
        comment.setLinkId(linkId);
        comment.setText(text);
        comment.setAuthor(author);
        comment.setSessionId(request.getSession().getId());

        CommentRepository.insert(comment);

        if (role.equals("admin"))
            response.sendRedirect("http://localhost:8080/lab25/AdminJsp/AdminPage.jsp");
        else if (role.equals("user"))
            response.sendRedirect("http://localhost:8080/lab25/UserJsp/UserPage.jsp");

    }
}
