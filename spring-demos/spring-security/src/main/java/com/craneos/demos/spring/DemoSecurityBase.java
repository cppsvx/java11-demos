package com.craneos.demos.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

public class DemoSecurityBase {

    private static DemoSecurityBase instance;

    @Autowired
    protected ApplicationContext applicationContext;

    public DemoSecurityBase(){
        System.out.println("DemoBase. Instatiation of "+ DemoSecurityBase.class.getName());
    }

    @PostConstruct
    protected void init(){
        System.out.println("DemoBase. PostConstruct - Init");
        String[] springBootAppBeanName = applicationContext.getBeanNamesForAnnotation(SpringBootApplication.class);
        DemoSecurityBase.instance = (DemoSecurityBase)applicationContext.getBean(springBootAppBeanName[0]);
    }

    public static DemoSecurityBase getInstance(){
        return DemoSecurityBase.instance;
    }

    public void close() {
        System.out.println("Closing application = "+applicationContext.getDisplayName());
        SpringApplication.exit(applicationContext);
    }

}
