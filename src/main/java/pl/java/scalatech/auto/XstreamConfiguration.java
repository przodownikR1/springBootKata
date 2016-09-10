package pl.java.scalatech.auto;

import java.util.Collection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
//org.springframework.boot.autoconfigure.EnableAutoConfiguration=pl.java.scalatech.CustomerXStreamConverter

@Configuration
public class XstreamConfiguration {
    @Bean
    @ConditionalOnMissingBean
    XStream xstream(){
        XStream xstream =  new XStream();        
        return xstream;
    }
    
    
    @Bean
    @ConditionalOnBean(Converter.class)
    public Collection<Converter> conterters(XStream xstream , Collection<Converter> converters){    
        converters.forEach(c->xstream.registerConverter(c));
        return converters;
        
    }
    
}
