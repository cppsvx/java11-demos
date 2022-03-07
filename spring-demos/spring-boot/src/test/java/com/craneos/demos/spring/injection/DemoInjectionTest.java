package com.craneos.demos.spring.injection;

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
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
public class DemoInjectionTest {

    @Before
    public void setup(){
        DemoInjection.main(new String[] {});
    }

    @After
    public void after(){
        DemoInjection.getInstance().close();
    }

    @Test
    public void testNormal() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/injection/normal");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("Greetings from Spring Boot!", responseNormal);
    }

    @Test
    public void testAutowired() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/injection/autowired");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("Greetings from Spring Boot from an autowired Bean!!!!", responseNormal);
    }

}
