package pl.java.scalatech.web.controller;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Optional.of;
import static java.util.function.Function.identity;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;
import pl.java.scalatech.web.controller.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;    
    
    public CustomerController(CustomerRepository customerRepository) {
        super();
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/")
    ResponseEntity<Page<Customer>> getAll(Pageable pageable) {
        return ResponseEntity.ok(customerRepository.findAll(pageable));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomereByID(@PathVariable Long id) {
        return verifyAndResponseEntityWrap(id);
    }

    private ResponseEntity<Customer> verifyAndResponseEntityWrap(Long id) {
        return of(customerRepository.findOne(id)).map(p -> ok(p)).orElseThrow(() -> new ResourceNotFoundException(Customer.class.getSimpleName(), id));
    }

    private Customer verify(Long id) {
        return of(customerRepository.findOne(checkNotNull(id))).map(identity())
                .orElseThrow(() -> new ResourceNotFoundException(Customer.class.getSimpleName(), id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/")
    public HttpHeaders createCustomer(@Valid @RequestBody Customer customer) {
        Customer loaded = customerRepository.save(checkNotNull(customer));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(fromCurrentRequest().path("/{id}").buildAndExpand(loaded.getId()).toUri());
        return httpHeaders;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResource(@Valid @RequestBody Customer customer, @PathVariable Long id) {
        verify(id);
        Customer loaded = customerRepository.save(checkNotNull(customer));
        return ResponseEntity.ok(loaded);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpHeaders deleteResource(@PathVariable Long id) {
        customerRepository.delete(verify(id));
        return new HttpHeaders();
    }
}
