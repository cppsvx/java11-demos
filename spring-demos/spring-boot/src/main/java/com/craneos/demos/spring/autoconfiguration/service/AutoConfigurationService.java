package com.craneos.demos.spring.autoconfiguration.service;

import com.craneos.demos.common.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoConfigurationService {

    // Notice the name match the method name of the bean definition in configuration file
    @Autowired
    private SimpleMessage simpleMessage;

    // Notice the name match the method name of the bean definition in configuration file
    @Autowired
    private SimpleMessage simpleMessage2;

    public String getSimpleMessage(){
        return simpleMessage2.getMessage();
    }

}
