import java.io.*;        // ���������� �����/������   
import javax.servlet.*;            // ���������� � ������ ������ ����  
import javax.servlet.http.*;       // ���������� javax.servlet ��� http 
import java.util.*;

public class Bbb extends HttpServlet implements Servlet {
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)    
  	 throws ServletException, IOException { 
		String s;
		rs.setContentType("text/html");
		rs.addHeader("MyHeader", "header1"); 
		rs.addHeader("MyHeader", "header2");
		PrintWriter pw = rs.getWriter();
		Enumeration enh = rq.getHeaderNames();  
		pw.println("<h2><br>Servlet Bbb<br>Request Headers from Aaa</h2>");
		while (enh.hasMoreElements()) {    
			s = (String)enh.nextElement();
			pw.println("<br>" + s + " = ");
			Enumeration enhel = rq.getHeaders(s); 
			while (enhel.hasMoreElements())
				pw.print((String)enhel.nextElement() + " ");
		}
		enh = rq.getParameterNames();
		pw.println("<br><h2>Request Parameters from Aaa</h2>");
		while (enh.hasMoreElements()) { 
			s = (String)enh.nextElement();
			pw.println("<br>" + s + " = ");
			String[] enhel = rq.getParameterValues(s);
			for(int i =0; i< enhel.length;i++)
				pw.print(enhel[i] + " ");
		}
		pw.close();   
	}
}