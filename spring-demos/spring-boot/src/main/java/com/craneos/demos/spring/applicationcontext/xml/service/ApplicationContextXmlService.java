package com.craneos.demos.spring.applicationcontext.xml.service;

import com.craneos.demos.spring.applicationcontext.xml.service.model.ApplicationContextXmlMessage;
import com.craneos.demos.spring.applicationcontext.xml.service.model.QualifiedContextXmlMessage;
import com.craneos.demos.common.model.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ApplicationContextXmlService {

    @Autowired
    private SimpleMessage simpleMessage;

    @Autowired
    private ApplicationContextXmlMessage firstMessage;

    @Autowired
    private ApplicationContextXmlMessage secondMessage;

    @Autowired
    @Qualifier("qualifiedMessage1")
    private QualifiedContextXmlMessage qualifiedFirstMessage;

    @Autowired
    @Qualifier("qualifiedMessage2")
    private QualifiedContextXmlMessage qualifiedSecondMessage;

    public String getSimpleMessage(){
        return simpleMessage.getMessage();
    }

    public String getApplicationContextXmlFirstMessage(){
        return firstMessage.getMessage();
    }

    public String getApplicationContextXmlSecondMessage(){
        return secondMessage.getMessage();
    }

    public String getQualifiedXmlFirstMessage(){
        return qualifiedFirstMessage.getMessage();
    }

    public String getQualifiedXmlSecondMessage(){
        return qualifiedSecondMessage.getMessage();
    }

}
