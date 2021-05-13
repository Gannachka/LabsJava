//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//public class SssGgg extends HttpServlet implements Servlet{
//    @Override
//    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        System.out.println("SssGgg:doGet");
//        String firstname = rq.getParameter("firstname");
//        String lastname = rq.getParameter("lastname");
//        String lastname2 = rq.getParameter("lastname2");
//        String password = rq.getParameter("password");
//        String sex = rq.getParameter("sex");
//        String press = rq.getParameter("press");
////        rs.setContentType("text/html");
//        PrintWriter pw = rs.getWriter();
//        pw.print(
//                "<br>SssGgg2:doGet:firstname=" + firstname
//                + "<br>SssGgg:doGet:lastname= " + lastname
//                + "<br>SssGgg:doGet:lastname2= " + lastname2
//                + "<br>SssGgg:doGet:password= " + password
//                + "<br>SssGgg:doGet:sex= " + sex
//                + "<br>SssGgg:doGet:press= " + press
//                );
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
//        System.out.println("SssGgg:doPost");
//        String firstname = rq.getParameter("firstname");
//        String lastname = rq.getParameter("lastname");
//        String lastname2 = rq.getParameter("lastname2");
//        String password = rq.getParameter("password");
//        String sex = rq.getParameter("sex");
//        String press = rq.getParameter("press");
////        rs.setContentType("text/html");
//        PrintWriter pw = rs.getWriter();
//        pw.print(
//                "<br>SssGgg2:doPost:firstname=" + firstname
//                        + "<br>SssGgg2:doPost:lastname= " + lastname
//                        + "<br>SssGgg2:doPost:lastname2= " + lastname2
//                        + "<br>SssGgg:doPost:password= " + password
//                        + "<br>SssGgg:doPost:sex= " + sex
//                        + "<br>SssGgg:doPost:press= " + press
//        );
//    }
//}
