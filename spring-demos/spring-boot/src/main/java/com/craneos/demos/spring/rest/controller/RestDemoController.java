package com.craneos.demos.spring.rest.controller;

import com.craneos.demos.spring.rest.services.RestDemoService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/rest")
public class RestDemoController {

    @Autowired
    private RestDemoService restDemoService;

    @GetMapping("/salute")
    public String salute() {
        return restDemoService.getSalute();
    }

    @GetMapping(value="/tolowercase/{text}")
    public String toLowerCase(@PathVariable("text") String text) {
        return restDemoService.toLowerCase(text);
    }

    @RequestMapping(value="/tolowercase/old/{text}", method=RequestMethod.GET)
    public String toLowerCaseOld(@PathVariable("text") String text) {
        return restDemoService.toLowerCase(text);
    }

    @PutMapping(value="/touppercase/{text}")
    public String toUpperCase(@PathVariable("text") String text) {
        return restDemoService.toUpperCase(text);
    }

    @RequestMapping(value="/touppercase/old/{text}")
    public String toUpperCaseOld(@PathVariable("text") String text) {
        return restDemoService.toUpperCase(text);
    }
}
