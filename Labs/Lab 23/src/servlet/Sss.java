package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Sss extends HttpServlet implements Servlet {
    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest rq,  HttpServletResponse rs)
            throws ServletException, IOException {
        rs.setCharacterEncoding("CP1251");
        System.out.println("Servlet:servlet.Sss");
        String dir=rq.getServletContext().getInitParameter("doc-dir");
        File file=new File(dir+"/"+rq.getParameter("file"));
        OutputDoc(file,rs);
//        PrintWriter pw=rs.getWriter();
//        pw.println(dir);
//        pw.close();
    }

    protected void OutputDoc(File doc, HttpServletResponse rs)
            throws IOException {
        rs.setContentType("application/msword");
        rs.addHeader("Content-Disposition", "attachment; filename="+
                doc.getName());
        rs.setContentLength((int) doc.length());

        FileInputStream in = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(in);
        ServletOutputStream out = rs.getOutputStream();
        int readBytes = 0;
        while ((readBytes = buf.read()) != -1)
            out.write(readBytes);//записываю байты

    }

}
