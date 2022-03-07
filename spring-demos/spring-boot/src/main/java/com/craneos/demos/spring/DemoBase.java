package com.craneos.demos.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

public class DemoBase {

    private static DemoBase instance;

    @Autowired
    protected ApplicationContext applicationContext;

    public DemoBase(){
        System.out.println("DemoBase. Instatiation of "+DemoBase.class.getName());
    }

    @PostConstruct
    protected void init(){
        System.out.println("DemoBase. PostConstruct - Init");
        String[] springBootAppBeanName = applicationContext.getBeanNamesForAnnotation(SpringBootApplication.class);
        DemoBase.instance = (DemoBase)applicationContext.getBean(springBootAppBeanName[0]);
    }

    public static DemoBase getInstance(){
        return DemoBase.instance;
    }

    public void close() {
        System.out.println("Closing application = "+applicationContext.getDisplayName());
        SpringApplication.exit(applicationContext);
    }

}
