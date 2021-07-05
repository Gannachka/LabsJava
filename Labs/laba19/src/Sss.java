import java.io.*;        // ���������� �����/������   
import javax.servlet.*;            // ���������� � ������ ������ ����  
import javax.servlet.http.*;       // ���������� javax.servlet ��� http 

public class Sss extends HttpServlet implements Servlet {
	
	public Sss() {
	       super();
 	       System.out.println("Sss:constructor"); 
	}   
	
	public void init(ServletConfig sc) throws ServletException {
                // ������������� ��������       
		super.init();       
		System.out.println("Sss:init"); 
	}   
	public void destroy() {
		// ����� ������������ ��������     
		super.destroy();     
		System.out.println("Sss:destroy"); 
	} 
	protected void service(HttpServletRequest rq,  HttpServletResponse rs) 
	 throws ServletException,  IOException {   
   		// ��������� http-�������                   
		System.out.println("Sss:service:"+rq.getMethod());  
		if(rq.getMethod().equals("GET"))
			doGet(rq,rs);
		if(rq.getMethod().equals("POST"))
			doPost(rq,rs);
	} 
	
	protected void doGet(HttpServletRequest rq, HttpServletResponse rs) 
	 throws ServletException, IOException { 
		System.out.println("doGet");
		String fn = rq.getParameter("firstname");
		String ln = rq.getParameter("lastname");  
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		pw.println("<html><body>"
			+"lastname:        " + ln
			+"<br>firstname:   " + fn
 			+"<br>ServletPath: " + rq.getRequestURL() + "?" + rq.getQueryString()
			+"</body></html>");    
 		pw.close();    
	}
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)    
  	 throws ServletException, IOException { 
		System.out.println("doPost"); 
		String fn = rq.getParameter("firstname");
		String ln = rq.getParameter("lastname");  
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		pw.println("<html><body>"
			+"lastname:        " + ln
			+"<br>firstname:   " + fn
			+"</body></html>");    
 		pw.close();   
	}
}