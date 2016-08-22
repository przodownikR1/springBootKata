package pl.java.scalatech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.java.scalatech.compoment.StartupComponent;

@SpringBootApplication
public class SpringBootKataApplication {

    @Autowired
    private StartupComponent startup;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }
    
  
    

}
