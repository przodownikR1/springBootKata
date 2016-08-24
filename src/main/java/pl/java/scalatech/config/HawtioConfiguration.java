package pl.java.scalatech.config;

import org.springframework.context.annotation.Configuration;

import io.hawt.springboot.EnableHawtio;
import io.hawt.web.AuthenticationFilter;

@Configuration
@EnableHawtio
public class HawtioConfiguration  {


    static {
        System.setProperty(AuthenticationFilter.HAWTIO_AUTHENTICATION_ENABLED, "false");
}
}