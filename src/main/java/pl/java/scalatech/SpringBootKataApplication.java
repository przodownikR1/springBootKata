package pl.java.scalatech;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.compoment.StartupComponent;

@SpringBootApplication
@Slf4j
public class SpringBootKataApplication {

    private static final String APPLICATION_USER = "application.user";

    @Autowired
    private StartupComponent startup;
    
    @Autowired
    private Environment env;
    
    @Bean
    InitializingBean bean(){
        return () -> log.info("!!!!  application.user : {}",env.getProperty(APPLICATION_USER));
        
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
               
    }
}
