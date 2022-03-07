package com.craneos.demos.spring.basic;

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
public class DemoThymeleafTest {

    @Before
    public void setup(){
        DemoThymeleaf.main(new String[] {});
    }

    @After
    public void after(){
        DemoThymeleaf.getInstance().close();
    }

    @Test
    public void testNoModel() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/thymeleaf/nomodel");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String touppercase = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertTrue(touppercase.contains("Hello, my name is DemoThyme"));
    }

    @Test
    public void testModel() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/thymeleaf/model");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String touppercase = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertTrue(touppercase.contains("Hello, my name is Second DemoThyme"));
    }

    @Test
    public void testModelWithParam() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/thymeleaf/modelwithparam?name=james");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String touppercase = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertTrue(touppercase.contains("Hello, james"));
    }
}
