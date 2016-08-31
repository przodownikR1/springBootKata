package pl.java.scalatech.web.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.security.Principal;
@RestController
@RequestMapping(value = "/api", produces = {APPLICATION_JSON_VALUE})
public class Api {

    @Produce(uri = "direct:sayHello")
    private ProducerTemplate sayHelloProducer;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    private void sayHello() {
        sayHelloProducer.requestBody("Hello");
    }
    
    @Autowired
    private CamelContext camelContext;

    
    @RequestMapping(value = "/send", method = RequestMethod.POST, consumes = "application/json")
    public void sendMessage(@RequestBody MyMessage message, Principal currentUser) {     
        message.setFromUser("przodownik");
        camelContext.createProducerTemplate().sendBody("activemq:rt_messages", message);
}
}