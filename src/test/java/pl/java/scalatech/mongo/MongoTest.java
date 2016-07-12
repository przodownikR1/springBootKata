package pl.java.scalatech.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.java.scalatech.config.MongoConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={MongoConfig.class})
@ActiveProfiles(value="dev")
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    
    @Test
    public void shouldInjectMongoTemplate(){
        
    }
    
}
