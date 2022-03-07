package com.craneos.demos.jersey.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * http://localhost:8180/basic-servlet-jersey-logs/services/message
 */
@Path("/message")
public class JerseyLogsService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JerseyLogsService.class);
    private static final org.apache.commons.logging.Log LOGGER_COMMONS = org.apache.commons.logging.LogFactory.getLog(JerseyLogsService.class);;

    @GET
    public String getMessage(){
        // USING LOGGER
        LOGGER.debug("JERSEY Testing messages in DEBUG mode.");
        LOGGER.info("JERSEY Testing messages in INFO mode.");
        LOGGER.warn("JERSEY Testing messages in WARN mode.");
        LOGGER.error("JERSEY Testing messages in ERROR mode.");
        LOGGER.trace("JERSEY Testing messages in TRACE mode.");

        // USING LOGGER
        LOGGER_COMMONS.debug("COMMONS Testing messages in DEBUG mode.");
        LOGGER_COMMONS.info("COMMONS Testing messages in INFO mode.");
        LOGGER_COMMONS.warn("COMMONS Testing messages in WARN mode.");
        LOGGER_COMMONS.error("COMMONS Testing messages in ERROR mode.");
        LOGGER_COMMONS.trace("COMMONS Testing messages in TRACE mode.");

        return "done! - Jersey 2";
    }

}