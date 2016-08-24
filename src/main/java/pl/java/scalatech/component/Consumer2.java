package pl.java.scalatech.component;

import java.util.Map;

import javax.jms.JMSException;
import org.springframework.messaging.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.validation.Valid;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.jms.support.JmsMessageHeaderAccessor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.JmsConfig;

@Component
@Slf4j
public class Consumer2 {

    @JmsListener(destination = JmsConfig.SAMPLE_QUEUE)
    @SendTo("anotherQueue")
    public Message<String> echo(String input, JmsMessageHeaderAccessor headerAccessor) {
        log.info("Sending back: " + input + " (messageId=" + headerAccessor.getMessageId() + ")");
        return MessageBuilder.withPayload(input).setHeader("myCustomHeader", "foo").setHeader(JmsHeaders.TYPE, "myJmsType").build();
    }

    @JmsListener(destination = "anotherQueue")
    public void log(String input, @Header(JmsHeaders.CORRELATION_ID) String correlationId) {
        log.info("++++ Received  from anotherQueue : " + input + " (correlationId=" + correlationId + ")");

    }
}