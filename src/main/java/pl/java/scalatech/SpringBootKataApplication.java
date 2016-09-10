package pl.java.scalatech;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.conditional.AvailableOnClasspath;
import pl.java.scalatech.conditionalResource.ResourcePresentConditional;

@SpringBootApplication
@Slf4j
public class SpringBootKataApplication implements CommandLineRunner{
    @Autowired
    private List<String> libs;
    
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }
    @Bean
    @AvailableOnClasspath("lombok.Lombok1")    
    String h2Driver() {
        return "lombok";
    }
    
    @Bean
    @AvailableOnClasspath("org.h2.Driver")    
    String postgresDriver() {
        return "h2 driver";
    }
    
    @Bean
    @AvailableOnClasspath("javax.persistence.EntityManager")    
    String mysqlDriver() {
        return "jpa";
    }
    @Bean
    @ResourcePresentConditional(value="przodownik")
    String myResource(){
        return "my nick";
    }
  
    
    @Bean
    @ConditionalOnMissingClass("java.lang.String")
    public String missingClassString() {
        return "missingClassString()";
    }
    
    @Bean
    @ConditionalOnClass(String.class)
    public String classString() {
        return "classString()";
    }
    
    
    @Bean   
    @ConditionalOnProperty(name="przodownik")
    public String przodownikProperty() {
        return "przodownik";
    }
    
    
    //@ConditionalOnBean(DataSource.class)
    
   //@ConditionalOnClass(JpaRepository.class)

   //@ConditionalOnMissingBean

   //@ConditionalOnProperty
 

  
    @Override
    public void run(String... args) throws Exception {
           
      log.info("+++  conditional drivers : {}",libs);  
    }

    

}
