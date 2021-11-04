package by.belstu.istomin.listeners;

import by.belstu.istomin.logger.Logger;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class L2 implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        Logger.info("L2 attributeAdded");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        Logger.info("L2 attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        Logger.info("L2 attributeReplaced");
    }
}
