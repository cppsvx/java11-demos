package com.craneos.demos.spring.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class SecurityDemoService {

    public String getSalute(){
        return "Hi, this is a controller for security spring testing!";
    }

}