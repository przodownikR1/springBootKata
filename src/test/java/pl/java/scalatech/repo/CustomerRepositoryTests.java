package pl.java.scalatech.repo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest // configures an in-memory database, scans for @Entity classes, @Component classes are not loaded into ApplicationContext.
public class CustomerRepositoryTests {

    @Autowired
    private TestEntityManager entityManager; // PA EntityManager designed for tests

    @Autowired
    private CustomerRepository repository;

    @Test
    public void shouldRepoWork() {
        repository.deleteAll();
        entityManager.persist(new Customer("slawek", "borowiec"));
        Assertions.assertThat(repository.count()).isEqualTo(1);

    }
}