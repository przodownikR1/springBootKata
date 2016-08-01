package pl.java.scalatech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.java.scalatech.filters.SimpleFilter;

@Configuration
@ComponentScan(basePackages="pl.java.scalatech.filters")
public class WebConfig {

    @Bean
    SimpleFilter simpleFilter(){
        return new SimpleFilter();
    }
}
