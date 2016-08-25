package pl.java.scalatech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="pl.java.scalatech.web.controller.assembler")
public class WebConfig {

}
