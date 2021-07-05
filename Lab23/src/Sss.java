import java.io.*;        // исключения ввода/вывода   
import javax.servlet.*;            // интерфейсы и классы общего типа  
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;       // расширение javax.servlet для http

import com.github.sardine.*;

@MultipartConfig
public class Sss extends HttpServlet implements Servlet {

    public Sss() {
        super();
    }

    protected void service(HttpServletRequest rq, HttpServletResponse rs)
            throws ServletException, IOException {
        String URL = "https://webdav.yandex.ru/";
        String login = "Hanna1111111";
        String pswd = "aqavegrfmcioixnj";
        Sardine sardine = SardineFactory.begin(login, pswd);

        if (rq.getParameter("add").equals("Create Directory")) {
            sardine.createDirectory(URL + "/" + rq.getParameter("dir"));
        }

        if (rq.getParameter("add").equals("Delete")) {
            sardine.delete(URL + "/" + rq.getParameter("dir"));
        }

        if (rq.getParameter("add").equals("Upload")) {
            Part filePart = rq.getPart("addFile");
            String fileName = getFileName(filePart);
            File file = new File("D:\\" + fileName);
            FileInputStream fileInputStream = new FileInputStream(file);
            sardine.put(URL + file.getName(), fileInputStream);
            fileInputStream.close();
        }

        if (rq.getParameter("add").equals("Download")) {
            String docdir   = getServletContext().getInitParameter("doc-dir2");
            String filename = rq.getParameter("file");
            InputStream is = sardine.get(URL+filename);
            File fff = new File(docdir + filename);
            OutputStream outputStream = new FileOutputStream(fff);
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) > 0){
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            is.close();
        }

        if (rq.getParameter("add").equals("Copy")) {
            String filename = rq.getParameter("file");
            InputStream is = sardine.get(URL+ rq.getParameter("dirFrom") +"/" +filename);
            sardine.put(URL + rq.getParameter("dir") + "/" + filename, is);
            is.close();
        }
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}