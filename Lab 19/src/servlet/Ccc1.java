package servlet;

import classes.CBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Ccc1 extends HttpServlet {

    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        CBean cb=null;
        if(req.getParameter("CBean").equals("new"))
        {
            cb=new CBean(req.getParameter("Value1"),req.getParameter("Value2"),req.getParameter("Value3"));
            HttpSession session=req.getSession();
            session.setAttribute(session.getId(),cb);
        }else if(req.getParameter("CBean").equals("old"))
        {
            HttpSession session=req.getSession();
            cb=(CBean) session.getAttribute(session.getId());
            String val;
            if( !(val = req.getParameter("Value1")).equals(""))
                cb.setValue1(val);
            if( !(val = req.getParameter("Value2")).equals(""))
                cb.setValue2(val);
            if( !(val = req.getParameter("Value3")).equals(""))
                cb.setValue3(val);
        }
    }
}
