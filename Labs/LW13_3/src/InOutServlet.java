import java.io.*;
import javax.servlet.*;
public class InOutServlet {
    protected InputStream ist;
    protected ServletOutputStream ost;
    public InOutServlet( ServletOutputStream ost, InputStream ist){
        this.ist = ist;
        this.ost = ost;
    }
    public void perform()throws IOException{
        int buf;
        this.ost.println("<html> " + "<body> ");
        while ((buf = this.ist.read()) > 0)
            this.ost.write(buf);

        this.ost.println("</body>" + "</html>");
        this.ost.flush();
    }
}