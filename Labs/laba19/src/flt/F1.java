package flt; 
 
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
 
public class F1 implements Filter {   
	public void init(FilterConfig cfg) throws ServletException {   
		System.out.println("F1:init");  
	}  
	public void destroy() {   
		System.out.println("F1:destroy");  
	} 
 
	public void doFilter(ServletRequest rq,   ServletResponse rs,   FilterChain ch)  throws IOException, ServletException {   
		FltRequest frq = new FltRequest((HttpServletRequest)rq);   
			frq.SetAA("Hello from F1");   
		System.out.println("F1:doFilter");   
		ch.doFilter(frq, rs);  
		//rs.setContentType("text/html");
		//PrintWriter pw = rs.getWriter();
		//pw.println("<h3>F1:doFilter</h3>");
		//pw.close();
		//ch.doFilter(rq, rs);  
	} 
}  