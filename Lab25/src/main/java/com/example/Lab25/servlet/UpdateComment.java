package com.example.Lab25.servlet;

import com.example.Lab25.model.Comment;
import com.example.Lab25.repository.CommentRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateComment")
public class UpdateComment extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = request.getParameter("role");
        String text = request.getParameter("text");
        int id = Integer.parseInt(request.getParameter("id"));

        Comment comment = new Comment();
        comment.setText(text);
        comment.setId(id);
        System.out.println("id: " + id + " role: " + role);

        try {
            CommentRepository.update(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (role.equals("admin"))
            response.sendRedirect("http://localhost:8080/lab25/AdminJsp/AdminPage.jsp");
        else if (role.equals("user"))
            response.sendRedirect("http://localhost:8080/lab25/UserJsp/UserPage.jsp");
    }

}
