package pl.java.scalatech.compoment;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@ConfigurationProperties(prefix =   "my.app")
@Data
public class AppProperties {

    
    private String name;
    
    private String user;
    
    
    private String secret;
    
    private int number;
    
    private BigDecimal bignumber;
    
    private String uuid;
    
    private int ten;
    
    private int range;
    
}
