package com.example.Lab25.servlet;

import com.example.Lab25.model.Link;
import com.example.Lab25.repository.LinkRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertLink extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getParameter("url");
        String description = request.getParameter("description");
        String role = request.getParameter("role");

        Link link = new Link(url, description, 0, 0);

        LinkRepository.insert(link);


        if (role.equals("admin"))
            response.sendRedirect("http://localhost:8080/lab25/AdminJsp/AdminPage.jsp");
        else if (role.equals("user"))
            response.sendRedirect("http://localhost:8080/lab25/UserJsp/UserPage.jsp");
    }
}
