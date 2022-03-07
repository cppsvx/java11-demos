package com.craneos.demos.spring.context.services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ContextService implements ApplicationContextAware {

    public static final String DEMO_CONTEXT_ID = "MyOwnId-14461";
    private String applicationId;
    private String id;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationId = applicationContext.getId();
        this.id = DEMO_CONTEXT_ID;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public String getId() {
        return id;
    }

}