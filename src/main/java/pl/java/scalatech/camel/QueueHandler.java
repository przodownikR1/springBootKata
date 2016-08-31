package pl.java.scalatech.camel;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

import pl.java.scalatech.web.controller.MyMessage;

@Component(value = "queueHandler")
public class QueueHandler {

    @Autowired
    private SimpMessageSendingOperations msgTemplate;

    private static Map<String, Object> defaultHeaders;

    static {
        defaultHeaders = new HashMap<>();
        // add the Content-Type: application/json header by default
        defaultHeaders.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
    }

    public void handle(Exchange exchange) {
        Message camelMessage = exchange.getIn();
        MyMessage message = camelMessage.getBody(MyMessage.class);
        
        msgTemplate.convertAndSendToUser(message.getToUser(), "/topic/messages", message, defaultHeaders);
    }
}