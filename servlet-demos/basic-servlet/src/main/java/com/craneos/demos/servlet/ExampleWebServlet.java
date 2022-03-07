package com.craneos.demos.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * http://localhost:8180/basic-servlet/
 */
public class ExampleWebServlet extends HttpServlet {

    private static final java.util.logging.Logger LOGGER_UTIL = java.util.logging.Logger.getLogger("ExampleWebServlet");
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ExampleWebServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        // USING LOGGER
        LOGGER.debug("INIT Testing messages in DEBUG mode.");
        LOGGER.info("INIT Testing messages in INFO mode.");
        LOGGER.warn("INIT Testing messages in WARN mode.");
        LOGGER.info("INIT Testing messages in INFO mode.");
        LOGGER.error("INIT Testing messages in ERROR mode.");
        LOGGER.trace("INIT Testing messages in TRACE mode.");
        // USING LOG_UTIL
        LOGGER_UTIL.fine("INIT JAVA LOGGER Testing messages in FINE mode.");
        LOGGER_UTIL.info("INIT JAVA LOGGER Testing messages in INFO mode.");
        LOGGER_UTIL.warning("INIT JAVA LOGGER Testing messages in WARNING mode.");
        LOGGER_UTIL.severe("INIT JAVA LOGGER Testing messages in SEVERE mode.");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // USING LOGGER
        LOGGER.debug("SERVICE Testing messages in DEBUG mode.");
        LOGGER.info("SERVICE Testing messages in INFO mode.");
        LOGGER.warn("SERVICE Testing messages in WARN mode.");
        LOGGER.error("SERVICE Testing messages in ERROR mode.");
        LOGGER.trace("SERVICE Testing messages in TRACE mode.");
        // USING LOG_UTIL
        LOGGER_UTIL.fine("SERVICE JAVA LOGGER Testing messages in FINE mode.");
        LOGGER_UTIL.info("SERVICE JAVA LOGGER Testing messages in INFO mode.");
        LOGGER_UTIL.warning("SERVICE JAVA LOGGER Testing messages in WARNING mode.");
        LOGGER_UTIL.severe("SERVICE JAVA LOGGER Testing messages in SEVERE mode.");

        // OUTPUT
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        out.println("<html>");
        out.println("<head>");
        out.println("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
        out.println("  <title> My first jsp  </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Hello World");
        out.println("</body>");
        out.println("</html>");
    }
}
