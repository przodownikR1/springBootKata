package pl.java.scalatech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repo.CustomerRepository;

@SpringBootApplication
@Slf4j
public class SpringBootKataApplication implements CommandLineRunner{

    @Autowired
    private CustomerRepository customerRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
         Customer customer = new Customer();
         customer.setFirstName("slawek");
         customer.setLastName("borowiec");
         pl.java.scalatech.domain.Address address = pl.java.scalatech.domain.Address.builder().addressLine1("polna 12").city("warszawa").country("polska").build();
         pl.java.scalatech.domain.Address address2 = pl.java.scalatech.domain.Address.builder().addressLine1("zielna 12").city("radom").country("polska").build();
         customer.getAddresses().add(address);
         customer.getAddresses().add(address2);
         customerRepository.save(customer);
      
         log.info("+++  {}",customerRepository.findAll());
    }
    
  
    

}
