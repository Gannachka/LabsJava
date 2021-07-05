package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;


public class F2 implements Filter {
    public void init(FilterConfig cfg) {
        System.out.println("F2:init");
    }

    public void destroy() {
        System.out.println("F2:destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        FltRequest fltRequest = new FltRequest((HttpServletRequest) req);
        fltRequest.SetBB("Hello from F2");
        System.out.println("F2:doFilter");
        if (req.getParameter("Value1").equals("0")) {
            PrintWriter pw=res.getWriter();
            pw.println("Filter F2 blocked");
            pw.close();
        }
        chain.doFilter(fltRequest, res);
    }
}
