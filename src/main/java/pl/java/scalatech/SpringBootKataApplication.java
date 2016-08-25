package pl.java.scalatech;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;

@SpringBootApplication
@Slf4j
@EnableCaching
public class SpringBootKataApplication implements CommandLineRunner{

    private static final String APPLICATION_USER = "application.user";

    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private Environment env;
    
    @Bean
    InitializingBean bean(){
        return () -> log.info("!!!!  application.user : {}",env.getProperty(APPLICATION_USER));
        
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
