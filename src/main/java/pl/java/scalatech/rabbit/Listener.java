package pl.java.scalatech.rabbit;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "spring.in")
    void handleMessage(Message message) throws UnsupportedEncodingException {
        String newMessage = "Spring: " + new String(message.getBody(), "UTF-8");
        rabbitTemplate.send("spring.out", new Message(newMessage.getBytes("UTF-8"), new MessageProperties()));
    }
}