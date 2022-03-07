package com.craneos.demos.spring.basic;

import com.craneos.demos.spring.DemoBase;
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
public class DemoBasicContextApplication extends DemoBase {

    private static ApplicationContext applicationContext;
    private static DemoBasicContextApplication instance;
    private static String displayName;

    public static void main(String[] args) {
        DemoBasicContextApplication.applicationContext = SpringApplication.run(DemoBasicContextApplication.class, args);
        String[] springBootAppBeanName = applicationContext.getBeanNamesForAnnotation(SpringBootApplication.class);
        DemoBasicContextApplication.displayName = applicationContext.getDisplayName();
        DemoBasicContextApplication.instance = (DemoBasicContextApplication)applicationContext.getBean(springBootAppBeanName[0]);
    }

    public static DemoBasicContextApplication getInstance(){
        return DemoBasicContextApplication.instance;
    }

    public void close(){
        System.out.println("Closing application = "+ DemoBasicContextApplication.displayName);
        SpringApplication.exit(applicationContext);
    }

}
