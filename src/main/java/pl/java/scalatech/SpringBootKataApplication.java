package pl.java.scalatech;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Customer;

@SpringBootApplication
@Slf4j
public class SpringBootKataApplication {
    
    @Bean
    @Profile("json")
    XStream xstream(){
        return new XStream(new JsonHierarchicalStreamDriver());
    }
    
    
    @Bean
    CommandLineRunner customerPrinter(XStream xstream){
        return args -> {                     
            Customer customer = Customer.builder().firstName("slawek").lastName("borowiec").id("1").build();
            log.info("customer : {}",xstream.toXML(customer));    
        };
        
    }
    
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }
    
  
    
    
    

}
