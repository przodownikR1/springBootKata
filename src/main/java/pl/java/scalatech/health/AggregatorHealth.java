package pl.java.scalatech.health;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthIndicator;
import org.springframework.boot.actuate.health.HealthAggregator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

public class AggregatorHealth {
    @Autowired
    private HealthAggregator healthAggregator;

    @Bean
    public HealthIndicator dbCountHealthIndicator(Collection<CrudRepository> repositories) {
        CompositeHealthIndicator compositeHealthIndicator = new CompositeHealthIndicator(healthAggregator);
        for (CrudRepository repository : repositories) {
            String name = DbCountRunner.getRepositoryName(repository.getClass());
            //compositeHealthIndicator.addHealthIndicator(name, new DbCountHealthIndicator(repository));
        }
        return compositeHealthIndicator;
    }
}
