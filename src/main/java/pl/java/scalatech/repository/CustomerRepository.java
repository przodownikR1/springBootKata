package pl.java.scalatech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import pl.java.scalatech.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    @Cacheable("customer")
    Optional<List<Customer>> findByFirstNameLike(String name);
    
}
