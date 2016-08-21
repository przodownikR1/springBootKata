package pl.java.scalatech;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

import com.thoughtworks.xstream.XStream;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication // <1>
public class SpringBootKataApplication { // <2>

 
    public static void main(String[] args) { // <4>
        SpringApplication.run(SpringBootKataApplication.class, args);
        
        
        
    }
    @Bean
    CommandLineRunner command(XStream xstream){
        return args -> {
           
            Dog dog = new Dog("przodownik", 23);
            String result  = xstream.toXML(dog);
            
            log.info("{}",result);
        };
    }
      
    
    @Bean
    @ConditionalOnMissingClass(value="pl.java.scalatech.compoment.One1")
    String generateHello(){
      log.info("_+++ hello boot");
      return "hello boot";
    }
    @RequiredArgsConstructor    
    @ToString
    public static class Dog{
        @Getter
        private final String name;
        @Getter
        private final int age;
        
        
    }
    
}
