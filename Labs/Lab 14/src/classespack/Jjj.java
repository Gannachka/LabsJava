package classespack;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Jjj extends HttpServlet implements Servlet {


    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Regimex regimex = new Regimex();
        int currentTime = regimex.GetHOUR();
        String currentJspPage = null;
        if ((currentTime > 0) && (currentTime <= 5))
            currentJspPage = "/jsp/night.jsp";
        else if ((currentTime > 5) && (currentTime <= 12))
            currentJspPage = "/jsp/morning.jsp";
        else if ((currentTime > 12) && (currentTime <= 17))
            currentJspPage = "/jsp/afternoon.jsp";
        else
            currentJspPage = "/jsp/evening.jsp";
        RequestDispatcher rd = req.getRequestDispatcher("/" + currentJspPage);
        rd.forward(req, res);
    }











    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Jjj:doGet");
        HttpClient hc = new HttpClient();

        Regimex regimex = new Regimex();
        int currentTime = regimex.GetHOUR();
        String currentJspPage = null;
        if ((currentTime > 0) && (currentTime <= 5))
            currentJspPage = "/jsp/night.jsp";
        else if ((currentTime > 5) && (currentTime <= 12))
            currentJspPage = "/jsp/morning.jsp";
        else if ((currentTime > 12) && (currentTime <= 17))
            currentJspPage = "/jsp/afternoon.jsp";
        else
            currentJspPage = "/jsp/evening.jsp";

        GetMethod gm = new GetMethod("http://localhost:48081" + req.getContextPath() + currentJspPage);
        hc.executeMethod(gm);
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println(gm.getResponseBodyAsString() + "GO AWAY FROM THIS PAGE");
        pw.close();
    }




    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Jjj:doPost");
        HttpClient hc = new HttpClient();

        String hour = req.getParameter("hour");

        Regimex regimex = new Regimex();
        int currentTime = regimex.GetHOUR();
        String currentJspPage = null;
        if ((currentTime > 0) && (currentTime <= 5))
            currentJspPage = "/jsp/night.jsp";
        else if ((currentTime > 5) && (currentTime <= 12))
            currentJspPage = "/jsp/morning.jsp";
        else if ((currentTime > 12) && (currentTime <= 17))
            currentJspPage = "/jsp/afternoon.jsp";
        else
            currentJspPage = "/jsp/evening.jsp";
        PostMethod gm = new PostMethod("http://localhost:48081" + req.getContextPath() +
                currentJspPage);
        hc.executeMethod(gm);
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println(gm.getResponseBodyAsString() + hour);
        pw.close();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Jjj:destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("Jjj:init");
    }
}
