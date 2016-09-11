package pl.java.scalatech.properties;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=PropertyTest.PropConfig.class)
public class PropertyTest {

    @Autowired
    Environment env;
    
    @Value("${my.key}")
    private String key;
    
    @Test
    public void shouldGetRightValue(){        
        Assertions.assertThat(key).isEqualTo("value1");
        Assertions.assertThat(env.getProperty("my.key")).isEqualTo("value1");
    }
    
    @Configuration
    @PropertySource("classpath:my.properties")
    static class PropConfig{
        
    }
}
