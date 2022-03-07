package com.craneos.demos.spring.autoconfiguration.controller;

import com.craneos.demos.spring.autoconfiguration.service.AutoConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller is used to mark classes as Spring MVC Controller.
 * @RestController is a convenience annotation that does nothing more than adding the @Controller and @ResponseBody annotations (see: Javadoc)
 * So the following two controller definitions should do the same:
 *
 * @Controller
 * @ResponseBody
 * public class MyController { }
 *
 * @RestController
 * public class MyRestController { }
 *
 * Source: https://stackoverflow.com/questions/25242321/difference-between-spring-controller-and-restcontroller-annotation
 *
 * More info: https://docs.spring.io/spring-framework/docs/current/reference/html/web.html
 */
@RestController
@RequestMapping("/autoconfiguration")
public class AutoConfigurationController {

    @Autowired
    private AutoConfigurationService service;

    public AutoConfigurationController(){
        System.out.println("Instantiation of AutoConfigurationController");
    }

    @GetMapping("/simple")
    public String message() {
        return service.getSimpleMessage();
    }

}
