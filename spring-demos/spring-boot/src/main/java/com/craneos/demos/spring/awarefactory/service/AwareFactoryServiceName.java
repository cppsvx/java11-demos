package com.craneos.demos.spring.awarefactory.service;

import org.springframework.beans.factory.BeanNameAware;

public class AwareFactoryServiceName implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String beanName) {
        this.name = beanName;
        System.out.println("setBeanName --> "+beanName);
    }

    public String getName(){
        return name;
    }
}