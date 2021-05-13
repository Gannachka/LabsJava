//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class Ggg2 extends HttpServlet implements Servlet
//{
//    public Ggg2()
//    {
//        super();
//        System.out.println("Ggg2:constructor");
//    }
//
//    public void init(ServletConfig sc) throws ServletException
//    {
//        super.init();
//        System.out.println("Ggg2:init");
//    }
//
//    public void destroy()
//    {
//        super.destroy();
//        System.out.println("Ggg2:destroy");
//    }
//
//
//    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
//            throws ServletException, IOException {
//        System.out.println("Ggg2:doGet");
//        String firstname = rq.getParameter("firstname");
//        String lastname = rq.getParameter("lastname");
//        String lastname2 = rq.getParameter("lastname2");
//        String password = rq.getParameter("password");
//        String sex = rq.getParameter("sex");
//        String press = rq.getParameter("press");
//        rs.setContentType("text/html");
//        PrintWriter pw = rs.getWriter();
//        pw.println(
//                  "<br>Ggg2:doGet:firstname=" + firstname
//                + "<br>Ggg2:doGet:lastname= " + lastname
//                + "<br>Ggg2:doGet:lastname2= " + lastname2
//                + "<br>Ggg2:doGet:password= " + password
//                + "<br>Ggg2:doGet:sex= " + sex
//                + "<br>Ggg2:doGet:press= " + press);
//        pw.close();
//    }
//
//    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
//            throws ServletException, IOException {
//        System.out.println("Ggg2:doPost");
//        String firstname = rq.getParameter("firstname");
//        String lastname = rq.getParameter("lastname");
//        String lastname2 = rq.getParameter("lastname2");
//        String password = rq.getParameter("password");
//        String sex = rq.getParameter("sex");
//        String press = rq.getParameter("press");
//        rs.setContentType("text/html");
//        PrintWriter pw = rs.getWriter();
//        pw.println(
//                        "<br>Ggg2:doPost:firstname=" + firstname
//                        + "<br>Ggg2:doPost:lastname= " + lastname
//                        + "<br>Ggg2:doPost:lastname2= " + lastname2
//                        + "<br>Ggg2:doPost:password= " + password
//                        + "<br>Ggg2:doPost:sex= " + sex
//                        + "<br>Ggg2:doPost:press= " + press);
//        pw.close();
//    }
//}