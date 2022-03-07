package com.craneos.demos.spring.restresponse.config;

import com.craneos.demos.common.model.SimpleMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Configuration
public class HttpMessageConverterConfiguration {

    @Bean
    public SimpleMessage simpleMessage(){
        SimpleMessage message = new SimpleMessage();
        message.setId(101);
        message.setMessage("SIMPLE bean defined in the CONFIGURATION class");
        message.setName("test1");
        message.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return message;
    }

}