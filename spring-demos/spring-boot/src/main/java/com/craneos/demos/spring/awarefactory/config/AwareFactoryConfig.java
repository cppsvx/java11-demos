package com.craneos.demos.spring.awarefactory.config;

import com.craneos.demos.spring.awarefactory.service.AwareFactoryService;
import com.craneos.demos.spring.awarefactory.service.AwareFactoryServiceName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.craneos.demos.spring.awarefactory"})
public class AwareFactoryConfig {

    @Bean(name = "myCustomBeanNameByValue")
    public AwareFactoryServiceName awareFactoryBeanName() {
        return new AwareFactoryServiceName();
    }

    @Bean(name = "myBeanFactory")
    public AwareFactoryService awareBeanFactory() {
        return new AwareFactoryService();
    }

}
