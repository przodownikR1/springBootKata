package pl.java.scalatech.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
@Configuration  // <4>
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository") // <1>
@Slf4j
public class JpaConfig {
    
    @PostConstruct // <3>
    public void init(){
      log.info("+++++++++++++++++++++++++++++");  
    }

}
