package com.craneos.demos.spring.autoconfiguration.config;

import com.craneos.demos.common.model.SimpleMessage;
import com.craneos.demos.common.service.CommonSimpleService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

/**
 * To create a custom auto-configuration, we need to create a class annotated as @Configuration and register it.
 * @Configuration
 * public class OtherAutoConfiguration {
 *     //...
 * }
 * The next mandatory step is registering the class as an auto-configuration candidate, by adding the name of the class
 * under the key:
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration
 *
 * in the standard file resources/META-INF/spring.factories:
 * org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
 * com.baeldung.autoconfiguration.MySQLAutoconfiguration
 *
 * If we want our auto-configuration class to have priority over other auto-configuration candidates, we can add the
 * @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE) annotation.
 *
 * Auto-configuration is designed using classes and beans marked with @Conditional annotations so that the
 * auto-configuration or specific parts of it can be replaced.
 */
@Configuration
@ConditionalOnClass(CommonSimpleService.class)
public class OtherAutoConfigurationWithConditionals {

    @Bean
    public SimpleMessage simpleMessage(){
        SimpleMessage message = new SimpleMessage();
        message.setId(101);
        message.setMessage("SIMPLE bean defined in the CONFIGURATION class. Third definition of the bean.");
        message.setName("test1");
        message.setTimestamp(String.valueOf(Calendar.getInstance().getTimeInMillis()));
        return message;
    }

}