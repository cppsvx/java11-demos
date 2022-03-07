package com.craneos.demos.spring.applicationcontext.annotation.controller;

import com.craneos.demos.spring.applicationcontext.annotation.service.ApplicationContextService;
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
@RequestMapping("/context")
public class ApplicationContextController {

    @Autowired
    private ApplicationContextService service;

    public ApplicationContextController(){
        System.out.println("Instantiation of ApplicationContextController");
    }

    @GetMapping("/simple")
    public String message() {
        return service.getSimpleApplicationContextMessage();
    }

    @GetMapping("/duplicated/firstmessage")
    public String duplicatedFirstmessage() {
        return service.getApplicationContextFirstMessage();
    }

    @GetMapping("/duplicated/secondmessage")
    public String duplicatedSecondmessage() {
        return service.getApplicationContextSecondMessage();
    }

    @GetMapping("/qualified/firstmessage")
    public String qualifiedFirstmessage() {
        return service.getQualifiedFirstMessage();
    }

    @GetMapping("/qualified/secondmessage")
    public String qualifiedSecondmessage() {
        return service.getQualifiedSecondMessage();
    }

}
