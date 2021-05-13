package classespack;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class afternoon extends HttpServlet implements Servlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("afternoon:service:"+req.getMethod());
        PrintWriter pw=res.getWriter();
        pw.println("Servlet:Good afternoon");
        pw.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("afternoon:destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("afternoon:init");
    }
}
