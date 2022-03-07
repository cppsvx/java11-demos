package com.craneos.demos.spring.autoconfiguration;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
public class DemoAutoConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Before
    public void setup(){
        DemoAutoConfiguration.main(new String[] {});
    }

    @After
    public void after(){
        DemoAutoConfiguration.getInstance().close();
    }

    @Test
    public void testSimple() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/autoconfiguration/simple");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("SIMPLE bean defined in the CONFIGURATION class. Second definition of the bean.", responseNormal);
    }

}
