package others;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;

import static java.lang.String.format;

public class ChoiseXXX {
    public String  listxxx[];
    protected class OnlyXXX implements FilenameFilter {
        String xxx = null;
        public OnlyXXX(String xxx) {
            this.xxx = "." + xxx;
        }
        public boolean accept(File d, String name) {
            return name.endsWith(xxx);
        }
    }
    public ChoiseXXX(String d, String xxx) {
        File dir = new File(d);
        if (dir.exists()) {
            listxxx = dir.list(new OnlyXXX(xxx));
        }
    }

    public static void OutputDoc(final File file, final HttpServletResponse response) {
        response.setContentType("application/msword");
        response.addHeader("Content-Disposition", format("attachment; filename=%s", file.getName()));
        response.setContentLength((int)file.length());
        try {
            final FileInputStream in = new FileInputStream(file);
            final BufferedInputStream buf = new BufferedInputStream(in);
            final ServletOutputStream out = response.getOutputStream();
            int readBytes = 0;
            while ((readBytes = buf.read()) != -1) {
                out.write(readBytes);
            }
            out.close();
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
