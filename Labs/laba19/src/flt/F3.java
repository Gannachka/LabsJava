package flt; 
 
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
 
public class F3 implements Filter {   
	public void init(FilterConfig cfg) throws ServletException {   
		System.out.println("F1:init");  
	}  
	public void destroy() {   
		System.out.println("F1:destroy");  
	} 
 
	public void doFilter(ServletRequest rq,   ServletResponse rs,   FilterChain ch)  throws IOException, ServletException {    
		FltRequest frq = new FltRequest((HttpServletRequest)rq);   
		frq.SetCC("Hello from F3");   
		System.out.println("F3:doFilter");   
		ch.doFilter(frq, rs);  
		
	} 
}  