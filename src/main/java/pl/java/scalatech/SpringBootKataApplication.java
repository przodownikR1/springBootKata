package pl.java.scalatech;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.java.scalatech.compoment.StartupComponent;
import pl.java.scalatech.domain.Invoice;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.InvoiceRepository;
import pl.java.scalatech.repository.UserRepository;

@SpringBootApplication
public class SpringBootKataApplication implements CommandLineRunner{

    @Autowired
    private StartupComponent startup;
    
    @Autowired
    private UserRepository userRepository; 
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    
    Random r = new Random();
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
        
    }

    @Override
    public void run(String... args) throws Exception {
        createUser();
        createInvoice();
        
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
