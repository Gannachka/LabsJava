import java.io.*;        // исключения ввода/вывода   
import javax.servlet.*;            // интерфейсы и классы общего типа  
import javax.servlet.http.*;       // расширение javax.servlet для http 
import org.apache.commons.httpclient.*; 
import org.apache.commons.httpclient.methods.*;
import java.util.*;

public class Aaa extends HttpServlet implements Servlet {
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)    
  	 throws ServletException, IOException { 
		System.out.println("Sss:doPost"); 
		HttpClient hc = new HttpClient();
		PostMethod pm = new PostMethod("http://localhost:8080" + rq.getContextPath() + "/Bbb");
		pm.addRequestHeader("lastname", "Miklyaeva1");
		pm.addRequestHeader("lastname", "Miklyaeva2");
		pm.addRequestHeader("lastname", "Miklyaeva3");
		NameValuePair[] parms = { new NameValuePair("name", "Hanna1"),
								  new NameValuePair("name", "Hanna2"),
								  new NameValuePair("name", "Hanna3")};
		pm.addParameters(parms); 
		hc.executeMethod(pm);   
		
		rs.setContentType("text/html");   
		PrintWriter pw = rs.getWriter(); 
		pw.println("<html><body><h1>Servlet Aaa<br>Response Headers from Bbb</h1>");
		//pm.getRequestHeaderNames();
		Header[] enhl = pm.getResponseHeaders();
		for(int i=0;i<enhl.length;i++) {
			pw.println("<br>" + enhl[i].getName() + ": " + enhl[i].getValue());
		}
		pw.println(pm.getResponseBodyAsString()); 
		pw.println("</body></html>");
		pw.close();
	}
}