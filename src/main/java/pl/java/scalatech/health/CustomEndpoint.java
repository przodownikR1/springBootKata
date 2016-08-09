package pl.java.scalatech.health;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpoint implements Endpoint<List<String>> {
     
    @Override
    public String getId() {
        return "myEndpoint";
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
 
    @Override
    public boolean isSensitive() {
        return true;
    }
 
    @Override
    public List<String> invoke() {
        List<String> messages = new ArrayList<>();
        messages.add("test one");
        messages.add("test 2");
        return messages;
    }
}