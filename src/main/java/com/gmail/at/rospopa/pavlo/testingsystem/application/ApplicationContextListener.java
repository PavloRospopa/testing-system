package com.gmail.at.rospopa.pavlo.testingsystem.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationContextListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        AppContext.INSTANCE.init();
        LOGGER.info("Application context has been initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
