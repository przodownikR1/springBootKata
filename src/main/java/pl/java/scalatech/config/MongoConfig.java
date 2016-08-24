package pl.java.scalatech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="pl.java.scalatech.repo")
public class MongoConfig {

        
}
