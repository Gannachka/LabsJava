import java.io.*;        // исключения ввода/вывода   
import javax.servlet.*;            // интерфейсы и классы общего типа  
import javax.servlet.http.*;
import jspclass.CBean;

public class Ccc1 extends HttpServlet implements Servlet {
	
	
	public void init() throws ServletException {
        super.init();       
	}   
	
	protected void service(HttpServletRequest rq,  HttpServletResponse rs) 
	 throws ServletException,  IOException { 
		if(rq.getMethod().equals("GET") || rq.getMethod().equals("POST")){
			if(rq.getParameter("CBean").equals("new")) {
				CBean Cb = new CBean(rq.getParameter("Value1"), rq.getParameter("Value2"), rq.getParameter("Value3"));
				rq.setAttribute("atrCBean", Cb);
				RequestDispatcher rd = rq.getRequestDispatcher("Ccc1.jsp");
				rd.forward(rq, rs);
			} else {
				if(!rq.getMethod().equals("GET")){
					if(rq.getAttribute("atrCBean") != null){
						CBean Cb = (CBean)rq.getAttribute("atrCBean");
						String val;
						if( !(val = rq.getParameter("Value1")).equals(""))
							Cb.SetValue1(val);
						if( !(val = rq.getParameter("Value2")).equals(""))
							Cb.SetValue2(val);
						if( !(val = rq.getParameter("Value3")).equals(""))
							Cb.SetValue3(val);
					}
				}
				PrintWriter pw = rs.getWriter();
				pw.println("Object CBean not initialized");
				pw.close();
			}
		}
	} 
}