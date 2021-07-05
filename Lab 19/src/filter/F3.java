package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;


public class F3 implements Filter {
    public void init(FilterConfig cfg)  throws ServletException{
        System.out.println("F3:init");
    }

    public void destroy() {
        System.out.println("F3:destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        FltRequest fltRequest = new FltRequest((HttpServletRequest) req);
        fltRequest.SetCC("Hello from F3");
        System.out.println("F3:doFilter");
        if (req.getParameter("Value2").equals("0")) {
            PrintWriter pw=res.getWriter();
            pw.println("Filter F3 blocked");
            pw.close();
        }
        chain.doFilter(fltRequest, res);
    }
}
