# spring-boot-demo
## REFERENCE
Related links from Spring:

CHAPTER | Reference | Link
--------- | --------- | ----------
0|Main Reference | https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/index.html
15|Configuration classes | https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-configuration-classes.html
17|Dependendy Injection | https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-spring-beans-and-dependency-injection.html
18|@SpringBootApplication | https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/using-boot-using-springbootapplication-annotation.html
27|JSON |https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/boot-features-json.html
47|Create your own auto-configuration|https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/boot-features-developing-auto-configuration.html
*|*|*
-|Common application properties|https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html
--------------------

## DEMOS

### BASIC - SpringBootApplication demo
Basic ways of how to use @SpringBootApplication
```
@SpringBootApplication
public class DemoBasic1Application extends DemoBase {
    public static void main(String[] args) {
        SpringApplication.run(DemoBasic1Application.class, args);
    }

}
```
Click [here](https://github.com/ciprisanchez/spring-demo/tree/master/src/main/java/com/craneos/spring/demos/basic) to go to the demo.


### APPLICATION CONTEXT FROM FILE
Example of a configuration loaded from file. Bean definitions and use of primary and qualifier annotations.
```
@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class DemoApplicationContextFile extends DemoBase {
```
Click [here](https://github.com/ciprisanchez/spring-mvc-demo/tree/master/src/main/java/com/craneos/spring/demos/applicationcontext/xml) to go to the demo.


### APPLICATION CONTEXT FROM CONFIGURATION CLASS
Example of a configuration loaded from a class annotated with @Configuration. Bean definitions and use of primary and qualifier annotations.
```
@Configuration
public class ApplicationContextConfiguration {

    @Bean
    public SimpleApplicationContextMessage simpleApplicationContextMessage(){
```
Click [here](https://github.com/ciprisanchez/spring-mvc-demo/tree/master/src/main/java/com/craneos/spring/demos/applicationcontext/annotation) to go to the demo.


### AWARE - BeanFactoryAware
Demo of interface BeanFactoryAware
```
public class AwareFactoryService implements BeanFactoryAware {
```
Click [here](https://github.com/ciprisanchez/spring-demo/tree/master/src/main/java/com/craneos/spring/demos/awarefactory) to go to the demo.


### AWARE - BeanNameAware
Demo of interface BeanNameAware
```
public class AwareNameBeanService implements BeanNameAware {
```
Click [here](https://github.com/ciprisanchez/spring-demo/tree/master/src/main/java/com/craneos/spring/demos/awarename) to go to the demo.


### CONTEXT
Example of an autowired ApplicationContext
```
@Autowired
private ApplicationContext applicationContext;
```
Click [here](https://github.com/ciprisanchez/spring-demo/tree/master/src/main/java/com/craneos/spring/demos/context) to go to the demo.


### INJECTION
Example of an autowired ApplicationContext
```
@SpringBootApplication
public class DemoInjection extends DemoBase {
    ....
    @Bean
    public InjectionMessage basicInjectionMessage(){
        ........
    }
}
```
Click [here](https://github.com/ciprisanchez/spring-demo/tree/master/src/main/java/com/craneos/spring/demos/injection) to go to the demo.


### INJECTION CONFIG
Example of an autowired ApplicationContext
```
@Configuration
public class InjectionConfig {
    @Bean
    public InjectionConfigMessage basicInjectionConfigMessage(){
        ..........
    }
}
```
Click [here](https://github.com/ciprisanchez/spring-demo/tree/master/src/main/java/com/craneos/spring/demos/injectionconfig) to go to the demo.


### REST
Annotations @RestController, @RequestMapping, @GetMapping and @PutMapping
```
    @GetMapping(value="/tolowercase/{text}")
    public String toLowerCase(@PathVariable("text") String text) {
        ....
    }

    @PutMapping(value="/touppercase/{text}")
    public String toUpperCase(@PathVariable("text") String text) {
        ....
    }
```
Click [here](https://github.com/ciprisanchez/spring-demo/tree/master/src/main/java/com/craneos/spring/demos/rest) to go to the demo.