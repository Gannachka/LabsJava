package flt; 
 
import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
 
public class F2 implements Filter {   
	public void init(FilterConfig cfg) throws ServletException {   
		System.out.println("F1:init");  
	}  
	public void destroy() {   
		System.out.println("F1:destroy");  
	} 
 
	public void doFilter(ServletRequest rq,   ServletResponse rs,   FilterChain ch)  throws IOException, ServletException { 
		flt.FltRequest  frq = new flt.FltRequest((HttpServletRequest)rq);   	
		System.out.println("F2:doFilter");  
		//frq = (flt.FltRequest)rq;
		rs.setContentType("text/html");
		PrintWriter pw = rs.getWriter();
		if(frq.GetAA() != null){
			pw.println("Filter1: " + frq.GetAA());
			pw.println("<br>Filter3: " + frq.GetCC());
		}
		pw.println("<br><h3>F2: access was block by Filter 2</h3>");
		pw.close();  
		
	} 
}  