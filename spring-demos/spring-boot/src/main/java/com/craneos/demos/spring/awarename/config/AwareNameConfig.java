package com.craneos.demos.spring.awarename.config;

import com.craneos.demos.spring.awarename.service.AwareNameBeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwareNameConfig {

    @Bean(name = "myCustomServiceNameByValue")
    public AwareNameBeanService awareNameBeanService() {
        return new AwareNameBeanService();
    }

}
