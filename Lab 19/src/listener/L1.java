package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class L1 implements ServletContextListener {
    public void contextInitialized(ServletContextEvent ce) {
        System.out.println("L1:contextInitializedCcc1");
    }

    public void contextDestroyed(ServletContextEvent ce) {
        System.out.println("L1:contextDestroyed");
    }
}
