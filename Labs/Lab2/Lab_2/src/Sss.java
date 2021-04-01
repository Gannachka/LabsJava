import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Sss extends HttpServlet implements Servlet  {
    public Sss(){
        super();
        System.out.println("Sss_constructor");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init();
        System.out.println("Sss_int");
    }

    @Override
    public void service(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Sss_service"+servletRequest.getMethod());
    }

    @Override
    public void destroy() {
        
    }
}
