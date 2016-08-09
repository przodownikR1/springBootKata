package pl.java.scalatech.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

import pl.java.scalatech.health.DbCountRunner;

@Configuration
public class DbCountAutoConfiguration {
    @Bean
    public DbCountRunner dbCountRunner(Collection<CrudRepository> repositories) {
        return new DbCountRunner(repositories);
    }
}