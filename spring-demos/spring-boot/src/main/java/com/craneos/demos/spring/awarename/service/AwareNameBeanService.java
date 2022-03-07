package com.craneos.demos.spring.awarename.service;

import org.springframework.beans.factory.BeanNameAware;

public class AwareNameBeanService implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String beanName) {
        this.name = beanName;
        System.out.println("setBeanName --> "+beanName);
    }

    public String getServiceName(){
        return name;
    }

}
