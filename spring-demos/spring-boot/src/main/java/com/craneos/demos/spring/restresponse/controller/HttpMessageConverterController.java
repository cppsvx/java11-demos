package com.craneos.demos.spring.restresponse.controller;

import com.craneos.demos.spring.restresponse.service.HttpMessageConverterService;
import com.craneos.demos.common.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/converter")
public class HttpMessageConverterController {

    @Autowired
    private HttpMessageConverterService service;

    public HttpMessageConverterController(){
        System.out.println("Instantiation of HttpConverterController");
    }

    @GetMapping("/simple")
    public String message() {
        return service.getSimpleMessage();
    }

    @GetMapping("/message/{text}")
    public String message(@PathVariable String text) {
        return text + " ---> suffix added!!";
    }

    @GetMapping("/message/responsebody/{text}")
    public @ResponseBody String messageResponseBody(@PathVariable String text) {
        return text + " ---> suffix added!!";
    }

    @GetMapping("/fullmessage")
    public SimpleMessage messageWithClass() {
        return service.getFullMessage();
    }

    @GetMapping(value = "/fullmessage/responsebody/rss", produces = {MediaType.APPLICATION_RSS_XML_VALUE})
    public @ResponseBody SimpleMessage messageResponseBodyRss() {
        return service.getFullMessage();
    }

    @GetMapping(value = "/fullmessage/responsebody/atom", produces = {MediaType.APPLICATION_ATOM_XML_VALUE})
    public @ResponseBody SimpleMessage messageResponseBodyAtom() {
        return service.getFullMessage();
    }

    @GetMapping(value = "/fullmessage/responsebody/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody SimpleMessage messageResponseBodyJson() {
        return service.getFullMessage();
    }

    @GetMapping(value = "/fullmessage/responsebody/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody SimpleMessage messageResponseBodyXml() {
        return service.getFullMessage();
    }

}
