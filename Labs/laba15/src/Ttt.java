import java.io.*;        // ���������� �����/������   
import javax.servlet.*;            // ���������� � ������ ������ ����  
import javax.servlet.http.*;       // ���������� javax.servlet ��� http 

public class Ttt extends HttpServlet implements Servlet {
	
	protected void doPost(HttpServletRequest rq, HttpServletResponse rs)

  	 throws ServletException, IOException {

		System.out.println("Ttt:doPost");

		if("OK".equals(rq.getParameter("press")))
		{
			rs.setContentType("text/html");
			PrintWriter pw = rs.getWriter();
			pw.println("<html><body>"
				+"surname:        " + rq.getParameter("surname")
				+"<br>lastname:   " + rq.getParameter("lastname")
				+"<br>sex:        " + rq.getParameter("sex")
				+"</body></html>");    
			pw.close();  
		}

		else {
			RequestDispatcher rd = rq.getRequestDispatcher("index.html");
			rd.forward(rq, rs);
		}
	}
}