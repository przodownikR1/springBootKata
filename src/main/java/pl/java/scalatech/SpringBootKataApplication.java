package pl.java.scalatech;


import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import static com.google.common.collect.Lists.newArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;


@SpringBootApplication
@Slf4j
@EnableCaching
@ConfigurationProperties(prefix="boot")
public class SpringBootKataApplication implements CommandLineRunner{

    private static final String APPLICATION_USER = "application.user";

    @Setter
    @Getter   
    private String simpleText;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private Environment env;
    
    @Bean
    InitializingBean bean(){
        return () -> log.info("!!!!  application.user : {}  : simpleTest : {}",env.getProperty(APPLICATION_USER),simpleText);
        
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
               
    }

    @Override
    public void run(String... args) throws Exception {
        List<Customer> customers = newArrayList(new Customer("slawek", "borowiec"),new Customer("kalina", "borowiec"),new Customer("mike", "tyson"),
                new Customer("evender", "holyfield"),new Customer("slawek", "nowak"),new Customer("slawek", "kacperski"),new Customer("kalina", "nowakowska"));
        customers.forEach(c->customerRepository.save(c));
        
        
    }
    
  
    

}
