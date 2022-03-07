package com.craneos.demos.spring.awarefactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoBeanFactoryAwareApplicationTest {

    @Before
    public void setup(){
        DemoBeanFactoryAwareApplication.main(new String[] {});
    }

    @After
    public void after() {
        DemoBeanFactoryAwareApplication.getInstance().close();
    }

    @Test
    public void testNormal() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/aware/beanFromFactory");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        // Test
        Assert.assertEquals("myCustomBeanNameByValue", responseNormal);
    }

}
