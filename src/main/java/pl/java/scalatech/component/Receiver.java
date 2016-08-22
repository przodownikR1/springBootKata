package pl.java.scalatech.component;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.SpringBootKataApplication;

@Component
@Slf4j
public class Receiver {

  
    @Autowired
    ConfigurableApplicationContext context;

    @JmsListener(destination = SpringBootKataApplication.MY_QUEUE, containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        log.info("++++          Received {}", message);
        context.close();
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}