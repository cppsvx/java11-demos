package com.craneos.demos.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;

/**
 * Here with the @ApplicationPath, it's just like if we configured the servlet mapping in the web.xml:
 *     <servlet>
 *         <servlet-name>Jersey Web Application</servlet-name>
 *         <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
 *         <init-param>
 *             <param-name>jersey.config.server.provider.packages</param-name>
 *             <param-value>com.craneos.demos.jersey.service</param-value>
 *         </init-param>
 *         <load-on-startup>1</load-on-startup>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>JerseyApplication</servlet-name>
 *         <url-pattern>/services/*</url-pattern>
 *     </servlet-mapping>
 */
@ApplicationPath("services")
public class InitJerseyLogsListener extends ResourceConfig {

    private final Logger LOGGER = LoggerFactory.getLogger(InitJerseyLogsListener.class);
    private final org.apache.commons.logging.Log LOGGER_COMMONS = org.apache.commons.logging.LogFactory.getLog(this.getClass());

    public InitJerseyLogsListener() {
        LOGGER.debug("SLF4J InitJerseyLogsListener contextInitialized");
        LOGGER.info("SLF4J InitJerseyLogsListener contextInitialized");
        LOGGER.warn("SLF4J InitJerseyLogsListener contextInitialized");
        LOGGER.error("SLF4J InitJerseyLogsListener contextInitialized");

        LOGGER_COMMONS.debug("COMMONS InitJerseyLogsListener contextInitialized");
        LOGGER_COMMONS.info("COMMONS InitJerseyLogsListener contextInitialized");
        LOGGER_COMMONS.warn("COMMONS InitJerseyLogsListener contextInitialized");
        LOGGER_COMMONS.error("COMMONS InitJerseyLogsListener contextInitialized");
    }

}