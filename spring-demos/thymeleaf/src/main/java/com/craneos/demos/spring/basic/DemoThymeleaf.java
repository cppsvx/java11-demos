package com.craneos.demos.spring.basic;

import com.craneos.demos.spring.DemoThymeleafBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 */
@SpringBootApplication
public class DemoThymeleaf extends DemoThymeleafBase {

    public static void main(String[] args) {
        SpringApplication.run(DemoThymeleaf.class, args);
    }

}
