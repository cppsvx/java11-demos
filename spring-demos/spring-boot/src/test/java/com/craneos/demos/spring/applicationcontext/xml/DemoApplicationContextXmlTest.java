package com.craneos.demos.spring.applicationcontext.xml;

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
public class DemoApplicationContextXmlTest {

    @Before
    public void setup(){
        DemoApplicationContextXml.main(new String[] {});
    }

    @After
    public void after(){
        DemoApplicationContextXml.getInstance().close();
    }

    @Test
    public void testSimple() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/context/simple");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("SIMPLE bean defined in the xml file", responseNormal);
    }

    @Test
    public void testDuplicatedFirst() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/context/duplicated/firstmessage");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("this is the message autowired of the SECOND bean defined in the xml file", responseNormal);
    }

    @Test
    public void testDuplicatedSecond() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/context/duplicated/secondmessage");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("this is the message autowired of the SECOND bean defined in the xml file", responseNormal);
    }

    @Test
    public void testQualifiedFirst() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/context/qualified/firstmessage");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("QUALIFIED bean. Message autowired of the -qualifiedMessage1- bean defined in the xml file", responseNormal);
    }

    @Test
    public void testQualifiedSecond() throws IOException {
        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/context/qualified/secondmessage");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        // Test
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
        Assert.assertEquals("QUALIFIED bean. Message autowired of the -qualifiedMessage2- bean defined in the xml file", responseNormal);
    }
}
