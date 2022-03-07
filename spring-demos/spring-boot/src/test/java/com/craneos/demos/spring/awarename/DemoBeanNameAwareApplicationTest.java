package com.craneos.demos.spring.awarename;

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
public class DemoBeanNameAwareApplicationTest {

    @Before
    public void setup(){
        DemoBeanNameAwareApplication.main(new String[] {});
    }

    @After
    public void after() {
        DemoBeanNameAwareApplication.getInstance().close();
    }

    @Test
    public void testNormal() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/aware/name");
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        String responseNormal = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        // Test
        Assert.assertEquals("myCustomServiceNameByValue", responseNormal);
    }

}
