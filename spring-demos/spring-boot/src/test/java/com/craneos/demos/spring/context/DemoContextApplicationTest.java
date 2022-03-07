package com.craneos.demos.spring.context;

import com.craneos.demos.spring.context.services.ContextService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DemoContextApplication.class)
public class DemoContextApplicationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Before
    public void setup(){
        DemoContextApplication.main(new String[] {});
    }

    @After
    public void after() {
        DemoContextApplication.getInstance().close();
    }

    @Test
    public void test() throws IOException {
        // Test ApplicationContextAware
        ContextService contextService = applicationContext.getBean(ContextService.class);
        System.out.println("application_id ---> "+ contextService.getApplicationId());
        System.out.println("id ---------------> "+ contextService.getId());
        Assert.assertTrue(contextService.getId().equals(ContextService.DEMO_CONTEXT_ID));

        // Test Rest
        HttpUriRequest request = new HttpGet( "http://localhost:8080/context/displayname");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
    }

}
