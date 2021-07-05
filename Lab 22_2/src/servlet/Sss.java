package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sss extends HttpServlet implements Servlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest rq,  HttpServletResponse rs)
            throws ServletException, IOException {
        HttpSession session=rq.getSession();
        session.invalidate();
        rs.sendRedirect("./jsp/login.jsp");


        System.out.println("Servlet:servlet.Sss");
    }
}
