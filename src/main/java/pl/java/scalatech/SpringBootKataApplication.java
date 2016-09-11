package pl.java.scalatech;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import pl.java.scalatech.counter.DbCountRunner;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.domain.Invoice;
import pl.java.scalatech.repository.CustomerRepo;
import pl.java.scalatech.repository.InvoiceRepo;

@SpringBootApplication
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository")
public class SpringBootKataApplication {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private InvoiceRepo invoiceRepo;
    

    @Bean
    CommandLineRunner populate(){
        return args -> {
                   for(int i1 =0 ; i1<10;i1++){
                       customerRepo.save(Customer.builder().firstName("first"+i1).lastName("last_"+i1).build());
                   }
                   for(int i2 =0 ; i2<16;i2++){
                       invoiceRepo.save(Invoice.builder().name("name "+i2).amount(BigDecimal.valueOf(i2)).build());
                   }
            
        };
            
        
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }

  /*  @Bean
    @Profile("counter")
    DbCountRunner runner(Collection<CrudRepository<?,Long>> repositories) {
        return new DbCountRunner(repositories);
    }*/

}
