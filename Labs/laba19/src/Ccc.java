import java.io.*;        // исключения ввода/вывода   
import javax.servlet.*;            // интерфейсы и классы общего типа  
import javax.servlet.http.*;
import jspclass.CBean;

public class Ccc extends HttpServlet implements Servlet {
	
	public void init() throws ServletException {
        super.init();       
		CBean Cb = new CBean(null, null, null);
		ServletContext sc1 = getServletContext();
		sc1.setAttribute("atrCBean", Cb);
	}   
	
	protected void service(HttpServletRequest rq,  HttpServletResponse rs) 
	 throws ServletException,  IOException {  
		if(rq.getMethod().equals("GET") || rq.getMethod().equals("POST")){
			if(rq.getParameter("CBean").equals("new")) {
				CBean Cb = new CBean(rq.getParameter("Value1"), rq.getParameter("Value2"), rq.getParameter("Value3"));
				ServletContext sc = getServletContext(); 
				sc.setAttribute("atrCBean", Cb);
			} else {
				if(!rq.getMethod().equals("GET")){
					ServletContext sc = getServletContext(); 
					CBean Cb = (CBean)sc.getAttribute("atrCBean");
					String val;
					if( !(val = rq.getParameter("Value1")).equals(""))
						Cb.SetValue1(val);
					if( !(val = rq.getParameter("Value2")).equals(""))
						Cb.SetValue2(val);
					if( !(val = rq.getParameter("Value3")).equals(""))
						Cb.SetValue3(val);
				}
			}
			RequestDispatcher rd = rq.getRequestDispatcher("Ccc.jsp");
			rd.forward(rq, rs);
		}
	} 
}