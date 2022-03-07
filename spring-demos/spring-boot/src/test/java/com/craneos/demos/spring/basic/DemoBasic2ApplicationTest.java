package com.craneos.demos.spring.basic;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DemoBasic2ApplicationTest {

    @After
    public void after(){
        DemoBasic2Application.getInstance().close();
    }

    @Test
    public void main() {
        DemoBasic2Application.main(new String[] {});
    }

}
