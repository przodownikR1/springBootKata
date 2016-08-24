package pl.java.scalatech.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.config.JmsConfig;


@Component
@Slf4j
public class Consumer {

	@JmsListener(destination = JmsConfig.SAMPLE_QUEUE)
	public void receiveQueue(String text) {
		log.info("receive text : {}",text);
	}

}