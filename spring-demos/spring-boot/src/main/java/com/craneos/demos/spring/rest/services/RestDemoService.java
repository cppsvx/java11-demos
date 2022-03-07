package com.craneos.demos.spring.rest.services;

import org.springframework.stereotype.Service;

@Service
public class RestDemoService {

    public String getSalute(){
        return "Hi Bro, this is a controller with string utilities!";
    }

    public String toLowerCase(String text1) {
        return text1.toLowerCase();
    }

    public String toUpperCase(String text1) {
        return text1.toUpperCase();
    }
}