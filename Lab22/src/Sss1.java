import java.io.*;        // исключения ввода/вывода
import javax.servlet.*;            // интерфейсы и классы общего типа
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;       // расширение javax.servlet для http
import others.ChoiseXXX;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

import static java.lang.String.format;
@MultipartConfig
public class Sss1 extends HttpServlet implements Servlet {

    public Sss1() {
        super();
    }

    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String path = getServletContext().getInitParameter("doc-dir");
        final Part filePart = req.getPart("file");
        final String fileName = getFileName(filePart);

        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = resp.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();

            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        } catch (FileNotFoundException ignored) {
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
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