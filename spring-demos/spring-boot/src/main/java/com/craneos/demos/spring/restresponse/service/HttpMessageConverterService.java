package com.craneos.demos.spring.restresponse.service;

import com.craneos.demos.common.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HttpMessageConverterService {

    @Autowired
    private SimpleMessage simpleMessage;

    public String getSimpleMessage(){
        return simpleMessage.getMessage();
    }

    public SimpleMessage getFullMessage(){
        return simpleMessage;
    }

}
