package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ttt extends HttpServlet {

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        PrintWriter pw = res.getWriter();
        if(req.getParameter("URLn").equals("1")) {
            res.sendRedirect(req.getServletContext().getInitParameter("URL1"));
        }else if(req.getParameter("URLn").equals("2")) {
            res.sendRedirect(req.getServletContext().getInitParameter("URL2"));
        }else {
            pw.println("parameter URLn not found");
        }
        pw.close();
    }
}
