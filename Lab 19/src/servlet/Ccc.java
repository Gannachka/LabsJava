package servlet;

import classes.CBean;
import filter.FltRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ccc extends HttpServlet {

    public void init() throws ServletException {
        super.init();
        System.out.println("Ccc:init");
        CBean cb=new CBean();
        ServletContext sc = getServletContext();
        sc.setAttribute("Value1",cb.getValue1());
        sc.setAttribute("Value2",cb.getValue2());
        sc.setAttribute("Value3",cb.getValue3());
        sc.setAttribute("artCBean", cb);
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        CBean cb=null;
        PrintWriter pw =res.getWriter();
        if(req.getParameter("CBean").equals("new"))
        {
            cb=new CBean(req.getParameter("Value1"),req.getParameter("Value2"),req.getParameter("Value3"));
            req.setAttribute("atrCBean",cb);
        }else if(req.getParameter("CBean").equals("old"))
        {
            cb=(CBean)req.getAttribute("atrCBean");
            pw.println(req.getAttribute("atrCBean"));
            String val;
            if( !(val = req.getParameter("Value1")).equals(""))
                cb.setValue1(val);
            if( !(val = req.getParameter("Value2")).equals(""))
                cb.setValue2(val);
            if( !(val = req.getParameter("Value3")).equals(""))
                cb.setValue3(val);
        }

        //pw.println(cb);
        pw.println(cb.getValue1());
        pw.println(cb.getValue2());
        pw.println(cb.getValue3());
        FltRequest fltRequest=new FltRequest((HttpServletRequest)req);
        pw.println(fltRequest.GetAA());
        pw.println(fltRequest.GetBB());
        pw.println(fltRequest.GetCC());
        pw.close();
    }
}
