package com.craneos.demos.jersey.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * http://localhost:8180/basic-servlet-jersey/services/message
 */
@Path("/message")
public class JerseyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyService.class);

    @GET
    public String getMessage(){
        // USING LOGGER
        LOGGER.debug("JERSEY Testing messages in DEBUG mode.");
        LOGGER.info("JERSEY Testing messages in INFO mode.");
        LOGGER.warn("JERSEY Testing messages in WARN mode.");
        LOGGER.error("JERSEY Testing messages in ERROR mode.");
        LOGGER.trace("JERSEY Testing messages in TRACE mode.");

        return "done! - Jersey 2";
    }

}