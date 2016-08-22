package pl.java.scalatech.component;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.SpringBootKataApplication;

@Component
@Slf4j
@NoArgsConstructor
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

  

    @Scheduled(fixedDelay = 2000)
    public void sendMessage() {
        MessageCreator messageCreator = session -> session.createTextMessage("ping! " + UUID.randomUUID().toString());
        log.info("Sending a new message. ");
        jmsTemplate.send(SpringBootKataApplication.MY_QUEUE, messageCreator);
    }
}
