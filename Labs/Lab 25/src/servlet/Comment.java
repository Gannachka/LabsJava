package servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import context.CommentContext;
import context.ReferenceContext;
import model.CommentModel;
import model.ReferenceModel;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class Comment extends HttpServlet implements Servlet {
    private CommentContext context;

    public void init() {
        try {
            context=new CommentContext();
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        try {
            Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
            String json = gson.toJson(context.getComments(Integer.parseInt(rq.getParameter("id"))));
            rs.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        CommentModel comment = new Gson().fromJson(rq.getReader().readLine(),CommentModel.class);
        try {
            comment.setStamp(new Date(System.currentTimeMillis()));
            context.addComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPut(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        CommentModel comment = new Gson().fromJson(rq.getReader().readLine(),CommentModel.class);
        try {
            context.updateComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doDelete(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        CommentModel comment = new Gson().fromJson(rq.getReader().readLine(),CommentModel.class);
        try {
            context.deleteComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
