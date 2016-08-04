package pl.java.scalatech.compoment;

import java.net.URL;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "app")
@EnableConfigurationProperties
@Data
public class SomeApplicationSettings {

    @NotNull
    private URL apiUrl;        
    @NotNull
    private String apiKey;
  
    @Digits(integer = 12, fraction = 0)    
    private int connectionTimeout;
  
    private String salary;
    
    private int count;
    
    private boolean useSSL;
}