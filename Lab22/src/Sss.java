import java.io.*;        // исключения ввода/вывода   
import javax.servlet.*;            // интерфейсы и классы общего типа  
import javax.servlet.http.*;       // расширение javax.servlet для http
import others.ChoiseXXX;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import static java.lang.String.format;

public class Sss extends HttpServlet implements Servlet {

    public Sss() {
        super();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String fileName = rq.getParameter("file");
        String dirName = getServletContext().getInitParameter("doc-dir");
        File file = new File(dirName, fileName);
        System.out.println(dirName + "/" + fileName);
        ChoiseXXX.OutputDoc(file, rs);
        String filename = rq.getParameter("file");
        PrintWriter pw = rs.getWriter();
        String docdir = rq.getServletContext().getInitParameter("doc-dir");
        pw.println(docdir);
        System.out.println(docdir);
        File dir = new File(docdir, filename);
        System.out.println(docdir + "/" + filename);
        ChoiseXXX.OutputDoc(dir, rs);
        pw.close();
    }

}