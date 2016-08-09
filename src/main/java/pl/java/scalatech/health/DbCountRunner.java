package pl.java.scalatech.health;

import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class DbCountRunner implements CommandLineRunner {
 
    private Collection<CrudRepository> repositories;

    public DbCountRunner(Collection<CrudRepository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public void run(String... args) throws Exception {
        repositories.forEach(
                crudRepository -> log.info(String.format("%s	has	%s	entries", getRepositoryName(crudRepository.getClass()), crudRepository.count())));
    }

    public static String getRepositoryName(Class crudRepositoryClass) {
        for (Class repositoryInterface : crudRepositoryClass.getInterfaces()) {
            if (repositoryInterface.getName().startsWith("org.test.bookpub.repository")) {
                return repositoryInterface.getSimpleName();
            }
        }
        return "UnknownRepository";
    }
}