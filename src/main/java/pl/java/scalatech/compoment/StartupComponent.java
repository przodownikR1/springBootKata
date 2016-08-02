package pl.java.scalatech.compoment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // <1>
public class StartupComponent implements CommandLineRunner { // <2>
  
    
    @Override
    public void run(String... args) throws Exception { // <3>
        log.info("START ...");
       
    }
}