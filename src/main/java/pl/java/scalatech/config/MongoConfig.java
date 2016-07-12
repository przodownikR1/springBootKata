package pl.java.scalatech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="pl.java.scaletech.repository")
public class MongoConfig {

    /*@Bean
    MongoDbFactory mongoFactory() throws UnknownHostException{
        return new SimpleMongoDbFactory(new MongoClient("localhost", 27017),"mongo_spring_test");
    }*/
       
    
}
