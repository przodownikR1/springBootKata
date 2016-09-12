package pl.java.scalatech.repo;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.domain.CustomerDto;
import pl.java.scalatech.domain.CustomerProjection;
import pl.java.scalatech.domain.CustomerSummary;

@RepositoryRestResource(excerptProjection=CustomerProjection.class)
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    
    Collection<CustomerProjection> findAllProjectionBy();

    Collection<CustomerSummary> findAllSummarizedBy();

    @Query("select c.firstName as firstName, c.lastName as lastName from Customer c")
    Collection<CustomerProjection> findsByProjectedColumns();

    Collection<CustomerDto> findAllDtoedBy();

    <T> Collection<T> findByFirstName(String firstname, Class<T> projection);

    CustomerProjection findProjectedById(Long id);

    Page<CustomerProjection> findPagedProjectedBy(Pageable pageable);

    @Query("select new pl.java.scalatech.domain.CustomerDto(c.firstName) from Customer c where c.firstName = ?1")
    Collection<CustomerDto> findDtoWithConstructorExpression(String firstname);

    Optional<CustomerProjection> findOptionalProjectionByLastName(String lastname);
}