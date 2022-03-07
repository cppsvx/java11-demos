package com.craneos.demos.spring.rest;

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
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * |--------------------------------------------------------------------------------------------------------------------
 * | HTTP Method |   CRUD         |  Collection Resource                     |        Single Resouce                   |
 * |--------------------------------------------------------------------------------------------------------------------
 * |  POST       | Create         | 201 (Created), ‘Location’ header with    | Avoid using POST on a single resource   |
 * |             |                | link to /users/{id} containing new ID    |                                         |
 * |--------------------------------------------------------------------------------------------------------------------
 * |  GET        | Read           | 200 (OK), list of users. Use pagination, | 200 (OK), single user. 404 (Not Found), |
 * |             |                |  sorting, and filtering to navigate big  |  if ID not found or invalid             |
 * |             |                |  lists                                   |                                         |
 * |--------------------------------------------------------------------------------------------------------------------
 * |  PUT        | Update/Replace | 405(Method not allowed), unless you want | 200 (OK) or 204 (No Content).           |
 * |             |                |   to update every resource in the entire |  Use 404 (Not Found), if ID is not      |
 * |             |                |   collection of resource                 |  found or invalid                       |
 * |--------------------------------------------------------------------------------------------------------------------
 * |  PATCH      | Partial        | 405 (Method not allowed), unless you     | 200 (OK) or 204 (No Content). Use 404   |
 * |             | Update/Modify  |   you want to modify the collection      |  (Not Found), if ID is not found        |
 * |             |                |   itself                                 |  or invalid                             |
 * |             |                |                                          |                                         |
 * |--------------------------------------------------------------------------------------------------------------------
 * |  DELETE     | Delete         | 405 (Method not allowed), unless you     | 200 (OK). 404 (Not Found), if ID not    |
 * |             |                |  want to delete the whole collection     |  found or invalid                       |
 * |             |                |  - — use with caution!                   |                                         |
 * |             |                |                                          |                                         |
 * |--------------------------------------------------------------------------------------------------------------------
 */
@SpringBootApplication
public class DemoRestApplication extends DemoBase {

    public static void main(String[] args) {
        SpringApplication.run(DemoRestApplication.class, args);
    }

}
