package com.craneos.demos.spring.basic;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DemoBasicContextApplicationTest {

    @After
    public void after() {
        DemoBasicContextApplication.getInstance().close();
    }

    @Test
    public void main() {
        DemoBasicContextApplication.main(new String[] {});
    }

    @Test
    public void mainWithArgs() {
        DemoBasicContextApplication.main(new String[] {"aaa", "bbbb"});
    }

}
