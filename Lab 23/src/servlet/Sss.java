package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.*;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;

import java.io.*;
import org.apache.commons.lang3.StringEscapeUtils;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class Sss extends HttpServlet implements Servlet {

    public Sss() {
        super();
        System.out.println("Servlet:SSS");
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
            out.write(readBytes);
    }


    protected void doGet(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String filename = StringEscapeUtils.unescapeHtml4(rq.getParameter("file"));
        String docdir   = getServletContext().getInitParameter("doc-dir");

        System.out.println(docdir);

        OutputDoc(new File(docdir, filename), rs);
        System.out.println("Sss:file = " + filename);

    }


    public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss: doPost");

        for (Part part: rq.getParts()) {
            System.out.println(part.getInputStream().read());
        }
        //String fileName = rq.getParameter("fileName");
        String fileName = Paths.get(rq.getPart("file").getSubmittedFileName()).getFileName().toString();
        System.out.println(fileName);
        fileName = StringEscapeUtils.unescapeHtml4(fileName);
        System.out.println(fileName);
        String docdir = getServletContext().getInitParameter("doc-dir");
        rq.getPart("file").write(docdir + "\\" + fileName);

        PrintWriter w = rs.getWriter();
        w.println("File uploaded");

    }
}