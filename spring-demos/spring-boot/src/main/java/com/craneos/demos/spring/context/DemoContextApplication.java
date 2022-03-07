package com.craneos.demos.spring.context;

import com.craneos.demos.spring.DemoBase;
import com.craneos.demos.spring.context.services.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
public class DemoContextApplication extends DemoBase implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(DemoContextApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(applicationContext.getDisplayName());
        System.out.println(applicationContext.getId());

        ContextService contextService = applicationContext.getBean(ContextService.class);
        System.out.println(contextService.getApplicationId());
    }

}
