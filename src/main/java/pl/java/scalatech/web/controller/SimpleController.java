package pl.java.scalatech.web.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleController {

    @RequestMapping("")
    String getSimpleText(){
        return "bianka "+getGenerateText();
    }
    
    String getGenerateText(){
        return UUID.randomUUID().toString();
    }
}
