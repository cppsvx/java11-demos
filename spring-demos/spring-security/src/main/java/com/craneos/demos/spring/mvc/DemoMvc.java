package com.craneos.demos.spring.mvc;

import com.craneos.demos.spring.DemoSecurityBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * If Spring Security is on the classpath, then web applications are secured by default.
 */
@SpringBootApplication
public class DemoMvc extends DemoSecurityBase {

    public static void main(String[] args) {
        SpringApplication.run(DemoMvc.class, args);
    }

}
