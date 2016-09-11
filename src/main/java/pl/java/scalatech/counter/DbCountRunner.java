package pl.java.scalatech.counter;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile("counter")
@Component
@NoArgsConstructor
public class DbCountRunner implements HealthIndicator {
    @Autowired
    private Collection<CrudRepository<?, Long>> repositories;


    // @Override
    public void run(String... args) throws Exception {
        repositories.forEach(crudRepository -> log.info("repo : {} , {} : entries", getRepositoryName(crudRepository.getClass()), crudRepository.count()));
    }

    private static String getRepositoryName(Class<? extends CrudRepository> crudRepositoryClass) {
        for (Class repositoryInterface : crudRepositoryClass.getInterfaces()) {
            if (repositoryInterface.getName().startsWith("pl.java.scalatech.repository")) {
                return repositoryInterface.getSimpleName();
            }
        }
        return "UnknownRepository";
    }

    @SuppressWarnings("boxing")
    @Override
    public Health health() {
        try {
            long count = repositories.size();
            
            if (count >= 0) {                
                return Health.up().withDetail("count", count).build();
            }
            return Health.unknown().withDetail("count", count).build();
        } catch (Exception e) {
            return Health.down(e).build();
        }

    }
}