package com.craneos.demos.spring.applicationcontext.annotation.service;

import com.craneos.demos.spring.applicationcontext.annotation.service.model.ApplicationContextMessage;
import com.craneos.demos.common.model.SimpleMessage;
import com.craneos.demos.spring.applicationcontext.annotation.service.model.QualifiedContextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextService {

    @Autowired
    private SimpleMessage simpleMessage;

    @Autowired
    private ApplicationContextMessage firstMessage;

    @Autowired
    private ApplicationContextMessage secondMessage;

    @Autowired
    @Qualifier("qualifiedMessage1")
    private QualifiedContextMessage qualifiedFirstMessage;

    @Autowired
    @Qualifier("qualifiedMessage2")
    private QualifiedContextMessage qualifiedSecondMessage;

    public String getSimpleApplicationContextMessage(){
        return simpleMessage.getMessage();
    }

    public String getApplicationContextFirstMessage(){
        return firstMessage.getMessage();
    }

    public String getApplicationContextSecondMessage(){
        return secondMessage.getMessage();
    }

    public String getQualifiedFirstMessage(){
        return qualifiedFirstMessage.getMessage();
    }

    public String getQualifiedSecondMessage(){
        return qualifiedSecondMessage.getMessage();
    }

}
