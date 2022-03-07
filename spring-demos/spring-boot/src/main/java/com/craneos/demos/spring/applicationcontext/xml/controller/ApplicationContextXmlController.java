package com.craneos.demos.spring.applicationcontext.xml.controller;

import com.craneos.demos.spring.applicationcontext.xml.service.ApplicationContextXmlService;
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
public class ApplicationContextXmlController {

    @Autowired
    private ApplicationContextXmlService service;

    public ApplicationContextXmlController(){
        System.out.println("Instantiation of ApplicationContextXmlController");
    }

    @GetMapping("/simple")
    public String message() {
        return service.getSimpleMessage();
    }

    @GetMapping("/duplicated/firstmessage")
    public String duplicatedXmlFirstmessage() {
        return service.getApplicationContextXmlFirstMessage();
    }

    @GetMapping("/duplicated/secondmessage")
    public String duplicatedXmlSecondmessage() {
        return service.getApplicationContextXmlSecondMessage();
    }

    @GetMapping("/qualified/firstmessage")
    public String qualifiedXmlFirstmessage() {
        return service.getQualifiedXmlFirstMessage();
    }

    @GetMapping("/qualified/secondmessage")
    public String qualifiedXmlSecondmessage() {
        return service.getQualifiedXmlSecondMessage();
    }

}
