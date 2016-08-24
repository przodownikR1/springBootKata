package pl.java.scalatech.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableScheduling
@EnableJms
@Slf4j
public class JmsConfig {

    public static final String SAMPLE_QUEUE = "sample1.queue";

    @Bean
    public Queue queue() {
        log.info("+++ create queue,.....");
        return new ActiveMQQueue(SAMPLE_QUEUE);
    }
}
