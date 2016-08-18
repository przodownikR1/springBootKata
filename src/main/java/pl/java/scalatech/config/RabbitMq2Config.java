package pl.java.scalatech.config;

import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.EnableScheduling;

@RabbitListener(queues = "foo")
@EnableScheduling
@Profile("two")
@Configuration
public class RabbitMq2Config {
    @Bean
    public Sender mySender() {
        return new Sender();
    }

    @Bean
    public Queue fooQueue() {
        return new Queue("foo");
    }

    @RabbitHandler
    public void process(@Payload String foo) {
        System.out.println(new Date() + ": " + foo);
}
}
