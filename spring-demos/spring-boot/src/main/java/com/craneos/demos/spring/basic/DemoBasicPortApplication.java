package com.craneos.demos.spring.basic;

import com.craneos.demos.spring.DemoBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 *
 * @Configuration: Tags the class as a source of bean definitions for the application context.
 *
 * @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and
 * various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application
 * as a web application and activates key behaviors, such as setting up a DispatcherServlet.
 *
 * @ComponentScan: Tells Spring to look for other components, configurations, and services in the
 * com.craneos.demos.spring.basic package, letting it find the controllers.
 *
 * The @SpringBootApplication annotation is equivalent to using @Configuration, @EnableAutoConfiguration,
 * and @ComponentScan with their default attributes.
 */
@SpringBootApplication
public class DemoBasicPortApplication extends DemoBase {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoBasicPortApplication.class);
        String port = "8085";
        if (args.length>0){
            port = args[0];
        }
        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        app.run(args);
    }

}
