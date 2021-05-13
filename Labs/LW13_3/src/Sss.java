import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet implements Servlet
{
    public Sss()
    {
        super();
        System.out.println("Sss:constructor");
    }

    public void init(ServletConfig sc) throws ServletException
    {
        super.init();
        System.out.println("Sss:init");
    }

    public void destroy()
    {
        super.destroy();
        System.out.println("Sss:destroy");
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException
    {
        RequestDispatcher rd = null;
        System.out.println("Sss: start service");
        String methodName = ((HttpServletRequest)rq).getMethod();
        String moveType = rq.getParameter("move");
        String workGroupType = rq.getParameter("workGroup");
        System.out.println("Sss:service:" + methodName +"!");
        System.out.println("Sss:service:before IF");
//        if ( workGroupType == null) {
            if (methodName.equals("GET")) {
                System.out.println("Sss:service:before IF:case");
                System.out.println("Sss:service:before IF:case:MOVETYPE= " + moveType);
                //Task1
                if (moveType == null) {
                    System.out.println("Sss:service:IF");
                    String firstname = rq.getParameter("firstname");
                    System.out.println("Sss: start service: firstname = " + firstname);
                    String lastname = rq.getParameter("lastname");
                    System.out.println("Sss: start service: lastname = " + lastname);
                    String lastname2 = rq.getParameter("lastname2");
                    System.out.println("Sss: start service: lastname2 = " + lastname2);
                    String parmstr = "firstname=" + firstname + ":Ggg:GET" + "&"
                            + "lastname=" + lastname + "&"
                            + "taskNum=" + '1' + "&"
                            + "lastname2=" + "hello Kitty";
                    rd = rq.getRequestDispatcher("/Ggg?" + parmstr);
                    System.out.println("Sss:service:before forward");
                    rd.forward(rq, rs);//переопределение
                    System.out.println("Sss:service:end IF");
                }
                //Task3
                else if (moveType.equals("HTML")) {
                    System.out.println("Sss:service:GET:IF:" + moveType);
                    rd = rq.getRequestDispatcher("/science.html");
                    System.out.println("Sss:service:before forward");
                    rd.forward(rq, rs);
                    System.out.println("Sss:service:GET:end IF:HTML");
                }
                //Task4
                else if (moveType.equals("Ggg:HTML")) {
                    System.out.println("Sss:service:GET:IF:" + moveType);
                    rd = rq.getRequestDispatcher("/Ggg?");
                    System.out.println("Sss:service:before forward");
                    rd.forward(rq, rs);
                    System.out.println("Sss:service:end IF");
                }
                System.out.println("Sss: end service");
            }

            if (methodName.equals("POST")) {
                System.out.println("Sss:service:workGroupType:" + workGroupType);
                if (workGroupType.equals("one")) {
                    String press = rq.getParameter("sex");
                    System.out.println("Sss:service:command:" + press);

                    if (press.equals("printToPrint")) {
                        System.out.println("Sss:service:command:" + press);
                        System.out.println("Sss:service:before printToPrint:command:" + press);
                        PrintWriter pw;
                        rd = rq.getRequestDispatcher("/SssGgg?");
                        System.out.println("Sss:service");
                        System.out.println("Sss:service:start current code");
                        String firstname = rq.getParameter("firstname");
                        String lastname = rq.getParameter("lastname");
                        String lastname2 = rq.getParameter("lastname2");
                        String password = rq.getParameter("password");
                        String sex = rq.getParameter("sex");
//
                        System.out.println("Sss:service:end current code");
                        System.out.println("Sss:service:before forward");
                        rd.forward(rq, rs);
                        pw = rs.getWriter();
                        pw.print(
                                "<br>Sss1:service:firstname=" + firstname
                                        + "<br>Sss:service:lastname= " + lastname
                                        + "<br>Sss:service:lastname2= " + lastname2
                                        + "<br>Sss:service:password= " + password
                                        + "<br>Sss:service:sex= " + sex
                                        + "<br>Sss:service:press= " + press
                        );
                        System.out.println("Sss:service:after forward");
                        pw.println("</body>" + "</html>");
                        pw.close();
                        //end text

                        System.out.println("Sss:service:after printToPrint:command:" + press);
                    } else if (press.equals("cdoPostUpToGet")) {
                        System.out.println("Sss:service:command:" + press);
                        System.out.println("Sss:service:before UP POST to GET:command:" + press);
                        doGet(rq, rs);
                        System.out.println("Sss:service:after UP POST to GET:command:" + press);
                    } else if (press.equals("cdoPostUp")) {
                        System.out.println("Sss:service:command:" + press);
                        System.out.println("Sss:service:before UP:command:" + press);
                        doPost(rq, rs);
                        System.out.println("Sss:service:after UP:command:" + press);
                    } else if (press.equals("cdoPostSuper")) {
                        System.out.println("Sss:service:command:" + press);
                        System.out.println("Sss:service:before super:command:" + press);
                        super.service(rq, rs);
                        System.out.println("Sss:service:after super:command:" + press);
                    } else {
                        //Task2
                        System.out.println("Sss:service:IF:POST");
                        String firstname = rq.getParameter("firstname");
                        System.out.println("Sss: start service: firstname = " + firstname);
                        String lastname = rq.getParameter("lastname");
                        System.out.println("Sss: start service: lastname = " + lastname);
                        String lastname2 = rq.getParameter("lastname2");
                        System.out.println("Sss: start service: lastname2 = " + lastname2);
                        String parmstr = "firstname=" + firstname + "Ggg:POST" + "&"
                                + "lastname=" + lastname + "&"
                                + "lastname2=" + "hello Kitty";
                        rd = rq.getRequestDispatcher("/Ggg?" + parmstr);
                        System.out.println("Sss:service:before forward");
                        rd.forward(rq, rs);
                        System.out.println("Sss:service:after forward");
                        System.out.println("Sss:service:end IF:POST");
                    }
                }
                else if(workGroupType.equals("two"))
                {
                    System.out.println("Sss:service:HTTP Client");
                    HttpClient hc = new HttpClient();
                    System.out.println("Sss:service:HttpClient constructor");
                    PostMethod pm = new PostMethod("http://localhost:8081"
                            + rq.getContextPath() + "/PostExample?press=OK");
                    NameValuePair[] parms = { new NameValuePair("firstname", "Gurin"),// 4
                            new NameValuePair("lastname", "Nik"), // 5
                            new NameValuePair("sex", "male") }; // 6
                    pm.addParameters(parms); // 7
                    hc.executeMethod(pm); // 8
                    rs.setContentType("text/html");

                    if (pm.getStatusCode() == HttpStatus.SC_OK) { // 9
                          InOutServlet inout = new InOutServlet(rs.getOutputStream(), // 10
                                pm.getResponseBodyAsStream()); // 11
                        inout.perform(); // 12
                    } else // 13
                        System.out.println("Sss:service:getStatusCode()=" // 14
                                + pm.getStatusCode()); // 15


                }
                else if (workGroupType.equals("three"))
                {
                    rs.setStatus(307);
                    rs.sendRedirect("http://localhost:8080/Lab_13/Ggg");
                }
            }

//        }


        System.out.println("Sss:end service method");
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Sss:doGet");
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String lastname2 = rq.getParameter("lastname2");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Sss:doGet:firstname=" + firstname
                + "<br>Sss:doGet:lastname= " + lastname
                + "<br>Sss:doGet:lastname2= " + lastname2
                + "<br>Sss:doGet:password= " + password
                + "<br>Sss:doGet:sex= " + sex
                + "<br>Sss:doGet:press= " + press
                + "</body>" + "</html>");
        pw.close();
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Sss:doPost");
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String lastname2 = rq.getParameter("lastname2");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Sss:doPost:firstname=" + firstname
                + "<br>Sss:doPost:lastname= " + lastname
                + "<br>Sss:doPost:lastname2= " + lastname2
                + "<br>Sss:doPost:password= " + password
                + "<br>Sss:doPost:sex= " + sex
                + "<br>Sss:doPost:press= " + press
                + "</body>" + "</html>");
        pw.close();
    }
}