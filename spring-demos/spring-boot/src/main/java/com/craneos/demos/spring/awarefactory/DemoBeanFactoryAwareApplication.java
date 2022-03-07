package com.craneos.demos.spring.awarefactory;

import com.craneos.demos.spring.DemoBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
 * -----------------------------------------------------------------------------------------------------------------
 *
 * BeanFactoryAware is used to inject the BeanFactory object. This way we get access to the BeanFactory which created the object.
 *
 * When to Use?
 * The typical use case for BeanNameAware could be acquiring the bean name for logging or wiring purposes.
 * For the BeanFactoryAware it could be the ability to use a spring bean from legacy code.
 *
 * In most cases, we should avoid using any of the Aware interfaces, unless we need them.
 * Implementing these interfaces will couple the code to the Spring framework.
 */
@SpringBootApplication
public class DemoBeanFactoryAwareApplication extends DemoBase {

    public static void main(String[] args) {
        SpringApplication.run(DemoBeanFactoryAwareApplication.class, args);
    }

}