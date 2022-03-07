package com.craneos.demos.spring.properties;

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
public class DemoPropertiesTest {

    @Before
    public void setup(){
        DemoProperties.main(new String[] {});
    }

    @After
    public void after(){
        DemoProperties.getInstance().close();
    }

    @Test
    public void testSalute() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/properties/salute");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("Greetings from Spring Boot!", responseNormal);
    }

    @Test
    public void testValues() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/properties/values");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("Hi, this is the value defined in properties --> 90323 - testing defined value --> and this is the static one --> my.static.value", responseNormal);
    }

}
