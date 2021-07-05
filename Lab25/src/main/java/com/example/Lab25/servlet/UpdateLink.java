package com.example.Lab25.servlet;

import com.example.Lab25.model.Link;
import com.example.Lab25.repository.LinkRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UpdateLink")
public class UpdateLink extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = request.getParameter("role");
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("id"));
        int plus = Integer.parseInt(request.getParameter("plus"));
        int minus = Integer.parseInt(request.getParameter("minus"));
        String updateScore = request.getParameter("updateScore");

        System.out.println("Role: " + role + " Url: " + url + " Description:" + description + " Id: " + id + " Plus: " + plus + " Minus: " + minus);

        if (updateScore.equals("plus"))
            plus++;
        if (updateScore.equals("minus"))
            minus++;

        Link link = new Link(id, url, description, plus, minus);

        if (link == null)
            System.out.println("link is null");

        try {
            LinkRepository.update(link);
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
