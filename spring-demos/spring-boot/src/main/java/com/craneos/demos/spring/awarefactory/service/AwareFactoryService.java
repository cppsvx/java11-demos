package com.craneos.demos.spring.awarefactory.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;

public class AwareFactoryService implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Autowired
    private AwareFactoryServiceName awareFactoryServiceName;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public String getMyBeanNameFromFactory() {
        AwareFactoryServiceName awareFactoryBeanNameFromFactory = beanFactory.getBean(AwareFactoryServiceName.class);
        System.out.println("myBeanNameFromFactory --> "+ awareFactoryBeanNameFromFactory.getName());
        System.out.println("beanFactory --> "+beanFactory.isSingleton(awareFactoryBeanNameFromFactory.getName()));
        return awareFactoryBeanNameFromFactory.getName();
    }
}
