package com.craneos.demos.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

public class DemoThymeleafBase {

    private static DemoThymeleafBase instance;

    @Autowired
    protected ApplicationContext applicationContext;

    public DemoThymeleafBase(){
        System.out.println("DemoBase. Instatiation of "+ DemoThymeleafBase.class.getName());
    }

    @PostConstruct
    protected void init(){
        System.out.println("DemoBase. PostConstruct - Init");
        String[] springBootAppBeanName = applicationContext.getBeanNamesForAnnotation(SpringBootApplication.class);
        DemoThymeleafBase.instance = (DemoThymeleafBase)applicationContext.getBean(springBootAppBeanName[0]);
    }

    public static DemoThymeleafBase getInstance(){
        return DemoThymeleafBase.instance;
    }

    public void close() {
        System.out.println("Closing application = "+applicationContext.getDisplayName());
        SpringApplication.exit(applicationContext);
    }

}
