package servlet;
import javax.servlet.http.*;
import javax.servlet.*;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Authorization extends HttpServlet implements Servlet {
     protected void doPost(HttpServletRequest rq,HttpServletResponse rs) throws IOException {
         PrintWriter pw =rs.getWriter();
         Map jsonJavaRootObject = new Gson().fromJson(rq.getReader().readLine(), Map.class);
         if(jsonJavaRootObject.get("password").equals(getServletContext().getInitParameter("Password")))
         {
             pw.println(new Gson().toJson("OK"));
         }
         else
         {
             pw.println(new Gson().toJson("error"));
         }
         pw.close();
     }
}
