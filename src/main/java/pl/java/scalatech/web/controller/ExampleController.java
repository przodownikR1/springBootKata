package pl.java.scalatech.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // <1>
public class ExampleController {

    @RequestMapping("/") // <2> 
    String home() {
        return "Hello World!";
    }

    
}