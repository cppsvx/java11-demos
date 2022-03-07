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
public class InitJerseyListener extends ResourceConfig {

    private final Logger LOGGER = LoggerFactory.getLogger(InitJerseyListener.class);

    public InitJerseyListener() {
        LOGGER.info("InitJerseyListener contextInitialized");
        LOGGER.warn("InitJerseyListener contextInitialized");
        LOGGER.error("InitJerseyListener contextInitialized");
    }

}