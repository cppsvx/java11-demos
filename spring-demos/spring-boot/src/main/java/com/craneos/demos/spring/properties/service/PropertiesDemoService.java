package com.craneos.demos.spring.properties.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertiesDemoService {

    @Value("my.static.value")
    private String staticValue;

    @Value("${my.defined.value}")
    private String definedValue;

    public String getSalute(){
        return "Greetings from Spring Boot!";
    }

    public String getDefinedValue(){
        return String.format("Hi, this is the value defined in properties --> %s --> and this is the static one --> %s", definedValue, staticValue);
    }
}