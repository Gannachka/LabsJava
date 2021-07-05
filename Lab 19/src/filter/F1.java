package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;


public class F1 implements Filter {
    public void init(FilterConfig cfg) {
        System.out.println("F1:init");
    }

    public void destroy() {
        System.out.println("F1:destroy");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        FltRequest fltRequest = new FltRequest((HttpServletRequest) req);
        fltRequest.SetAA("Hello from F1");
        System.out.println("F1:doFilter");
        if (!req.getParameter("CBean").equals("new") && !req.getParameter("CBean").equals("old")) {
            PrintWriter pw=res.getWriter();
            pw.println("Filter F1 blocked");
            pw.close();
        }
        chain.doFilter(fltRequest, res);
    }
}
