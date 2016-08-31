package pl.java.scalatech.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MySimpleQueueRoute {
     
    @Bean
    RouteBuilder myRouter() {
        return new RouteBuilder() {

            @Override
            public void configure() throws Exception {
         
                from("activemq:rt_messages").to("bean:queueHandler");
            }
        };
}
}

