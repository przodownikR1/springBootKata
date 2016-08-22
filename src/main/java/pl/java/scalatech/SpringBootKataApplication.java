package pl.java.scalatech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pl.java.scalatech.component.StartupComponent;

@SpringBootApplication
public class SpringBootKataApplication {
    public static final String MY_QUEUE = "myQueue";
    @Autowired
    private StartupComponent startup;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootKataApplication.class, args);
    }
    
  
    

}
