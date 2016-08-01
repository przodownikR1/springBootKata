package pl.java.scalatech.compoment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.UserRepository;

@Slf4j
@Component
public class StartupComponent implements CommandLineRunner {
  
    
    @Override
    public void run(String... args) throws Exception {
        log.info("START ...");
       
    }
}