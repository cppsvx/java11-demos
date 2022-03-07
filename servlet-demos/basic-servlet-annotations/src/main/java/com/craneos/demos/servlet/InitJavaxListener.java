package com.craneos.demos.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitJavaxListener implements ServletContextListener {
    
    private final Logger LOGGER = LoggerFactory.getLogger(InitJavaxListener.class);

    @Override
    public void contextInitialized(ServletContextEvent event) {
        LOGGER.info("InitJavaxListener contextInitialized");
        LOGGER.error("InitJavaxListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        LOGGER.info("InitJavaxListener contextDestroyed");
        LOGGER.error("InitJavaxListener contextDestroyed");
    }
}