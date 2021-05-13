import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;



public class Ppp extends HttpServlet implements Servlet {

    public void service(ServletRequest rq, ServletResponse rs) throws ServletException, IOException {
        super.service(rq,rs);
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Ppp:doGet");
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Ppp:doPost:firstname=" + firstname
                + "<br>Ppp:doPost:lastname= " + lastname
                + "<br>Ppp:doPost:password= " + password
                + "<br>Ppp:doPost:sex= " + sex
                + "<br>Ppp:doPost:press= " + press
                + "</body>" + "</html>");
        pw.close();
    }

//    protected void doPost(HttpServletRequest rq, HttpServletResponse
//            rs)
//            throws ServletException, IOException {
//        String firstname = rq.getParameter("firstname");
//        String lastname = rq.getParameter("lastname");
//        String password = rq.getParameter("password");
//        String sex = rq.getParameter("sex");
//        String press = rq.getParameter("press");
//        rs.setContentType("text/html");
//        PrintWriter pw = rs.getWriter();
//        pw.println("<html> " + "<body> "
//                + "<br>Ppp:doPost:firstname=" + firstname
//                + "<br>Ppp:doPost:lastname= " + lastname
//                + "<br>Ppp:doPost:password= " + password
//                + "<br>Ppp:doPost:sex= " + sex
//                + "<br>Ppp:doPost:press= " + press
//                + "</body>" + "</html>");
//        pw.close();
//    }
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("PPPPPP");
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        HttpClient hc = new HttpClient();
        GetMethod gm;
        String uri = "http://localhost:8080" + rq.getContextPath();
        if (press.equalsIgnoreCase("OK")) {
            String parmstr = "firstname=" + firstname + "&"
                    + "lastname=" + lastname;

            if (sex.equalsIgnoreCase("male"))
                uri += "/Ggg2?" + parmstr;
            else if (sex.equalsIgnoreCase("female"))
                uri += "/Ggg2?" + parmstr;
        } else
            uri += "/index.html";
        hc.executeMethod(gm = new GetMethod(uri));
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("Hello PPP");
        pw.println(gm.getResponseBodyAsString());
        pw.println("Hello PPP2");
        pw.flush();
    }

}
