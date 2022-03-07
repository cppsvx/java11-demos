package com.craneos.demos.spring.basic;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DemoBasicPortApplicationTest {

    @After
    public void after(){
        DemoBasicPortApplication.getInstance().close();
    }

    @Test
    public void main() {
        DemoBasicPortApplication.main(new String[] {"8191"});
    }

}
