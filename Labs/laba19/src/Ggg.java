import java.io.*;        // исключения ввода/вывода   
import javax.servlet.*;            // интерфейсы и классы общего типа  
import javax.servlet.http.*;       // расширение javax.servlet для http 
import org.apache.commons.httpclient.*; 
import org.apache.commons.httpclient.methods.*;

public class Ggg extends HttpServlet implements Servlet {
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) 
	 throws ServletException, IOException { 
		System.out.println("Ggg:doGet");
		String urln = rq.getParameter("urln");
		ServletContext sc = getServletContext(); 
		String url = sc.getInitParameter(urln);
		if( url == null || urln == null) {
			PrintWriter pw = rs.getWriter();   
			pw.println("<h1>parameter URLn not found</h1>");   
			pw.close();
		} else {
			HttpClient hc = new HttpClient(); 
			GetMethod gm; 
			String uri = url + "?" +  "firstname=" + rq.getParameter("firstname")+"&lastname="+rq.getParameter("lastname");
			hc.executeMethod(gm = new GetMethod(uri));   
			rs.setContentType("text/html");   
			PrintWriter pw = rs.getWriter();   
			pw.println(gm.getResponseBodyAsString());   
			pw.close();
		}		
	}
}