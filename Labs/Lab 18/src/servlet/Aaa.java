package servlet;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class    Aaa extends HttpServlet {

    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        HttpClient hc=new HttpClient();
        PostMethod postMethod = new PostMethod("http://localhost:8080"+req.getContextPath()+"/Bbb");
        NameValuePair[] parms={
                new NameValuePair("param1","Hanna1"),
                new NameValuePair("param2","Hanna2"),
                new NameValuePair("param3","Hanna3"),
        };
        postMethod.addParameters(parms);
        postMethod.addRequestHeader("MyHeader1","HeaderHanna1");
        postMethod.addRequestHeader("MyHeader2","HeaderHanna2");
        postMethod.addRequestHeader("MyHeader3","HeaderHanna3");
        hc.executeMethod(postMethod);

        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        pw.println("<h1>Servlet Aaa Response Headers from Bbb</h1>");
        Header[] headers=postMethod.getResponseHeaders();
        for (int i = 0; i < headers.length; i++) {
            pw.println("<br/>"+headers[i].getName()+" = "+headers[i].getValue());
        }
        pw.println(postMethod.getResponseBodyAsString());
        pw.close();
    }
}
