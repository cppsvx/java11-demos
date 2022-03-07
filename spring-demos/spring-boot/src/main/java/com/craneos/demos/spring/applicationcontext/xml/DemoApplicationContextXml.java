package com.craneos.demos.spring.applicationcontext.xml;

import com.craneos.demos.spring.DemoBase;
import com.craneos.demos.spring.autoconfiguration.config.OtherAutoConfiguration;
import com.craneos.demos.spring.autoconfiguration.config.OtherAutoConfigurationWithConditionals;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

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
@ImportResource("classpath:applicationContext.xml")
@EnableAutoConfiguration(exclude = {OtherAutoConfiguration.class, OtherAutoConfigurationWithConditionals.class})
public class DemoApplicationContextXml extends DemoBase {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplicationContextXml.class, args);
    }

}