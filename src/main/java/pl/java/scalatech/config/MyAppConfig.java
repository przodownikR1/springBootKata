package pl.java.scalatech.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.compoment.AppProperties;

@Configuration
@PropertySource("classpath:/app.properties")
//@EnableConfigurationProperties(value=AppProperties.class)
@Slf4j
public class MyAppConfig implements CommandLineRunner{

    @Autowired
    private AppProperties appProperties;
    
    @Override
    public void run(String... args) throws Exception {
             log.info("++++ MY app properties : {}",appProperties);
    }

}
