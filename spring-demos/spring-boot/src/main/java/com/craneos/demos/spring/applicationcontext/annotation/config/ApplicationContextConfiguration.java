package com.craneos.demos.spring.applicationcontext.annotation.config;

import com.craneos.demos.spring.applicationcontext.annotation.service.model.ApplicationContextMessage;
import com.craneos.demos.common.model.SimpleMessage;
import com.craneos.demos.spring.applicationcontext.annotation.service.model.QualifiedContextMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Calendar;

@Configuration
public class ApplicationContextConfiguration {

    @Bean
    public SimpleMessage simpleApplicationContextMessage(){
        SimpleMessage message = new SimpleMessage();
        message.setId(101);
        message.setMessage("SIMPLE bean defined in the CONFIGURATION class");
        message.setName("test1");
        message.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return message;
    }

    @Bean
    @Primary
    public ApplicationContextMessage testContextMessage1(){
        ApplicationContextMessage message = new ApplicationContextMessage();
        message.setId(201);
        message.setMessage("this is the message autowired of the FIRST bean defined in CONFIGURATION");
        message.setName("test 201");
        message.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return message;
    }

    @Bean
    public ApplicationContextMessage testContextMessage2(){
        ApplicationContextMessage message = new ApplicationContextMessage();
        message.setId(202);
        message.setMessage("this is the message autowired of the SECOND bean defined in CONFIGURATION");
        message.setName("test 202");
        message.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return message;
    }

    @Bean
    @Qualifier("qualifiedMessage1")
    public QualifiedContextMessage qualifiedMessageFirst(){
        QualifiedContextMessage message = new QualifiedContextMessage();
        message.setId(201);
        message.setMessage("QUALIFIED bean. Message autowired of the -qualifiedMessage1- bean defined in the CONFIGURATION class");
        message.setName("test 201");
        message.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return message;
    }

    @Bean
    @Qualifier("qualifiedMessage2")
    public QualifiedContextMessage qualifiedMessageSecond(){
        QualifiedContextMessage message = new QualifiedContextMessage();
        message.setId(202);
        message.setMessage("QUALIFIED bean. Message autowired of the -qualifiedMessage2- bean defined in the CONFIGURATION class");
        message.setName("test 202");
        message.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return message;
    }

}