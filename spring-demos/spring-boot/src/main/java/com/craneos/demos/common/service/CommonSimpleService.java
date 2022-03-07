package com.craneos.demos.common.service;

import org.springframework.stereotype.Service;

@Service
public class CommonSimpleService {

    private static final String DEFAULT_MESSAGE = "This is the service MyCommonService";

    public String getDefaultMessage(){
        return DEFAULT_MESSAGE;
    }

}
