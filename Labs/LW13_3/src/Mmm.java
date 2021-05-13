import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Mmm extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Mmm:doGet");
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String lastname2 = rq.getParameter("lastname2");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Mmm:doGet:firstname=" + firstname
                + "<br>Mmm:doGet:lastname= " + lastname
                + "<br>Mmm:doGet:lastname2= " + lastname2
                + "<br>Mmm:doGet:password= " + password
                + "<br>Mmm:doGet:sex= " + sex
                + "<br>Mmm:doGet:press= " + press
                + "</body>" + "</html>");
        pw.close();
    }
}
