package pl.java.scalatech.jpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository repository;

    @Test
    public void findByFirstName() {
        this.entityManager.persist(new Customer("sboot", "123"));
        Customer customer = this.repository.findByFirstName("sboot").get(0);
        
        assertThat(customer.getFirstName()).isEqualTo("sboot");
        assertThat(customer.getLastName()).isEqualTo("123");
    }

}