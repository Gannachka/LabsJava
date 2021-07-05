package com.example.Lab25.servlet;

import com.example.Lab25.model.Link;
import com.example.Lab25.repository.LinkRepository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FilterLinks")
public class    FilterLink extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String role = request.getParameter("role");
        String filter = request.getParameter("filter");

        if (filter == null)
            filter = "";

        LinkRepository.filter = filter;

        if (role.equals("admin"))
            response.sendRedirect("http://localhost:8080/lab25/AdminJsp/AdminPage.jsp");
        else if (role.equals("user"))
            response.sendRedirect("http://localhost:8080/lab25/UserJsp/UserPage.jsp");
    }

}
