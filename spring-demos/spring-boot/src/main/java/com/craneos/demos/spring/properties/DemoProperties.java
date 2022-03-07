package com.craneos.demos.spring.properties;

import com.craneos.demos.spring.DemoBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * If Spring Security is on the classpath, then web applications are secured by default.
 */
@SpringBootApplication
public class DemoProperties extends DemoBase {

    public static void main(String[] args) {
        SpringApplication.run(DemoProperties.class, args);
    }

}
