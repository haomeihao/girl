package com.imooc.girl.core.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by hmh on 2017/8/17.
 */
@WebListener("This is Only a Simple Listener.")
public class SimpleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("SimpleListener.contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("SimpleListener.contextDestroyed()");
    }
}
