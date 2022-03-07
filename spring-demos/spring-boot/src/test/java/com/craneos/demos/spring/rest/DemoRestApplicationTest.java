package com.craneos.demos.spring.rest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
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
public class DemoRestApplicationTest {

    @Before
    public void setup(){
        DemoRestApplication.main(new String[] {});
    }

    @After
    public void after(){
        DemoRestApplication.getInstance().close();
    }

    @Test
    public void testToLowerCase() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/tolowercase/ABCDEFG");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String touppercase = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("abcdefg", touppercase);
    }

    @Test
    public void testToUpperCase() throws IOException {
        // Given
        HttpUriRequest request = new HttpPut( "http://localhost:8080/rest/touppercase/abcdefg");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String touppercase = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("ABCDEFG", touppercase);
    }

    @Test
    public void testToLowerCaseOld() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/rest/tolowercase/old/ABCDEFG");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String touppercase = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("abcdefg", touppercase);
    }

    @Test
    public void testToUpperCaseOld() throws IOException {
        // Given
        HttpUriRequest request = new HttpPut( "http://localhost:8080/rest/touppercase/old/abcdefg");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String touppercase = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("ABCDEFG", touppercase);
    }
}
