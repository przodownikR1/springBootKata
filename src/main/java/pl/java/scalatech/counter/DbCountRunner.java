package pl.java.scalatech.counter;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Profile("counter")

public class DbCountRunner implements CommandLineRunner {

    private final Collection<CrudRepository<?,Long>> repositories;

    public DbCountRunner(Collection<CrudRepository<?,Long>> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void run(String... args) throws Exception {
        repositories.forEach(
                crudRepository -> log.info("repo : {} , {} : entries", getRepositoryName(crudRepository.getClass()), crudRepository.count()));
    }

    private static String getRepositoryName(Class<? extends CrudRepository> crudRepositoryClass) {
        for (Class repositoryInterface : crudRepositoryClass.getInterfaces()) {
            if (repositoryInterface.getName().startsWith("pl.java.scalatech.repository")) {
                return repositoryInterface.getSimpleName();
            }
        }
        return "UnknownRepository";
    }
}