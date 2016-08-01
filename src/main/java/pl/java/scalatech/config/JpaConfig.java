package pl.java.scalatech.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
@Configuration
@EnableJpaRepositories(basePackages="pl.java.scalatech.repository")
@Slf4j
@EntityScan(basePackages="pl.java.scalatech.domain")
public class JpaConfig {
    @PostConstruct
    public void init(){
      log.info("+++++++++++++++++++++++++++++");  
    }

}
