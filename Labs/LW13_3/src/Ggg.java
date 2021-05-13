import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

public class Ggg extends HttpServlet implements Servlet
{
    public Ggg()
    {
        super();
        System.out.println("Ggg:constructor");
    }

    public void init(ServletConfig sc) throws ServletException
    {
        super.init();
        System.out.println("Ggg:init");
    }

    public void destroy()
    {
        super.destroy();
        System.out.println("Ggg:destroy");
    }

    @Override
    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        RequestDispatcher rd = null;
        System.out.println("Ggg: start service");
        String methodName = ((HttpServletRequest)rq).getMethod();
        String moveType = rq.getParameter("move");
        System.out.println("Ggg:service:" + methodName +"!");
        System.out.println("Ggg:service:before IF");
        if (methodName.equals("GET"))
        {
            //Task4
            if (moveType!= null && moveType.equals("Ggg:HTML"))
            {
                System.out.println("Ggg:service:GET:IF:"+moveType );
                rd = rq.getRequestDispatcher("/science.html");
                System.out.println("Ggg:service:before forward" );
                rd.forward(rq, rs);
                System.out.println("Ggg:service:end IF");
            }
            else
            {
                System.out.println("Ggg:service:before super");
                super.service(rq, rs);
                System.out.println("Ggg:service:after super");
            }

        }
        else{
            System.out.println("Ggg:service:before super");
            super.service(rq, rs);
            System.out.println("Ggg:service:after super");
        }

    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Ggg:doGet");
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String lastname2 = rq.getParameter("lastname2");
        String password = rq.getParameter("password");
        String taskNum = rq.getParameter("taskNum");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Ggg:doGet:taskNum=" + taskNum
                + "<br>Ggg:doGet:firstname=" + firstname
                + "<br>Ggg:doGet:lastname= " + lastname
                + "<br>Ggg:doGet:lastname2= " + lastname2
                + "<br>Ggg:doGet:password= " + password
                + "<br>Ggg:doGet:sex= " + sex
                + "<br>Ggg:doGet:press= " + press
                + "</body>" + "</html>");
        pw.close();

    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        System.out.println("Ggg:doPost");
        String firstname = rq.getParameter("firstname");
        String lastname = rq.getParameter("lastname");
        String lastname2 = rq.getParameter("lastname2");
        String password = rq.getParameter("password");
        String sex = rq.getParameter("sex");
        String press = rq.getParameter("press");
        rs.setContentType("text/html");
        PrintWriter pw = rs.getWriter();
        pw.println("<html> " + "<body> "
                + "<br>Ggg:doPost:firstname=" + firstname
                + "<br>Ggg:doPost:lastname= " + lastname
                + "<br>Ggg:doPost:lastname2= " + lastname2
                + "<br>Ggg:doPost:password= " + password
                + "<br>Ggg:doPost:sex= " + sex
                + "<br>Ggg:doPost:press= " + press
                + "</body>" + "</html>");
        pw.close();
    }
}