package pl.java.scalatech.health;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class DbCountHealthIndicator implements HealthIndicator {
    private Collection<CrudRepository> repository;

    @Autowired
    public DbCountHealthIndicator(Collection<CrudRepository> repository) {
        this.repository = repository;
    }

    @Override
    public Health health() {
        try {
            long count = repository.size();
            if (count >= 0) {
                return Health.up().withDetail("count", count).build();
            }
            return Health.unknown().withDetail("count", count).build();
        } catch (Exception e) {
            return Health.down(e).withException(e).build();
        }
    }
}