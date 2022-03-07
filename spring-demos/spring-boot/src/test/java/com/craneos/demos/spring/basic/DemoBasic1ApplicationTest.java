package com.craneos.demos.spring.basic;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DemoBasic1ApplicationTest {

    @After
    public void after(){
        DemoBasic1Application.getInstance().close();
    }

    @Test
    public void main() {
        DemoBasic1Application.main(new String[] {});
    }

}
