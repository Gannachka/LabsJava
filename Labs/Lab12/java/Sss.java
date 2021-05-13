//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sss extends HttpServlet implements Servlet {
    public Sss(){
        super();
        System.out.println("Sss_constructor");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init();
        System.out.println("Sss_int");
    }

    @Override
    public void service(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        super.service(servletRequest,servletResponse);
        System.out.println("Sss_service"+servletRequest.getMethod());
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    protected void doGet(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        System.out.println("Ggg:doGet");
        String var3 = var1.getParameter("firstname");
        String var4 = var1.getParameter("lastname");
        var2.setContentType("text/html");
        PrintWriter var5 = var2.getWriter();
        var5.println("<html> <body> doGet<br>Ggg:firstname = " + var3 + "<br>Ggg:lastname = " + var4 + "<br>Ggg:getServerName: " + var1.getServerName() + "<br>Ggg:getRemoteAddr: " + var1.getRemoteAddr() + "<br>Ggg:getRequestURI: " + var1.getRequestURI() + "</body></html>");
        var5.close();
    }

    protected void doPost(HttpServletRequest var1, HttpServletResponse var2) throws ServletException, IOException {
        System.out.println("Ggg:doPost");
        String var3 = var1.getParameter("firstname");
        String var4 = var1.getParameter("lastname");
        var2.setContentType("text/html");
        PrintWriter var5 = var2.getWriter();
        var5.println("<html> <body> doPost<br>Ggg:firstname = " + var3 + "<br>Ggg:lastname = " + var4 + "<br>Ggg:getServerName: " + var1.getServerName() + "<br>Ggg:getRemoteAddr: " + var1.getRemoteAddr() + "<br>Ggg:fullRequest: " + this.showRequest(var1) + "</body></html>");
        var5.close();
    }

    private String showRequest(HttpServletRequest var1) throws ServletException, IOException {
        StringBuilder var2 = new StringBuilder();
        var2.append(var1.getMethod() + " ");
        var2.append(var1.getRequestURL() + " ");
        var2.append(var1.getProtocol() + "\n");
        Enumeration var3 = var1.getHeaderNames();

        while(var3.hasMoreElements()) {
            String var4 = (String)var3.nextElement();
            var2.append(var4 + ": " + var1.getHeader(var4) + "\n");
        }

        return var2.toString();
    }
}
