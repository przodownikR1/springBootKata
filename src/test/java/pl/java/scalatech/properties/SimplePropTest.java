package pl.java.scalatech.properties;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.compoment.SomeApplicationSettings;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SimplePropTest.SimpleConfing.class)
@Slf4j
public class SimplePropTest {
    
    @Autowired
    private SomeApplicationSettings settings;
    
    @Value("${user.name}")
    private String name;
    
    @Test
    public void shouldBootstrap(){
        
    }
    @Test
    public void shouldInjectByValue(){
        assertThat(name).isEqualTo("przodownik");
    }
    @Test
    public void shouldConfigurationPropertiesWork(){
        log.info("{}",settings);
    }
    
    
    @Configuration   
    @ComponentScan(basePackageClasses={SomeApplicationSettings.class})
    @EnableConfigurationProperties({SomeApplicationSettings.class})
    static class SimpleConfing{
        
    }
    
}
