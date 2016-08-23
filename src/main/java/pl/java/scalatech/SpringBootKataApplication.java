package pl.java.scalatech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repo.CustomerRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages="pl.java.scalatech.repo")
@Slf4j
public class SpringBootKataApplication implements CommandLineRunner{

    @Autowired
    private CustomerRepository customerRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.save(Customer.builder().firstName("slawek").lastName("borowiec").build());
        customerRepository.findAll().forEach(cust -> log.info("++ {}",cust));
    }
    
  
}
