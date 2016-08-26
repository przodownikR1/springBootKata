package pl.java.scalatech.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class RequestReply {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "spring.rr.in")
    @SendTo("spring.rr.out")
    String handleMessage(String message) {
        return "Spring: " + message;
    }
}