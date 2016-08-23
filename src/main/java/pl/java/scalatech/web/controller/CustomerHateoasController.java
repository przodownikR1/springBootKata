package pl.java.scalatech.web.controller;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static pl.java.scalatech.web.controller.utils.Utils.getLinks;
import static pl.java.scalatech.web.controller.utils.Utils.getMetadata;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.java.scalatech.domain.Customer;
import pl.java.scalatech.repository.CustomerRepository;
import pl.java.scalatech.web.controller.assembler.CustomerAssembler;

@RestController
@RequestMapping("/customer2")
public class CustomerHateoasController {

    private final CustomerRepository customerRepository;
    
    private final CustomerAssembler customerAssembler;

    public CustomerHateoasController(CustomerRepository customerRepository, CustomerAssembler customerAssembler) {
        super();
        this.customerRepository = customerRepository;
        this.customerAssembler = customerAssembler;
    }

    @GetMapping(path = "/")
    PagedResources<List<Resource<Customer>>> getAll(Pageable pageable) {
        Page<Customer> result = customerRepository.findAll(pageable);
        List<Resource<Customer>> customers = result.getContent().stream().map(this::toResource).collect(toList());
        return new PagedResources(customers, getMetadata(result), getLinks(result));

    }
    
    @GetMapping(path="/second",produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<PagedResources<Customer>> page(Pageable pageable,PagedResourcesAssembler pagedResourcesAssembler) {                      
        return ResponseEntity.ok((pagedResourcesAssembler.toResource(customerRepository.findAll(pageable),customerAssembler )));
}
    

    @GetMapping(value = "/{id}")
    public ResponseEntity<Resource<Customer>> findOne(@PathVariable("id") Long id) {
        return Optional.of(customerRepository.findOne(id)).map(this::toResource).map(ResponseEntity::ok).orElseThrow(IllegalArgumentException::new);
    }

    @GetMapping(path = "/all")
    ResponseEntity<Resources<Resource<Customer>>> getAll2() {
        List<Link> links = new LinkedList<>();
        links.add(linkTo(methodOn(getClass()).getAll2()).withSelfRel());
        List<Resource<Customer>> customers = customerRepository.findAll().stream().map(this::toResource).collect(Collectors.toList());
        return ResponseEntity.ok(new Resources<>(customers, links));
    }

    private Resource<Customer> toResource(final Customer customer) {
        List<Link> links = new LinkedList<>();
        links.add(linkTo(methodOn(CustomerController.class).getCustomereByID(customer.getId())).withSelfRel());
        return new Resource<>(customer, links);
    }

}
