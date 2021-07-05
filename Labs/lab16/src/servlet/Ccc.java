package servlet;

import classes.CBean;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Ccc extends HttpServlet {

    public void init() throws ServletException {
        super.init();

    }

    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {

        CBean cBean = new CBean();
        ServletContext servletContext=getServletContext();

        if(req.getParameter("CBean").equals("old")){
            cBean=(CBean)servletContext.getAttribute("artCBean");
        }

        else if(req.getParameter("CBean").equals("new")) {
            cBean=new CBean("0","0","0");
            servletContext.setAttribute("artCBean",cBean);
        }

        PrintWriter pw = res.getWriter();

        if(!req.getParameter("Value1").isEmpty()){
            cBean.setValue1(req.getParameter("Value1"));
            servletContext.setAttribute("Value1",req.getParameter("Value1"));

        }else {
            cBean.setValue1((String)servletContext.getAttribute("Value1"));
        }

        if(!req.getParameter("Value2").isEmpty()){
            cBean.setValue2(req.getParameter("Value2"));
            servletContext.setAttribute("Value2",req.getParameter("Value2"));
        }else {
            cBean.setValue1((String)servletContext.getAttribute("Value2"));
        }

        if(!req.getParameter("Value3").isEmpty()){
            cBean.setValue3(req.getParameter("Value3"));
            servletContext.setAttribute("Value3",req.getParameter("Value3"));
        }else {
            cBean.setValue1((String)servletContext.getAttribute("Value3"));
        }

        Enumeration enumeration=servletContext.getAttributeNames();
        String x;

        while (enumeration.hasMoreElements()){
            x=(String)enumeration.nextElement();
        }

        req.setAttribute("Value1",cBean.getValue1());
        req.setAttribute("Value2",cBean.getValue2());
        req.setAttribute("Value3",cBean.getValue3());
        pw.println(cBean.getValue1());
        pw.println(cBean.getValue2());
        pw.println(cBean.getValue3());

        pw.close();
    }
}
