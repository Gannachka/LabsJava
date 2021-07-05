package servlet;

import com.google.gson.Gson;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import context.ReferenceContext;
import model.ReferenceModel;

import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Reference extends HttpServlet implements Servlet {
    private ReferenceContext context;

    public void init() {
        try {
            context=new ReferenceContext();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        try {
            String sessionId = "";
            for (Cookie cookie : rq.getCookies())
                if (cookie.getName().equals("JSESSIONID"))
                    sessionId = cookie.getValue();
            rs.setHeader("sessionId", sessionId);
            String json = new Gson().toJson(context.getReferences(rq.getParameter("filter")));
            rs.getWriter().write(json);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        ReferenceModel reference = new Gson().fromJson(rq.getReader().readLine(), ReferenceModel.class);
        try {

            System.out.println("Add References");
            context.addReferences(reference);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    protected void doPut(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        ReferenceModel reference = new Gson().fromJson(rq.getReader().readLine(), ReferenceModel.class);
        try {
            context.updateReferences(reference);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }

    protected void doDelete(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        ReferenceModel reference = new Gson().fromJson(rq.getReader().readLine(), ReferenceModel.class);
        try {
            context.deleteReference(reference);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }
}
