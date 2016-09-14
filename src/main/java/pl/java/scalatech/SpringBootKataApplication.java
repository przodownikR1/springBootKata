package pl.java.scalatech;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.Book;
import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.domain.CustomerProjection;
import pl.java.scalatech.domain.CustomerSummary;
import pl.java.scalatech.repo.BookRepository;
import pl.java.scalatech.repo.CustomerRepository;

@SpringBootApplication
@Slf4j
public class SpringBootKataApplication implements CommandLineRunner{

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BookRepository bookRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
          populate();    
          query();  
          
          
    }

    private void query() {
        log.info("findAllProjectedBy : {}",customerRepository.findAllProjectionBy());
          
          log.info("findAllSummarizedBy : {}",customerRepository.findAllSummarizedBy());
          
          
          log.info("findsByProjectedColumns : {}",customerRepository.findsByProjectedColumns());
          
          
          log.info("findAllDtoedBy : {}",customerRepository.findAllDtoedBy());
          
          log.info("findDtoWithConstructorExpression {}",customerRepository.findDtoWithConstructorExpression("kalina") );
          
          log.info("findAllDtoedBy {}",customerRepository.findAllDtoedBy() );
           
           log.info("findPagedProjectedBy  {}",customerRepository.findPagedProjectedBy(new PageRequest(0,10)) );
           
           log.info("findDtoWithConstructorExpression  {}",customerRepository.findDtoWithConstructorExpression("kalina") );
           
          log.info("findOptionalProjectionByLastName  {}",customerRepository.findOptionalProjectionByLastName("borowiecq") );
          
         // log.info("method1 :  {}",bookRepository.findByAuthorByJQL("sienkiewicz"));
    }

    private void populate() {
          Customer c = new Customer("slawek","borowiec");         
          Customer c1 = new Customer("kalina","borowiecq");                 
          c1 = customerRepository.save(c1);
          c = customerRepository.save(c);
          Book book = Book.builder().author("sienkiewicz").isbn("12312/34/34").name("krzyzacy").customers(Lists.newArrayList(c,c1)).build();
          Book book1 = Book.builder().author("mickiewicz").isbn("66/77/22").name("pan tadeusz").customers(Lists.newArrayList(c)).build();
          bookRepository.save(book);
          bookRepository.save(book1);
          
          
          
          
    }
    
    
  
    

}
