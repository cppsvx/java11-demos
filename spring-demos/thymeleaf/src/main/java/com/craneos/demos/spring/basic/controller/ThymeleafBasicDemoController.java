package com.craneos.demos.spring.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Use @Controller instead of @RestController when working with a templating engine and you don't want the return value to be bound to the response body:
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafBasicDemoController {

    @GetMapping("/nomodel")
    public ModelAndView nomodel() {
        // demo_basic point to the template 'demo_basic.html'
        ModelAndView modelAndView = new ModelAndView("demo_basic");
        modelAndView.addObject("message", "my name is DemoThyme");
        return modelAndView;
    }

    @GetMapping("/model")
    public String model(Model model) {
        model.addAttribute("message", "my name is Second DemoThyme");
        model.addAttribute("tasks", "my task");
        // demo_basic point to the template 'demo_basic.html'
        return "demo_basic";
    }

    @GetMapping("/modelwithparam")
    public String modelwithparam(@RequestParam(name = "name", required = false, defaultValue = "") String name,
                                 Model model) {
        model.addAttribute("message", name);
        model.addAttribute("tasks", "my task");
        // demo_basic point to the template 'demo_basic.html'
        return "demo_basic";
    }
}
