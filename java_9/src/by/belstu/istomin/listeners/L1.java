package by.belstu.istomin.listeners;

import by.belstu.istomin.logger.Logger;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class L1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger.info("L1 contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Logger.info("L1 contextDestroyed");
    }
}
