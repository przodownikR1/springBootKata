package pl.java.scalatech.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.java.scalatech.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>{

}
