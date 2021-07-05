package servlet;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet {

    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        String s;
        res.setContentType("text/html");
        res.addHeader("Header1","HeaderHannaBbb1");
        res.addHeader("Header2","HeaderHannaBbb2");
        PrintWriter pw=res.getWriter();
        pw.println("<h2>Servlet Bbb Request Headers from Aaa</h2>");
        Enumeration headerNames=req.getHeaderNames();
        while (headerNames.hasMoreElements())
        {
            s=(String)headerNames.nextElement();
            pw.println("<br/>"+s+"= "+req.getHeader(s));
        }
       // pw.println("<br/><h2>Servlet Bbb Request Parameters from Aaa</h2>");
        Enumeration parameterNames=req.getParameterNames();
        while (parameterNames.hasMoreElements())
        {
            s=(String)parameterNames.nextElement();
            pw.println("<br/>"+s+"= ");
            String[] values=req.getParameterValues(s);
            for (int i = 0; i < values.length; i++) {
                pw.println(values[i]+" ");
            }
        }
        pw.close();
    }
}
