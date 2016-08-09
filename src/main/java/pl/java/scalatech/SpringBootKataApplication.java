package pl.java.scalatech;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.boot.actuate.metrics.repository.InMemoryMetricRepository;
import org.springframework.boot.actuate.metrics.repository.MetricRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.compoment.StartupComponent;
import pl.java.scalatech.domain.Invoice;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.InvoiceRepository;
import pl.java.scalatech.repository.UserRepository;

@SpringBootApplication // <1>
@Slf4j
public class SpringBootKataApplication implements CommandLineRunner{ // <2>

    @Autowired
    private MetricRepository metricRepository;
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    @Autowired // <3>
    private StartupComponent startup;
    
    @Autowired
    private UserRepository userRepository; 
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    
    Random r = new Random();
    public static void main(String[] args) { // <4>
        SpringApplication.run(SpringBootKataApplication.class, args);
        
    }

    @Override
    public void run(String... args) throws Exception { // <5>
        createUser();
        createInvoice();
        metricRepository.set(new Metric("slawek", 123));
        metricRepository.findAll().forEach(m->log.info("++++        {}",m));               
    }
   
    
    
    @Bean
    InMemoryMetricRepository inMemoryMetricRepository() {
        return new InMemoryMetricRepository();
    }

    

    private void createInvoice() {
        for(int i=0;i<35;i++){
            Invoice invoice = new Invoice();
            invoice.setName("i_"+i);
            if(i%2==0){
            invoice.setOwner("przodownik");
            }else{
                invoice.setOwner("tyson");
            }
            invoice.setPayment(new BigDecimal(""+r.nextInt(100)));
            invoiceRepository.save(invoice);
        }
    }

    private void createUser() {
        for(int i = 0; i< 30 ; i++){
            User user = new User();
            user.setName("przodownik"+"_ "+i);
            userRepository.save(user);
            
        }
    }
}
