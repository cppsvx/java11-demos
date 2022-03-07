package com.craneos.demos.spring.properties.controller;

import com.craneos.demos.spring.properties.service.PropertiesDemoService;
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
@RequestMapping("/properties")
public class PropertiesDemoController {

    @Autowired
    private PropertiesDemoService propertiesDemoService;

    @GetMapping("/salute")
    public String salute() {
        return propertiesDemoService.getSalute();
    }

    @GetMapping("/values")
    public String values() {
        return propertiesDemoService.getDefinedValue();
    }
}
