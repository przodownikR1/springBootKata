package pl.java.scalatech.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqRoute extends RouteBuilder{

    
    @Override
    public void configure() throws Exception {
        from("rabbitmq:localhost:5672/tasks?username=admin&password=admin&autoDelete=false&durable=true&exchangeType=direct&routingKey=camel&queue=forCamel")
            .log(LoggingLevel.INFO, "Received message ${body}")
            .convertBodyTo(String.class)
            .to("amq:queue:fromCamel");
    }

   
   /*     DefaultCamelContext context = new DefaultCamelContext();
        context.addComponent("amq", ActiveMQComponent.jmsComponent(new ActiveMQConnectionFactory("admin", "admin", "tcp://localhost:61616")));
   */ 
}